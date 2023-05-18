$(function (){
    initFirstPage("row",3);
    window.addEventListener("load",function (){
        initFirstPage("row",3);
    })
})
function initFirstPage(divId,count){
    let re = getBBS(count);
    /*清空区域*/
    $("#"+divId).empty();
    /*取出数据键名形成数组*/
    for (let i = 0;i<re.length;i++){
        let key0 = Object.keys(re[i]);
        let col = $("<div class='col-sm-3 col-md-6 col-lg-4'></div>");
        let card = $("<div class='card'></div>");
        /*如果有照片则添加*/
        if (re[i]["pic"] !== "null"){
            let image = $("<div class='image thumbnail'><img src='../webResources/"+re[i]["pic"]+
                "' alt='缩略图' width='100%' height='auto'></div>");
            card.append(image);
        }
        let content = $("<div class='content'></div>");
        let title_href = $("<a href='displayBBS.html?id="+re[i]["id"]+"' target='_blank'><span class='title'>"+re[i]["title"]+"</span></a>");
        let p_desc = $("<p class='desc'>"+re[i]["content"]+"</p>");
        let auth_href = $("<a href='#' class='action'>作者："+re[i]["auth"]+"<span aria-hidden='true'>→</span></a>");
        let other = $("<span class='bi bi-chat-right-dots'></span><span>"+re[i]["repNo"]+
            "</span>&nbsp;&nbsp;<span class='bi bi-hand-thumbs-up'></span><span>"+re[i]["greatNo"]+
            "</span>&nbsp;&nbsp;<span class='bi bi-hand-thumbs-down'></span><span>"+re[i]["dropNo"]+"</span>");
        content.append(title_href).append(p_desc).append(auth_href).append(other);
        card.append(content);
        col.append(card);
        $("#"+divId).append(col);
    }
}

/*需要展示的BBS数量*/
function getBBS(count){
    let re0 = "";
    $.ajax({
        method:"get",
        url:"../bbs",
        data:{"count":count},
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