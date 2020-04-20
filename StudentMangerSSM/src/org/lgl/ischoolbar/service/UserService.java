package org.lgl.ischoolbar.service;

import java.util.List;
import java.util.Map;

import org.lgl.ischoolbar.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	public User findByUserName(String username);
	
	public int add(User user);
	
	public List<User> findList(Map<String,Object> queryMap);
	
	public int getTotal	(Map<String,Object> queryMap);
	
	public int edit(User user);
	
	public int delete(String ids);
}
