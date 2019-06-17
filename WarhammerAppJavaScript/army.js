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
    makeRequest("GET", `http://localhost:8080/WarhammerCalculator/api/army/getArmy/${id}`)
        .then(res => { console.log(res) });
}

function readAll() {
    makeRequest("GET", "http://localhost:8080/WarhammerCalculator/api/army/getAllArmy")
        .then(res => { console.log(res) });
}