package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	User getUser(String name);

	User findOne(Long id);

	List<User> findAll();

	User findByLoginName(String loginName);

	User findUserByToken(String token);

	void save(User user);

	
}
