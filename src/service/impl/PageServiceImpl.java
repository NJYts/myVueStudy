package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.PageService;
import dao.DeptDao;
import dao.page.PageDao;
import entity.Dept;
import entity.page.Page;
//@Service("PageService") 
@Service
@Transactional
public class PageServiceImpl implements PageService {
	
	private PageDao pageDao;
	@Autowired
	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}
	/*思路：
	
	定义一个分页查询的方法，设置参数：当页页号和每页显示多少条记录，返回查询结果的分页类对象（Page）
	通过Dao层，获取查询实体的总记录数
	获取当前页开始记录数
	通过Dao层，获取分页查询结果集
	Set入page对象
	代码如下：

	复制代码*/
	/**
	     * 分页查询 
	     * @param currentPage 当前页号：现在显示的页数
	     * @param pageSize 每页显示的记录条数
	     * @return 封闭了分页信息(包括记录集list)的Bean
	     * */
	
	    public Page queryForPage(int currentPage,int pageSize) {
	        Page page = new Page();
	        //总记录数
	        int allRow = pageDao.getAllRowCount();
	        //当前页开始记录
	        int start = page.countOffset(currentPage,pageSize);
	        //分页查询结果集
	        List<Dept> list = pageDao.queryForPage(start, pageSize);

	        page.setPageNo(currentPage);
	        page.setPageSize(pageSize);
	        page.setTotalRecords(allRow);
	        page.setList(list); 
	        return page;
	    }

	


}
