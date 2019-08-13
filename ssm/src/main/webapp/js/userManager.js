$(function() {
	$(document).delegate("#rent", "click", function() {
		// 租书
		location = "http://localhost:8080/ssm/ShowBook.do";
	})
	
	// 还书
	$(document).delegate("#repay", "click", function() {
		location = "http://localhost:8080/ssm/ShowBR.do";
	})
	
})