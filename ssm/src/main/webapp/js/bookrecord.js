$(function() {
		$(document).delegate("#repay", "click", function() {
			//还书
			//获得当前时间
			var mydate = new Date();
			var now=mydate.getTime(); //获取当前毫秒数(0-999)
			var id_array=new Array();  
			$('input[name="ck"]:checked').each(function(){  
				  id_array.push($(this).val());//向数组中添加元素
			});
			var idstr=id_array.join(',');//将数组元素连接起来以构建一个字符串  
			location = "http://localhost:8080/ssm/repaybook.do?idstr="+idstr+"&now="+now;
			
		})
})