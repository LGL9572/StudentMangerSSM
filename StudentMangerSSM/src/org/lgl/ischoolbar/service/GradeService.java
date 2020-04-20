package org.lgl.ischoolbar.service;

import java.util.List;
import java.util.Map;

import org.lgl.ischoolbar.entity.Grade;
import org.springframework.stereotype.Service;

/**
 *.service
 * @author Lenovo
 *
 */
@Service
public interface GradeService {
	
	public int add(Grade grade);
	
	public List<Grade> findList(Map<String,Object> queryMap);
	
	public List<Grade> findAll();
	
	public int getTotal	(Map<String,Object> queryMap);
	
	public int edit(Grade grade);
	
	public int delete(String ids);
	
	
}
