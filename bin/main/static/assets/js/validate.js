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
