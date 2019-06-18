package com.ch.lesson.utils.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ch.lesson.entity.User;
import com.ch.lesson.utils.Result;
import com.ch.lesson.utils.exception.NotFoundException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 * 登录认证的拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * Handler执行完成之后调用这个方法
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exc)
			throws Exception {

	}

	/**
	 * Handler执行之后，ModelAndView返回之前调用这个方法
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * Handler执行之前调用这个方法
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的URL
		String url = request.getRequestURI();
		// 配置不拦截的URL，其中登录页和获取验证码的路径不拦截
		if ((url.indexOf("tologin") >= 0)||
				(url.indexOf("validateCode")>=0)||
				(url.indexOf("vueLogin")>=0)) {
			return true;
		}
		// 获取Session
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("account");
		System.out.println(user);
		if (user != null) {
			return true;
		}else {
			// 不符合条件的，跳转到登录界面
			throw new NotFoundException("您还未登录，请先登录！",Result.ErrorCode.USER_UN_LOGIN.getCode());
//			request.getRequestDispatcher("/tologin").forward(request, response);
		}
//		return false;
	}

}
