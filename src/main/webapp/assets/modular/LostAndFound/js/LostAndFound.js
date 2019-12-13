//这是查询失物招领js
$.ajax({
    url: "/API/lostandfoundgetAll",
    type: 'POST',
    headers: {
        "token": sessionStorage.getItem("token")
    },
    async: true,
    success: function (data) {
        var json = JSON.parse(data);
        var main = $("#lostandfound")
        for (var i = 0; i < json.length; i++) {
            main.append(" <div class=\"col-sm-3\">\n" +
                "        <div class=\"card\">\n" +
                "            <img class=\"card-img-top\" src=\"http://localhost/getImage?name='"+json[i].imagename+"'&&account='"+json[i].account+"'\" width=\"100%\" height=\"200px\" alt=\""+json[i].imagename+"\">\n" +
                "            <div class=\"card-body\">\n" +
                "                <h5 class=\"card-title\">"+json[i].title+"</h5>\n" +
                "                <p class=\"card-text\">"+json[i].content+"</p>\n" +
                "                <a>地点:"+json[i].place+"</a><br>\n" +
                "                <a>发布人:"+json[i].name+"</a><br>\n" +
                "                <a>联系方式:"+json[i].contact+"</a><br>\n" +
                // "                <a href=\"#\" class=\"btn btn-primary\">查看</a>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>")
        }
    },
    error: function (data) {
        alert("token已失效，请重新登录！")
        sessionStorage.clear()
        window.location.replace("/login")
    }
});