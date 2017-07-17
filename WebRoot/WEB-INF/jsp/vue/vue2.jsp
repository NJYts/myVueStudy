<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'vue2.jsp' starting page</title>
    <script type="text/javascript" src="${ctx }/js/vue/vue.min.js""></script>
    <script type="text/javascript" src="${ctx }/js/jquery/jquery-1.9.1.min.js"></script>
  </head>
	<style></style>
<body>
	
	<div id="app">
		事件监听可以使用 v-on 指令：<br>
		<button v-on:click="say('hi')">Say hi</button>
		<button @click="say('what')">Say what</button>
		<br>----------------------------------------------------------<br>
		<p>input 元素：</p>
	    <input v-model="message" placeholder="编辑我……">
	    <p>消息是: {{ message }}</p>
		
	    <p>textarea 元素：</p>
	    <p style="white-space: pre">{{ message2 }}</p>
	    <textarea v-model="message2" placeholder="多行文本输入……"></textarea>
	    <br>----------------------------------------------------------<br>
	    <p>单个复选框：</p>
	  <input type="checkbox" id="checkbox" v-model="checked">
	  <label for="checkbox">{{ checked }}</label>
		
	  <p>多个复选框：</p>
	  <input type="checkbox" id="runoob" value="Runoob" v-model="checkedNames">
	  <label for="runoob">Runoob</label>
	  <input type="checkbox" id="google" value="Google" v-model="checkedNames">
	  <label for="google">Google</label>
	  <input type="checkbox" id="taobao" value="Taobao" v-model="checkedNames">
	  <label for="taobao">taobao</label>
	  <br>
	  <span>选择的值为: {{ checkedNames }}</span>
	  <br>----------------------------------------------------------<br>
	  <p>下拉框：</p>
	  <select v-model="selected" name="fruit">
	    <option value="">选择一个网站</option>
	    <option value="www.runoob.com">Runoob</option>
	    <option value="www.google.com">Google</option>
  	  </select>
	  <div id="output">
	      选择的网站是: {{selected}}
	  </div>
	  <br>----------------------------------------------------------<br>
	  <p>单选框：</p>
	   <input type="radio" id="runoob" value="Runoob" v-model="picked" name ="runoob">
		  <label for="runoob">Runoob</label>
		  <br>
		  <input type="radio" id="google" value="Google" v-model="picked">
		  <label for="google">Google</label>
		  <br>
		  <span>选中值为: {{ picked }}</span>
	  <br>----------------------------------------------------------<br>  
	  Prop<br>
		prop 是父组件用来传递数据的一个自定义属性。<br>
		父组件的数据需要通过 props 把数据传给子组件，子组件需要显式地用 props 选项声明 "prop"：<br>
	      动态 Prop<br>
		类似于用 v-bind 绑定 HTML 特性到一个表达式，也可以用 v-bind 动态绑定 props 的值到父组件的数据中。每当父组件的数据变化时，该变化也会传导给子组件：<br>
	  <div>
		  <input v-model="parentMsg">
		  <br>
		  <child v-bind:message="parentMsg"></child>
	  </div>
	  <br>----------------------------------------------------------<br> 
	  v-bind 指令将 todo 传到每一个重复的组件中：<br>
	  注意: prop 是单向绑定的：当父组件的属性变化时，将传导给子组件，但是不会反过来。 <br>
	   <ol>
    <todo-item v-for="item in sites" v-bind:todo="item"></todo-item>
      </ol>
    
	<br>----------------------------------------------------------<br>  
	<p>页面载入时，input 元素自动获取焦点：</p>
  		<input v-focus>
  	<!-- <br>----------------------------------------------------------<br> 	
  	指令函数可接受所有合法的 JavaScript 表达式，以下实例传入了 JavaScript 对象：<br>
  		 <div v-runoob="{ color: 'green', text: '菜鸟教程!' }"></div> -->
  		
  		
	</div>
	
	<div id="app1">
	  <p>页面载入时，input 元素自动获取焦点：</p>
	  <input v-focus>
	</div>
	
	<br>----------------------------------------------------------<br> 
   	 自定义事件<br> 
	父组件是使用 props 传递数据给子组件，但如果子组件要把数据传递回去，就需要使用自定义事件！<br> 
	我们可以使用 v-on 绑定自定义事件, 每个 Vue 实例都实现了事件接口(Events interface)，即：<br> 
	使用 $on(eventName) 监听事件<br> 
	使用 $emit(eventName) 触发事件<br> 
	另外，父组件可以在使用子组件的地方直接用 v-on 来监听子组件触发的事件。<br> 
	以下实例中子组件已经和它外部完全解耦了。它所做的只是触发一个父组件关心的内部事件。<br> 
	<div id="counter-event-example">
	  <p>{{ total }}</p>
	  <button-counter v-on:increment="incrementTotal"></button-counter>
	  <button-counter v-on:increment="incrementTotal"></button-counter>
	</div>   
	<script>
		// 注册
		Vue.component('child', {
		  // 声明 props
		  props: ['message'],
		  // 同样也可以在 vm 实例中像 “this.message” 这样使用
		  template: '<span>{{ message }}</span>'
		})
		Vue.component('todo-item', {
		  props: ['todo'],
		  template: '<li>{{ todo.text }}</li>'
		})
		var dxk = $("#runoob").val()
		new Vue({
			el : '#app',
			data:{
				message: 'Runoob',
				message2: '菜鸟教程\r\nhttp://www.runoob.com',
				checked : false,
				checkedNames : [],
				selected :'',
				picked : dxk,
				parentMsg:'父组件内容',
				sites: [
				        { text: 'Runoob' },
				        { text: 'Google' },
				        { text: 'Taobao' }
				      ]
			},
			methods : {
				say : function(message) {
					alert(message)
				}
			},
			directives: {
			    // 注册一个局部的自定义指令 v-focus
			    focus: {
			      // 指令的定义
			      inserted: function (el) {
			        // 聚焦元素
			        el.focus()
			      }
			    }
			  }
		})
		Vue.component('button-counter', {
			  template: '<button v-on:click="increment">{{ counter }}</button>',
			  data: function () {
			    return {
			      counter: 0
			    }
			  },
			  methods: {
			    increment: function () {
			      this.counter += 1
			      this.$emit('increment')
			    }
			  },
			})
			new Vue({
			  e1: '#counter-event-example',
			  data: {
			    total: 0
			  },
			  methods: {
			    incrementTotal: function () {
			      this.total += 1
			    }
			  }
			})/* 
		Vue.directive('runoob', function (el, binding) {
		    // 简写方式设置文本及背景颜色
		    el.innerHTML = binding.value.text
		    el.style.backgroundColor = binding.value.color
		}) */
	</script>
</body>
</html>

