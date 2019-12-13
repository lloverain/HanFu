function updateuser() {
    var form = new FormData($("#updateuser")[0]);
    var name = form.get("name");
    var sex = form.get("sex");
    var account = sessionStorage.getItem('account')
    var token = sessionStorage.getItem("token")
    if(yanzhengname(name)){
        $.ajax({
            url: "/API/user/alertuser",
            type: 'POST',
            headers: {
                "token": token
            },
            data: JSON.stringify({
                'account': account,
                'name': name,
                'sex': sex
            }),
            async: true,
            success: function (data) {
                var json = JSON.parse(data);
                var code = json.code;
                if(code === 200){
                    $('.modal-title').html('成功')
                    $('.modal-body').html("个人资料更新成功！")
                    $('#myModal').modal('show')
                    localStorage.setItem('name',name) //缓存
                    $('#name').text(name)
                }
                if(code === 500){
                    $('.modal-title').html('失败')
                    $('.modal-body').html("个人资料更新失败")
                    $('#myModal').modal('show')
                }
            },
            error: function (date) {
                alert("token已失效，请重新登录！")
                sessionStorage.clear()
                window.location.replace("/login")
            }
        });
    }
}

function yanzhengname(name) {
    if (name == null || name == "") {
        $('.modal-title').html('提示')
        $('.modal-body').html("昵称不能为空！")
        $('#myModal').modal('show')
        return false
    }
    return true;
}