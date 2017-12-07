<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="top.dreamyy.cardapp.domain.Card"  
import="java.util.*" 
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>名片管理系统</title>
<link href="css/main.css" rel="stylesheet">
</head>
<body>
	<!-- title部分 -->
	<div class="div_title">
		<span class="title">名片管理系统</span>
	</div>
	<!-- 导航栏部分 -->
	<div class="div_dh">
		<ul>
			<li><a href="allCardController">所有名片</a></li>
			<li><a href="select">查询名片</a></li>
			<li><a href="allCardController3">修改名片</a></li>
			<li><a href="add">增加名片</a></li>
			<li><a href="allCardController1">删除名片</a></li>
			<li><a href="allCardController2">回收站</a></li>
		</ul>
	</div>
	 
	<div class="div_body">
		<div>
			<h3>添加名片</h3>
			<form action="addCardController">
				姓名:<input type="text"  name="name" >
				性别:<input type="text"  name="gender" >
				电话:<input type="text"  name="phone"   ><br>
				单位:<input type="text"  name="company" >
				住址:<input type="text"  name="address" >
				email:<input type="text"name="email" ><br>
				<input type="submit" value="添加名片">
				<input type="reset" value="重置">
			</form>
		</div>
	</div>
</body>
</html>