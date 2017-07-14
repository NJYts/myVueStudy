<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>login.jsp</title>

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

	<form action="${ctx}/dept/showAll" id="form" method="post">
		<div align="center"
			style="position:absolute; top:50%; left:50%; margin-left:-290px; margin-top:-290px;">
			<table width="200px" height="100px" cellpadding="0" cellspacing="0" align="center">
				<tr align="center">
					<td><img src="/images/qingyun.jpg"/></td>
				</tr>
			</table>
			
			<table border="1" align="center">
				<tr>
					<td>姓名：</td>
					<td><input name="name" id="name" onblur="checkUser()" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" id="password" /></td>
				</tr>
			</table>
			<div>
				<input type="button" value="登录" onclick="check()" />&nbsp; <input
					type="reset" value="重置" />
			</div>
			<div class="active" align="center">
				<img src="/images/huanghunliming.jpg" />
			</div>
		</div>
	</form>


</body>
<script type="text/javascript">
	function check() {
		var username = document.getElementById("name").value;
		var password = document.getElementById('password').value;
		if (password == null || password == "" || username == ''
				|| username == null) {
			alert("用户名或密码不能为空++++");
		} else {
			document.getElementById("form").submit();
		}

	}
</script>

</html>
