package com.laptrinhjavaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		System.out.println("Chuan bi vao check");
		if (url.startsWith("/admin")) {
			System.out.println("Dang vao trang admin");
			UserModel model = (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
			if (model != null) {
				System.out.println("model da khac null");
				if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
					System.out.println("day chinh la admin");
					chain.doFilter(servletRequest, servletResponse);
				} else if (model.getRole().getCode().equals(SystemConstant.USER)) {
					System.out.println("day chinh la user");
					response.sendRedirect(
							request.getContextPath() + "/dang-nhap?action=login&message=not_permission&alert=danger");

				}
			} else {
				System.out.println("model da bang null");
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
			}
		} else {
			System.out.println("Khong vao trang admin");
			chain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
