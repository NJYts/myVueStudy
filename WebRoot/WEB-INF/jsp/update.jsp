<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<head>

<title>My JSP 'update.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form action="update_dept" method="post">
		<table border="1">
			<tr>
				<td><input type="hidden" name="deptNo" value="${dept.deptNo }" /></td>
			</tr>
			<tr>
				<td>部门名称：</td>
				<td><input name="deptName" value="${dept.deptName }" /></td>
			</tr>
			<tr>
				<td>部门地址：</td>
				<td><input name="location" value="${dept.location }" /></td>
			</tr>
			<tr>
				<td>是否停用：</td>
				<td><select name="status">
							<option value="1" ${dept.status==1?"selected='selected'":""}>启用</option>

							<option value="0" ${dept.status==0?"selected='selected'":""}>停用</option>
						</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
