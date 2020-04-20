package org.lgl.ischoolbar.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.lgl.ischoolbar.entity.Grade;
import org.lgl.ischoolbar.page.Page;
import org.lgl.ischoolbar.service.GradeService;
import org.lgl.ischoolbar.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/grade")
@Controller
public class GradeController {
	
	@Autowired
	private GradeService gradeService;
	/**
	 * .�꼶�б�ҳ
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("grade/grade_list");
		return model;
	}
	/**
	 * .��ȡ�꼶�б�
	 * @param name
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/get_list",method=RequestMethod.POST)
	public Map<String,Object> getList(
			@RequestParam(value="name",required=false,defaultValue="")String name,
			Page page
			){
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("name", "%"+name+"%");
		queryMap.put("offset", page.getOffset());
		queryMap.put("pageSize", page.getRows());
		ret.put("rows", gradeService.findList(queryMap));
		ret.put("total", gradeService.getTotal(queryMap));
		return ret;
	}
	/**
	 *.�༭�꼶��Ϣ
	 * @param grade
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public Map<String,String> edit(Grade grade){
		Map<String,String> ret = new HashMap<String,String>();
		if(StringUtils.isEmpty(grade.getName())) {
			ret.put("type", "error");
			ret.put("msg", ".�꼶���Ʋ���Ϊ��");
			return ret;
		}
		if(gradeService.edit(grade)<=0) {
			ret.put("type", "error");
			ret.put("msg", ".�꼶�޸�ʧ��");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", ".�꼶�ɹ�");
		return ret;
	}
	/**
	 * .����꼶��Ϣ
	 * @param grade
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Map<String,String> add(Grade grade){
		Map<String,String> ret = new HashMap<>();
		if(StringUtils.isEmpty(grade.getName())) {
			ret.put("type", "error");
			ret.put("msg", ".�꼶���Ʋ���Ϊ��");
			return ret;
		}
		if(gradeService.add(grade)<=0) {
			ret.put("type", "error");
			ret.put("msg", ".�꼶���ʧ��");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", ".�꼶��ӳɹ�");
		return ret;
	}
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Map<String,String> delete(
			@RequestParam(value="ids[]",required=true)Long[] ids){
		Map<String,String> ret = new HashMap<>();
		if(ids==null || ids.length==0) {
			ret.put("type", "error");
			ret.put("msg", ".��ѡ��Ҫɾ��������");
			return ret;
		}
		try {
			if(gradeService.delete(StringUtil.joinString(Arrays.asList(ids), ","))<=0) {
				ret.put("type", "error");
				ret.put("msg", ".ɾ��ʧ��");
				System.out.println("1");
				return ret;
			}			
		}catch (Exception e) {
			ret.put("type", "error");
			ret.put("msg", ".���꼶�´��ڰ༶��Ϣ,�޷�ɾ��");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", ".�꼶ɾ���ɹ�");
		return ret;
	}
}
