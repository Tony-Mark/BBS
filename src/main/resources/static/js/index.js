$(function(){
    $(window).on('load', function(){
        // setTimeout(function (){
        //     $("#loading").fadeToggle();
        // },2000);
        $.ajax({
            method:"post",
            url:"../getSession",
            data:{
                "sessionName":"userName"
            },
            async:false,
            dataType:"Text",
            success:function (re){
                console.log(re);
            },
            error:function (){
                window.location.href = "login2.html";
            }
        })
    });
    /*document.onreadystatechange=function(){
        if(document.readyState==="complete"){
            $(".loading").fadeOut();
        }
    }*/
    /*当一个页面中使用了window.onload = function ()，
    * 后续嵌套页面只能使用window.addEventListener('load', function)来进行监听
    * */
    $.get("firstPage.html",function (data){
        $("#context").html(data);
    })
    $(".firstPage").bind("click",function (){
        $.get("firstPage.html",function (data){
            $("#context").html(data);
        })
    })
    $("#publish").bind("click",function (){
        $.get("publish.html",function (data){
            $("#context").html(data);
        })
    })
    $("#onlineUser").bind("click",function (){
        $.get("index-showUser.html",function (data){
            $("#context").html(data);
        })
        // window.location.href = "index-showUser.html";
    })
    // windowResize()
    // // 监听窗口尺寸变化
    // window.addEventListener('resize', windowResize);
})