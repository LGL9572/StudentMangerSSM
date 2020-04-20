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
 * 	��¼������������
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
			//��ʾδ��¼���߱�ʾ��¼״̬ʧЧ
			System.out.println( ".��ʾδ��¼���߱�ʾ��¼״̬ʧЧ url:"+url);
			if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
				//ajax����
				Map<String,String> ret = new HashMap<>();
					ret.put("type", "error");
					ret.put("msg", ".��¼״̬��ʧЧ,�����µ�¼!!!");
					response.getWriter().write(JSONObject.fromObject(ret).toString());
					return false;
			}
			response.sendRedirect(request.getContextPath()+"/system/login");
			return false;
		}
		return true;
	}
	
}
