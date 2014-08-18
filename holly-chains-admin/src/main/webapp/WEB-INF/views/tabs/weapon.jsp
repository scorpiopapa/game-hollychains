<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
#weapon_form {
margin: 0;
padding: 10px 30px;
}

.weapon_item {
margin-bottom: 5px;
}

.weapon_item label {
display: inline-block;
width: 80px;
}
</style>

<script type="text/javascript" src="resources/js/common.js"></script>
<script type="text/javascript">
var weaponTable = 'weapon';
var weaponQuery;

$(function() {
	// need order, uncomment here
	//var orderBy = getIdDescOrder();
	//initDataGrid('#weapon_grid', appName + 'search/' + weaponTable + '.json?orderBy=' + orderBy');
	
	// no need order
	initDataGrid('#weapon_grid', 'search/' + weaponTable + '.json');
});

/**
 * 查询
 */
function doSearchWeapon() {
	weaponQuery = getQueryJson();
	searchDataGrid('#weapon_grid', weaponQuery);
}

/**
 * 查询条件
 */
function getQueryJson(){
	var json = {
		name : $('#weapon_text').val()
	};
	
	return json;
}

/**
 * 刷新
 */
function doRefreshWeapon() {
	$('#weapon_grid').datagrid('reload');
}

/**
 * 导出查询结果
 */
function exportWeaponQuery(){
	showConfirmMessage('是否导出查询结果？', function(r){
		if(r){
			var form = new Object();
			// 每列以分号分隔
			form.columns = 'id,编号';	
			
			form.table = weaponTable;
			
			var query = weaponQuery ? weaponQuery : getQueryJson();
			form.query = JSON.stringify(query);
			
			// 表格显示的名称
			form.tableDisplayName = 'Weapon';
			
			//console.log(form);
			
			exportExcel(form);
		}
	});
}
</script>
<table id="weapon_grid" class="easyui-datagrid" style="width:700px;height:250px" data-options="toolbar:'#weapon_toolbar'">
    <thead>
        <tr>
        <th data-options="field:'ck'" checkbox="true"></th>
            <th data-options="field:'wid'">序号</th>
            <th data-options="field:'weaponId'">武器ID</th>
            <!-- 添加字段 -->
        </tr>
    </thead>
</table>
<div id="weapon_toolbar" style="padding:5px;height:auto">
<!--     <div style="margin-bottom:5px">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="showAddDialog('#weapon_form', '#weapon_dlg')">添加</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="showEditDialog('#weapon_grid', '#weapon_form', '#weapon_dlg')">编辑</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="doRefreshWeapon()">刷新</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteItem('#weapon_grid', weaponTable)">删除</a>
    </div> -->
  <!-- 添加查询条件  -->      
        名称<input id="weapon_text" type="text"/>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearchWeapon()">查询</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearCriteria('#weapon_toolbar')">清除</a>
  		<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="showAddDialog('#weapon_form', '#weapon_dlg')">添加</a> 
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit "onclick="showEditDialog('#weapon_grid', '#weapon_form', '#weapon_dlg')">编辑</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteItem('#weapon_grid', weaponTable)">删除</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="exportWeaponQuery()">导出</a>
</div>

<div id="weapon_dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#weapon_dlg_buttons">
     <form id="weapon_form" method="post" novalidate>
        <input name="id" type="hidden">
     	<!-- 添加编辑列 -->
         <div class="weapon_item">
             <label>名称</label>
             <input name="name" >
         </div>
         <div class="weapon_item">
             <label>描述<</label>
             <textarea name="description" rows="5" cols="40"></textarea>
         </div>
     </form>
 </div>
 <div id="weapon_dlg_buttons">
     <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveItem('#weapon_grid', '#weapon_form', '#weapon_dlg', weaponTable)">保存</a>
     <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeDialog('#weapon_dlg')">取消</a>
 </div>

