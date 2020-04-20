package org.lgl.ischoolbar.service.impl;

import java.util.List;
import java.util.Map;

import org.lgl.ischoolbar.dao.ClazzDao;
import org.lgl.ischoolbar.entity.Clazz;
import org.lgl.ischoolbar.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzSerivceImpl implements ClazzService {

	@Autowired
	private ClazzDao clazzDao;
	
	@Override
	public int add(Clazz clazz) {
		return clazzDao.add(clazz);
	}

	@Override
	public List<Clazz> findList(Map<String, Object> queryMap) {
		return clazzDao.findList(queryMap);
	}

	@Override
	public List<Clazz> findAll() {
		return clazzDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		return clazzDao.getTotal(queryMap);
	}

	@Override
	public int edit(Clazz clazz) {
		return clazzDao.edit(clazz);
	}

	@Override
	public int delete(String ids) {
		return clazzDao.delete(ids);
	}

}
