<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>HollyChains后台管理登录</title>
<script type="text/javascript">
$(function() {
	$('#name').select();
	
	$('#name').keyup(function(){
		if(event.keyCode == 13){
			$('#password').select();
		}
	});

	$('#password').keyup(function(){
		if(event.keyCode == 13){
			login();
		}
	});
});
	
function login(){
	var form = new Object();
	form.name = $('#name').val();
	form.password = $('#password').val();
	
	console.log(form);
	
	$.ajax({
		type : "post",
		url : 'login.json',
		data : form,
		success : function(data) {
			if(data.code == 0){
				//console.log(data.userId);
				window.location.href = 'main.html';
			}else{
				showErrorMessage('用户名或密码错误');
			}
		},
		error: function(){
			showErrorMessage('网络连接错误');
		}
	});
}
</script>
</head>
<body>
<form id="login_form" method="post" action="login.jspx">
	用户名<input id="name" name="name" type="text"/><br/>
	密码<input id="password" name="password" type="password"/><br/>
	<input type="submit" value="确定">
</form>
</body>
</html>