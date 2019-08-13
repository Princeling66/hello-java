//自动获取当前时间 根据时间生成编号 创建用户为当前登录用户
function showDate() {
	var today = new Date();
	var day = today.getDate();
	var month = today.getMonth() + 1;
	var year = today.getFullYear();
	var hours = today.getHours();
	var minutes = today.getMinutes();
	var seconds = today.getSeconds();
	var date = year + "-" + month + "-" + day;
	var date1 =""+year+month+day+ hours+ minutes+seconds;
	document.getElementsByName("createdate")[0].value = date;

	//创建用户为当前登录用户
	$("#username").val($("#uName").text());
	//设置分类 是用户的类别
	var auth=$('#uAuth').text();
	 $("#type").val(auth);
}
$(function() {
	var abc=false;
	$("#tijiao").click(function() {
		var reg = /^[\u4e00-\u9fa5]{0,}$/;
		var title = $("#title").val();
		if(reg.test(title)&&title!=""){
			abc=true;
			$("#type").removeAttr("disabled");
			$("#addNews").submit();
		}else{
			$("#message").text("请输入中文");
		}
	})
})