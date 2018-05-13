package com.ssm.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.po.Coach;
import com.ssm.po.Guide;
import com.ssm.po.PaidGuide;
import com.ssm.po.User;
import com.ssm.service.CoachService;

@Controller
@RequestMapping("/coach")
public class CoachController
{
	@Autowired
	private CoachService coachService;

	@RequestMapping("/coachRegist")
	public ModelAndView coachRegist(@Validated Coach coach, BindingResult bindingResult, MultipartFile pic)
			throws Exception
	{
		String coachUsername = coach.getCoachUsername();

		if (bindingResult.hasErrors())
		{
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			ModelAndView model = new ModelAndView();
			model.addObject("allErrors", allErrors);
			model.setViewName("coach/coachregist");
			return model;
		}

		if (coachService.hasCoach(coachUsername))
		{
			ModelAndView model = new ModelAndView();
			model.addObject("msg", "已经有用户名");
			model.setViewName("coach/coachfail");
			return model;
		}
		coach.setCoachMoney(0);
		coach.setCoachNumber(0);

		String originalFilename = pic.getOriginalFilename();
		if (pic != null && originalFilename != null && originalFilename.length() > 0)
		{

			String pic_path = "E:\\Tomcat8\\upload\\temp\\";
			String newFileName = "coachpic" + coach.getCoachName()
					+ originalFilename.substring(originalFilename.lastIndexOf("."));
			File newFile = new File(pic_path + newFileName);
			pic.transferTo(newFile);
			coach.setCoachPic(newFileName);
		}
		coachService.coachRegist(coach);

		ModelAndView model = new ModelAndView();
		model.addObject("msg", "行家注册成功");
		model.setViewName("coach/coachsuccess");
		return model;
	}

	@RequestMapping("/coachLogin")
	public String coachLogin(@RequestParam("coachUsername") String coachUsername,
			@RequestParam("coachPassword") String coachPassword, HttpServletRequest request)
	{
		Coach coach = new Coach();
		coach.setCoachUsername(coachUsername);
		coach.setCoachPassword(coachPassword);
		coach = coachService.selectCoachByUserNameAndPassword(coach);
		if (coach == null)
		{
			request.setAttribute("msg", "用户名密码不正确");
			return "coach/coachfail";
		}
		HttpSession session = request.getSession();
		session.setAttribute("coach", coach);
		request.setAttribute("msg", "行家登陆成功");
		return "coach/coachsuccess";

	}

	@RequestMapping("/coachLogout")
	public ModelAndView coachLogout(HttpSession session)
	{
		session.removeAttribute("coach");
		session.invalidate();

		ModelAndView model = new ModelAndView();
		model.addObject("msg", "行家退出成功");
		model.setViewName("coach/coachlogin");
		return model;
	}

	@RequestMapping("/coachAddguide")
	public ModelAndView coachAddguide(@Validated Guide guide, BindingResult bindingResult, HttpSession session)
	{
		Coach coach = (Coach) session.getAttribute("coach");
		guide.setCoachId(coach.getCoachId());
		guide.setGuideNumber(0);
		guide.setGuideRate(0.0);
		guide.setGuideChecked(0);
		guide.setCoachName(coach.getCoachName());
		if (bindingResult.hasErrors())
		{
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			ModelAndView model = new ModelAndView();
			model.addObject("allErrors", allErrors);
			model.setViewName("coach/check/coachaddguide");
			return model;
		}
		coachService.addGuide(guide);

		ModelAndView model = new ModelAndView();
		model.addObject("msg", "指导添加成功");
		model.setViewName("coach/coachsuccess");
		return model;
	}

	@RequestMapping("/check/findpaidguidebycoachid")
	public ModelAndView findpaidguidebycoachid(HttpSession session)
	{
		Coach coach = (Coach) session.getAttribute("coach");
		Integer coachId = coach.getCoachId();
		List<PaidGuide> listpaidguide = coachService.findPaidGuideByCoachId(coachId);

		ModelAndView model = new ModelAndView();
		model.addObject("listpaidguide", listpaidguide);
		model.setViewName("coach/check/findpaidguidebycoachid");
		return model;
	}

	@RequestMapping("/check/updatecoachinfomation")
	public ModelAndView updatecoachinfomation(@Validated Coach coach, BindingResult bindingResult)
	{
		coachService.updateCoachInfomation(coach);
		if (bindingResult.hasErrors())
		{
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			ModelAndView model = new ModelAndView();
			model.addObject("allErrors", allErrors);
			model.setViewName("coach/check/updatecoachinfomation");
			return model;
		}
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "行家修改信息成功");
		model.setViewName("coach/coachsuccess");
		return model;
	}

	@RequestMapping("/check/findguidebycoachid")
	public ModelAndView findguidebycoachid(HttpSession session)
	{
		Coach coach = (Coach) session.getAttribute("coach");
		Integer coachId = coach.getCoachId();
		List<Guide> guidelist = coachService.findGuideByCoachId(coachId);
		ModelAndView model = new ModelAndView();
		model.addObject("guidelist", guidelist);
		model.setViewName("coach/check/findguidebycoachid");
		return model;
	}

	@RequestMapping("/check/findguidebyguideid")
	public ModelAndView findguidebyguideid(Integer guideId)
	{

		Guide guide = coachService.findGuideByGuideId(guideId);
		ModelAndView model = new ModelAndView();
		model.addObject("guide", guide);
		model.setViewName("coach/check/findguidebyguideid");
		return model;
	}

	@RequestMapping("/check/updateguide")
	public ModelAndView updateguide(@Validated Guide guide, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			ModelAndView model = new ModelAndView();
			model.addObject("allErrors", allErrors);
			model.setViewName("coach/check/findguidebyguideid");
			return model;
		}
		coachService.updateGuide(guide);

		ModelAndView model = new ModelAndView();
		model.addObject("msg", "指导修改成功");
		model.setViewName("coach/coachsuccess");
		return model;
	}
}
