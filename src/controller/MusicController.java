package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import service.MusicService;
import vo.Music;

@Controller
public class MusicController {
	@Autowired
	private MusicService musicService;
	
	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}
	@RequestMapping("musicUpload.do")
	public ModelAndView upploadMusic(Music music,HttpServletRequest request){
		String musicPath = request.getServletContext().getRealPath("music");
		File dir = new File(musicPath);
		if(dir.exists()==false){
			dir.mkdir();	//디렉토리 생성
		}
		MultipartFile albumImgFile = music.getAlbumImg();
		MultipartFile musicFile = music.getMusicFile();
		
		String savedAlbumImgName = musicPath+"/"+new Random().nextInt(1000000)+albumImgFile.getOriginalFilename();
		String savedMusicName = musicPath+"/"+new Random().nextInt(1000000)+musicFile.getOriginalFilename();
		
		//DB에 저장될 파일 경로
		String realAlbumImgPath = "/"+savedAlbumImgName.substring(savedAlbumImgName.indexOf("Cygram"));
		String realMusicPath = "/"+savedMusicName.substring(savedMusicName.indexOf("Cygram"));
		
		File savedAlbumImgFile = new File(savedAlbumImgName);
		File savedMusicFile = new File(savedMusicName);
		
		//디렉토리에 파일 저장
		try {
			albumImgFile.transferTo(savedAlbumImgFile);
			musicFile.transferTo(savedMusicFile);
			music.setAlbumImgPath(realAlbumImgPath);
			music.setMusicFilePath(realMusicPath);
			musicService.uploadMusic(music);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@RequestMapping("musicList.do")
	public ModelAndView selectMusicList(){
		ModelAndView mv = new ModelAndView("musicList");
		List<Music> musicList = musicService.selectMusicList();
		mv.addObject("musicList", musicList);
		return mv;
	}
	@RequestMapping("buyMusicForm.do")
	public ModelAndView buyMusicForm(@RequestParam(value="musicNo")int musicNo){
		ModelAndView mv = new ModelAndView("buyMusicForm");
		Music music = musicService.selectMusic(musicNo);
		mv.addObject("music", music);
		return mv;
	}
	@RequestMapping("buyMusic.do")
	public ModelAndView buyMusic(@RequestParam(value="musicNo")int musicNo,HttpSession session){
		ModelAndView mv = new ModelAndView("successBuyMusic");
		String loginId = (String)session.getAttribute("loginId");
		musicService.buyMusic(musicNo,loginId);
		return mv;
	}
}
