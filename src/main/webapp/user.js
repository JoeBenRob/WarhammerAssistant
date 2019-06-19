const path = "http://35.205.137.159:8888/WarhammerCalculator/api/user/"; 


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
    let aUser = createUser();
    makeRequest("POST", `${path}/createUser/`, JSON.stringify(aUser))
        .then(res => { console.log(res) });
}

function read(id) {
    makeRequest("GET", `${path}/getAUser/${id}`)
        .then(res => { console.log(res) });
}

function readAll() {
    makeRequest("GET", `${path}/getAllUser`)
        .then(res => { console.log(res) });
}

function update(id) {
    let aUser = createUser();
    makeRequest("PUT", `${path}/updateUser/${id}`, JSON.stringify(aUser))
        .then(res => { console.log(res) });

}

function destroy(id) {
    makeRequest("DELETE", `${path}/deleteUser/${id}`)
        .then(res => { console.log(res) });
}

function createUser() {
    const aUser = {
        name: namebox.value,
        score: scorebox.value
    }
    return aUser;
}