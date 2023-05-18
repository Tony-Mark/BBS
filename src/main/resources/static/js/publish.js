$(function(){
    init();
    $("#commit").bind("click",function (){
        if (getFormAllDataHaveFile("../bbs","form-publish") === "true"){
            window.location.href = "index.html";
        }
    })
    /*监听窗口加载*/
    // window.addEventListener("load",init);
    // windowResize()
    // // 监听窗口尺寸变化
    // window.addEventListener('resize', windowResize);
})
function init(){
    let re0 = getSession("userName");
    $("#auth").val(re0);
}