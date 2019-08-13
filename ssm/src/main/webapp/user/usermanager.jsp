<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台欢迎页</title>
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/content.css" />
	 <script type="text/javascript" src="/ssm/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ssm/js/userManager.js" ></script> 
</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">个人信息管理</a>></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3>用户信息</h3>
			</div>
			<div class="public-content-cont">
			
				<table class="public-cont-table">
					<tr>
						<th style="width:10%">用户ID</th>
						<th style="width:10%">用户名</th>
						<th style="width:10%">密码</th>
						<th style="width:10%">身份证号</th>
						<th style="width:20%">电话</th>
						<th style="width:10%">注册日期</th>
						<th style="width:10%">用户状态</th>
						<th style="width:10%">欠费金额</th>
						<th style="width:10%">操作</th>
					</tr>
					<tr>
						<td>${curuser.userid }</td>
						<td>${curuser.username }</td>
						<td>${curuser.password }</td>
						<td>${curuser.idcard }</td>
						<td>${curuser.phone }</td>
						<td>${curuser.createtime }</td>
						<c:if test="${curuser.status==1 }">
						<td>正常</td>
						</c:if>
						<c:if test="${curuser.status!=1 }">
						<td>锁定</td>
						</c:if>
						<td style="color:red">${curuser.owing_money }</td>
						<td>
							<div class="table-fun">
							<input type="button" id="rent" value="租书">
							<input type="button" id="repay" value="还书">
							</div>
						</td>
					</tr>
				</table>
				
				<span style="color:red" id="message">${message }</span>
				
			</div>
		</div>
	</div>
			</div>
</body>
</html>