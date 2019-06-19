const path = "http://35.205.20.223:8888/WarhammerCalculator/api/army/"; 


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

function read(id) {
    makeRequest("GET", `${path}/getArmy/${id}`)
        .then(res => { console.log(res) });
}

function readAll() {
    makeRequest("GET", `${path}/getAllArmy`)
        .then(res => { console.log(res) });
}

// function createArmy() {
//     const anArmy = {

//     armynamebox.value = name,
//     allegiance.value =  allegiance
//     }
//     return anArmy
// }