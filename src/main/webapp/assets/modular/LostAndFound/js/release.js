// 这是发布失物招领js
function tijiao() {
    var form = new FormData($("#release")[0]);
    form.append("name",sessionStorage.getItem("name"))
    form.append("account",sessionStorage.getItem("account"))
    form.append("time",getTime())
    $.ajax({
        url: "/API/release",
        type: 'POST',
        data:form,
        processData : false,  //必须false才会避开jQuery对 formdata 的默认处理
        contentType : false,  //必须false才会自动加上正确的Content-Type
        headers: {
            "token": sessionStorage.getItem("token")
        },
        async: true,
        success: function (data) {
            console.log(data)
            var json = JSON.parse(data);
            var code = json.code;
            if (code === 200) {
                $('.modal-title').html('成功')
                $('.modal-body').html("发布成功！")
                $('#myModal').modal('show')
                cleanform()
            }
            if (code === 500) {
                $('.modal-title').html('失败')
                $('.modal-body').html("发布失败！")
                $('#myModal').modal('show')
            }
        },
        error:function (data) {
            alert("token已失效，请重新登录！")
            sessionStorage.clear()
            window.location.replace("/login")
        }
    });
}


function cleanform() {
    $('#title').val('')
    $('#content').val('')
    $('#file').val('')
    $('#contact').val('')
    $('#place').val('')
}

function getTime() {     	//获取时间
    var date = new Date();

    var year = date.getFullYear();
    var month = date.getMonth();
    var day = date.getDate();

    var hour = date.getHours();
    var minute = date.getMinutes();
    var second = date.getSeconds();

    //这样写显示时间在1~9会挤占空间；所以要在1~9的数字前补零;
    if (hour < 10) {
        hour = '0' + hour;
    }
    if (minute < 10) {
        minute = '0' + minute;
    }
    if (second < 10) {
        second = '0' + second;
    }
    var x = date.getDay();//获取星期
    if (x == 1) {
        x = "一"
    }
    if (x == 2) {
        x = "二"
    }
    if (x == 3) {
        x = "三"
    }
    if (x == 4) {
        x = "四"
    }
    if (x == 5) {
        x = "五"
    }
    if (x == 6) {
        x = "六"
    }
    if (x == 7) {
        x = "天"
    }
    var time = year + '-' + month + '-' + day + '_' + hour + '-' + minute + '-' + second + '_星期' + x
    return time
}
