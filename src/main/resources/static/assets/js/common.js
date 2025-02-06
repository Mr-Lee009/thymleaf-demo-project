
$(document).ready(function () {
    initScreen();
});

function generateRowHTML(rowLabel, cols) {
    let seatBoxes = cols.map(col => 
        `<div class="col"><div class="box">${rowLabel}${col}</div></div>`
    ).join(""); // Tạo HTML cho từng ghế

    return `
    <div class="row">
        <div class="col-sm-5 arr-train">
            <div class="row text-center">
                ${seatBoxes.slice(0, 3)}  <!-- 3 ghế bên trái -->
            </div>
        </div>

        <div class="col-sm-2"></div>

        <div class="col-sm-5 arr-train">
            <div class="row text-center">
                ${seatBoxes.slice(3)}  <!-- 3 ghế bên phải -->
            </div>
        </div>
    </div>
    `;
}

function initScreen() {
    let rows = ["A", "B", "C", "D", "E", "F"];
    let numberOfSeats = 6; // Chỉ cần thay đổi số ghế ở đây
    let cols = Array.from({ length: numberOfSeats }, (_, i) => (i + 1).toString());

    let chairHTML = rows.map(row => generateRowHTML(row, cols)).join(""); // Tạo toàn bộ HTML

    $(".container").append(chairHTML); // Chèn HTML vào .container
}


