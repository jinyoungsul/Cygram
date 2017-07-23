package controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import service.FriendsService;
import service.MemberService;
import service.MiniHomepageService;
import service.MusicService;
import vo.Friend;
import vo.Member;
import vo.MiniHomepage;
import vo.Music;

@Controller
public class MiniHomepageController {
	@Autowired
	private MiniHomepageService homepageService;
	@Autowired
	private FriendsService friendsService;
	@Autowired
	private MemberService memberService; 
	@Autowired
	private MusicService musicService;
	
	public void setService(MiniHomepageService homepageService) {
		this.homepageService = homepageService;
	}
	public void setFriendsService(FriendsService friendsService) {
		this.friendsService = friendsService;
	}
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}
	@RequestMapping(value="/miniHomepage.do",method=RequestMethod.POST)
	public ModelAndView miniHomepage(String id,HttpSession session,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String friendId = id;
		String myId = (String)session.getAttribute("loginId");
		
		///////////////방문자 수 (쿠키)//////////////////////////
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			//쿠키 서치
			boolean create = true;
			for(Cookie cookie : cookies){
				System.out.println(cookie.getName());
				if(cookie.getName().equals(myId+friendId)){
					create = false;
				}
			}
			if(create){
				//쿠키 생성
				Cookie cookie = new Cookie(myId+friendId,"visit");
				Date expireday = new Date();
				expireday = new Date(expireday.getTime()/86400000*86400000+54000000);
				int expire = (int)(((expireday.getTime()/86400000*86400000)+54000000) - new Date().getTime());
				cookie.setMaxAge(expire);
				response.addCookie(cookie);
				homepageService.increaseTodayTotal(id);
			}
			
		} else {
			//쿠키 생성
			Cookie cookie = new Cookie(myId+friendId,"visit");
			Date expireday = new Date();
			expireday = new Date(expireday.getTime()/86400000*86400000+54000000);
			int expire = (int)(((expireday.getTime()/86400000*86400000)+54000000) - new Date().getTime());
			cookie.setMaxAge(expire);
			response.addCookie(cookie);
			homepageService.increaseTodayTotal(id);
		}
		Friend friend = friendsService.checkFriend(myId,friendId);
		List<Friend> friendsList = friendsService.selectAcceptFriends(friendId);
		MiniHomepage miniHomepage = homepageService.selectMiniHomepage(friendId);
		List<Music> bgmList = musicService.bgmList(friendId);
		mv.setViewName("minihomepage");
		mv.addObject("friend", friend);
		mv.addObject("miniHomepage", miniHomepage);
		mv.addObject("friendsList", friendsList);
		mv.addObject("bgmList", bgmList);
		return mv;
	}
	@RequestMapping(value="/minihomepageHome.do")
	public ModelAndView minihomepageHome(HttpSession session,String id){
		ModelAndView mv = new ModelAndView("homepageHome");
		String loginId = (String)session.getAttribute("loginId");
		mv.addObject("contentCountMap", homepageService.minihomepageHome(id, loginId));
		return mv;
	}
	@RequestMapping(value="/minihomepageSearch.do")
	public ModelAndView miniHomepageSearch(HttpSession session ){
		ModelAndView mv = new ModelAndView();
		String id = (String)session.getAttribute("loginId");
		mv.addObject("member", memberService.selectMember(id));
		mv.setViewName("homepageList");
		return mv;
	}
	@RequestMapping(value="/minihomepageSearchKeyword.do")
	public @ResponseBody List<MiniHomepage> miniHomepageSearchKeyword(
			@RequestParam(value="keyword",defaultValue="")String keyword,int startRow,int count){
		ModelAndView mv = new ModelAndView();
		List<MiniHomepage> homepageList = homepageService.selectMiniHomepageList(keyword,startRow,count);
		mv.addObject("homepageList", homepageList);
		return homepageList;
	}
	@RequestMapping(value="/homepageTitleUpdate.do",method=RequestMethod.POST)
	public @ResponseBody int homepageTitleUpdate(String id,String title){
		int result = homepageService.titleUpdate(id,title);
		return result;
	}
	
	@RequestMapping(value="/editIntoduceAndImgForm.do")
	public ModelAndView editIntoduceAndImgForm(){
		return new ModelAndView("editIntoduceAndImgForm");
	}
	@RequestMapping(value="/homepageIntroduceAndImgUpdate.do",method=RequestMethod.POST)
	public ModelAndView homepageIntroduceAndImgUpdate(MiniHomepage miniHomepage,HttpServletRequest request){
		String homepageImgPath = request.getServletContext().getRealPath("img");
		File dir = new File(homepageImgPath);
		if(dir.exists()==false){
			dir.mkdirs();
		}
//		데이터 베이스 기록
			MultipartFile f = (MultipartFile) miniHomepage.getMinihomepage_img();
			String savedName = 
					homepageImgPath +"/"+new Random().nextInt(1000000)+f.getOriginalFilename();
			String realPath = "/"+savedName.substring((savedName.indexOf("Cygram")));
			File saveFile = new File(savedName);
			
			// 업로드
			try {
				f.transferTo(saveFile);
				miniHomepage.setMinihomepage_img_path(realPath);
				homepageService.introduceImgUpdate(miniHomepage);
			} catch (IllegalStateException |IOException e) {
				e.printStackTrace();
			}	
		
		return new ModelAndView("editIntoduceAndImgSuccess"); 
	}
}
