var testCases = [];
var url = new URL("http://"+location.host+"/createTests");

function sendTestCaseList() {
    testComplect = document.getElementById("test-complect");
    fetch(url, {
        method: 'post',
        redirect: 'follow',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(testCases)
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