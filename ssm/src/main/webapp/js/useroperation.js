$(function() {
	var arr;
	$(document).delegate("#update", "click", function() {
		// 修改
		arr = $(this).parents("tr");
		$("#UserUpd").css("visibility","visible");
		$("#id1").val(arr.find("td:eq(0) input").val());
		$("#account1").val(arr.find("td:eq(1) input").val());
		$("#password1").val(arr.find("td:eq(2) input").val());
		$("#username1").val(arr.find("td:eq(3) input").val());
		
				$("#auth1 option").each(function(){
			if($(this).text()==arr.find("td:eq(4) input").val()){
				$(this).prop("selected", 'selected');
			}
		})
	})

	// 删除
	$(document).delegate("#delete", "click", function() {
		if (confirm("是否删除当前用户？") == true) {
			var delId = $(this).parents("tr").find("td:eq(0) input").val();
			location = "http://localhost:8080/sam/DelUser?delId=" + delId;
		}

	})
	// 搜索
		$(document).delegate("#search", "click", function() {

	})
	// 保存修改
	$(document).delegate("#ok", "click", function() {
		var abc=false;
		// 用户名密码校验--英文或数字
		var reg=/^[A-Za-z0-9]{1,16}$/;
		//姓名校验--只能为中文
		var reg2 = /^[\u4e00-\u9fa5]{0,}$/;
		//拿到值
		var account=$("#account1").val();
		var password=$("#password1").val();
		var username=$("#username1").val();
		if(reg.test(account)||reg.test(password)){
			abc=true;
		}else{
		
			$("#message").text("用户名或密码格式错误");
			abc=false;
		}
	 if(reg2.test(username)){
		 abc=true;
		}else{
			$("#message").text("姓名请输入中文");
			abc=false;
		}
	 
	 	if(abc){
			$("#updUser").submit();
		}
	})
	//修改--返回
	$(document).delegate("#cancel", "click", function() {
		$("#UserUpd").css("visibility","hidden");
	})
})
