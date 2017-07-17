package controller.dept;


import java.util.List;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.PageService;
import dao.DeptDao;
import dao.UserDao;
import entity.Dept;
import entity.User;
import entity.page.Page;

@Controller
@RequestMapping(value = "/dept")
public class DeptController {
	private User user;
	private JSONObject result;
	private List<Dept> lsDept;
	/*@Resource*/
	@Autowired
	private PageService PageService;
	
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private UserDao userDao;

	/**
	 * 判断用户是否登录
	 * @param currUser
	 * @return
	 */
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public void isLogin(User deluuser){
		Subject user = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(deluuser.getName(), deluuser.getPassword());  
		token.setRememberMe(true);
	    try {  
	        //4、登录，即身份验证  
	    	user.login(token); 
	        System.out.println("登录");
	    } catch (AuthenticationException e) {  
	    	System.out.println("身份验证失败");
	        //5、身份验证失败  
	    }  
	}
	/**
	 * 分页展示
	 * 
	 * @param request 路径 对应工作空间@RequestMapping 的顺序，不需要加项目结构路径
	 * @param response 路径 jsp对应项目结构路径
	 * @return
	 */
	@RequestMapping(value = "/showAll")
    public String list(HttpServletRequest request) {
		System.out.println("showAll 方法");
        try {
            String pageNo = request.getParameter("pageNo");
            if (pageNo == null) {
                pageNo = "1";
            }
            Page page = PageService.queryForPage(Integer.valueOf(pageNo), 6);
            request.setAttribute("page", page);
            List<Dept> course = page.getList();
            request.setAttribute("courses", course);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
	/**
	 * ͨ获取dept
	 * */
	@RequestMapping(value = "/getById_dept")
	public String getById(Dept dept,HttpServletRequest request) {
		dept = deptDao.get(dept);
		request.setAttribute("dept", dept);
		return "update";
	}

	/**
	 * 添加
	 * */
	@RequestMapping(value = "/save_dept")
	public String addDept(Dept dept, HttpServletRequest request) {
		deptDao.save(dept);
		
		return this.list(request);
	}
	/**
	 *删除
	 * */
	@RequestMapping(value = "/delete_dept")
	public String delete(Dept dept,  HttpServletRequest request) {
		deptDao.delete(dept);
		this.list(request);
		return "success.jsp";
	}
	/**
	 * 修改
	 * */
	@RequestMapping(value = "/update_dept")
	public String update(Dept dept,HttpServletRequest request) {
		deptDao.update(dept);
		
		return this.list(request);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/vue")
	public String vue(@RequestParam("flag") String flag){
		if(flag.equals("2")){
			return "vue/vue2";
		}else{
			return "vue/vue";
		}
		
	}
	/**
	 * 登录验证֤
	 * */
	@RequestMapping(value = "/login_user")
	/*public String login(User user, HttpServletRequest request,Model model) {
		User user1 = userDao.getUser(user);
		if (user1 == null) {
			return "login.jsp";
		}
		if (user.getPassword().equals(user1.getPassword())) {
			deptDao.select();
			this.select(model);
			return "success.jsp";
		} else {
			return "login.jsp";
		}

	}
	*/
	

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Dept> getLsDept() {
		return lsDept;
	}

	public void setLsDept(List<Dept> lsDept) {
		this.lsDept = lsDept;
	}
	public void setPageService(PageService pageService) {
		PageService = pageService;
	}
	

	
}
