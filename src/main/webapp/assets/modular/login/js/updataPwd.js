function updatePassword() {
    if (updateyanzhengpwd()) {
        var account = sessionStorage.getItem('account')
        var oldpwd = $('#oldpassword').val()
        var newpwd = $('#newpassword').val()
        var token = sessionStorage.getItem("token")
        $.ajax({
            url: '/API/user/alertpw',
            type: 'POST',
            headers: {
                "token": token
            },
            data: JSON.stringify({
                'account': account,
                'oldpassword': oldpwd,
                'newpassword': newpwd
            }),
            async: true,
            success: function (dates) {
                var json = JSON.parse(dates);
                var code = json.code;//状态码
                var data = json.data;//返回信息
                var message = json.message //其他消息
                if (code == 200) {
                    $('.modal-title').html('成功')
                    $('.modal-body').html("密码更新成功,请重新登录!")
                    $('#myModal').modal('show')
                } else {
                    $('.modal-title').html('失败')
                    $('.modal-body').html("密码更新失败,请重试！")
                    $('#myModal').modal('show')
                }
                clearContent()
            },
            error: function (date) {
                alert("token已失效，请重新登录！")
                sessionStorage.clear()
                window.location.replace("/login")
            }
        })
    }
}

function updateyanzhengpwd() {
    var pwd = $('#newpassword').val()
    var alignpwd = $('#newpasswords').val()
    if (pwd != alignpwd) {
        $('.modal-title').html('提示')
        $('.modal-body').html('输入的密码不一致')
        $('#myModal').modal('show')
        return false
    } else {
        return true
    }
}

function clearContent() {
    $('#oldpassword').val("")
    $('#newpassword').val("")
    $('#newpasswords').val("")
}