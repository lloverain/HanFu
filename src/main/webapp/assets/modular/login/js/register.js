console.log("调用了？")
function register() {
    if(yanzhengaccount() && yanzhengpassword() && yanzhengname()){
        var form = new FormData($("#registerForm")[0]);
        $.ajax({
            url: "/register",
            type: 'POST',
            data: form,
            processData: false,
            contentType: false,
            async: false,
            success: function (data) {
                console.log(data)
                var json = JSON.parse(data);
                var code = json.code;
                var name = json.other;
                console.log(name)
                if(code === "200"){
                    $('.modal-title').html('成功')
                    $('.modal-body').html("注册成功！")
                    $('#myModal').modal('show')
                    location.href = "/homepage" //跳转
                    localStorage.setItem('name',name); //缓存
                }
                if(code === "500"){
                    $('.modal-title').html('提示')
                    $('.modal-body').html("注册失败")
                    $('#myModal').modal('show')
                }
            }
        });
    }

}


function yanzhengaccount() {
    var zhanghu = $("#account").val()

    if (zhanghu == null || zhanghu == "") {
        $('.modal-title').html('提示:账户问题')
        $('.modal-body').html("账户不能为空！")
        $('#myModal').modal('show')
        return false
    } else {
        if (zhanghu.length < 6 || zhanghu.length > 10) {
            // console.log(zhanghu.length)
            $('.modal-title').html('提示:账户问题')
            $('.modal-body').html('账户长度不能低于6位和高于10位')
            $('#myModal').modal('show')
            return false
        }else {
            $.ajax({
                url: "/isItRegistered?account="+zhanghu,
                type: 'POST',
                data: {},
                processData: false,
                contentType: 'application/json;charset=utf-8',
                async: false,
                success: function (data) {
                    console.log(data)
                    var json = JSON.parse(data);
                    var code = json.code;
                    if(code === "200"){
                        $('.modal-title').html('提示:账户问题')
                        $('.modal-body').html("账户已存在")
                        $('#myModal').modal('show')
                    }
                }
            });
        }
    }
    return true

}

function yanzhengpassword() {
    var mm = $("#password").val()
    var mm1 = $("#passwords").val()
    if (mm1 != mm) {
        // alert("二次输入的密码不正确")
        $('.modal-title').html('提示:密码问题')
        $('.modal-body').html("二次输入的密码不正确")
        $('#myModal').modal('show')
        return false
    } else {
        if (mm.length < 6 || mm.length > 15) {
            // alert("密码不能低于6位和大于15位")
            $('.modal-title').html('提示:密码问题')
            $('.modal-body').html("密码不能低于6位和大于15位")
            $('#myModal').modal('show')
            return false
        }
    }
    return true
}

function yanzhengname() {
    var name = $("#name").val()
    if (name == null || name == "") {
        $('.modal-title').html('提示:昵称问题')
        $('.modal-body').html("昵称不能为空！")
        $('#myModal').modal('show')
        return false
    } else {
        if (name.length > 15) {
            $('.modal-title').html('提示:昵称问题')
            $('.modal-body').html("昵称不能超过15个字")
            $('#myModal').modal('show')
            return false
        }
    }
    return true
}