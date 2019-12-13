console.log("HomePage.js执行了")
$(".tou").load("pages/modular/system/head.html")
$("#tuichu").click(function () {
    console.log("11")
    tuichu()
})

function LostAndFound() {
    $("#content").load("pages/modular/LostAndFound/LostAndFound.html",'',function (response,status,xhr) {

    })
}