const memberForm = document.getElementById("memberForm");
const memberButton = document.getElementById("memberButton");
const username= document.getElementById("username");
const password = document.getElementById("password");

memberButton.addEventListener("click", function(){
    console.log("Button Click");
    memberForm.submit();

    console.log(username.value);
    console.log(password.value);

    if(username.value.length<1 || password.value.length<1){
        alert("id,pw를 확인해주세요");
    }
})



//---------------------강사님
// memberButton.addEventListener("click", function(){
//     let u = usernmae.value;
//     let p = password.value;
//     console.log(u == "");
//     console.log(u.length);

//     if(u == ""){
//         alert("id는 필수입니다");
//         return;//메서드 내에서 return을 만나면 그 즉시 종료
//     }
//     if(p == ""){
//         alert("pw는 필수입니다,");
//         return;
//     }

//     memberForm.submit;


    // if(u.length>0 && p,length>0){
    // memberForm.submit;
    // }else{
    //     alert("id,pw는 필수입니다.");
    // }
// })
//-------------------------





























