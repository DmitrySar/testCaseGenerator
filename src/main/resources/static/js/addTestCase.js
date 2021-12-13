let testCaseList = [];

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
        testCaseList.push(testCase);
        setColor(btnId);
    }

}

function isAdded(testCase) {
    return testCaseList.filter(t => t.chapterId == testCase.chapterId
        && t.testCaseId == testCase.testCaseId).length > 0;
}

function removeTestCase(testCase) {
    index = testCaseList.findIndex(t => t.chapterId == testCase.chapterId
        && t.testCaseId == testCase.testCaseId);
    testCaseList.splice(index);
}