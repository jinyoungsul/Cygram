package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.ProfileService;
import vo.Profile;

@Controller
public class ProfileController {
	@Autowired
	private ProfileService profileService;

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}
	// ----------------------------------------------------------//

	@RequestMapping("/writeProfileForm.do")
	public String writeProfileForm(HttpSession session, String id) {
		if (id.equals(session.getAttribute("loginId"))) {
			return "write_profile_form";
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/writeProfile.do", method = RequestMethod.POST)
	public ModelAndView writeProfile(HttpSession session, Profile profile) {
		String id = (String) session.getAttribute("loginId");
		profile.setId(id);
		ModelAndView mv = new ModelAndView("read_profile");
		return mv;
	}

	@RequestMapping("/readProfile.do")
	public ModelAndView read(HttpSession session, String id) {
		String loginId = (String) session.getAttribute("loginId");
		Profile profile = profileService.read(loginId);

		ModelAndView mv = new ModelAndView("read_profile");
		mv.addObject("profile", profile);
		return mv;
	}
	
	@RequestMapping("modifyProfileForm.do")
	public String modifyProfileForm(HttpSession session, String id) {
		if (id.equals(session.getAttribute("loginId"))) {
			return "modify_profile_form";
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/modifyProfile.do", method = RequestMethod.POST)
	public ModelAndView modifyProfile(HttpSession session, Profile profile) {
		String id = (String) session.getAttribute("loginId");
		profile.setId(id);
		ModelAndView mv = new ModelAndView("read_profile");
		return mv;
	}

}
