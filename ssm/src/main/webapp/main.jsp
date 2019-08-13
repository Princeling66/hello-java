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
	<link rel="stylesheet" href="css/content.css"/>
	 <script type="text/javascript" src="/ssm/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ssm/js/main.js" ></script> 
</head>
<body marginwidth="0" marginheight="0">
	<div class="container">
		<div class="public-nav">您当前的位置：<a href="">图书首页</a>></div>
		<div class="public-content">
			<div class="public-content-header">
				<h3>图书一览</h3>
			</div>
			<div class="public-content-cont">
			<form action="ShowBook.do" method="post">
			<div class="public-cont-title">
						图书名称<input type="text" id="bookname" name="bookname">
						图书作者<input type="text" id="author" name="author">
						<input type="submit" value="搜索" id="search">
					</div>
					</form>
				<table class="public-cont-table">
					<tr>
						<th style="width:10%">图书ID</th>
						<th style="width:10%">图书名称</th>
						<th style="width:10%">图书作者</th>
						<th style="width:10%">图书价格</th>
						<th style="width:20%">出版社</th>
						<th style="width:10%">图书状态</th>
						<th style="width:10%">图书编号</th>
						<th style="width:10%">操作</th>
					</tr>
					<c:forEach items="${pa.data }" var="book">
					<tr>
						<td>${book.bookid }</td>
						<td>${book.bookname }</td>
						<td>${book.author }</td>
						<td>${book.price }</td>
						<td>${book.publisher }</td>
						<td>${book.status }</td>
						<td>${book.bookcode }</td>
						<td>
							<div class="table-fun">
							<input type="button" id="rent" value="租书">
							</div>
						</td>
					</tr>
					</c:forEach>
				</table>
				<input type="button" id="pay" value="缴费">
				<span style="color:red" id="message">${message }</span>
				<div class="page">
					<form action="ShowBook.do" method="post">
			
						<a href="ShowBook.do?page=1">首页 </a>
						<c:if test="${pa.currentPage!=1 }">
						<a href="ShowBook.do?page=${pa.currentPage-1}">上一页 </a>
						</c:if>
						
						<a>当前${pa.currentPage }页/共${pa.page }页 </a>
						<c:if test="${pa.currentPage!=pa.page }">
						<a href="ShowBook.do?page=${pa.currentPage+1}">下一页</a>
						</c:if>
						<a href="ShowBook.do?page=${pa.page }">尾页</a>
						<input type="text" class="page-input" >
						<input type="submit" class="page-btn" value="跳转">
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>