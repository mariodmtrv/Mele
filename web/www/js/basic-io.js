/**
 * Created by mariodimitrov on 12/26/14.
 */
function submitInputQuery() {

    var jsonQuery = processUserInput();
    console.log("Query" + jsonQuery);
    $.ajax({
        type: "POST",
        url: "/api/query/text",
        data: jsonQuery,
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function (data) {
        displayResult(data);
    }).error(function (data) {
        console.log("Failed" + JSON.stringify(data));
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
    console.log(JSON.stringify(response));
}
var functionAppendix = {
    "LoadFile": "load(/path/to/file.csv)",
    "Min": "min(object.property)",
    "Mode": "mode(object.property)"
}
function createHelpButtons() {

    Object.keys(functionAppendix).forEach(function (key, index) {
        var functionButton = "<li><button name= \"" + key +
            "\" onclick=funcButtonAppend(\"" + key + "\") >" + key +
            "</button> </li>";
        $("#functionsMenu").append(functionButton);
    }, functionAppendix);
}
function funcButtonAppend(buttonName) {
    console.log("buttonCalled " + buttonName + " " + functionAppendix[buttonName]);
    $("#expressionInput").append(functionAppendix[buttonName]);
}