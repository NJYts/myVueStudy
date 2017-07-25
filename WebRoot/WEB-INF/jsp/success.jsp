<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="${ctx}\js\bootstrap\css\bootstrap.min.css">
	<script src="${ctx}\js\jquery\jquery-1.9.1.min.js"></script>
	<script src="${ctx}\js\bootstrap\js\bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div  style="border-color: #9dca59;background-color: #ffa60d;text-align:center">
		部门名称： <input id="" /> 使用状态：<select name="status">
			<option value="1" ${list.status==1?"selected='selected'":""}>启用</option>

			<option value="0" ${list.status==0?"selected='selected'":""}>停用</option>
		</select><input type="submit" value="查询" onclick="checkuser()" />
	</div>
	<table border="1" style="border-collapse:collapse;height:600px; width:500px; margin:auto;text-align:center" >
		<tr>
			<!-- <td colspan="4"><a href="http://localhost:8080/My/add.jsp">添加部门</a></td> -->
			<td colspan="2"><a href="${ctx}/dept/vue?flag='0'"> Go To Vue.js</a></td>
			<td colspan="1"><a href="${ctx}/dept/getById_dept">添加部门</a></td>
			<td colspan="2"><a href="${ctx}/dept/bootstrap?flag='0'"> Go To Bootstrap</a></td>
		</tr>
		<tr style="border-color: #9dca59;background-color: #019fe6;">
			<th style="width:140px;">部门名称：</th>
			<th width="110px">部门地址：</th>
			<th width="110px">是否停用：</th>
			<th width="140px">操作：</th>
		</tr>
		<tr>
			<td colspan="4" >
				<div style="position:relative;width:100%; height:400px; overflow:auto">
					<table border="1"id="depts" style="table-layout: fixed;border-collapse:collapse; height:600px;width:500px; align:center">
					<c:forEach items="${page.list}" var="deptPage">
						<tr>
							<input type="hidden" value="${deptPage.deptNo }" />
							<td width="140px">${deptPage.deptName }</td>
							<td width="110px">${deptPage.location }</td>
							<td width="115px"><select name="status">
								<option value="1" ${deptPage.status==1?"selected='selected'":""}>启用</option>
								<option value="0" ${deptPage.status==0?"selected='selected'":""}>停用</option>
							</select></td>
							<td ><a href="${ctx}/delete_dept?deptNo=${deptPage.deptNo }">删除</a>|
								<a href="${ctx}/dept/getById_dept?deptNo=${deptPage.deptNo }">修改</a></td>
						</tr>
					</c:forEach>
					</table>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="6" align="center" bgcolor="#5BA8DE">共${page.totalRecords}条记录
				共${page.totalPages}页 当前第${page.pageNo}页<br> <a
				href="${ctx}/showAll?pageNo=${page.topPageNo }"><input
					type="button" name="fristPage" value="首页" /></a> <c:choose>
					<c:when test="${page.pageNo!=1}">

						<a href="${ctx}/showAll?pageNo=${page.previousPageNo }"><input
							type="button" name="previousPage" value="上一页" /></a>
					</c:when>
					<c:otherwise>
						<input type="button" disabled="disabled" name="previousPage"
							value="上一页" />
					</c:otherwise>
				</c:choose> <c:choose>
					<c:when test="${page.pageNo != page.totalPages}">
						<a href="${ctx}/showAll?pageNo=${page.nextPageNo }"><input
							type="button" name="nextPage" value="下一页" /></a>
					</c:when>
					<c:otherwise>
						<input type="button" disabled="disabled" name="nextPage" value="下一页" />
					</c:otherwise>
				</c:choose> <a href="${ctx}/showAll?pageNo=${page.bottomPageNo }"><input
					type="button" name="lastPage" value="尾页" /></a>
			</td>
		</tr>
		
	</table>

</body>

<script type="text/javascript">
	//翻页操作记录ID
	function updateSub(pageno) {
		$("#dialog").css({
			height : $("#scrollContent").height() - 30
		});
		$("#dialog").css("margin-top", $(".box2").height() - 53);

		var checkid = $(":checkbox");
		var sub = $("#sub").val();
		sub = sub.replace(/\s+/g, "");
		var subs1 = new Array();
		subs1 = sub.split(",");
		for (var i = 0; i < checkid.length; i++) {
			var diff = 0;
			for (var j = 0; j < subs1.length; j++) {
				if (checkid[i].value == subs1[j]) {
					diff++;
				}
			}
			if (checkid[i].checked && diff == 0) {
				sub += checkid[i].value + ",";
			}
		}
		$("#sub").val(sub);
		jumpPage(pageno);
	}

	function gotoPage() {
		var pageNum = document.getElementById("pageNum").value;
		var reg = /\d+/;
		pageNum = reg.exec(pageNum);
		if (pageNum <= 0) {
			top.Dialog.alert('请输入正整数。');
			$("#pageNum").val(${page.pageNo});
		} else if (pageNum > ${page.totalPages}) {
			top.Dialog.alert('超出总页数。');
			$("#pageNum").val(${page.pageNo});
		} else {
			//jumpPage(pageNum) ;
			updateSub(pageNum);
		}
	}
</script>
<script type="text/javascript">
	// 登录相关
	var depts = document.getElementById('depts');
	if (depts != null) {
		for (var i = 0; i < depts.rows.length; i++) {
			if (depts.rows[i].rowIndex % 2 == 1) {
				depts.rows[i].style.backgroundColor = "#c9dbe1";
			}
		}
	}

	function checkuser() {
		var username = document.getElementById("username").value;
		var status = document.getElementById("status").value;
		var trs = document.getElementsByTagName("tr");
		for (var i = 1; i < trs.length; i++) {
			var userstatus = trs[i].childNodes;
			if (username != '' && status != 'null') {
				if (username == trs[i].id && userstatus[5].id == status) {

				} else {
					trs[i].style.display = 'none';
				}
			} else if (username == '' && status != 'null') {
				if (userstatus[5].id != status) {
					trs[i].style.display = 'none';
				} else {

				}
			} else if (username != '' && status == 'null') {
				if (username != trs[i].id) {
					trs[i].style.display = 'none';
				} else {

				}
			} else {
				alert('请输入查找条件');
				break;
			}
		}
	}
</script>
</html>