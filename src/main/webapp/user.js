const path = "http://35.242.246.89:8888/WarhammerCalculator/api/user/";

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
    makeRequest("POST", `${path}createUser/`, JSON.stringify(aUser))
        .then(res => { console.log(res) });
}

function read(id) {
    makeRequest("GET", `${path}getUser/${id}`)
        .then(res => { console.log(res) });
}

function readAll() {
    makeRequest("GET", `${path}getAllUser`)
        .then(res => { console.log(res) });
}

function update(id) {
    let aUser = createUser();
    makeRequest("PUT", `${path}updateUser/${id}`, JSON.stringify(aUser))
        .then(res => { console.log(res) });

}

function destroy(id) {
    makeRequest("DELETE", `${path}deleteUser/${id}`)
        .then(res => { console.log(res) });
}

function createUser() {
    const aUser = {
        name: namebox.value,
        score: scorebox.value
    }
    return aUser;
}

function tableAll() {
    makeRequest("GET", `${path}getAllUser`).then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('userTable');

        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (i = tableSize; i > 1; i--) {
                container.deleteRow(i - 1);
            }

        }

        for (let i = 0; i < value.length; i++) {
            let myRow = document.createElement('tr');
            container.appendChild(myRow);
            let myUserid = document.createElement('td');
            myUserid.innerHTML = data[i].id;
            let myName = document.createElement('td');
            myName.innerHTML = data[i].name;
            let myScore = document.createElement('td');
            myScore.innerHTML = data[i].score;

            myRow.appendChild(myUserid);
            myRow.appendChild(myName);
            myRow.appendChild(myScore);
        }
    })
        .catch((error) => console.log(error.message));
    return false;
}

