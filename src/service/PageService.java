package service;

import entity.page.Page;
 
public interface PageService {
	    @SuppressWarnings("rawtypes")
		public Page queryForPage(int currentPage,int pageSize);
	
}
