// 네이버 스마트 에디터 2.0 적용
let oEditors = [];

function smartEditor() {
    console.log("Naver SmartEditor");
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: oEditors,
        elPlaceHolder: "editorTxt",
        sSkinURI: "/smarteditor2/SmartEditor2Skin.html",
        fCreator: "createSEditor2"
    });
}

document.addEventListener("DOMContentLoaded", function(){
    // Handler when the DOM is fully loaded
    smartEditor();
});


// $(document).ready(function() {
//     smartEditor();
// });