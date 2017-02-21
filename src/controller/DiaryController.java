package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.DiaryService;
import vo.Diary;

@Controller
public class DiaryController {
	@Autowired
	private DiaryService diaryService;
	public void setDiaryService(DiaryService diaryService){
		this.diaryService = diaryService;
	}
	
	//-----------------------------------------------------//
	
	@RequestMapping("/writeDiaryForm.do")
	public String writeDiaryForm(HttpSession session, String id){
		if(id.equals(session.getAttribute("loginId"))){
			return "write_diary_form";
		} else {
			return null;
		}
	}
	
	@RequestMapping("/diaryList.do")
	public ModelAndView diaryList(@RequestParam(value="page",defaultValue="1") int page, String id){
		ModelAndView mv = new ModelAndView("diary_list");
		mv.addObject("diaryPage", diaryService.makePage(page, id));
		return mv;
	}
	
	@RequestMapping(value="/writeDiary.do", method=RequestMethod.POST)
	public ModelAndView writeDiary(HttpSession session, Diary diary){
		String id =(String) session.getAttribute("loginId");
		diary.setId(id);
		diaryService.write(diary, id);
		ModelAndView mv = new ModelAndView("diary_list");
		mv.addObject("diaryPage", diaryService.makePage(1, id));
		return mv;
	}
	
	@RequestMapping("modifyDiaryForm.do")
	public String modifyDiaryForm(HttpSession session, String id) {
		if (id.equals(session.getAttribute("loginId"))) {
			return "modify_diary_form";
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/modifyDiary.do", method = RequestMethod.POST)
	public ModelAndView modifyProfile(HttpSession session, Diary diary) {
		String id = (String) session.getAttribute("loginId");
		diary.setId(id);
		diaryService.modify(diary, id);
		ModelAndView mv = new ModelAndView("diary_list");
		return mv;
	}
}
