package dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.UserDao;
import entity.User;
//@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User getUser(String name) {
		
		String hql = "from User u where u.name='"+name+"'";
//		String sql = "select * from user where userName = '"+user.getName()+"'";
		Session session = this.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
//		Query query = session.createSQLQuery(sql);
		
		Object result = query.uniqueResult();
		session.close();
		if(result != null){
			return (User)result;
		}
		return null;
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

}
