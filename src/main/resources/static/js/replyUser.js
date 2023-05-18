$(function (){
    $("#tzid").val(getQueryString("id"));
    $("#replyUser").val(getQueryString("replyUser"));
    let label0 = $("<label for='content'>回复："+getQueryString("replyUser")+"</label>")
    $("#content-area").append(label0);
    $("#reply").bind("click",function (){
        let tzid = $("#tzid").val();
        let content = $("#content").val();
        let replyUser = $("#replyUser").val();
        $.ajax({
            url:"../reply",
            method:"get",
            data:{
                "tzid":tzid,
                "content":content,
                "replyUser":replyUser
            },
            dataType:"Text",
            success:function (re){
                if (re === "true"){
                    window.location.href = "displayBBS.html?id="+tzid;
                }
            },
            error:function (){
                console.log("失败");
            }
        })
    })
})