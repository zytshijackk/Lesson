function  getPath(){

                     var pathName = document.location.pathname;
                     var index = pathName.substr(1).indexOf("/");
                    var result = pathName.substr(0,index+1);
                    return result;

                 }

//刷新验证码
$("#codeImage").click(function(){
	var url = getPath()+"/user/validateCode.do?number="+Math.random();
	$("#codeImage").attr("src",url);
}
);
$(function(){
    $("#btn_login").click(function(){
        if(checkInput()){
        	var identity = $("#identity").val()
        	var username = $("#username").val()
        	var password = $("#password").val()
        	var validateCode = $("#validateCode").val()
        	$.ajax({
    			url : getPath()+"/user/login.do",
    			data : {
    				"username" : username,
    				"validateCode":validateCode,
    				"identity":identity,
    				"password":password
    			},
        		type:'post',
        		dataType:'json',//不写返回的data.isSuccess会出现问题
    			success:function(data){
    				if(data.isSuccess==true)//后台校验成功
    					window.location.href='/evaluation/user/index.do';
    				else//后台校验失败
    					alert(data.message);
    			},
    			error:function(){
    				alert("服务器出错");
    			}
    		});
        }else{
            return false;
        }
    }
    );
});
function checkInput(){
    //判断用户名
    if($("input[name=username]").val()==null || $("input[name=username]").val()==""){
        alert("用户名不能等于空");
        $("input[name=username]").focus();
        return false;
    }
    //判断密码
    if($("input[name=password]").val()==null || $("input[name=password]").val()==""){
        alert("密码不能等于空");
        $("input[name=password]").focus();
        return false;
    }
    //判断验证码
    if($("input[name=validateCode]").val()==null || $("input[name=validateCode]").val()==""){
        alert("验证码不能为空");
        $("input[name=validateCode]").focus();
        return false;
    }
    return true;
}