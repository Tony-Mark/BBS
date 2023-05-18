$(function (){
    initArticle();
    initReply();
    // window.addEventListener("load",function (){
    //     initArticle();
    //     initReply();
    // })
    $("#submit").bind("click",function (){
        let tzid = $("#tzid").val();
        let content = $("#content").val();
        $.ajax({
            method:"post",
            url:"../reply",
            data:{
                "tzid":tzid,
                "content":content
            },
            dataType:"Text",
            async:false,
            success:function (re){
                if (re === "true"){
                    window.location.href = "displayBBS.html?id="+tzid;
                }
            },
            error:function (){
                console.log("不成功");
            }
        })
    })
})
function initArticle(){
    let article = getArticle();
    /*取得键名*/
    let keys0 = Object.keys(article[0]);
    let title = $("<div class='row'><div class='col-12'><h1 class='display-1 text-center'>"
        +article[0]["title"]+"</h1></div></div> <hr class='bg-black'>");
    let timeAndAuth = $("<div class='row'>" +
        "<div class='col-2'><p class='text-start text-secondary'>"+article[0]["fbDate"]+"</p></div>" +
        "<div class='col-6'><p class='text-center text-secondary'>作者："+article[0]["auth"]+"</p></div>" +
        "</div>");
    let content = $("<div class='row'>" +
        "<div class='col-lg col-md col-sm-12'><p class='lead text-justify'>&nbsp;&nbsp;"+article[0]["content"]+"</p></div>"+"</div>");
    /*照片区域1.需要判断是否有照片2.多张照片需要进行处理*/
    if (article[0]["pic"] !== "null"){
        let image = $("<div class='col-lg-4 col-md-4 col-sm-12'>" +
            "<img src='../webResources/"+article[0]["pic"]+
            "' alt='文章图片' class='mx-auto d-block img-fluid'></div>");
        content.append(image);
    }
    let navbar = $("<nav class='navbar navbar-expand-sm bg-light navbar-light justify-content-end'>" +
        "<a class='navbar-brand' href='#'>" +article[0]["auth"]+
        "   <button type='button' class='btn btn-secondary'>关注</button>" +
        "</a>" +
        "<ul class='navbar-nav'>" +
        "   <li class='nav-item text-end'>" +
        "       <a class='nav-link' href='#'><span class='bi bi-hand-thumbs-up'>"+article[0]["greatNo"]+"</span></a>" +
        "   </li>&nbsp;&nbsp;" +
        "   <li class='nav-item text-end'>" +
        "       <a class='nav-link' href='#'><span class='bi bi-hand-thumbs-down'>"+article[0]["dropNo"]+"</span></a>" +
        "   </li>&nbsp;&nbsp;" +
        "   <li class='nav-item'>" +
        "       <a class='nav-link' id='reply' data-bs-toggle='offcanvas' data-bs-target='#offcanvasBottom' aria-controls='offcanvasBottom' " +
        "          href='#'><span class='bi bi-chat-dots'></span>"+article[0]["repNo"]+"</a>" +
        "   </li></ul></nav>");
    $("#display-area").append(title).append(timeAndAuth).append(content).append(navbar);
    let canvas = $("<div class='offcanvas offcanvas-bottom' tabindex='-1' id='offcanvasBottom' aria-labelledby='offcanvasBottomLabel'>" +
        "<div class='offcanvas-header'>"+
        "      <h5 class='offcanvas-title' id='offcanvasBottomLabel'>评论</h5>"+
        "      <button type='button' class='btn-close text-reset' data-bs-dismiss='offcanvas' aria-label='Close'></button>" +
        "</div>"+
        "<div class='offcanvas-body small'>"+
        "<form action='../reply' method='post'><input type='hidden' id='tzid' name='tzid' value='"+getQueryString("id")+"'>" +
        "<div class='form-floating'><textarea class='form-control w-50' id='content' name='content' placeholder='请友善评论'></textarea>" +
        "<label for='content'>请友善评论</label></div><button type='button' id='submit' class='btn btn-primary'>评论</button></form>"+
        "</div></div>");
    $("#body").append(canvas);
}
function initReply(){
    let reply = getReply();
    if (reply !=null){
        /*取得键名*/
        // let keys0 = Object.keys(reply[0]);
        for (let i = 0;i<reply.length;i++){
            let user = $("<div class='row'>"+
                "<div class='col'>"+reply[i]["repl"]+"&nbsp;&nbsp;<span class='text-end'>"+reply[i]["repDate"]+"</span>" +
                "<a id='a-href' class='link-info' href='replyUser.html?id="+getQueryString("id")+
                "&replyUser="+reply[i]["repl"]+"'><p>&nbsp;&nbsp;"+reply[i]["content"]+"</p></a></div></div>");
            $("#comment-area").append(user);
        }
    }
}
function getArticle(){
    let id = getQueryString("id");
    let re0 = "";
    $.ajax({
        method:"get",
        url:"../bbs/"+id,
        dataType:"Json",
        async:false,
        success:function (re){
            re0 = re;
        },
        error:function (){
            console.log("失败");
        }
    })
    return re0;
}
function getReply(){
    let id = getQueryString("id");
    let re0 = "";
    $.ajax({
        method:"get",
        url:"../reply/"+id,
        dataType:"Json",
        async:false,
        success:function (re){
            re0 = re;
        },
        error:function (){
            console.log("失败")
        }
    })
    return re0;
}