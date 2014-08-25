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
width: 100px;
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
	weaponQuery = '';
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
		weaponName : $('#weapon_name').val(),
		weaponId : $('#weapon_id').val()
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
			form.columns = 'wid;weaponId;weaponName;weaponRare;baseExperience;sellPrice;maxBlood;minBlood;maxBloodReply;minBloodReply;maxBaseAttack;minBaseAttack;maxAttack;minAttack;maxShield;minShield;maxDefenseShield;minDefenseShield;maxVampire;minVampire;maxCritRate;minCritRate;maxPenetrationRate;minPenetrationRate';
			
			form.table = weaponTable;
			
			var query = weaponQuery ? weaponQuery : getQueryJson();
			form.query = JSON.stringify(query);
			
			// 表格显示的名称
			form.tableDisplayName = '基本武器';
			form.fileName = '基本武器';
			
			form.type = 'csv';
			
			console.log(form);
			
			downloadFile(form);
		}
	});
}

function importWeapon(){
	$('#weapon_file').click();
}

function submitImportWeapon(){
	var fileName;
	var uploadFlag = true;
	
	$.ajaxFileUpload({
        url:'upload.json', 
        secureuri:false,
        fileElementId:'weapon_file',
        dataType: 'json',
        async: false,
        success: function (data, status){
            if(data.code == 0){
            	fileName = data.fileName;
            	console.log('returned name ' + fileName);
            	
            	if(fileName){
            		window.location.href = 'import/' + fileName + '/' + weaponTable + '.json';
            		showInformationMessage('上传完毕');
            	}else{
            		showErrorMessage('导入失败');
            	}
            }else if(data.code = 1001 || data.code == 1008){
            	showErrorMessage('文件格式错误');
            }else{
            	showErrorMessage('上传失败');
            }
        },
        error: function (data, status, e){
        	uploadFlag = false;
        	showErrorMessage('网络连接失败');
        }
    });
    
    /*
    console.log(uploadFlag);
    console.log(fileName);
    if(uploadFlag && fileName){
    	window.location.href = 'import/' + fileName + '?' + weaponTable + '.json';
    	showInformationMessage('上传完毕');
    }
    */
}
</script>
<table id="weapon_grid" class="easyui-datagrid" style="width:700px;height:250px" data-options="toolbar:'#weapon_toolbar'">
    <thead>
        <tr>
        <th data-options="field:'ck'" checkbox="true"></th>
            <th data-options="field:'wid'">CSV序号</th>
            <th data-options="field:'weaponId'">武器ID</th>
            <th data-options="field:'weaponName'">名称</th>
            <th data-options="field:'weaponRare'">稀有度</th>
	        <th data-options="field:'baseExperience'">基础经验值</th>
	        <th data-options="field:'sellPrice'">金币价格</th>
	        <th data-options="field:'maxBlood'">基本血量</th>
	        <th data-options="field:'minBlood'">血量增量</th>
	        <th data-options="field:'maxBloodReply'">血瓶基本恢复值</th>
	        <th data-options="field:'minBloodReply'">血瓶恢复值增量</th>
	        <th data-options="field:'maxBaseAttack'">基本攻击力</th>
	        <th data-options="field:'minBaseAttack'">基本攻击力增量</th>
	        <th data-options="field:'maxAttack'">武器攻击力</th>
	        <th data-options="field:'minAttack'">武器攻击力增量</th>
	        <th data-options="field:'maxShield'">盾牌基础值</th>
	        <th data-options="field:'minShield'">盾牌基础值增量</th>
	        <th data-options="field:'maxDefenseShield'">盾牌基本防御力</th>
	        <th data-options="field:'minDefenseShield'">盾牌防御力增量</th>
	        <th data-options="field:'maxVampire'">基本吸血值</th>
	        <th data-options="field:'minVampire'">吸血值增量</th>
	        <th data-options="field:'maxCritRate'">基本暴击率</th>
	        <th data-options="field:'minCritRate'">暴击率增量</th>
	        <th data-options="field:'maxPenetrationRate'">基本穿透率</th>
	        <th data-options="field:'minPenetrationRate'">穿透率增量</th>
        </tr>
    </thead>
</table>

<div style="visibility:hidden">
<form id="weapon_file_form" action="import.json" method="post" enctype="multipart/form-data">
	<!-- <input id="weapon_file_name" type="text" name="file" /> -->
	<!-- <input id="weapon_file" type="file" name="file" accept="text/csv,application/vnd.ms-excel" onchange="importFile(this.value);"/> -->
	<input id="weapon_file" type="file" name="file" accept=".csv" onchange="submitImportWeapon();"/>
	<input id="weapon_file_submit" type="submit"/>
