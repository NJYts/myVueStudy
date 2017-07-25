<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/taglibs.jsp"%>

<html>
<head>
    <title>Bootstrap</title>
    <link rel="stylesheet" href="${ctx}\js\bootstrap\css\bootstrap.min.css">
    <script src="${ctx}\js\jquery\jquery-1.9.1.min.js"></script>
    <script src="${ctx}\js\bootstrap\js\bootstrap.min.js"></script>
</head>
<body>
    <h1>我是标题1 h1. <small>我是副标题1 h1</small></h1>
    <h2>我是标题2 h2. <small>我是副标题2 h2</small></h2>
    <h3>我是标题3 h3. <small>我是副标题3 h3</small></h3>
    <h4>我是标题4 h4. <small>我是副标题4 h4</small></h4>
    <h5>我是标题5 h5. <small>我是副标题5 h5</small></h5>
    <br>--------------------------------------------------------------------.--分割线---------------------------------------------------<br>

    <h2>引导主体副本</h2>
    <p>为了给段落添加强调文本，则可以添加 class="lead"，这将得到更大更粗、行高更高的文本，。</p>
    <p class="lead">这是一个演示引导主体副本用法的实例。这是一个演示引导主体副本用法的实例。。</p>
        <br>----------------------------------------------------------------------分割线---------------------------------------------------<br>
    <p>HTML 元素提供了用于缩写的标记，比如 WWW 或 HTTP。Bootstrap 定义 &lt;abbr&gt; 元素的样式为显示在文本底部的一条虚线边框，当鼠标悬停在上面时会显示完整的文本（只要您为 &lt;abbr&gt; title 属性添加了文本）。</p>
    <p> 为了得到一个更小字体的文本，请添加 .initialism 到 。</p>
    <abbr title="World Wide Web">WWW</abbr><br>
    <abbr title="Real Simple Syndication" class="initialism">RSS</abbr>
        <br> --------------------------------------------------------------------分割线---------------------------------------------------<br>
        <address>
            <strong>Some Company, Inc.</strong><br>
            007 street<br>
            Some City, State XXXXX<br>
            <abbr title="Phone">P:</abbr> (123) 456-7890
        </address>
        <address>
            <strong>Full Name</strong><br>
            <a href="mailto:#">mailto@somedomain.com</a>
        </address>
        <br>----------------------------------------------------------------------分割线---------------------------------------------------<br>
        <h4>未定义样式列表</h4>
        <ul >
            <li>Item 1</li>
            <li>Item 2</li>
            <li>Item 3</li>
            <li>Item 4</li>
        </ul>
        <h4>内联列表</h4>
        <ul class="list-inline">
            <li>Item 1</li>
            <li>Item 2</li>
            <li>Item 3</li>
            <li>Item 4</li>
        </ul>
        <h4>定义列表</h4>
        <dl>
            <dt>Description 1</dt>
            <dd>Item 1</dd>
            <dt>Description 2</dt>
            <dd>Item 2</dd>
        </dl>
        <h4>水平的定义列表</h4>
        <dl class="dl-horizontal">
            <dt>Description 1</dt>
            <dd>Item 1</dd>
            <dt>Description 2</dt>
            <dd>Item 2</dd>
        </dl>
        <br>---------------------------------------------------------------------------------------------------------------<br>
        <pre>
            Bootstrap 网格标准结构
            &lt;div class="container"&gt;
                 &lt;div class="row"&gt;
                     &lt;div class="col-*-*"></div&gt;
                        &lt;div class="col-*-*"&gt;&lt;/div&gt;
                &lt;/div&gt;
                    &lt;div class="row"&gt;... &lt;/div&gt;
                 &lt;/div>--%>
                    &lt;div class="container"&gt;....  &lt;/div&gt;
             &lt;/div&gt;
        </pre>
        <div class="container">
            <div class="row" >
                <div class="col-xs-6 col-sm-3"
                     style="background-color: #dedef8;
         box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                </div>
                <div class="col-xs-6 col-sm-3"
                     style="background-color: #dedef8;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                        eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
                        enim ad minim veniam, quis nostrud exercitation ullamco laboris
                        nisi ut aliquip ex ea commodo consequat.
                    </p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                        eiusmod tempor incididunt ut.
                    </p>
                </div>

                <div class="clearfix visible-xs"></div>

                <div class="col-xs-6 col-sm-3"
                     style="background-color: #dedef8;
         box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
                        laboris nisi ut aliquip ex ea commodo consequat.
                    </p>
                </div>
                <div class="col-xs-6 col-sm-3"
                     style="background-color: #dedef8;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do
                        eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
                        enim ad minim
                    </p>
                </div>
            </div>
            为了在大屏幕显示器上使用偏移，请使用 .col-md-offset-* 类。这些类会把一个列的左外边距（margin）增加 * 列，其中 * 范围是从 1 到 11。
            在下面的实例中，我们有 <div class="col-md-6">..</div>，我们将使用 .col-md-offset-3 class 来居中这个 div。<br>
            <div class="row" >
                <div class="col-xs-6 col-md-offset-3"
                     style="background-color: #dedef8;box-shadow:
        inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing
                        elit.
                    </p>
                </div>
            </div>

            <h1>Hello, world!</h1>

            <div class="row">

                <div class="col-md-3" style="background-color: #dedef8;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    <h4>第一列</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                </div>

                <div class="col-md-9" style="background-color: #dedef8;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    <h4>第二列 - 分为四个盒子</h4>
                    <div class="row">
                        <div class="col-md-6" style="background-color: #B18904;
               box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                            <p>Consectetur art party Tonx culpa semiotics. Pinterest
                                assumenda minim organic quis.
                            </p>
                        </div>
                        <div class="col-md-6" style="background-color: #B18904;
               box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                            <p> sed do eiusmod tempor incididunt ut labore et dolore magna
                                aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                                ullamco laboris nisi ut aliquip ex ea commodo consequat.
                            </p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6" style="background-color: #B18904;
               box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                            <p>quis nostrud exercitation ullamco laboris nisi ut
                                aliquip ex ea commodo consequat.
                            </p>
                        </div>
                        <div class="col-md-6" style="background-color: #B18904;
               box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                                sed do eiusmod tempor incididunt ut labore et dolore magna
                                aliqua. Ut enim ad minim.</p>
                        </div>
                    </div>

                </div>

            </div>
        </div>

        <br>----------------------------------------------------------------------分割线---------------------------------------------------<br>
    <p>您可以很轻易地改变带有 .col-md-push-* 后推 和 .col-md-pull-* 前推 类的内置网格列的顺序，其中 * 范围是从 1 到 11。 <p><br>
        <div class="container">

            <h1>Hello, world!</h1>

            <div class="row">
                <p>排序前</p>
                <div class="col-md-2" style="background-color: #dedef8;
         box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    我在左边
                </div>
                <div class="col-md-4" style="background-color: #dedef8;
         box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    我在中间
                </div>
                <div class="col-md-6" style="background-color: #dedef8;
         box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    我在右边
                </div>
            </div><br>
            <div class="row">
                <p>排序后</p>
                <div class="col-md-2 col-md-push-10"
                     style="background-color: #dedef8;
         box-shadow: inset 1px -1px 1px #444,
         inset -1px 1px 1px #444;">
                    我在左边
                </div>
                <div class="col-md-4 col-md-push-4" style="background-color: #dedef8;
         box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
                    我在中间
                </div>
                <div class="col-md-6 col-md-pull-6"
                     style="background-color: #dedef8;
         box-shadow: inset 1px -1px 1px #444,
         inset -1px 1px 1px #444;">
                    我在右边
                </div>
            </div>

        </div>
        <br> ----------------------------------------------------------------------分割线---------------------------------------------------<br>
        <p><code>&lt;header&gt;</code> 作为内联元素被包围。</p>
        <p>如果需要把代码显示为一个独立的块元素，请使用 &lt;pre&gt; 标签：</p>
        <pre>
        &lt;article&gt;
            &lt;h1&gt;Article Heading&lt;/h1&gt;
        &lt;/article&gt;
        </pre>
        <br> ----------------------------------------------------------------------分割线---------------------------------------------------<br>
        <%--.table-striped	在 <tbody> 内添加斑马线形式的条纹 ( IE8 不支持)	尝试一下--%>
        <%--.table-bordered	为所有表格的单元格添加边框	尝试一下--%>
        <%--.table-hover	在 <tbody> 内的任一行启用鼠标悬停状态	尝试一下--%>
        <%--.table-condensed 是表格更紧凑--%>
        <%--通过把任意的 .table 包在 .table-responsive class 内，您可以让表格水平滚动以适应小型设备（小于 768px）。当在大于 768px 宽的大型设备上查看时，您将看不到任何的差别。--%>
        <table class="table table-hover">
            <caption>悬停表格布局</caption>
            <thead>
            <tr>
                <th>名称</th>
                <th>城市</th>
                <th>邮编</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Tanmay</td>
                <td>Bangalore</td>
                <td>560001</td>
            </tr>
            <tr>
                <td>Sachin</td>
                <td>Mumbai</td>
                <td>400003</td>
            </tr>
            <tr>
                <td>Uma</td>
                <td>Pune</td>
                <td>411027</td>
            </tr>
            </tbody>
        </table>
    <br> ----------------------------------------------------------------------分割线---------------------------------------------------<br>
        <pre>向父 &lt;form&gt; 元素添加 role="form"。<br>
                把标签和控件放在一个带有 class .form-group 的 &lt;div&gt; 中。这是获取最佳间距所必需的。<br>
                向所有的文本元素 &lt;input&gt;、&lt;textarea&gt;和 &lt;select&gt;添加 class ="form-control" 。<br>
        </pre>

                    <form role="form">
                        <div class="form-group">
                            <label for="name">名称</label>
                            <input type="text" class="form-control" id="name" placeholder="请输入名称">
                       <%-- </div>

                        <div class="form-group">--%>
                            <label for="name">选择列表</label>
                            <select class="form-control">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                            <label for="name">可多选的选择列表</label>
                            <select multiple class="form-control">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="inputfile">文件输入</label>
                            <input type="file" id="inputfile">
                            <p class="help-block">这里是块级帮助文本的实例。</p>
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">请打勾
                            </label>
                        </div>
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>

        <br>----------------------------------------------------------------------分割线---------------------------------------------------<br>
        <p>
            <button type="button" class="btn btn-default btn-lg">默认按钮</button>
            <button type="button" class="btn btn-default btn-lg" disabled="disabled">禁用按钮</button>
        </p>
        <p>
            <button type="button" class="btn btn-primary btn-lg ">原始按钮</button>
            <button type="button" class="btn btn-primary btn-lg" disabled="disabled">禁用的原始按钮</button>
        </p>
        <p>
            <a href="#" class="btn btn-default btn-lg" role="button">链接</a>
            <a href="#" class="btn btn-default btn-lg disabled" role="button">禁用链接</a>
        </p>
        <p>
            <a href="#" class="btn btn-primary btn-lg" role="button">原始链接</a>
            <a href="#" class="btn btn-primary btn-lg disabled" role="button">禁用的原始链接</a>
        </p>
    <br>----------------------------------------------------------------------分割线---------------------------------------------------<br>
    <img src="${ctx}\static\images\zonglan.png" class="img-rounded">
    <img src="${ctx}\static\images\zonglan.png" class="img-circle">
    <img src="${ctx}\static\images\zonglan.png" class="img-thumbnail">
    <br>----------------------------------------------------------------------分割线---------------------------------------------------<br>
    <a class="bg-warning" href="${ctx}/dept/bootstrap?flag=1"><p class="text-danger">点击换页继续</p></a>
</body>

</body>
</html>
