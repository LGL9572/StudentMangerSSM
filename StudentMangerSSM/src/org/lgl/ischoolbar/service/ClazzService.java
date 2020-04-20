package org.lgl.ischoolbar.service;

import java.util.List;
import java.util.Map;

import org.lgl.ischoolbar.entity.Clazz;
import org.springframework.stereotype.Service;

/**
 *.°à¼¶service
 * @author Lenovo
 *
 */
@Service
public interface ClazzService {
	
	public int add(Clazz clazz);
	
	public List<Clazz> findList(Map<String,Object> queryMap);
	
	public List<Clazz> findAll();
	
	public int getTotal	(Map<String,Object> queryMap);
	
	public int edit(Clazz clazz);
	
	public int delete(String ids);
	
	
}
