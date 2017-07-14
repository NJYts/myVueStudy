package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import dao.DeptDao;
import entity.Dept;
//@Repository
public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao{

	@Override
	public void save(Dept dept) {
		super.getHibernateTemplate().save(dept);
	}

	@Override
	public void delete(Dept dept) {
		super.getHibernateTemplate().delete(this.get(dept));		
	}

	@Override
	public List<Dept> select() {
		return (List<Dept>) super.getHibernateTemplate().find("from Dept");
	}

	@Override
	public Dept get(Dept dept) {
		return super.getHibernateTemplate()
				.get(Dept.class, dept.getDeptNo());
		
	}

	@Override
	public void update(Dept dept) {
		super.getHibernateTemplate().update(dept);
		
	}


}





