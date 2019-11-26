function login() {
    var form = new FormData($("#loginForm")[0]);
    $.ajax({
        url:  "/login",
        type: 'POST',
        data: form,
        processData: false,
        contentType: false,
        async: false,
        success: function (data) {
           var json = JSON.parse(data);
           var code = json.code;
           var name = json.other;
           console.log(name)
           if(code === "200"){
                location.href = "/homepage" //跳转
               sessionStorage.setItem('name',name); //缓存
           }
           if(code === "500"){
               $('.modal-title').html('提示')
               $('.modal-body').html("登录失败！")
               $('#myModal').modal('show')
           }
        }
    });
}

$(document).keydown(function(){
    if (event.keyCode == 13) {//回车键的键值为13
        login()
    }
});