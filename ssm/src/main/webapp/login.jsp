<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/login.css" />
	 <script type="text/javascript" src="/ssm/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ssm/js/login.js" ></script> 
</head>
<body>
<div class="page">
	<div class="loginwarrp">
		<div class="logo">图书管理系统</div>
        <div class="login_form">
			<form id="LogInForm" name="Login" method="post"  action="login.do">
				<li class="login-item">
					<span>用户名：</span>
					<input type="text" id="userid" name="userid" class="login_input">
				</li>
				<li class="login-item">
					<span>密　码：</span>
					<input type="password" id="password" name="password" class="login_input">
				</li>
				<span  id="error"style="color:red">${error }</span><br/>
				<div class="clearfix"></div>
				<li class="login-sub">
					<input type="submit" id="submit" name="submit" value="登录" />
				</li>                      
           </form>
		</div>
	</div>
</div>
</body>
</html>