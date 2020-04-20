package org.lgl.ischoolbar.dao;

import java.util.List;
import java.util.Map;

import org.lgl.ischoolbar.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao {
	
	public Student findByUserName(String usernmae);
	
	public int add(Student student);
	
	public List<Student> findList(Map<String,Object> queryMap);
	
	public List<Student> findAll();
	
	public int getTotal	(Map<String,Object> queryMap);
	
	public int edit(Student student);
	
	public int delete(String ids);

}
