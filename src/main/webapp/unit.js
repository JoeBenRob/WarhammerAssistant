const path = "http://35.242.246.89:8888/WarhammerCalculator/api/unit/"; 


const makeRequest = (method, url, body) => {
    return new Promise(
        function (res, rej) {
            const req = new XMLHttpRequest();
            req.onload = () => {
                if (req.status === 200) {
                    res(req.response);
                } else {
                    const reason = new Error('Error');
                    rej(reason);
                }
            }
            req.open(method, url)
            req.send(body);
        }
    )
}

function create() {
    let aUnit = createUnit();
    makeRequest("POST", `${path}/createUnit/`, JSON.stringify(aUnit))
        .then(res => { console.log(res) });
}

function read(id) {
    makeRequest("GET", `${path}getUnit/${id}`)
        .then(res => { console.log(res) });
}

function readAll() {
    makeRequest("GET", `${path}getAllUnit`)
        .then(res => { console.log(res) });
}

function update(id) {
    let aUnit = createUnit();
    makeRequest("PUT", `${path}updateUnit/${id}`, JSON.stringify(aUnit))
        .then(res => { console.log(res) });

}

function destroy(id) {
    makeRequest("DELETE", `${path}deleteUnit/${id}`)
        .then(res => { console.log(res) });
}

// function createUnit() {
//     const aUnit = {
//         namebox.value = name,
//         armybox.value = army,
//         allegiance.value = allegiance,
//         minbox.value = min,
//         max.value = max,
//         points.value = points
//     }
//     return aUnit;
// }