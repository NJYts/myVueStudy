<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory" %>

<%
	Throwable ex = null;
	if (exception != null)
		ex = exception;
	if (request.getAttribute("javax.servlet.error.exception") != null)
		ex = (Throwable) request.getAttribute("javax.servlet.error.exception");

	//记录日志
	Logger logger = LoggerFactory.getLogger("500.jsp");
	logger.error(ex.getMessage(), ex);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>500 - 系统内部错误</title>
	<script type="text/javascript" src="../js/jquery-1.4.js"></script>
	<style>
	body{
		text-align: left;
		color: #3f3f3f;
		font-size: 14px; 
		font-family: 微软雅黑;
	}
.noPageBtnContainer{
	position:absolute;
	right:110px;
	bottom:250px;
}
.noPageBtn{
	display:block;
	background-image:url(../images/404Btn.png);
    background-repeat:no-repeat; 
	display:block;
	color:#ffffff;
	width:111px;
	height:40px;
	line-height:35px;
	text-align:center;
	text-decoration:none;
}
.noPageBtn:hover{
	text-decoration:none;
	color:yellow;
}

</style>
	
</head>

<body>

<img  src="../images/500.jpg"  class="noPageBg"/>

	<div class="noPageBtnContainer">
		<table>
			<tr>
				<td width="120"><a class="noPageBtn"  href="javascript:history.go(-1)">返回上一页</a></td> 
				<td><a class="noPageBtn"  href="<c:url value="/"/>">返回首页</a></td>
			</tr>
		</table>
	</div>

<script>
$(function(){
var contentHeight=window.screen.availHeight;
var contentWidth=window.screen.availWidth-140;
$(".noPageBg").height(contentHeight-200);
$(".noPageBg").width(contentWidth);
$(window).resize(function(){
	var contentHeight=window.screen.availHeight;
	var contentWidth=window.screen.availWidth-140;
	$(".noPageBg").height(contentHeight-200);
	$(".noPageBg").width(contentWidth);
});

});
</script>
</body>
</html>
