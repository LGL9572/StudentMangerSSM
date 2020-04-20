package org.lgl.ischoolbar.service.impl;

import java.util.List;
import java.util.Map;

import org.lgl.ischoolbar.dao.UserDao;
import org.lgl.ischoolbar.entity.User;
import org.lgl.ischoolbar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	
	@Override
	public User findByUserName(String username) {
		return userdao.findByUserName(username);
	}

	@Override
	public int add(User user) {
		return userdao.add(user);
	}

	@Override
	public List<User> findList(Map<String,Object> queryMap) {
		return userdao.findList(queryMap);
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		return userdao.getTotal(queryMap);
	}

	@Override
	public int edit(User user) {
		return userdao.edit(user);
	}

	@Override
	public int delete(String ids) {
		return userdao.delete(ids);
	}

}
