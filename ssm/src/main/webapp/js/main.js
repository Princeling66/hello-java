$(function() {
	$(document).delegate("#rent", "click", function() {
		//获得当前时间
		var mydate = new Date();
		var now=mydate.getTime(); //获取当前毫秒数(0-999)
		// 租书
		var bookid=$(this).parents("tr").find("td:eq(0)").text();
		location = "http://localhost:8080/ssm/recordbook.do?bookid="+bookid+"&now="+now;
	})
	
	$(document).delegate("#pay", "click", function() {
		location = "http://localhost:8080/ssm/user/pay.jsp";
	})
	
	
	
	
})

