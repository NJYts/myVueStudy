<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.kapowtech.com/robosuite_1_2.tld" prefix="rs" %>
<%@ taglib uri="/jstl-c" prefix="c" %>

<html>
<head>
  <title>Baidu search example</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
  <%-- Get the search text parameter --%>
  <c:set var="text" value="${param.text}"/>
  <h1>百度搜图</h1>
next: <c:out value="${param.next}"/>
  <form action="">
    <table>
      <tr>
        <td><input type="text" name="text" size="20" value="<c:out value="${text}"/>"/></td>
        <td><input type="submit" value="Search" name="start"/></td>
      </tr>
    </table>

  <%-- Run the robot --%>
  <c:if test="${text != null}">
    <c:set var="result"/>
	<div>执行机器人...</div>
    <rs:execute url="library:/bd-searchgraph.robot">
      <rs:inputObject name="GoogleInput">
        <rs:attribute name="searchText" value="${param.text}"/>
		<div>searchText...<c:out value="${param.text}"/> ... <c:out value="${param.next}"/> </div>
        <c:choose>
          <c:when test="${param.next != null || param.prev != null}">
            <c:choose>
              <c:when test="${param.next != null}">
                <rs:attribute name="conversation" value="next"/>
              </c:when>          
              <c:when test="${param.prev != null}">
                <rs:attribute name="conversation" value="prev"/>
              </c:when>          
            </c:choose>
          <rs:attribute name="session" type="binary" value="${sessionScope.status[0].attributes.session}"/>
        </c:when>
        </c:choose>
      </rs:inputObject>

      <rs:outputObjects var="result" scope="page">
        <rs:filter type="name" value="GoogleOutput"/>
      </rs:outputObjects>
      <rs:outputObjects var="status" scope="session">
        <rs:filter type="name" value="GoogleStatus"/>
      </rs:outputObjects>

      <rs:errors var="errors" scope="page"/>
    </rs:execute>

    <p>
      <%-- Present the result --%>
      <table>
      <c:forEach var="object" items="${result}" varStatus="status">
        <c:choose>
          <c:when test="${status.count % 2 == 1}">
            <tr bgcolor="#EEEEFF">
          </c:when>
          <c:otherwise>
            <tr bgcolor="white">
          </c:otherwise>
        </c:choose>
          <td>
            <img src="<c:out value="${object.attributes.url}"/>">
          </td>
		  <td><c:out value="${object.attributes.title}"/> </td>
        </tr>
      </c:forEach>
      </table>

    </p>
  </c:if>

  <%-- Add the previous and next buttons --%>
  <c:if test="${sessionScope.status[0].attributes.hasPrev == 'true'}">
    <input type="submit" value="Prev" name="prev"/>
  </c:if>
  <c:if test="${sessionScope.status[0].attributes.hasNext == 'true'}">
    <input type="submit" value="Next" name="next"/>
  </c:if>


  </form>

</body>
</html>
