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
}