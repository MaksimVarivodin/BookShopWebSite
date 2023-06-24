/**
 *
 */
$(function () {
    $('.add-to-cart-btn').bind('click', function () {
        let id = $(this).val();
        $.post('http://localhost:8080/Lab8/addtocart', {"id": id}, () => {
            $('#added-to-cart').css('display', 'flex');
            let k = $('#a-cart').text();
            k = parseInt(k.substring(6, k.length - 7));
            k++;
            $('#a-cart').text('Cart (' + k + ' items)');
            setTimeout(() => {
                $('#added-to-cart').css('display', 'none');
            }, 5000);
        });
    });
});

$(function () {
    $('.remove-from-cart-btn').bind('click', function () {
        let id = $(this).val();
        $.post('http://localhost:8080/Lab8/delfromcart', {"id": id}, () => {
        });
        let price = $(this).parent().parent().children().children('p').text();
        price = price.substring(0, price.length - 3);
        let oldPrice = $('#form-buy').children('#total-p').text();
        oldPrice = oldPrice.substring(13, oldPrice.length - 3);
        let k = $('#total-k').text();
        k = parseInt(k.substring(13, k.length));
        k--;
        $('#total-k').text('Total count: ' + k);
        $('#a-cart').text('Cart (' + k + ' items)');
        price = parseInt(oldPrice) - parseInt(price);
        if (isNaN(price))
            price = 0;
        $('#form-buy').children('#total-p').text('Total price: ' + price + '.0$');
        $(this).parent().parent().remove();
        if ($('.product-all-cart').children().length === 0) {
            let m = $("<h3></h3>").text("Cart is empty :(");
            $('.product-all-cart').append(m);
        }
    });
});


$(function () {
    $('#a-login').bind('click', function () {
        $('#form-login').css('display', 'block');
    });
});

$('#close-login').bind('click', () => {
    $('#form-login').css('display', 'none');
    $('#email-login').val('');
    $('#password-login').val('');
});

$('#close-register').bind('click', () => {
    $('#form-register').css('display', 'none');
    $('#name-register').val('');
    $('#email-register').val('');
    $('#password-register').val('');
});

$('#anthr-login').bind('click', () => {
    $('#close-login').trigger('click');
    $('#form-register').css('display', 'block');
});

$('#anthr-register').bind('click', () => {
    $('#close-register').trigger('click');
    $('#form-login').css('display', 'block');
});

$('#btn-login').bind('click', () => {
    let email = $('#email-login').val();
    let password = $('#password-login').val();
    if (!(email.includes('@') && (email.endsWith('.com') || email.endsWith('.ua')))) {
        $('#msg-login').text('Your email must include @ and end with .com/.ua');
        return;
    }
    if (email.length < 6) {
        $('#msg-login').text('Your email is too short');
        return;
    }
    if (email.startsWith('@')) {
        $('#msg-login').text('Your email is must include symbols before @');
        return;
    }
    /*
    if (password.length < 6) {
        $('#msg-login').text('Your password must contain at least 6 characters');
        return;
    }
    */
    $.post('http://localhost:8080/Lab8/login', {"email": email, "pass": password}, () => {
        $('#password-login').val('');
    }).done(() => {
        $('#close-login').trigger('click');
        //$('#btn-order').prop('disabled', false);
        $('#card-order').prop('disabled', false);
        $('#cvv-order').prop('disabled', false);
        $('#msg-order').text('');
        alert("Welcome!");
    }).fail(() => {
        $('#msg-login').text('Wrong email or password');
    });
});

$('#btn-register').bind('click', () => {
    let name = $('#name-register').val();
    let email = $('#email-register').val();
    let password = $('#password-register').val();
    if (!(email.includes('@') && (email.endsWith('.com') || email.endsWith('.ua')))) {
        $('#msg-register').text('Your email must include @ and end with .com/.ua');
        return;
    }
    if (email.length < 6) {
        $('#msg-register').text('Your email is too short');
        return;
    }
    if (email.startsWith('@')) {
        $('#msg-register').text('Your email is must include symbols before @');
        return;
    }
    if (password.length < 6) {
        $('#msg-register').text('Your password must contain at least 6 characters');
        return;
    }
    $.post('http://localhost:8080/Lab8/register', {"name": name, "email": email, "pass": password}, () => {
        $('#password-register').val('');
    }).done(() => {
        $('#close-register').trigger('click');
        //$('#btn-order').prop('disabled', false);
        $('#card-order').prop('disabled', false);
        $('#cvv-order').prop('disabled', false);
        $('#msg-order').text('');
        alert("Welcome!");
    }).fail(() => {
        $('#msg-register').text('Oops...try again later');
    });
});

$('#card-order').on('keyup input', () => {
    if ($('#card-order').val().length != 8 || $('#cvv-order').val().length != 3) {
        $('#btn-order').prop('disabled', true);
        $('#msg-order').text('Wrong card or cvv!');
    } else {
        $('#btn-order').prop('disabled', false);
        $('#msg-order').text('');
    }
});

$('#cvv-order').on('keyup input', () => {
    if ($('#card-order').val().length != 8 || $('#cvv-order').val().length != 3) {
        $('#btn-order').prop('disabled', true);
        $('#msg-order').text('Wrong card or cvv!');
    } else {
        $('#btn-order').prop('disabled', false);
        $('#msg-order').text('');
    }
});
