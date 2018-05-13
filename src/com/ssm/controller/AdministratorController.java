package com.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.po.Administrator;
import com.ssm.po.Guide;
import com.ssm.service.AdministratorService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController
{
	@Autowired
	private AdministratorService administratorService;

	@RequestMapping("/administratorLogin")
	public String administratorLogin(@RequestParam("administratorUsername") String administratorUsername,
			@RequestParam("administratorPassword") String administratorPassword, HttpServletRequest request)
	{
		Administrator administrator = new Administrator();
		administrator.setAdministratorUsername(administratorUsername);
		administrator.setAdministratorPassword(administratorPassword);
		administrator = administratorService.selectAdministratorByUserNameAndPassword(administrator);
		if (administrator == null)
		{
			request.setAttribute("msg", "用户名密码不正确");
			return "administrator/administratorfail";
		}
		HttpSession session = request.getSession();
		session.setAttribute("administrator", administrator);
		request.setAttribute("msg", "管理员登陆成功");
		return "administrator/administratorsuccess";

	}

	@RequestMapping("/administratorLogout")
	public ModelAndView administratorLogout(HttpSession session)
	{
		session.removeAttribute("administrator");
		session.invalidate();

		ModelAndView model = new ModelAndView();
		model.addObject("msg", "管理员退出成功");
		model.setViewName("administrator/administratorlogin");
		return model;
	}

	@RequestMapping("/check/administratorfinduncheckedguide")
	public ModelAndView administratorfinduncheckedguide(HttpSession session)
	{
		List<Guide> guidelist = administratorService.findUncheckedGuide();

		ModelAndView model = new ModelAndView();
		model.addObject("guidelist", guidelist);
		model.setViewName("administrator/check/administratorfinduncheckedguide");
		return model;
	}

	@RequestMapping("/check/administratorcheckguide")
	public ModelAndView administratorcheckguide(Integer guideId)
	{
		administratorService.checkGuide(guideId);
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "审核成功");
		model.setViewName("administrator/administratorsuccess");
		return model;
	}
}