</form>
</div>

<div id="weapon_toolbar" style="padding:5px;height:auto">
  <!-- 添加查询条件  -->      
        名称<input id="weapon_name" type="text"/>
        武器ID<input id="weapon_id" type="text"/>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearchWeapon()">查询</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="clearCriteria('#weapon_toolbar')">清除</a>
  		<a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="showAddDialog('#weapon_form', '#weapon_dlg')">添加</a> 
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit "onclick="showEditDialog('#weapon_grid', '#weapon_form', '#weapon_dlg')">编辑</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteItem('#weapon_grid', weaponTable)">删除</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="exportWeaponQuery()">导出</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-excel" onclick="importWeapon()">导入</a>
</div>

<div id="weapon_dlg" class="easyui-dialog" style="width:650px;height:500px;padding:10px 20px" closed="true" buttons="#weapon_dlg_buttons">
     <form id="weapon_form" method="post" novalidate>
        <input name="wid" type="hidden">
<table style="width: 100%;">
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>武器ID</label>
			<input name="weaponId" class="easyui-numberbox easyui-validatebox" data-options="min:1001,decimalSeparator:'',required:true">
		</div>
		</td>
		<td>
		<div class="weapon_item">
			<label>名称</label>
			<input name="weaponName" class="easyui-validatebox" data-options="required:true">
		</div>
		</td>
	</tr>
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>稀有度</label>
			<input name="weaponRare" class="easyui-numberbox" data-options="min:1,decimalSeparator:''">
		</div>
		</td>
		<td>
		<div class="weapon_item">
			<label>基础经验值</label>
			<input name="baseExperience" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
	</tr>
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>金币价格</label>
			<input name="sellPrice" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
		<td>
		</td>
	</tr>
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>基本血量</label>
			<input name="maxBlood" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
		<td>
		<div class="weapon_item">
			<label>血量增量</label>
			<input name="minBlood" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
	</tr>
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>血瓶基本恢复值</label>
			<input name="maxBloodReply" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
		<td>
		<div class="weapon_item">
			<label>血瓶恢复值增量</label>
			<input name="minBloodReply" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
	</tr>
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>基本攻击力</label>
			<input name="maxBaseAttack" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
		<td>
		<div class="weapon_item">
			<label>基本攻击力增量</label>
			<input name="minBaseAttack" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
	</tr>
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>武器攻击力</label>
			<input name="maxAttack" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
		<td>
		<div class="weapon_item">
			<label>武器攻击力增量</label>
			<input name="minAttack" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
	</tr>
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>盾牌基础值</label>
			<input name="maxShield" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
		<td>
		<div class="weapon_item">
			<label>盾牌基础值增量</label>
			<input name="minShield" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
	</tr>
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>盾牌基本防御力</label>
			<input name="maxDefenseShield" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
		<td>
		<div class="weapon_item">
			<label>盾牌防御力增量</label>
			<input name="minDefenseShield" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
	</tr>
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>基本吸血值</label>
			<input name="maxVampire" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
		<td>
		<div class="weapon_item">
			<label>吸血值增量</label>
			<input name="minVampire" class="easyui-numberbox" data-options="min:0,decimalSeparator:''">
		</div>
		</td>
	</tr>
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>基本暴击率</label>
			<input name="maxCritRate" class="easyui-numberbox" data-options="min:0,precision:1">
		</div>
		</td>
		<td>
		<div class="weapon_item">
			<label>暴击率增量</label>
			<input name="minCritRate" class="easyui-numberbox" data-options="min:0,precision:1">
		</div>
		</td>
	</tr>
	<tr>
		<td style="width: 50%;">
		<div class="weapon_item">
			<label>基本穿透率</label>
			<input name="maxPenetrationRate" class="easyui-numberbox" data-options="min:0,precision:1">
		</div>
		</td>
		<td>
		<div class="weapon_item">
			<label>穿透率增量</label>
			<input name="minPenetrationRate" class="easyui-numberbox" data-options="min:0,precision:1">
		</div>
		</td>
	</tr>
</table>
     </form>
 </div>
 <div id="weapon_dlg_buttons">
     <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveItem('#weapon_grid', '#weapon_form', '#weapon_dlg', weaponTable)">保存</a>
     <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="closeDialog('#weapon_dlg')">取消</a>
 </div>


