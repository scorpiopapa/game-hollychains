<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HollyChains后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="resources/jquery-easyui/themes/metro-green/easyui.css">
    <link rel="stylesheet" type="text/css" href="resources/jquery-easyui/themes/icon.css">
    <!-- <link rel="stylesheet" type="text/css" href="resources/jquery-easyui/demo/demo.css"> -->
    <!-- <link rel="stylesheet" type="text/css" href="resources/css/main.css"/> -->
    <script type="text/javascript" src="resources/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="resources/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="resources/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="resources/js/common.js"></script>
<script type="text/javascript">
$(function(){
	$('#nav_menu').tree({
		url: appName + 'navigator.json',
		loadFilter: function(data){
			if(data.code == 1){
				return data.menus;
			}else{
				alert('menu load failed');
				return "";
			}
		}
	});
});
</script>
</head>
<body class="easyui-layout">
	<div id="header" data-options="region:'north',href:'header.html'" style="height:60px"></div>
	<!-- <div data-options="region:'south',split:true" style="height:50px;"></div> -->
	<!-- <div data-options="region:'east',split:true" title="East" style="width:200px;"></div> -->
	<div data-options="region:'west',split:true,href:'west.html'" style="width:200px;"></div>
	<div data-options="region:'center',iconCls:'icon-ok',href:'center.html'">
	</div>
</body>
</html>