package org.lgl.ischoolbar.service.impl;

import java.util.List;
import java.util.Map;

import org.lgl.ischoolbar.dao.StudentDao;
import org.lgl.ischoolbar.entity.Student;
import org.lgl.ischoolbar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentdao;
	
	@Override
	public int add(Student student) {
		return studentdao.add(student);
	}

	@Override
	public List<Student> findList(Map<String, Object> queryMap) {
		return studentdao.findList(queryMap);
	}

	@Override
	public List<Student> findAll() {
		return studentdao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		return studentdao.getTotal(queryMap);
	}

	@Override
	public int edit(Student student) {
		return studentdao.edit(student);
	}

	@Override
	public int delete(String ids) {
		return studentdao.delete(ids);
	}

	@Override
	public Student findByUserName(String usernmae) {
		return studentdao.findByUserName(usernmae);
	}

}
