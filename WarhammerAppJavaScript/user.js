
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
    makeRequest("POST", "http://localhost:8080/WarhammerCalculator/api/user/createUser/", JSON.stringify(aUser))
        .then(res => { console.log(res) });
}

function read(id) {
    makeRequest("GET", `http://localhost:8080/WarhammerCalculator/api/user/getAUser/${id}`)
        .then(res => { console.log(res) });
}

function readAll() {
    makeRequest("GET", "http://localhost:8080/WarhammerCalculator/api/user/getAllUser")
        .then(res => { console.log(res) });
}

function update(id) {
    let aUser = createUser();
    makeRequest("PUT", `http://localhost:8080/WarhammerCalculator/api/user/updateUser/${id}`, JSON.stringify(aUser))
        .then(res => { console.log(res) });

}

function destroy(id) {
    makeRequest("DELETE", `http://localhost:8080/WarhammerCalculator/api/user/deleteUser/${id}`)
        .then(res => { console.log(res) });
}

function createUser() {
    const aUser = {
        name: name.value,
        score: score.value
    }
    console.log(aUser);
    return aUser;
}