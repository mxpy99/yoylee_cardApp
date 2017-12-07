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
	<%! List<Card> cards=new ArrayList<Card>();%>
	<%
		request.setCharacterEncoding("UTF-8");
		cards = (List<Card>)request.getAttribute("card");
		System.out.println("mian :card = "+cards);
	%>
	<div class="div_body">
		<span>更新名片</span>
			<%
				out.print("<table>");
				out.print("<tr>");
				out.print("<th>姓名");
				out.print("<th>性别");
				out.print("<th>电话");
				out.print("<th>公司");
				out.print("<th>地址");
				out.print("<th>email");
				out.print("<th>是否修改");
				if(cards!=null){
					for(int i = 0;i<cards.size();i++){
						out.print("<tr>");
						out.print("<td>"+cards.get(i).getName());
						out.print("<td>"+cards.get(i).getGender());
						out.print("<td>"+cards.get(i).getPhone());
						out.print("<td>"+cards.get(i).getCompany());
						out.print("<td>"+cards.get(i).getAddress());
						out.print("<td>"+cards.get(i).getEmail());
						out.print("<td>"+"<a class='a_1' href='updateCardController"+"?name="+cards.get(i).getName()+"'>修改</a>");
					}
				}
				out.print("</table>");
			%>
		<h4>点击左侧 更新名片 刷新</h4>
	</div>
</body>
</html>