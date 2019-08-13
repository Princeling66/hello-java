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
<title>逾期缴费</title>
<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/content.css"/>
	 <script type="text/javascript" src="/ssm/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ssm/js/pay.js" ></script> 
</head>
<body>
需缴费金额:<input type="text" value="${curuser.owing_money }" readonly="readonly">
<span style="color:red" id="message">${message }</span>
<input type="button" value="确定" id="ok">
<input type="button" value="取消" id="cancel">
</body>
</html>