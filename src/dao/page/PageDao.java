package dao.page;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import entity.Dept;
@Repository
public class PageDao extends HibernateDaoSupport{
	/**
	 * 分页查询
	 * 思路：定义一个分页查询的方法，设置参数：当页页号和每页显示多少条记录
	 * @param hql
	 *            查询的条件
	 * @param start
	 *            开始记录
	 * @param length
	 *            一次查询几条记录
	 * @return 返回查询记录集合
	 */
	public List<Dept> queryForPage(int start, int length) {
		List<Dept> entitylist = null;
		try {
			Session session = getSessionFactory().openSession();
			Query query = session.createQuery("from Dept");
			query.setFirstResult(start);
			query.setMaxResults(length);
			entitylist = query.list();
			session.close();

		} catch (RuntimeException re) {
			throw re;
		}

		return entitylist;
	}

	public int getAllRowCount() {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("select count(distinct d.id) from Dept d");
		Number number = (Number) query.uniqueResult();
		int allRow = number.intValue();
		//page.setTotalCount(number.longValue());
		return allRow;
	}
}
