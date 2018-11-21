$(document).ready(function () {

    $('#firstNumber').change(function () {
        calculate();
    });

    $('#secondNumber').change(function () {
        calculate();
    });

    $('#operator').change(function () {
        calculate();
    })

});

function calculate() {

    var first = $('#firstNumber').val().trim();
    var second = $('#secondNumber').val().trim();
    var operator = $('#operator').val().trim();

    console.log(first + ' ' + second + ' ' + operator);

    if (!isValidInput(first)) {
        console.log('ilk sayi eksik');
        return;
    }

    if (!isValidInput(second)) {
        console.log('ikinci sayi eksik');
        return;
    }

    if (!isValidInput(operator)) {
        console.log('operator eksik');
        $('#calculationResult').text('');
        return;
    }


    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: getContextPath() + '/api/calculate?first=' + first + '&second=' + second + '&operator=' + operator,
        timeout: 15000,
        success: function (data) {
            console.log('success: ', data);
            $('#calculationResult').text(data);
        },
        error: function (e) {
            console.log('error: ', e);

        },
        done: function (e) {
            console.log('done');
        }

    })


}

function isValidInput(inputValue) {
    if (inputValue === null || inputValue === undefined) {
        return false;
    }
    return inputValue.length !== 0;
}

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/", 2));
}