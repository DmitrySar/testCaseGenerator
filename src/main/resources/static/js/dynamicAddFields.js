let ids = 0;
function addField(id) {
    let expResult = document.getElementById('expResult'+id);
    let condition = document.getElementById('condition' + id);
    condition.className = 'oval show';
    expResult.className = 'oval show';
    let vs = [];
    let elem = document.getElementById(id);
    for (i = 0; i < ids; i++) {
        vs.push(document.getElementById('ids'+i).value);
    }
    elem.innerHTML += `<br><input class="oval" placeholder="действия" type="text" name="stepNames" id="ids${ids++}">`;
    elem.innerHTML += `<button class="oval" onclick=\"addField('${id}')\" type=\"button\">+</button>`
    for (i = 0; i < ids - 1; i++) {
        document.getElementById('ids'+i).value = vs[i];
    }
}