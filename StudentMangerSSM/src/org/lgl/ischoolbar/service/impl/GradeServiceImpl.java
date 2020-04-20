package org.lgl.ischoolbar.service.impl;

import java.util.List;
import java.util.Map;

import org.lgl.ischoolbar.dao.GradeDao;
import org.lgl.ischoolbar.entity.Grade;
import org.lgl.ischoolbar.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao gradedao;

	@Override
	public int add(Grade grade) {
		return gradedao.add(grade);
	}

	@Override
	public List<Grade> findList(Map<String, Object> queryMap) {
		return gradedao.findList(queryMap);
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		return gradedao.getTotal(queryMap);
	}

	@Override
	public int edit(Grade grade) {
		return gradedao.edit(grade);
	}

	@Override
	public int delete(String ids) {
		return gradedao.delete(ids);
	}

	@Override
	public List<Grade> findAll() {
		return gradedao.findAll();
	}
	
}
