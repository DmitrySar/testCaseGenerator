let testCases = [];
let url = new URL("http://"+location.host+"/createTests");
let testCaseResponse = [];
let testCaseBackEnd = {
    id: 0,
    name: '',
    expResult: '',
    condition: '',
    stepList: []
};
let step = {

}

function sendTestCaseList() {
        fetch(url, {
        method: 'post',
        redirect: 'follow',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(testCases)
    }).then(res => res.json())
        .then(res =>  fillTestComplete(res));

}

function fillTestComplete(res) {
    testCaseResponse = res;
    let testComplect = document.getElementById("test-complect");
    let inner = '';
    for (let k in testCaseResponse) {
        testCaseBackEnd = testCaseResponse[k];
        inner += "<p><b>Тест-кейс №" + (parseInt(k)+1) + ". " + testCaseBackEnd.name + "</b></p>";
        inner += `<p><b>Условие: </b>${testCaseBackEnd.condition}</p>`
        inner += `<p><b>Шаги:</b></p>`
        for (let i in testCaseBackEnd.stepList) {
            step = testCaseBackEnd.stepList[i];
            inner += "<p>" + (parseInt(i)+1) + ". " + step.name + "</p>";
        }
        inner += "<p><b> Ожидаемый результат:</b><br>" + testCaseBackEnd.expResult +"</p>";
        inner += "<p><b>Фактический результат:</b></p>" +
            "<p>___________________________(вводит сам пользователь)</p>" +
            "<p><b>Комментарий:</b></p>" +
            "<p>____________________________________________________</p>" +
            "<p><br></p>";
    }

    testComplect.innerHTML = `<fieldset class="oval"><legend>Тест-комплект</legend>  
        ${inner} 
        <form action="/word" method="post">
        <textarea class="hidden" name="text" >${inner}</textarea>
        <input class="oval" type="submit" value="create docx">
        </form>
        </fieldset>`;
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