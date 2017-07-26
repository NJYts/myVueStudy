<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'vue.jsp' starting page</title>
    <script type="text/javascript" src="${ctx }/js/vue/vue.min.js"></script>
  </head>
	<style>
	a { text-decoration: none} 
	.class1 {
		background: #444;
		color: #eee;
	}
	.classRed {
		background: #eee;
		color: red;
	}
	.active {
		width: 100px;
		height: 100px;
		background: green;
	}
	.text-danger {
		background: red;
	}
	</style>
<body>
	<!-- 数据绑定最常见的形式就是使用 {{...}}（双大括号）的文本插值： -->
	<!-- <div id="app">
    	{{message}}
    </div> -->
	 使用v-html指令用于输出html代码：<br><br>
	<div id="app">
		<div v-html="message"></div>
		
	</div>
	----------------------------------------------------------<br>
	 HTML 属性中的值应使用v-bind指令。
	以下实例判断class1的值，如果 true使用class1类的样式，否则不使用该类：<br><br>
	<div id="test">
		<label for="in">修改颜色</label><input type="checkbox" v-model="class1" id="in">
		<br><br>
		<div v-bind:class="{'class1':class1}">my first time!</div>
	</div>
	----------------------------------------------------------<br>
	表达式vue。js 都提供了完全的javaScript表达式支持。<br><br>
	<div id="app1">
	{{5+5}}<br>
	{{ ok ? 'YES' : 'NO' }}<br>
	{{ message1.split(' ').reverse().join('-') }}<!-- 用split函数拆分成数组对象，再用reverse函数将数组倒序排列 -->
	<div v-bind:id="'list-' + id">菜鸟教程</div>
	
	----------------------------------------------------------<br>
	指令<br>
	指令是带有 v- 前缀的特殊属性。<br>
	指令用于在表达式的值改变时，将某些行为应用到 DOM 上。如下例子：<br><br>
    	<p v-if="seen">现在你看到我了</p>
   	 参数<br>
	参数在指令后以冒号指明。例如， v-bind 指令被用来响应地更新 HTML 属性：<br>
    	<pre><a v-bind:href="urlHY" target = _blank>菜鸟教程</a></pre>
    ----------------------------------------------------------<br>
            用户输入<br>
	在input 输入框中我们可以使用 v-model 指令来实现双向数据绑定：<br>
    <p>{{ message2 }}</p>
    <input v-model="message2"><br>
    ----------------------------------------------------------<br>
            按钮的事件我们可以使用 v-on 监听事件，并对用户的输入进行响应。<br>
	以下实例在用户点击按钮后对字符串进行反转操作：<br>
    <p>{{ message3 | capitalize}}</p>
    <button v-on:click="reverseMessage">反转字符串</button>
    <br>----------------------------------------------------------<br>
    Vue.js 允许你自定义过滤器，被用作一些常见的文本格式化。由"管道符"指示, 格式如下：
	在两个大括号中<br>
	{{ message5 }}<br>
	在 v-bind 指令中<br>
	{{ message4}}<br>
	<div v-html="message6"></div>
	<br>----------------------------------------------------------<br>
	<div v-html="message7"></div>
    {{ message8}}
    <div v-html="message9"></div>
    {{ message10}}
    <br>----------------------------------------------------------<br>
    v-else-if<br>
	v-else-if 在 2.1.0 新增，顾名思义，用作 v-if 的 else-if 块。可以链式的多次使用：<br>
            请输入一个数：<br>
            
    <input v-model="type">
    <div v-if="type > 5">
     {{ type }} > 5
    </div>
    <div v-else-if="type === '5'">
      {{ type }} = 5
    </div>
    <div v-else-if="type < '5'">
      {{ type }} < 5
    </div>
    <div v-else v-bind:class="{classRed:isClassRed}">
     	不符合要求， 请输入一个数！
    </div>
     <br>----------------------------------------------------------<br>
              循环使用 v-for 指令。<br>
	v-for 指令需要以 site in sites 形式的特殊语法， sites 是源数据数组并且 site 是数组元素迭代的别名。<br>
	 <ol>
	    <li v-for="site in sites">
	      {{ site.name }}
	    </li>
	  </ol>
	  <ul>
	  	<li v-for="value in object">
	      {{ value }}
	    </li>
	    </ul>
	<ul>
    <li v-for="(value, key) in object">
    {{ key }} : {{ value }}
    </li>
  </ul>
  <ul>
    <li v-for="(value, key, index) in object">
     {{ index }}. {{ key }} : {{ value }}
    </li>
  </ul>
   <br>----------------------------------------------------------<br>
        把样式css与style封装成对象,用计算的方法，实现动态class<br>
   <div v-bind:class="classObject"></div>
  	 我们还可以使用三元表达式来切换列表中的 class ：<br>
	errorClass 是始终存在的，isActive 为 true 时添加 activeClass 类：<br>
  <div v-bind:class="[errorClass ,isActive ? activeClass : '']"></div>
   <br>----------------------------------------------------------<br>
  	<div><a :href="urlHY"><span v-bind:style="huanYe">突然感觉内容好长好长，换一页继续</span></a></div>
  
  </div>
	<script type="text/javascript">
		var app = new Vue({
			el : '#app',
			data : {
				message : '<h1>Hello Vue.js!</h1>'
			}
		})
		new Vue({
			el : '#test',
			data : {
				class1 : false
			}
		})
		new Vue({
			el : '#app1',
			data : {
				ok : false,
				message1 :'my first time',
				message2 :'my first time',
				message3 :'my first time',
				message4 :'<div v-bind:id="rawId | formatId"></div>',
				message5 :'{{ message | capitalize }}',
				message6 :'过滤器可以串联：<br>'+
				 '{{ message | filterA | filterB }}<br>'+
				 '过滤器是 JavaScript 函数，因此可以接受参数：<br>'+
				 '{{ message | filterC('+'arg1'+', arg2) }}<br>'+
				 '这里，message 是第一个参数，字符串 '+'arg1'+' 将传给过滤器作为第二个参数， arg2 表达式的值将被求值然后传给过滤器作为第三个参数.',
				message7 :' 缩写<br>'+
				  'v-bind 缩写<br>'+
				  'Vue.js 为两个最为常用的指令提供了特别的缩写：<br>'+
				  '完整语法&nbsp/&nbsp缩写<br>',
				message8:'<a v-bind:href="url"></a>&nbsp/&nbsp<a :href="url"></a><br>',
				message9:'完整语法/缩写<br>',
				message10:'<a v-on:click="doSomething"></a>&nbsp/&nbsp<a @click="doSomething"></a>',
				id : 1,
				seen :true,
				url:'http://www.runoob.com',
				urlHY : '${ctx}/dept/vue?flag=2',
				type:'d',
				isClassRed : true,
				isActive: true,
				error: '1',
				activeClass: 'active',
			    errorClass: 'text-danger',
				sites: [
				        { name: 'Runoob' },
				        { name: 'Google' },
				        { name: 'Taobao' }
				      ],
				object: {
				          name: '菜鸟教程',
				          url: 'http://www.runoob.com',
				          slogan: '学的不仅是技术，更是梦想！'
				        },
				huanYe : {
					color: 'green',
				    fontSize: '30px',
					fontStyle:'italic',
					fontFamily:'宋体'
				}
				
			},
			methods: {
				  reverseMessage: function () {
				    this.message3 = this.message3.split('').reverse().join('')
				  }
				},
			filters: {
			  capitalize: function (value) {
			    if (!value) return ''
			    value = value.toString()
			    return value.charAt(0).toUpperCase() + value.slice(1)
			  }
			},computed: {
				    classObject: function () {
				    	/* alert(this.isActive && this.error );
				    	alert(this.error && this.error.type === 'fatal'); */
				      return {
				        active: this.isActive && this.error,
				        'text-danger': !this.error && this.error.type === 'fatal',
				      }
				    }
				  }
		})
	</script>
</body>
</html>

