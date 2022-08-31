joinCheck(){
const username = document.getElementById("username");
const password = document.getElementById("password");
const inputPassword = document.getElementById("inputPassword");
const name1 = document.getElementById("name1");
const phone = document.getElementById("phone");
const email = document.getElementById("email");
const d1 = document.getElementById("d1");
const d2 = document.getElementById("d2");
const d3 = document.getElementById("d3");
const d4 = document.getElementById("d4");
const d5 = document.getElementById("d5");
const d6 = document.getElementById("d6");
const joinForm = document.getElementById("joinForm");
const joinButton = document.getElementById("joinButton");

let idCheck = false;
let pwCheck = false;
let pwEqualCheck = false;
let nameCheck = false;
let emailCheck = false;
let phineCheck = false;


let count = 0;
username.addEventListener("blur", function(){
    idCheck = false;

    let un = username.value;
    if(un.length<3){
        d1.innerHTML = ("아이디는 두글자 이상이어야 합니다.");   
        return;
    }else{
        idCheck = true;
        d1.innerHTML=('O');
    }
});

password.addEventListener("keyup", function(){
    pwCheck = false;
    
    if(password.value.length < 6){
      d2.innerHTML = "최소 6글자 이상이어야 합니다.";
      return;
    }else{
        pwCheck=true;
        d2.innerHTML='O';
    }
});

inputPassword.addEventListener("blur", function(){
    pwEqualCheck = false;
    if(inputPassword.value != password.value){
        d3.innerHTML=("일치하지 않습니다");
        return;
    }else{
        pwEqualCheck = true;
        d3.innerHTML=("O");
    }
});

name1.addEventListener("blur", function(){
    nameCheck = false;

    let n1 = name1.value;
    if(n1.length<2){
        d4.innerHTML = ("이름은 한글자 이상이어야 합니다");
        return;
    }else{
        nameCheck=true;
        d4.innerHTML=('O')
    }
});

phone.addEventListener("blur", function(){
    phineCheck = false;
    let p = phone.value;
    if(p.length<2){
        d5.innerHTML = ("한글자 이상이어야 합니다.");
        return;
    }else{
        phineCheck = true;
        d5.innerHTML=('O')
    }
});

email.addEventListener("blur", function(){
    emailCheck = false;
    let e = email.value;
    if(e.length<2){
        d6.innerHTML = ("한글자 이상이어야 합니다.");
        return;

    }else{
        emailCheck = true;
        d6.innerHTML="O";
    }
});

joinButton.addEventListener("click", function(){
    if(idCheck&&pwCheck&&pwEqualCheck&&nameCheck&&emailCheck&&phineCheck){
        joinForm.submit();
    }else{
        alert("필수 입력 사항을 입력하세요")
        }
    });
}