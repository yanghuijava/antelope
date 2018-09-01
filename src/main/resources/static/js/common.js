function showMessager(msg) {
	$.messager.show({
        title:'提示',
        msg:msg,
        timeout:3000,
        showType:'show'
    });
}

function templateDownload(fileName){
	window.location = 'templatedownload/' + fileName + '.html';
}


$.ajaxSetup({  
	error: function (XMLHttpRequest, textStatus, errorThrown){  
		if(XMLHttpRequest.status==403){  
			alert('您没有权限访问此资源或进行此操作');
			return false;  
		}  
	},    
	complete:function(XMLHttpRequest,textStatus){
		var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头,sessionstatus，   
        	if(sessionstatus=='timeout'){     
	            //如果超时就处理 ，指定要跳转的页面    
	        	var top = getTopWinow(); //获取当前页面的顶层窗口对象  
//	        	$.messager.confirm('提示','登录超时, 请重新登录?',function(r){
//	        	    if (r){
//	        	    	top.location.href = "login.html";
//	        	    }
//	        	});
	        	top.location.href = "login.html";
	        	//alert('登录超时, 请重新登录.');
	            //top.location.href = "login.html"; //跳转到登陆页面  
        	}else if(sessionstatus=='pwdstatus'){
        		var top = getTopWinow(); //获取当前页面的顶层窗口对象  
        		$.messager.alert("提示",'密码没有重新设置,不能进行相关操作,请先修改密码！',"info");
        	}     
     	}
});   
	  
/**  
  * 在页面中任何嵌套层次的窗口中获取顶层窗口  
  * @return 当前页面的顶层窗口对象  
  */  
function getTopWinow(){    
    var p = window;    
    while(p != p.parent){    
        p = p.parent;    
    }    
    return p;    
}

function dialogSave(dialogObj,url,dgObj,formObj){
	dialogObj.dialog({
		title: '新增',
		closed: false,
        buttons: [{
            text:'保存',
            iconCls:'icon-ok',
            handler:function(){
            	$.messager.progress();
            	formObj.form('submit',{
            	    url:url,
            	    onSubmit: function(){
            	    	var isValid = $(this).form('validate');
            			if (!isValid){
            				$.messager.progress('close');
            			}
            			return isValid;
            	    },
            	    success:function(data){
            	    	$.messager.progress('close');
            	    	var obj = eval('(' + data + ')');
            	    	if(obj.success){
            	    		showMessager(obj.message);
            	    		dialogObj.dialog('close');
            	    		dgObj.datagrid('reload');
            	    	}else {
            	    		$.messager.alert('提示',obj.message,'error');
            	    	}
            	    }
            	});
            }
        },{
            text:'取消',
            iconCls:'icon-cancel',
            handler:function(){
            	dialogObj.dialog('close');
            }
        }],
        onClose:function(){
        	formObj.form('clear');
        }
	});
}

function dialogEdit(dialogObj,url,dgObj,formObj,formLoadUrl){
	var selectRow = dgObj.datagrid('getSelected');
	if(selectRow == null){
		$.messager.alert('提示',"请选择您要编辑的行！",'warning');
		return;
	}
	formObj.form("load",formLoadUrl + "?id=" + selectRow.id);
	dialogObj.dialog({
		title: '编辑',
		closed: false,
        buttons: [{
            text:'保存',
            iconCls:'icon-ok',
            handler:function(){
            	$.messager.progress();
            	formObj.form('submit',{
            	    url:url,
            	    onSubmit: function(){
            	    	var isValid = $(this).form('validate');
            			if (!isValid){
            				$.messager.progress('close');
            			}
            			return isValid;
            	    },
            	    success:function(data){
            	    	$.messager.progress('close');
            	    	var obj = eval('(' + data + ')');
            	    	if(obj.success){
            	    		showMessager(obj.message);
            	    		dialogObj.dialog('close');
            	    		dgObj.datagrid('reload');
            	    	}else {
            	    		$.messager.alert('提示',obj.message,'error');
            	    	}
            	    }
            	});
            }
        },{
            text:'取消',
            iconCls:'icon-cancel',
            handler:function(){
            	dialogObj.dialog('close');
            }
        }],
        onClose:function(){
        	formObj.form('clear');
        }
	});
}

function deleteRecord(dg,deleteUrl){
	var selectRow = dg.datagrid('getSelected');
	if(selectRow == null ||selectRow.length == 0) {
		$.messager.alert('提示', '请选择需要删除的行！','warning');
		return;
	}
	var param = {};
	param.id = selectRow.id;
	$.messager.confirm('警告', '你确定要删除此记录吗?', function(r){
		if (r){
			$.post(deleteUrl,param,function(data){
				if(data.success) {
					showMessager(data.message);
					dg.datagrid("reload");
				}else {
					$.messager.alert('错误', data.message,'error');
				}
			},'json');
		}
	});
}
