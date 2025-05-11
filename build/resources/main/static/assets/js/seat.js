const SeatStatus = Object.freeze({
    AVAILABLE: "AVAILABLE",      // Ghế còn trống, có thể đặt
    RESERVED: "RESERVED",        // Đã giữ chỗ, chờ thanh toán
    BOOKED: "BOOKED",            // Đã đặt và thanh toán thành công
    CHECKED_IN: "CHECKED_IN",    // Hành khách đã check-in
    OCCUPIED: "OCCUPIED",        // Hành khách đang ngồi trên tàu
    CANCELLED: "CANCELLED",      // Vé bị hủy, có thể giải phóng ghế
    REFUNDED: "REFUNDED",        // Vé đã hoàn tiền cho khách
    BLOCKED: "BLOCKED"           // Ghế bị chặn, không thể đặt
});

$(document).ready(() => {
    intit();
});


let chair_selected = [];

function removeAllChairSelected() {
    chair_selected = [];
}

function loadChairSelected() {
    $("#home").html("");
    chair_selected.forEach((item) => {
        $("#home").append(`<p>${item}</p>`);
    });
}

function intit() {
    $(".box").on("click", function () {
        // let text = $("#parent .child").text(); // Cách 2 (dùng selector trực tiếp)
        let text = $(this).find(".chair").text();

        if (chair_selected.includes(text))
            return;

        chair_selected.push(text);
        loadChairSelected();
    });

    $(".chair").on("click",function(){
        if($(this).attr('data-status') !== SeatStatus.BOOKED){
            $(this).addClass("booked");
            $(this).attr('data-status','BOOKED');
            $(this).find('.number-chair').addClass("booked-number");
        }
        else{
            $(this).removeClass("booked");
            $(this).attr('data-status','AVAILABLE');
            $(this).find('.number-chair').removeClass("booked-number");
        }
    });
}