
const type_seat = {
    "First Class Seat": { rows: ["A", "B", "C","D", "E", "F"], seatsPerRow: 4 },
    "Premium Class": { rows: ["D", "E", "F"], seatsPerRow: 6 },
    "Business Class": { rows: ["G", "H", "I"], seatsPerRow: 8 },
    "Sleeper First Class": { rows: ["J", "K"], seatsPerRow: 4 }
};

$(document).ready(function () {
    initScreen("Business Class"); // Mặc định chọn loại ghế
});

function generateRowHTML(rowLabel, cols) {
    let seatBoxesArr = cols.map(col => 
        `<div class="col"><div class="box">${rowLabel}${col}</div></div>`
    );

    let leftSideCount = Math.floor(cols.length / 2);
    
    return `
    <div class="row">
        <div class="col-sm-5 arr-train">
            <div class="row text-center">
                ${seatBoxesArr.slice(0, leftSideCount).join("")}  
            </div>
        </div>

        <div class="col-sm-2"></div>

        <div class="col-sm-5 arr-train">
            <div class="row text-center">
                ${seatBoxesArr.slice(leftSideCount).join("")}  
            </div>
        </div>
    </div>
    `;
}

function initScreen(seatType) {
    if (!type_seat[seatType]) {
        console.error("Invalid seat type!");
        return;
    }

    let { rows, seatsPerRow } = type_seat[seatType];
    let cols = Array.from({ length: seatsPerRow }, (_, i) => (i + 1).toString());

    let chairHTML = rows.map(row => generateRowHTML(row, cols)).join("");

    $(".container").empty().append(chairHTML);
}



