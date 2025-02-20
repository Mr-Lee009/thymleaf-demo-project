const type_seat = {
    "First Class Seat": { rows: ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"], seatsPerRow: 4 },
    "Premium Class": { rows: ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"], seatsPerRow: 6 },
    "Business Class": { rows: ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"], seatsPerRow: 8 },
    "Sleeper First Class": { rows: ["J", "K"], seatsPerRow: 4 }
};

let HTML_FIRSTCLASS_SEAT = `<div></div>`;
let HTML_PREMIUM_CLASS = `<div></div>`;
let HTML_BUSINESS_CLASS = `<div></div>`;
let HTML_SLEEPER_FIRSTCLASS = `<div></div>`;

let container_seating = {
    "First Class Seat": HTML_FIRSTCLASS_SEAT,
    "Premium Class": HTML_PREMIUM_CLASS,
    "Business Class": HTML_BUSINESS_CLASS,
    "Sleeper First Class": HTML_SLEEPER_FIRSTCLASS
};

$(document).ready(function () {
    initScreen("Business Class"); // Mặc định chọn loại ghế
});

function generateRowHTML(rowLabel, cols) {
    let seatBoxesArr = cols.map(col =>
        `<div class="col">
            <div class="box" data-status="AVAILABLE">
                <div class="chair"><h6 class="number-chair">${rowLabel}${col}</h6></div>
            </div>
        </div>`
    );

    let leftSideCount = Math.floor(cols.length / 2);

    return `
    <div class="row">
        <div class="col-sm-5 arr-train">
            <div class="row text-center">
                ${seatBoxesArr.slice(0, leftSideCount).join("")}  
            </div>
        </div>

        <div class="col-sm-2 aisle"></div>

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

    $(".seating").empty().append(chairHTML);
}
