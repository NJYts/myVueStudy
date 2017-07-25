<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
    <title>Bootstrap1</title>
    <link rel="stylesheet" href="${ctx}\js\bootstrap\css\bootstrap.min.css">
    <script src="${ctx}\js\jquery\jquery-1.9.1.min.js"></script>
    <script src="${ctx}\js\bootstrap\js\bootstrap.min.js"></script>
</head>
<body>

<h4>胶囊式导航中的激活状态</h4>
<ul class="nav nav-pills">
    <li class="active"><a href="#">首页 <span class="badge">42</span></a></li>
    <li><a href="#">简介</a></li>
    <li><a href="#">消息 <span class="badge">3</span></a></li>
</ul>
<br>
<h4>列表导航中的激活状态</h4>
<ul class="nav nav-pills nav-stacked" style="max-width: 260px;">
    <li class="active">
        <a href="#">
            <span class="badge pull-right">42</span>
            首页
        </a>
    </li>
    <li><a href="#">简介</a></li>
    <li>
        <a href="#">
            <span class="badge pull-right">3</span>
            消息
        </a>
    </li>
</ul>

<div class="container">
    <div class="jumbotron">
        <h1>欢迎登陆页面！</h1>
        <p>这是一个超大屏幕（Jumbotron）的实例。</p>
        <p><a class="btn btn-primary btn-lg" role="button">
            学习更多</a>
        </p>
    </div>
</div>

<div class="progress">
    <div class="progress-bar progress-bar-success" role="progressbar"
         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
         style="width: 90%;">
        <span class="sr-only">90% 完成（成功）</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-info" role="progressbar"
         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
         style="width: 30%;">
        <span class="sr-only">30% 完成（信息）</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-warning" role="progressbar"
         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
         style="width: 20%;">
        <span class="sr-only">20% 完成（警告）</span>
    </div>
</div>
<div class="progress">
    <div class="progress-bar progress-bar-danger" role="progressbar"
         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
         style="width: 10%;">
        <span class="sr-only">10% 完成（危险）</span>
    </div>
</div>

<div class="progress progress-striped">
    <div class="progress-bar progress-bar-success" role="progressbar"
         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
         style="width: 90%;">
        <span class="sr-only">90% 完成（成功）</span>
    </div>
</div>

<div class="progress progress-striped active">
    <div class="progress-bar progress-bar-success" role="progressbar"
         aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
         style="width: 40%;">
        <span class="sr-only">40% 完成</span>
    </div>
</div>

<h2>创建模态框（Modal）</h2>
<!-- 按钮触发模态框 -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
            </div>
            <div class="modal-body">在这里添加一些文本</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>
