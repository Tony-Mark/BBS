$(function (){
    getUser();
    // window.addEventListener("load",function (){
    //     getUser();
    // });
    // windowResize();
	// // 监听窗口尺寸变化
	// window.addEventListener('resize', windowResize);
})
function getUser(){
    $.ajax({
        method:"get",
        url:"../getSession",
        type:"Json",
        success:function (re){
            JsonsTOTable("show",re);
            console.log(re);
        },
        error:function (){
            console.log("失败");
        }
    })
}