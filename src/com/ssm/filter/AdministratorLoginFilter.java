package com.ssm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssm.po.Administrator;

public class AdministratorLoginFilter implements Filter
{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();

		Administrator administrator = (Administrator) session.getAttribute("administrator");

		if (administrator == null)
		{
			servletRequest.getRequestDispatcher("/jsp/administrator/administratorlogin.jsp").forward(servletRequest,
					servletResponse);
		} else
		{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy()
	{
	}

}
