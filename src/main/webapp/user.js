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

function update() {
    id = document.getElementById('updateId').value;
    let aUser = updateUser();
    makeRequest("PUT", `${path}updateUser/${id}`, JSON.stringify(aUser))
    tableAll();
}

function destroy() {
    id = document.getElementById('deleteId').value;
    makeRequest("DELETE", `${path}deleteUser/${id}`)
    tableAll();
}

function createUser() {
    const aUser = {
        name: createName.value,
        score: createScore.value
    }
    return aUser;
}

function updateUser() {
    const aUser = {
        name: updateName.value,
        score: updateScore.value
    }
    return aUser;
}

function tableByName() {

    id = document.getElementById('getbyname').value;
    console.log(id)
    makeRequest("GET", `${path}getUser/${id}`).then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('userTable');
        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (i = tableSize; i > 1; i--) {
                container.deleteRow(i - 1);
            }

        }
            let myRow = document.createElement('tr');
            container.appendChild(myRow);
            let myId = document.createElement('td');
            myId.innerHTML = data[i].id;
            let myName = document.createElement('td');
            myName.innerHTML = data[i].name;
            let myScore = document.createElement('td');
            myScore.innerHTML = data[i].score;

            myRow.appendChild(myId);
            myRow.appendChild(myName);
            myRow.appendChild(myScore);
    })
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
            let myId = document.createElement('td');
            myId.innerHTML = data[i].id;
            let myName = document.createElement('td');
            myName.innerHTML = data[i].name;
            let myScore = document.createElement('td');
            myScore.innerHTML = data[i].score;

            myRow.appendChild(myId);
            myRow.appendChild(myName);
            myRow.appendChild(myScore);
        }
    })
        .catch((error) => console.log(error.message));
    return false;
}

function create() {
    let aUser = createUser();
    makeRequest("POST", `${path}createUser/`, JSON.stringify(aUser))
    tableAll();
}

var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
    coll[i].addEventListener("click", function () {
        this.classList.toggle("active");
        var content = this.nextElementSibling;
        if (content.style.display === "block") {
            content.style.display = "none";
        } else {
            content.style.display = "block";
        }
    });
}

function closeAll() {
    closeMyGetForm();
    closeMyCreateForm();
    closeMyUpdateForm();
    closeMyDeleteForm();
}

function openMyGetForm() {
    
    if (document.getElementById("myGetForm").style.display != "block") {
        closeAll();
        document.getElementById("myGetForm").style.display = "block";
    }
    else { document.getElementById("myGetForm").style.display = "none" }
}
function closeMyGetForm() {
    document.getElementById("myGetForm").style.display = "none";
}

function openMyCreateForm() {
   
    if (document.getElementById("myCreateForm").style.display != "block") {
        closeAll();
        document.getElementById("myCreateForm").style.display = "block";
    }
    else { document.getElementById("myCreateForm").style.display = "none" }
}

function closeMyCreateForm() {
    document.getElementById("myCreateForm").style.display = "none";
}

function openMyUpdateForm() {
   
    if (document.getElementById("myUpdateForm").style.display != "block")
     {
        closeAll();
        document.getElementById("myUpdateForm").style.display = "block";
    }
    else { document.getElementById("myUpdateForm").style.display = "none" }
}
function closeMyUpdateForm() {
    document.getElementById("myUpdateForm").style.display = "none";
}

function openMyDeleteForm() {
  
    if (document.getElementById("myDeleteForm").style.display != "block") {
        closeAll();
        document.getElementById("myDeleteForm").style.display = "block";
    }
    else { document.getElementById("myDeleteForm").style.display = "none" }
}
function closeMyDeleteForm() {
    document.getElementById("myDeleteForm").style.display = "none";
}