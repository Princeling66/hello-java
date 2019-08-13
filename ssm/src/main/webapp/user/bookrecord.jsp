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
<title>还书</title>
<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/content.css" />
	 <script type="text/javascript" src="/ssm/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ssm/js/bookrecord.js" ></script> 
</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">借书记录管理</a>></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3>借书信息</h3>
			</div>
			<div class="public-content-cont">
				<table class="public-cont-table">
					<tr>
						<th style="width:5%">选择</th>
						<th style="width:5%">借书ID</th>
						<th style="width:5%">借书人ID</th>
						<th style="width:5%">图书ID</th>
						<th style="width:20%">借书时间</th>
						<th style="width:20%">还书时间</th>
						<th style="width:20%">到期日期</th>
						<th style="width:5%">剩余免费天数</th>
					</tr>
					<c:forEach items="${BookRecord }" var="BookRecord">
					<tr>
						<td><input type="checkbox" name="ck" value="${BookRecord.recordid }"/></td>
						<td>${BookRecord.recordid }</td>
						<td>${BookRecord.userid }</td>
						<td>${BookRecord.bookid }</td>
						<td>${BookRecord.lendtime }</td>
						<td>${BookRecord.returntime }</td>
						<td>${BookRecord.expiretime }</td>
						<td>${BookRecord.day }</td>
						
					</tr>
					</c:forEach>
				</table>
				<input type="button" id="repay" value="归还">
				<span style="color:red" id="message">${message }</span>
			</div>
		</div>
	</div>
</head>
<body>

</body>
</html>