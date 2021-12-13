let ids = 0;
let idr = 0;
function addField(id) {
    let vs = [];
    let vr = [];
    elem = document.getElementById(id);
    for (i = 0; i < ids; i++) {
        vs.push(document.getElementById('ids'+i).value);
        vr.push(document.getElementById('idr'+i).value);
    }
    elem.innerHTML += `<br><input class="oval" placeholder="действия" type="text" name="stepNames" id="ids${ids++}">`;
    elem.innerHTML += `<input class="oval" placeholder="ожидаемый результат" type="text" name="stepRes" id="idr${idr++}">`
    elem.innerHTML += `<button class="oval" onclick=\"addField('${id}')\" type=\"button\">+</button>`
    for (i = 0; i < ids - 1; i++) {
        document.getElementById('ids'+i).value = vs[i];
        document.getElementById('idr'+i).value = vr[i];
    }
}