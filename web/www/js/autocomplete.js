function uploadFileDialog() {


    $('#fileInputDialog').css('visibility', 'visible');
    console.log("UploadFileDialogCalled");
}

function callAutocompleteOption() {
    var textInput = document.getElementById("expressionInput").value;
    console.log(textInput);
    if (textInput.substr(textInput.length - 6) == "upload") {
        uploadFileDialog();
    }
    /*else if(){

     }*/
}
function submitFile() {
    $('#fileInputDialog').css('visibility', 'hidden');
    //TODO submit file ajax
}