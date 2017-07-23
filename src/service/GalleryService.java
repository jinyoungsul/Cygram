package service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import repository.FriendsDao;
import repository.GalleryCommentDao;
import repository.GalleryDao;
import vo.Gallery;
import vo.GalleryComment;
import vo.GalleryImg;
import vo.GalleryPage;

@Component
public class GalleryService {
	@Autowired
	private GalleryDao galleryDao;

	public void setGalleryDao(GalleryDao galleryDao) {
		this.galleryDao = galleryDao;
	}

	@Autowired
	private FriendsDao friendsDao;

	public void setFriendsDao(FriendsDao friendsDao) {
		this.friendsDao = friendsDao;
	}
	@Autowired
	private GalleryCommentDao galleryCommentDao;
	
	public void setGalleryCommentDao(GalleryCommentDao galleryCommentDao) {
		this.galleryCommentDao = galleryCommentDao;
	}

	public int write(HttpServletRequest request, HttpSession session, Gallery gallery) {
		System.out.println("gallery:" + gallery);

		String id = (String) session.getAttribute("loginId");
		gallery.setId(id);
		gallery.setWriteDate(new Date());
		int result = galleryDao.insert(gallery);
		System.out.println(result);
		String galleryPath = request.getServletContext().getRealPath("img");
		List<GalleryImg> galleryImgList = new ArrayList<>();

		File dir = new File(galleryPath);
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		for (MultipartFile f : gallery.getPhotoList()) {
			if (f.isEmpty() == true) {

			} else {
				String storedName = new Random().nextInt(1000000) + f.getOriginalFilename();
				String savedName = galleryPath + "/" + storedName;
				String realPath = "/" + savedName.substring((savedName.indexOf("Cygram")));
				File saveFile = new File(savedName);

				try {
					f.transferTo(saveFile);
					GalleryImg galleryImg = new GalleryImg();
					galleryImg.setOriginalFileName(f.getOriginalFilename());
					galleryImg.setStoredFileName(storedName);
					galleryImg.setGalleryPath(realPath);
					galleryImgList.add(galleryImg);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}

		if (result > 0) {
			for (GalleryImg galleryImg : galleryImgList) {
				galleryImg.setGalleryNo(gallery.getGalleryNo());
				galleryDao.insertImg(galleryImg);
			}
		}
		return gallery.getGalleryNo();
	}

	public Gallery read(int galleryNo) {
		Gallery gallery = galleryDao.select(galleryNo);
		List<GalleryImg> galleryImgList = galleryDao.selectImgList(galleryNo);
		gallery.setGalleryImgList(galleryImgList);
		return gallery;
	}

	public int galleryCount(String id) {
		int galleryCount = galleryDao.selectGalleryCount(id);
		return galleryCount;
	}

	public int newGalleryCount(String id) {
		int newGalleryCount = galleryDao.selectNewGalleryCount(id);
		return newGalleryCount;
	}

	public GalleryPage makePage(int currentPage, String id, String loginId) {
		final int COUNT_PER_PAGE = 3;
		int startRow = ((currentPage - 1) * COUNT_PER_PAGE) + 1;
		int endRow = startRow + 2;
		int totalGalleryCount;
		List<Gallery> galleryList;

		if (loginId.equals(id)) {
			totalGalleryCount = galleryDao.selectGalleryCount(id);
			galleryList = galleryDao.selectGalleryList(startRow, endRow, id);
		} else if (friendsDao.isOkFriends(id, loginId) != null) {
			totalGalleryCount = galleryDao.selectFriendCount(id);
			galleryList = galleryDao.selectGalleryFriendList(startRow, endRow, id);
		} else {
			totalGalleryCount = galleryDao.selectPrivateCount(id);
			galleryList = galleryDao.selectGalleryPrivateList(startRow, endRow, id);
		}

		if (totalGalleryCount == 0)
			return new GalleryPage();

		for (Gallery g : galleryList) {
			int galleryNo = g.getGalleryNo();
			List<GalleryImg> galleryImgList = galleryDao.selectImgList(galleryNo);
			List<GalleryComment> galleryCommentList = galleryCommentDao.selectGalleryComment(galleryNo);
			g.setGalleryCommentList(galleryCommentList);
			g.setGalleryImgList(galleryImgList);
		}

		int totalPage = totalGalleryCount / COUNT_PER_PAGE;
		if (totalGalleryCount % COUNT_PER_PAGE != 0)
			totalPage++;

		int startPage = (currentPage - 1) / 5 * 5 + 1;
		int endPage = startPage + 4;
		if (endPage > totalPage)
			endPage = totalPage;

		return new GalleryPage(galleryList, startPage, endPage, currentPage, totalPage);
	}

	public int modify(HttpServletRequest request, Gallery gallery, HttpSession session) {
		int result = 0;
		galleryDao.deleteImg(gallery.getGalleryNo());
		String id = (String) session.getAttribute("loginId");
		gallery.setId(id);
		gallery.setWriteDate(new Date());
		result = galleryDao.update(gallery);
		String galleryPath = request.getServletContext().getRealPath("img");
		List<GalleryImg> galleryImgList = new ArrayList<>();

		File dir = new File(galleryPath);
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		if (gallery.getGalleryImgNo() != null) {
			for (int galleryImgNo : gallery.getGalleryImgNo()) {
				galleryDao.updateImg(galleryImgNo);
			}
		}
		if (gallery.getPhotoList() != null) {
			for (MultipartFile f : gallery.getPhotoList()) {
				if (f.isEmpty() == true) {

				} else {
					String storedName = new Random().nextInt(1000000) + f.getOriginalFilename();
					String savedName = galleryPath + "/" + storedName;
					String realPath = "/" + savedName.substring((savedName.indexOf("Cygram")));
					File saveFile = new File(savedName);

					try {
						f.transferTo(saveFile);
						GalleryImg galleryImg = new GalleryImg();
						galleryImg.setOriginalFileName(f.getOriginalFilename());
						galleryImg.setStoredFileName(storedName);
						galleryImg.setGalleryPath(realPath);
						galleryImgList.add(galleryImg);
					} catch (IllegalStateException | IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (result > 0) {
			for (GalleryImg galleryImg : galleryImgList) {
				galleryImg.setGalleryNo(gallery.getGalleryNo());
				galleryDao.insertImg(galleryImg);
			}
		}
		return result;
	}
}