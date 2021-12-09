let ids = 0;
let idr = 0;
function addField() {
    let vs = [];
    let vr = [];
    elem = document.getElementById("dynamic");
    for (i = 0; i < ids; i++) {
        vs.push(document.getElementById('ids'+i).value);
        vr.push(document.getElementById('idr'+i).value);
    }
    elem.innerHTML += `<br><input placeholder="step" type="text" name="stepNames" id="ids${ids++}">`;
    elem.innerHTML += `<input placeholder="expRes" type="text" name="stepRes" id="idr${idr++}">`
    elem.innerHTML += "<button onclick=\"addField()\" type=\"button\">+</button>"
    for (i = 0; i < ids - 1; i++) {
        document.getElementById('ids'+i).value = vs[i];
        document.getElementById('idr'+i).value = vr[i];
    }
}