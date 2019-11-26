var name = sessionStorage.getItem('name');
console.log(name.length)
if(name.length==0||name == "null"){
    window.location.replace("/login") //跳转
}
$("#name").text(name)


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
                // location.href = "/login" //跳转
                sessionStorage.clear()
                window.location.replace("/login") //跳转
                // localStorage.setItem('name',name); //缓存

            }
        }
    });
}