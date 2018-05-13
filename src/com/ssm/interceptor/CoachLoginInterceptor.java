package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.po.Coach;
import com.ssm.po.User;

public class CoachLoginInterceptor implements HandlerInterceptor
{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{

		HttpSession session = request.getSession();
		Coach coach = (Coach) session.getAttribute("coach");

		if (coach != null)
		{
			return true;
		}

		request.getRequestDispatcher("/jsp/coach/coachlogin.jsp").forward(request, response);

		return false;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception
	{

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception
	{

	}
}
