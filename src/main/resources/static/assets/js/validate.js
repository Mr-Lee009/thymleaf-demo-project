const MESSAGE_ERROR_INDEX = {
    productName: {
        required : 'please enter product name.',
        maxLength : 'please 18 character.',
        minLength : 'you need enter more 10 charactor'
    },
    orderName: {
        required : 'please enter order name.',
        minLength : 'you need enter more 10 charactor'
    }
};

const RULE = {
    productName: {
        nameEl: 'product name',
        required: true,
        maxLength: 30,
        minLength: 10,
    },
    orderName: {
        nameEl: 'order',
        required: true
    },
    order: {
        nameEl: 'order',
        required: true,
        maxLength: 30
    }
}


// main function
$(document).ready(() => {
    init();
});

let init = function(){
    $('.btn-submit').on('click',function(evt){
        evt.preventDefault();
        let listInput = $('.validate');
        if(validate(listInput, RULE, MESSAGE_ERROR_INDEX)){
            alert('PASSS')
        }
        else{
            alert("FALSE");
        }
    });
}


function isNullOrEmpty(value) {
    return typeof value === 'string' && value.trim() === '';
}

function isEmptyArray(value) {
    return Array.isArray(value) && value.length === 0;
}


let validate = function (listInput, rules, messages) {
    $(DOT_INVALID_FEEDBACK).remove();
    let checked = true;
    if (isEmptyArray(listInput))
        return false;

    let ABC = listInput?.toArray().map((input) => {
        let name = $(input).attr("name")
        if (name && rules[name]) {
            $(input).removeClass(IS_INVALID);

            const keys = Object.keys(rules[name]);
            const dataValue = $(input).val();
            
            // check require
            if (keys.includes(REQUIRED) && rules[name].required && (!dataValue || dataValue.length === ZERO)) {
               $(input).addClass('ng').addClass(IS_INVALID);
                addMessage(messages[name].required, $(input));
                checked = false;
                return false; 
            }

            // check max length
            if (keys.includes(MAX_LENGTH) && rules[name].maxLength && dataValue.length > rules[name].maxLength) {
               $(input).addClass('ng').addClass(IS_INVALID);
                addMessage(messages[name].maxLength, $(input));
                checked = false;
                return false; 
            }

            // check min length
            if (keys.includes(MIN_LENGTH) && rules[name].minLength && dataValue.length < rules[name].minLength) {
               $(input).addClass('ng').addClass(IS_INVALID);
               addMessage(messages[name].minLength, $(input)); 
               checked = false;
               return false; 
            }
        }
        return true; 
    });
    console.log('ABC', ABC);
    $('.needs-validation').addClass('was-validated');
    return checked;
}


/**
 * Set style message error for parent or tag td.
 * @param rules
 * @param name
 * @param $ipt
 */
function setCssRequired(rules, name, $ipt) {
    $ipt.addClass(IS_INVALID);
}


function addMessage(message,$ipt) {
    let invalidFeedback = `<div class="invalid-feedback">{0}</div>`;
    $ipt.parent().append(invalidFeedback.replace('{0}',message));
}

// Example starter JavaScript for disabling form submissions if there are invalid fields
// (function () {
//     'use strict'
  
//     // Fetch all the forms we want to apply custom Bootstrap validation styles to
//     var forms = document.querySelectorAll('.needs-validation')
  
//     // Loop over them and prevent submission
//     Array.prototype.slice.call(forms)
//       .forEach(function (form) {
//         form.addEventListener('submit', function (event) {
//           if (!form.checkValidity()) {
//             event.preventDefault()
//             event.stopPropagation()
//           }
  
//           form.classList.add('was-validated')
//         }, false)
//       })
//   })()
var createStorage = function(key){
    const store = JSON.parse(localStorage.getItem(key)) ?? {};

    const save = () =>{
        localStorage.setItem(key,JSON.stringify(store));
    }

    return storage = {
        get(key){
            return store[key];
        },
        set(key, value){
            store[key] = value;
            save();
        },save(key, value){
            delete store[key];
            save();
        },show(){
            return store;
        }
    }

    return storage;
};

// alert("hello");

var local1 = new createStorage("profile-user");
console.log(local1.get('user-name'));
local1.set('phone-number', '0972491396');
local1.set('gender', 1);
local1.set('vip', {
    'A':1,
    'B':2,
    'C':3
});

var local2 = new createStorage("profile-user-2");
local2.set('phone-number', '0972491396');
local2.set('gender', 1);
local2.set('vip', {
    'A':1,
    'B':2,
    'C':3
});

console.table(local2.show());
console.table(local1.show());
