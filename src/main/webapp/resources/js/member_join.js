 function joinCheck(){
const joinForm = document.getElementById("joinForm");
const joinButton = document.getElementById("joinButton");

const username = document.getElementById("username");
const inputUserNameResult = document.getElementById("inputUserNameResult");
const password = document.getElementById("password");
const inputPasswordResult = document.getElementById("inputPasswordResult");
const inputPassword = document.getElementById("inputPassword");
const inputPasswordCheckResult = document.getElementById("inputPasswordCheckResult");
const name1 = document.getElementById("name1");
const inputNameResult = document.getElementById("inputNameResult");
const phone = document.getElementById("phone");
const inputPhoneResult = document.getElementById("inputPhoneResult");
const email = document.getElementById("email");
const inputEmailResult = document.getElementById("inputEmailResult");

let idCheck=false;
let pwCheck=false;
let pwEqualCheck=false;
let nameCheck=false;
let emailCheck=false;
let phoneCheck=false;

 //idCheck
 username.addEventListener("blur", function(){
    idCheck=false;
    if(username.value.length>1){
        inputUserNameResult.innerHTML="";
        idCheck=true;
    }else {
        //idCheck=false;
        inputUserNameResult.innerHTML="ID는 최소 2글자 이상 이어야 합니다."
    }
    });

    //pw길이 Check
    password.addEventListener("change", function(){
        if(password.value.length>5){
            pwCheck=true;
            inputPasswordResult.innerHTML="";
            inputPassword.value="";
        }else {
            pwCheck=false;
            inputPasswordResult.innerHTML="패스워드는 6자 글자 이상이어야 합니다";

        }
    });

    //pw가 같은지 check
    inputPassword.addEventListener("blur", function(){
        console.log("pwEqual");
        if(password.value == inputPassword.value){
            pwEqualCheck=true;
            inputPasswordCheckResult.innerHTML="";
        }else {
            pwEqualCheck=false;
            inputPassword.value="";
            inputPasswordCheckResult.innerHTML="패스워드가 일치하지 않습니다"
        }
    });

    joinButton.addEventListener("click", function(){
        if(idCheck&&pwCheck&&pwEqualCheck){
            alert("서버 전송 합니다");
            //joinForm.submit();
        }else {
            alert("필수 입력 사항은 다 입력 해야 함");
        }

    });

 };//joinCheck 끝