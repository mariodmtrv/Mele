/**
 * Created by mariodimitrov on 12/26/14.
 */



function submitInputQuery() {

    var jsonQuery = processUserInput();
    console.log("Query" + jsonQuery);
    $.ajax({
        type: "POST",
        url: "api/query/text",
        data: jsonQuery,
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).complete(function (data) {
        displayResult(data);
    });
}

function processUserInput() {
    var userInput = $("#expressionInput").val();
    console.log("Input" + userInput);
    var query = {
        queryText: userInput,
        sessionId: "hardcoded"
    };
    var result = JSON.stringify(query);
    return result;
}

function displayResult(response) {
    var json = eval("(" + response.responseText + ")");
    var resultArea = document.getElementById("resultArea");
    resultArea.value += ">>>> " + json["query"] + Array(10).join(" ") + " at " + json["producedTime"].substr(11, 5) + "\n";
    var x = json["queryResult"];
    for (var line in x) {
        console.log("line");
        resultArea.value += "<< " + x[line] + "\n";
    }
    resultArea.value += Array(3).join("<<<") + "\n";
}
var functionAppendix = {
    "LoadFile": "load(/path/to/file.csv)",
    "Min": "min(object.property)",
    "Mode": "mode(object.property)",
    "Normalize": "normalize(object.property)",
    "Upload": "upload(path/to/file.csv)"
};
function createHelpButtons() {

    Object.keys(functionAppendix).forEach(function (key, index) {
        var functionButton = "<li><span name= \"" + key +
            "\" onclick=funcButtonAppend(\"" + key + "\") class=\"availableFunctionButton\">" + key +
            "</span> </li>";
        $("#functionsMenu").append(functionButton);
    }, functionAppendix);
}
function funcButtonAppend(buttonName) {
    console.log("buttonCalled " + buttonName + " " + functionAppendix[buttonName]);
    $("#expressionInput").append(functionAppendix[buttonName]);
}