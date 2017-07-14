package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import service.IUserService;
import dao.UserDao;
import entity.User;

public class IUserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;
	public User getByAccount(String name) {
		return userDao.getUser(name);
	}
}
