package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DeptDao;
import dao.impl.DeptDaoImpl;
import entity.Dept;

public class Test11 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DeptDao deptDao = ac.getBean(DeptDao.class, "deptDao");
		Dept dept = new Dept();
		dept.setDeptName("zzzzzzzzzz");
		dept.setLocation("zzzzzzzzzz");
		deptDao.save(dept);
		/*List<Dept> list = deptDao.select();
		for (Dept dept2 : list) {
			System.out.println(dept2.getDeptNo()+dept2.getDeptName()+dept2.getLocation()+dept2.getStatus()+"\n");
		}*/
		String str1 = "<'https://zhidao.baidu.com/question/575203023.html'>";
		String str2 = str1.replace("<", "&lt;").replace(">", "&gt;").replace("&ldquo;", "").replace("&rdquo;", "").replace("&", "&amp;").replace("'", "&apos;").replace("\"", "&quot;")+"</URL>";
		
	}
	

}
