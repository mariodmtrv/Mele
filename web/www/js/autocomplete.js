/**
 * Created by mariodimitrov on 1/21/15.
 */
$(document).ready(function () {

    $("#expressionInput").keypress(callAutocompleteOption());
    console.log("added expression input handler");
});
function uploadFileDialog() {
    console.log("UploadFileDialogCalled");
    /*   $("#dialog").dialog({

     autoOpen: true,
     buttons: {

     Yes: function() {

     alert("Yes!");
     $(this).dialog("close");
     },
     No: function() {

     alert("No!");
     $(this).dialog("close");

     },
     Maybe: function() {

     alert("Maybe!");
     $(this).dialog("close");
     }

     },
     width: "400px"

     });*/

}
function callAutocompleteOption() {
    var textInput = $("#textInput").text();
    console.log(textInput);
    if (textInput.substr(textInput.length - 4) == "load") {
        uploadFileDialog();
    }
    /*else if(){

     }*/
}