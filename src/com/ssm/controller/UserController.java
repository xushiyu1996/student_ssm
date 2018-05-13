package com.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.mapper.PaidGuideMapper;
import com.ssm.po.Coach;
import com.ssm.po.Guide;
import com.ssm.po.PaidGuide;
import com.ssm.po.User;
import com.ssm.service.CoachService;
import com.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;

	@Autowired
	private CoachService coachservice;

	@RequestMapping("/userRegist")
	public ModelAndView userRegist(@Validated User user, BindingResult bindingResult)
	{
		String userUsername = user.getUserUsername();

		if (bindingResult.hasErrors())
		{
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			ModelAndView model = new ModelAndView();
			model.addObject("allErrors", allErrors);
			model.setViewName("user/userregist");
			return model;
		}

		if (userService.hasUser(userUsername))
		{
			ModelAndView model = new ModelAndView();
			model.addObject("msg", "已经有用户名");
			model.setViewName("user/userfail");
			return model;
		}
		user.setUserMoney(20000);
		user.setUserNumber(0);
		userService.userRegist(user);

		ModelAndView model = new ModelAndView();
		model.addObject("msg", "用户注册成功");
		model.setViewName("user/usersuccess");
		return model;
	}

	@RequestMapping("/userLogin")
	public String userLogin(@RequestParam("userUsername") String userUsername,
			@RequestParam("userPassword") String userPassword, HttpServletRequest request)
	{
		User user = new User();
		user.setUserUsername(userUsername);
		user.setUserPassword(userPassword);
		user = userService.selectUserByUserNameAndPassword(user);
		if (user == null)
		{
			request.setAttribute("msg", "用户名密码不正确");
			return "user/userfail";
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		request.setAttribute("msg", "用户登陆成功");
		return "user/usersuccess";

	}

	@RequestMapping("/userLogout")
	public ModelAndView userLogout(HttpSession session)
	{
		session.removeAttribute("user");
		session.invalidate();

		ModelAndView model = new ModelAndView();
		model.addObject("msg", "用户退出成功");
		model.setViewName("user/userlogin");
		return model;
	}

	@RequestMapping("/check/getCheckedGuides")
	public ModelAndView getCheckedGuides(HttpSession session)
	{
		List<Guide> guidelist = userService.getCheckedGuides();

		ModelAndView model = new ModelAndView();
		model.addObject("guidelist", guidelist);
		model.setViewName("user/check/getcheckedguides");
		return model;
	}

	@RequestMapping("/getDetailedGuide/{guideId}")
	public ModelAndView getDetailedGuide(@PathVariable(value = "guideId") Integer guideId)
	{
		Guide guide = userService.getGuideById(guideId);
		int coachId = guide.getCoachId();
		Coach coach = coachservice.getCoachByCoachId(coachId);
		List<PaidGuide> paidguidelist = userService.findPaidGuideByGuideId(guideId);

		ModelAndView model = new ModelAndView();
		model.addObject("guide", guide);
		model.addObject("coach", coach);
		model.addObject("paidguidelist", paidguidelist);
		model.setViewName("user/getdetailedguide");
		return model;
	}

	@RequestMapping("/check/buyGuide/{guideId}")
	public ModelAndView buyGuide(@PathVariable(value = "guideId") Integer guideId, HttpSession session)
	{
		Guide guide = userService.getGuideById(guideId);
		User user = (User) session.getAttribute("user");
		Coach coach = coachservice.getCoachByCoachId(guide.getCoachId());
		PaidGuide paidguide = new PaidGuide();

		paidguide.setGuideId(guide.getGuideId());
		paidguide.setGuideName(guide.getGuideName());
		paidguide.setUserId(user.getUserId());
		paidguide.setUserName(user.getUserName());
		paidguide.setCoachId(guide.getCoachId());
		paidguide.setCoachName(guide.getCoachName());
		paidguide.setGuidePrice(guide.getGuidePrice());
		paidguide.setGuideRate(-1);

		if (user.getUserMoney() < guide.getGuidePrice())
		{
			ModelAndView model = new ModelAndView();
			model.addObject("msg", "账户余额不足");
			model.setViewName("user/userfail");
			return model;
		}
		if (userService.hasPaidGuide(paidguide) == 1)
		{
			ModelAndView model = new ModelAndView();
			model.addObject("msg", "用户已购买此商品");
			model.setViewName("user/userfail");
			return model;
		}

		guide.setGuideNumber(guide.getGuideNumber() + 1);
		userService.setGuideNumber(guide);

		userService.buyGuide(paidguide);

		user.setUserMoney(user.getUserMoney() - guide.getGuidePrice());
		user.setUserNumber(user.getUserNumber() + 1);
		userService.updateUserMoney(user);
		session.setAttribute("user", user);
		coach.setCoachMoney(coach.getCoachMoney() + guide.getGuidePrice());
		coach.setCoachNumber(coach.getCoachNumber() + 1);
		coachservice.updateCoachMoney(coach);

		ModelAndView model = new ModelAndView();
		model.addObject("msg", "购买成功");
		model.setViewName("user/usersuccess");
		return model;
	}

	@RequestMapping("/check/findPaidGuideByUserId")
	public ModelAndView findPaidGuideByUserId(HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		Integer userId = user.getUserId();
		List<PaidGuide> listpaidguide = userService.findPaidGuideByUserId(userId);
		List<Guide> guidelist = new ArrayList<>();
		List<Coach> coachlist = new ArrayList<>();
		for (PaidGuide paidGuide : listpaidguide)
		{
			Guide guide = userService.getGuideById(paidGuide.getGuideId());
			Coach coach = userService.getCoachByCoachId(paidGuide.getCoachId());
			guidelist.add(guide);
			coachlist.add(coach);
		}
		Long length = new Long((long) listpaidguide.size());
		ModelAndView model = new ModelAndView();
		model.addObject("listpaidguide", listpaidguide);
		model.addObject("guidelist", guidelist);
		model.addObject("coachlist", coachlist);
		model.addObject("length", length);

		model.setViewName("user/check/findpaidguidebyuserid");
		return model;
	}

	@RequestMapping("/selectguidebykey")
	public ModelAndView selectguidebykey(String key)
	{
		List<Guide> guidelist = userService.selectGuideByKey(key);

		ModelAndView model = new ModelAndView();
		model.addObject("guidelist", guidelist);
		model.setViewName("user/guidelist");
		return model;
	}

	@RequestMapping("/check/ratepaidguide")
	public ModelAndView ratepaidguide(@Validated PaidGuide paidguide, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			ModelAndView model = new ModelAndView();
			model.addObject("allErrors", allErrors);
			model.setViewName("user/check/remarkpaidguide");
			return model;
		}
		userService.ratePaidGuide(paidguide);
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "评价成功");
		model.setViewName("user/usersuccess");
		return model;
	}

	@RequestMapping("/check/getpaidguide/{guideId}")
	public ModelAndView getpaidguide(@PathVariable(value = "guideId") Integer guideId, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		Integer userId = user.getUserId();
		PaidGuide paidguide = new PaidGuide();
		paidguide.setGuideId(guideId);
		paidguide.setUserId(userId);
		paidguide = userService.findPaidGuideByUserIdAndGuideId(paidguide);

		ModelAndView model = new ModelAndView();
		model.addObject("paidguide", paidguide);
		model.setViewName("user/check/remarkpaidguide");
		return model;
	}

	@RequestMapping("/check/updateuserinfomation")
	public ModelAndView updateuserinfomation(@Validated User user, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors())
		{
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			ModelAndView model = new ModelAndView();
			model.addObject("allErrors", allErrors);
			model.setViewName("user/check/updateuserinfomation");
			return model;
		}
		userService.updateUserInfomation(user);
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "用户修改信息成功");
		model.setViewName("user/usersuccess");
		return model;
	}

	@RequestMapping("/getcoachinfomation")
	public ModelAndView getcoachinfomation(@RequestParam(value = "coachId") Integer coachId)
	{
		Coach coach = coachservice.getCoachByCoachId(coachId);
		List<Guide> guidelist = userService.findGuideByCoachId(coachId);
		ModelAndView model = new ModelAndView();
		model.addObject("coach", coach);
		model.addObject("guidelist", guidelist);
		model.setViewName("user/getcoachinfomation");
		return model;
	}

	@RequestMapping("/check/findguidebycoachid")
	public ModelAndView findguidebycoachid(Integer coachId)
	{
		List<Guide> guidelist = coachservice.findGuideByCoachId(coachId);
		ModelAndView model = new ModelAndView();
		model.addObject("guidelist", guidelist);
		model.setViewName("user/check/getcheckedguides");
		return model;
	}

	@RequestMapping("/index")
	public ModelAndView index(Integer coachId)
	{
		List<Coach> coachlist = userService.getCoachOrderByNumber();
		List<Coach> coachlist2 = userService.getCoachOrderByNumber2();

		ModelAndView model = new ModelAndView();
		model.addObject("coachlist", coachlist);
		model.addObject("coachlist2", coachlist2);

		model.setViewName("user/index");
		return model;
	}

	@RequestMapping("/selectguidebytype/{guideType}")
	public ModelAndView selectguidebytype(@PathVariable(value = "guideType") String type)
	{
		List<Guide> guidelist = userService.selectGuideByType(type);

		ModelAndView model = new ModelAndView();
		model.addObject("guidelist", guidelist);

		model.setViewName("user/guidelist");
		return model;
	}

}
