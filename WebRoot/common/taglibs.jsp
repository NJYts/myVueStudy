<%-- <%@ taglib prefix="s" uri="/struts-tags" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%-- <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> --%>
<%-- <%@ taglib uri="http://www.yuqing.com/robot" prefix="auth"%> --%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path", basePath);
%>