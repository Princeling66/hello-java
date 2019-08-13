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
<title>金额记录</title>
<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/content.css" />
	 <script type="text/javascript" src="/ssm/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ssm/js/userManager.js" ></script> 
</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">金额记录管理</a>></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3>借书信息</h3>
			</div>
			<div class="public-content-cont">
			<table class="public-cont-table">
					<tr>
						<th style="width:5%">记录ID</th>
						<th style="width:5%">用户ID</th>
						<th style="width:5%">变动金额</th>
						<th style="width:20%">变动时间</th>
						<th style="width:20%">变动类型</th>
					</tr>
					<c:forEach items="${AccountRecord }" var="AccountRecord">
					<tr>
						<td>${AccountRecord.recordid }</td>
						<td>${AccountRecord.userid }</td>
						<td>${AccountRecord.money }</td>
						<td>${AccountRecord.changetime }</td>
						<c:if test="${AccountRecord.type==1 }">
						<td>逾期欠费</td>
						</c:if>
						<c:if test="${AccountRecord.type==2 }">
						<td>补交逾期费用</td>
						</c:if>
					</tr>
					</c:forEach>
				</table>
				<span style="color:red" id="message">${message }</span>
			</div>
		</div>
	</div>
</head>
</body>
</html>