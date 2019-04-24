
//跳出修改密码模态框
function openModal(name,identity){
	$("#editPassword").modal("show");
}

//提交修改密码
$("#btn_editPassword")
.click(
		function() {
				var oldPass = $('#old_password').val();
				var newPass = $('#new_password').val();
				var rePass = $('#re_password').val();
					$.ajax({
							url : "/evaluation/user/editPassword.do",
							data : {
								"oldPassword" : oldPass,
								"newPassword": newPass,
								"rePassword":rePass,
							},
							dataType : "json",
							success : function(data) {
								console.log(data);
								if(data.isSuccess==true)//后台校验成功
								{
									$('#editPassword').modal('hide');
									$.toaster({
										priority : 'success',
										title : '修改成功',
										message : '修改成功'
									});
								}
			    				else//后台校验失败
			    					alert(data.message);
							},
							error : function() {
								console.log(arguments)
								$.toaster({
									priority : 'danger',
									title : '服务器出错',
									message : '服务器出错',
								});
							}
						});
		});