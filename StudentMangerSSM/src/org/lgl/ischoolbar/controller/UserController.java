package org.lgl.ischoolbar.controller;

import java.util.HashMap;
import java.util.Map;

import org.lgl.ischoolbar.entity.User;
import org.lgl.ischoolbar.page.Page;
import org.lgl.ischoolbar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.util.StringUtil;

/**
 * 
 * @author Lenovo
 *
 */
@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired  
	private UserService UserService;
	
	/**
	 * .�û������б���
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model) {
		model.setViewName("user/user_list");
		return model;
	}
	
	/**
	 * .��ȡ�û��б�
	 * @param username
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/get_list",method=RequestMethod.POST)
	public Map<String,Object> getList(
			@RequestParam(value="username",required=false,defaultValue="")String username,
			Page page
			){
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("username", "%"+username+"%");
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", UserService.findList(queryMap));
		ret.put("total", UserService.getTotal(queryMap));
		return ret;
	}
	
	/**
	 * .ɾ���û�����
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Map<String,String> delete(
			@RequestParam(value="ids[]",required=true)Long[] ids){
		Map<String,String> ret = new HashMap<String,String>();
		ret.put("ids", ids.toString());
		if(ids == null) {
			ret.put("type", "error");
			ret.put("msg", ".��ѡ��Ҫɾ��������");
			return ret;
		}
		String idsString = "";
		for (Long id : ids) {
			idsString += id + ",";
		}
		idsString = idsString.substring(0, idsString.length()-1);
		if(UserService.delete(idsString)<=0) {
			ret.put("type", "error");
			ret.put("msg", ".ɾ��ʧ��!!!");
			return ret;	
		}
		ret.put("type", "success");
		ret.put("msg", ".ɾ���ɹ�");
		return ret;
	}
	
	/**
	 * .�༭�û�����
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,String> edit(User user){
		Map<String,String> ret = new HashMap<String,String>();
		if(user == null) {
			ret.put("type", "error");
			ret.put("msg", ".���ݰ󶨳���,����ϵ��������!!!");
			return ret;
		}
		if(StringUtils.isEmpty(user.getUsername())) {
			ret.put("type", "error");
			ret.put("msg", ".�û�������Ϊ��!!!");
			return ret;
		}
		if(StringUtil.isEmpty(user.getPassword())) {
			ret.put("type", "error");
			ret.put("msg", ".���벻��Ϊ��!!!");
			return ret;
		}
		User exitsUser = UserService.findByUserName(user.getUsername());
		if(exitsUser!=null) {
			if(user.getId()!=exitsUser.getId()) {
				ret.put("type", "error");
				ret.put("msg", ".���û����Ѿ�����,�޸�ʧ��!!!");
				return ret;				
			}
		}
		if(UserService.edit(user)<=0) {
			ret.put("type", "error");
			ret.put("msg", ".�޸�ʧ��!!!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", ".�޸ĳɹ�");
		return ret;
	}
	
	/**
	 * .����û�����
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,String> add(User user){
		Map<String,String> ret = new HashMap<String,String>();
		if(user == null) {
			ret.put("type", "error");
			ret.put("msg", ".���ݰ󶨳���,����ϵ��������!!!");
			return ret;
		}
		if(StringUtils.isEmpty(user.getUsername())) {
			ret.put("type", "error");
			ret.put("msg", ".�û�������Ϊ��!!!");
			return ret;
		}
		if(StringUtil.isEmpty(user.getPassword())) {
			ret.put("type", "error");
			ret.put("msg", ".���벻��Ϊ��!!!");
			return ret;
		}
		User exitsUser = UserService.findByUserName(user.getUsername());
		if(exitsUser!=null) {
			ret.put("type", "error");
			ret.put("msg", ".���û����Ѿ�����,���ʧ��!!!");
			return ret;
		}
		if(UserService.add(user)<=0) {
			ret.put("type", "error");
			ret.put("msg", ".���ʧ��!!!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", ".��ӳɹ�");
		return ret;
	}

	
}
