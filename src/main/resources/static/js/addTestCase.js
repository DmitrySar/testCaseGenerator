var testCases = [];
var url = new URL("http://"+location.host+"/createTests?testCases=");

function sendTestCaseList() {
    // var req = "";
    // testCases.forEach(t => req += t.testCaseId + "&testCases=");
    // window.location.replace(url + req.substr(0,req.length-11));
    testComplect = document.getElementById("test-complect");
    fetch('http://localhost/createTests', {
        method: 'post',
        redirect: 'follow',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify([{
            "name": "test",
            "expResult": "testResult"
        }])
    }).then(res => res.text())
        .then(res => testComplect.innerHTML = `<fieldset><legend>Тест-комплект</legend>${res}</fieldset>`);
}

function setColor(btnId) {
    btn = document.getElementById(btnId);
    btn.style.backgroundColor = "#59a869";
    btn.style.color = "white";
}

function resetColor(btnId) {
    btn = document.getElementById(btnId);
    btn.style.backgroundColor = "";
    btn.style.color = "";
}

function addTestCase(chId, tcId, btnId) {
    let testCase = new Object();
    testCase.chapterId = chId;
    testCase.testCaseId = tcId;
    if (isAdded(testCase)) {
        removeTestCase(testCase);
        resetColor(btnId);
    } else {
        testCases.push(testCase);
        setColor(btnId);
    }

}

function isAdded(testCase) {
    return testCases.filter(t => t.chapterId == testCase.chapterId
        && t.testCaseId == testCase.testCaseId).length > 0;
}

function removeTestCase(testCase) {
    index = testCases.findIndex(t => t.chapterId == testCase.chapterId
        && t.testCaseId == testCase.testCaseId);
    testCases.splice(index);
}