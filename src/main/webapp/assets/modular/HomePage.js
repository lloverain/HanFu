$(".tou").load("pages/modular/system/head.html")
$("#tuichu").click(function () {
    console.log("11")
    tuichu()
})

function updatePassword() {
    if(yanzhengpwd()){
        var account = sessionStorage.getItem('account')
        var oldpwd = $('#oldpassword').val()
        var newpwd = $('#newpassword').val()
        var token = sessionStorage.getItem('token')
        console.log(token)
        $.ajax({
            url:'/API/alepwd',
            type:'POST',
            headers:{
                "token":token
            },
            data:JSON.stringify({
                'account':account,
                'oldpassword':oldpwd,
                'newpassword':newpwd
            }),
            async:true,
            success:function (date) {
                var json = JSON.parse(data);
                var code = json.code;//状态码
                var data = json.data;//返回信息
                var message = json.message //其他消息
                if(code==200){
                    $('.modal-title').html('提示')
                    $('.modal-body').html(message)
                    $('#myModal').modal('show')
                }else {
                    $('.modal-title').html('提示')
                    $('.modal-body').html(message)
                    $('#myModal').modal('show')
                }
            },
            error:function (date) {
                sessionStorage.clear()
                window.location.replace("/login")
            }
        })
    }
}

function yanzhengpwd() {
    var pwd = $('#newpassword').val()
    var alignpwd = $('#newpasswords').val()
    if(pwd!=alignpwd){
        $('.modal-title').html('提示')
        $('.modal-body').html('输入的密码不一致')
        $('#myModal').modal('show')
        return false
    }else {
        return true
    }
}