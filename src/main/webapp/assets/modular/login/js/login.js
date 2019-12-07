function login() {
    $.ajax({
        url: "/API/login",
        type: 'POST',
        data: JSON.stringify({
            "account": $("#account").val(),
            "password": $("#password").val()
        }),
        async: true,
        success: function (data) {
            var json = JSON.parse(data);
            var code = json.code;//状态码
            var data = json.data;//返回信息
            var message = json.message //其他消息
            if (code === 200) {
                var account = data.account
                var name = data.name
                var sex = data.sex
                var token = data.token
                sessionStorage.setItem('name', name) //昵称
                sessionStorage.setItem('account', account)//账户
                sessionStorage.setItem('sex', sex)//性别
                sessionStorage.setItem('token', token)//token
                location.href = message //跳转
            }
            if (code === 500) {
                console.log("11111")
                $('.modal-title').html('提示')
                $('.modal-body').html(data)
                $('#myModal').modal('show')
            }
        }
    });
}

$(document).keydown(function () {
    if (event.keyCode == 13) {//回车键的键值为13
        login()
    }
});