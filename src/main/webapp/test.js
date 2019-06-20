
function addToTable(newEntry, aRow) {
    let aPoseID = document.createElement('td');
    aPoseID.innerHTML = newEntry.poseID;
    let aPoseName = document.createElement('td');
    aPoseName.innerHTML = newEntry.poseName;
    let aPoseDifficulty = document.createElement('td');
    aPoseDifficulty.innerHTML = newEntry.poseDifficulty;
    let deleteButton = document.createElement('td');
    deleteButton.innerHTML = `<button type="button" class="btn btn-secondary" onclick ='destroy(${newEntry.poseID})' > Delete</button >`;
    let readOneButton = document.createElement('td');
    readOneButton.innerHTML = `<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#exampleModal" onclick ='readOne(${newEntry.poseID})' > More Details </button >`;
    aRow.appendChild(aPoseID);
    aRow.appendChild(aPoseName);
    aRow.appendChild(aPoseDifficulty);
    aRow.appendChild(deleteButton);
    aRow.appendChild(readOneButton);
}
//read
const readAll = () => {
    // removes any existing tables
    const tableContainer = document.getElementById('table');
    if (tableContainer.rows.length > 1) {
        let tableSize = tableContainer.rows.length;
        for (let i = tableSize; i > 1; i--) {
            tableContainer.deleteRow(i - 1);
        }
    }
    makeRequest("GET", `${poseURL}getAllPoses`)
        .then((req) => {
            let data = JSON.parse(req.responseText);
            console.table(data);
            console.table(data[0].poseName);
            const tableContainer = document.getElementById('table');
            tableContainer.className = "table table-hover";
            // creating table rows and adding data into the rows
            for (let i = 0; i < data.length; i++) {
                let aRow = document.createElement('tr')
                tableContainer.appendChild(aRow);
                addToTable(data[i], aRow);
            }
            console.table(req.responseText)
        }).catch((error) => { console.log(error.message) });
}