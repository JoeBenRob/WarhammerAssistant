const path = "http://35.242.246.89:8888/WarhammerCalculator/api/army/";

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
    let anArmy = createArmy();
    makeRequest("POST", `${path}createArmy/`, JSON.stringify(anArmy))
        .then(res => { console.log(res) });
}

function read(id) {
    makeRequest("GET", `${path}getArmy/${id}`)
        .then(res => { console.log(res) });
}

function readAll() {
    makeRequest("GET", `${path}getAllArmy`)
        .then(res => { console.log(res) });
}

function update(id) {
    let anArmy = createUArmy();
    makeRequest("PUT", `${path}updateArmy/${id}`, JSON.stringify(anArmy))
        .then(res => { console.log(res) });

}

function destroy(id) {
    makeRequest("DELETE", `${path}deleteUArmy/${id}`)
        .then(res => { console.log(res) });
}

// function createArmy() {
//     const anArmy = {

//     armynamebox.value = name,
//     allegiance.value =  allegiance
//     }
//     return anArmy
// }

function UnitTableAll(input) {
    makeRequest("GET", `http://35.242.246.89:8888/WarhammerCalculator/api/unit/getAllUnit`).then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('unitTable');

        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (i = tableSize; i > 1; i--) {
                container.deleteRow(i - 1);
            }

        }

        for (let i = 0; i < value.length; i++) {
            if (data[i].army === input) {
                let myRow = document.createElement('tr');
                container.appendChild(myRow);
                let myName = document.createElement('td');
                myName.innerHTML = data[i].name;
                let myAllegiance = document.createElement('td');
                myAllegiance.innerHTML = data[i].allegiance;
                let myArmy = document.createElement('td');
                myArmy.innerHTML = data[i].army;
                let myRole = document.createElement('td');
                myRole.innerHTML = data[i].role;
                let myMin = document.createElement('td');
                myMin.innerHTML = data[i].min;
                let myMax = document.createElement('td');
                myMax.innerHTML = data[i].max;
                let myPoints = document.createElement('td');
                myPoints.innerHTML = data[i].points;

                myRow.appendChild(myName);
                myRow.appendChild(myAllegiance);
                myRow.appendChild(myArmy);
                myRow.appendChild(myRole);
                myRow.appendChild(myMin);
                myRow.appendChild(myMax);
                myRow.appendChild(myPoints);
            }

        }
    })
        .catch((error) => console.log(error));
    return false;
}



function UnitTableAllbyAllegiance(input) {
    makeRequest("GET", `http://35.242.246.89:8888/WarhammerCalculator/api/unit/getAllUnit`).then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('unitTable');

        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (i = tableSize; i > 1; i--) {
                container.deleteRow(i - 1);
            }

        }

        for (let i = 0; i < value.length; i++) {
            if (data[i].allegiance === input) {
                let myRow = document.createElement('tr');
                container.appendChild(myRow);
                let myName = document.createElement('td');
                myName.innerHTML = data[i].name;
                let myAllegiance = document.createElement('td');
                myAllegiance.innerHTML = data[i].allegiance;
                let myArmy = document.createElement('td');
                myArmy.innerHTML = data[i].army;
                let myRole = document.createElement('td');
                myRole.innerHTML = data[i].role;
                let myMin = document.createElement('td');
                myMin.innerHTML = data[i].min;
                let myMax = document.createElement('td');
                myMax.innerHTML = data[i].max;
                let myPoints = document.createElement('td');
                myPoints.innerHTML = data[i].points;

                myRow.appendChild(myName);
                myRow.appendChild(myAllegiance);
                myRow.appendChild(myArmy);
                myRow.appendChild(myRole);
                myRow.appendChild(myMin);
                myRow.appendChild(myMax);
                myRow.appendChild(myPoints);
            }

        }
    })
        .catch((error) => console.log(error.message));
    return false;
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