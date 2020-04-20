package org.lgl.ischoolbar.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lgl.ischoolbar.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;

/**
 * 	登录过滤器拦截器
 * @author Lenovo
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception e)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView modelAndView)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String url = request.getRequestURI();
		Object user = request.getSession().getAttribute("user");
		if(user == null) {
			//表示未登录或者表示登录状态失效
			System.out.println( ".表示未登录或者表示登录状态失效 url:"+url);
			if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
				//ajax请求
				Map<String,String> ret = new HashMap<>();
					ret.put("type", "error");
					ret.put("msg", ".登录状态以失效,请重新登录!!!");
					response.getWriter().write(JSONObject.fromObject(ret).toString());
					return false;
			}
			response.sendRedirect(request.getContextPath()+"/system/login");
			return false;
		}
		return true;
	}
	
}
