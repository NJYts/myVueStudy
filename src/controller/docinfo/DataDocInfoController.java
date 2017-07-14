package controller.docinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import controller.BaseController;

@Controller
@RequestMapping(value = "/docinfo")
public class DataDocInfoController extends BaseController {
	static String[] data = { "rm-2ze1h8l9qt5822mmr.mysql.rds.aliyuncs.com", "3306", "pom", "cctvroot","Cctvroot123" };
	static String[] data2 = { "127.0.0.1", "3306", "sh", "root","123456" };
	/**
	 * 远程连接入库
	 */
	public void saveDocInfo(){
		Connection connection = getConnection(data2);
		String sqlid = "SELECT last_id FROM `wise_address_log` where id=2;";
		String sql = "SELECT title,site_name,author,url,publishtime,source,content,gathertime,inserttime,id,group_id  FROM `wise_web_docinfo` ";
		Connection remoteConn = null;
		Statement remoteStatment = null;
		ResultSet resultSet = null;
		long lastId = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sqlid);
		
			if(result.next()){
				Long id = Long.parseLong(result.getObject(1).toString());
				lastId = id;
				sql += "where id>"+id;
			}
			free(result,statement,connection);
			
			remoteConn = getConnection(data);
			remoteStatment= remoteConn.createStatement();
			resultSet = remoteStatment.executeQuery(sql);
			int count = 0;
			while (resultSet.next()) {
				String title = resultSet.getString(1);
				delHTMLTag(title);
				String siteName = resultSet.getString(2);
				String author = resultSet.getString(3);
				String url = resultSet.getString(4);
				String publishtime = resultSet.getString(5);
				String publishtime1 = publishtime.substring(0,
				publishtime.lastIndexOf("."));
				String source = resultSet.getString(6);
				String content = resultSet.getString(7);
				String gathertime = resultSet.getString(8);
				String gathertime1 = publishtime.substring(0,gathertime.lastIndexOf("."));
				String inserttime = resultSet.getString(9);
				Date date = new Date(Long.parseLong(inserttime) * 1000L);
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String inserttime1 = format.format(date);
				lastId = resultSet.getLong(10);
				int groupId = resultSet.getInt(11);
				try {
					StringBuilder sqlBuilder = new StringBuilder(
							"insert ignore into 'wise_web_docinfo' (title,site_name,group_id,author,url,publishtime,source,content,gathertime,inserttime) values");
					count++;
					sqlBuilder.append("(").append("'" + title + "',")
							.append("'" + siteName + "',").append(groupId + ",")
							.append("'" + author + "',")
							.append("'" + url + "',")
							.append("'" + publishtime1 + "',")
							.append("'" + source + "',")
							.append("'" + content + "',")
							.append("'" + gathertime1 + "',")
							.append("'" + inserttime1 + "'").append(");");
					System.out.println("保存第" + count + "条");
					System.out.println(sqlBuilder);
					remoteStatment.addBatch(sqlBuilder.toString());
					if (count % 100 == 0) {
						remoteStatment.executeBatch();
						remoteStatment.clearBatch();
						count=0;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			}
			if (count > 0) {
				String sqlSetId = "UPDATE  wise_address_log SET last_id="
						+ lastId + ",publishtime= NOW() WHERE id = 1;";
				remoteStatment.addBatch(sqlSetId);
				remoteStatment.executeBatch();
				remoteStatment.clearBatch();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			free(resultSet, remoteStatment, remoteConn);
		}
	}
	
	
	public static Connection getConnection(String[] dataConnection){
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		//1 URL指向要访问的数据库名scutcs
		String url = "jdbc:mysql://" + dataConnection[0] + ":"
				+ dataConnection[1] + "/" + dataConnection[2];
		//2 MySQL配置时的用户名
		String user = dataConnection[3];
		//3 Java连接MySQL配置时的密码
		String password = dataConnection[4];
		//4 加载驱动程序
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//5 连续数据库
		try {
			conn =  DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("链接失败");
		}
		return conn;
	}
	
	public static void free(ResultSet resultset, Statement statement, Connection conn) {
		// this.docInfoManager.getSession().clear();
		// 6.释放资源
		try {
			if (resultset != null)
				resultset.close();
			if (statement != null)
				statement.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public static String delHTMLTag(String htmlStr) {
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
		String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

		Pattern p_script = Pattern.compile(regEx_script,
				Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern
				.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签

		return htmlStr.trim(); // 返回文本字符串
	}
	
}
