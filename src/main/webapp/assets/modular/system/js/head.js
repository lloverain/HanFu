var token = sessionStorage.getItem('token')
if(token!=null){
    if(token.length==0){
        window.location.replace("/login") //跳转
    }else {
        var name = sessionStorage.getItem('name')
        $("#name").text(name)
        $("#content").load("pages/modular/home/homecontent.html")
    }
}else {
    sessionStorage.clear()
    window.location.replace("/login") //跳转
}



function updatePwd() {
    $("#content").load("pages/modular/login/updatePwd.html",'',function (response,status,xhr) {
        console.log(response)
        console.log(status)
        console.log(xhr)
    })
}


function ceshi() {
    var eml = $("#content")
    $.ajax({
        url:  "/test",
        type: 'GET',
        processData: false,
        contentType: false,
        async: true,
        success: function (data) {
            eml.html(data)

        }
    });
    eml.bootstrapPaginator()
}

/**
 * 账户退出
 */
function tuichu() {
    $.ajax({
        url:  "/signout",
        type: 'GET',
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
                sessionStorage.clear()
                window.location.replace("/login") //跳转

            }
        },
        error:function (date) {
            console.log(date)
            sessionStorage.clear()
            window.location.replace("/login") //跳转
        }

    });
}