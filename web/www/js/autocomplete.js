function uploadFileDialog() {


    $('#fileInputDialog').css('visibility', 'visible');
    setTimeout(function () {
        var dialog = $('#fileInputDialog');
        dialog.css('visibility', 'hidden');
    }, 5000);
}

function callAutocompleteOption(e) {
    var textInputObject = document.getElementById("expressionInput");
    var textInput = textInputObject.value;
    /*
     textInputObject.innerHTML = textInput.replace("<br>", "");
     */
    console.log(textInput);
    if (textInput.substr(textInput.length - 6) == "upload") {
        uploadFileDialog();
    }
    /* calls the text autocomplete option*/
    if (e.keyCode == 39) {
        console.log("right pressed");
        // textInputObject.value = textInputObject.value.replace("<br>", "$");
        /*   var endPos = textInputObject.selectionEnd;*/
        var endPos = textInputObject.selectionEnd;
        console.log(endPos);
        var textInputEnd = textInput.length;

        if (endPos == textInputEnd) {
            var spacePos = textInput.lastIndexOf(" ");
            console.log("SPACE POSITION " + spacePos);
            if (spacePos < textInputEnd - 1) {
                if (spacePos == -1) {
                    spacePos = 0;
                }
                var lastWord = textInput.substr(spacePos, textInputEnd);
                console.log("LAST WORD $" + lastWord);
                var suggestedWord = simpleAutocompleteOption(lastWord);
                console.log("SUGGESTED $" + suggestedWord);
                console.log("BEFORE MOD $" + textInputObject.value);
                textInputObject.value = textInputObject.value + suggestedWord;
                console.log("AFTER MOD $" + textInputObject.value);
            }
        }
    }
}
function getCaretCharacterOffsetWithin(element) {
    var caretOffset = 0;
    var doc = element.ownerDocument || element.document;
    var win = doc.defaultView || doc.parentWindow;
    var sel;
    if (typeof win.getSelection != "undefined") {
        sel = win.getSelection();
        if (sel.rangeCount > 0) {
            var range = win.getSelection().getRangeAt(0);
            var preCaretRange = range.cloneRange();
            preCaretRange.selectNodeContents(element);
            preCaretRange.setEnd(range.endContainer, range.endOffset);
            caretOffset = preCaretRange.toString().length;
        }
    } else if ((sel = doc.selection) && sel.type != "Control") {
        var textRange = sel.createRange();
        var preCaretTextRange = doc.body.createTextRange();
        preCaretTextRange.moveToElementText(element);
        preCaretTextRange.setEndPoint("EndToEnd", textRange);
        caretOffset = preCaretTextRange.text.length;
    }
    return caretOffset;
}
function submitFile() {
    $('#fileInputDialog').css('visibility', 'hidden');
    //TODO submit file ajax
}

/*
 TODO Use trie structure here when the options are many
 * */
function simpleAutocompleteOption(lastWord) {
    var lastWordModded = lastWord.trim();
    var lastWordModdedLength = lastWordModded.length;
    for (var index in functionAppendix) {
        var wordStart = index.toLowerCase().substr(0, lastWordModdedLength);
        console.log("wordStart $" + wordStart);
        if (wordStart == lastWordModded) {
            return functionAppendix[index].substr(lastWordModdedLength);
        }
    }
    return "";
}

