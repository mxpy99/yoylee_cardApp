<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册用户</title>
<link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/style2.css" media="screen" type="text/css"/>
<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
</head>
<body>
<%request.setCharacterEncoding("UTF-8");  
%>
	<div class='container'>
		<form action="registerUser">
			<fieldset class='alpha wii'>
				<legend>
					<b>注册用户</b>
				</legend>
				<div class="frow">
					<input class="item name" placeholder="账号" type="text" name="name" >
				</div>
				<div class="frow">
					<input class="item eng" placeholder="密码" type="password" name="password" value="${requestScope.password}">
				</div>
				<div class="frow">
					<input class="item math" placeholder="密保(用于找回密码)" type="text" name="mibao" value="${requestScope.mibao}">
				</div>
				<div class="frow">
					<input class="next-step sub" type="submit" value="Registe">
				</div>
				 
				<div class="frow">
					<a href="loginForm" >已有账号?去登录</a>
				</div>
				<div class="frow" align="center">
					<label id="lb" style="color: red;">${requestScope.message }</label>
				</div>
			</fieldset>
		</form>
		
	</div>
</body>
</html>