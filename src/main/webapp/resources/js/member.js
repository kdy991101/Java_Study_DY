function loginCheck(){
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
}

// //---------------------강사님
// // memberButton.addEventListener("click", function(){
// //     let u = usernmae.value;
// //     let p = password.value;
// //     console.log(u == "");
// //     console.log(u.length);

// //     if(u == ""){
// //         alert("id는 필수입니다");
// //         return;//메서드 내에서 return을 만나면 그 즉시 종료
// //     }
// //     if(p == ""){
// //         alert("pw는 필수입니다,");
// //         return;
// //     }

// //     memberForm.submit;


//     // if(u.length>0 && p,length>0){
//     // memberForm.submit;
//     // }else{
//     //     alert("id,pw는 필수입니다.");
//     // }
// // })
// //-------------------------


//==========================================================================약관 동의

    const all = document.getElementById("all");
    // const all = document.querySelector("#all");//아이디로 가져올떄,,,?
    // const cb = document.getElementsByClassName("cb");//class이름으로 받아옴
    const cb = document.querySelectorAll(".cb");//실제 배열
    const req = document.getElementsByClassName("req");
    const join = document.getElementById("join");
    const frm = document.getElementById("frm");
//==0902
    // console.log("forEach");
    // cb.forEach(function(){
    //     console.log(v);
    // });
    //----------------

//==

    //  join.addEventListener("click", function(){
    //      if(all.checked){
    //          frm.submit();
    //      }else{
    //          alert("모두 동의 하십시오.")
    //      }
    //  });

    join.addEventListener("click", function(){

        for(let i=0; i<req.length; i++){
            let count = 0;
            if(req[i].checked){
               count=count+1;
                   continue;
            }
            if(count == req.length){
                frm.submit();
            }else{
                alert("필수약관을 모두 동의하셔야 합니다.")
            }
        }

            if(req[0].checked && req[1].checked){
                frm.submit();
            }else{
                alert("필수약관을 모두 동의하셔야 합니다.")
            }
        }
    )

//         //======================================강사님
        let result = true;
        for(let i=0; i<req.length; i++){
            if(!req[i].checked){
                result = false;
                break;
            }
        }
        if(result){
            frm.submit();
        }else{
            alert("필수약관을 모두 동의하셔야 합니다.")
        }
//         //=====================================
       
    

    all.addEventListener("click", function(){
        console.log(all.checked);
        for(let i=0; i<cb.length; i++){
            cb[i].checked=all.checked;
        }
    });
    for(let i=0; i<cb.length; i++){
        let result = true;
        cb[i].addEventListener("click", function(){
            for(let j=0; j<cb.length; j++){
                if(!cb[j].checked){
                    result = false;
                    break;
                }
            }
            all.checked=result;
        });
        
    
    };


// //--------------------------------------------강사님
// function joinCheck(){
//         const joinForm = document.getElementById("joinForm");
//         const joinButton = document.getElementById("joinButton");

//         const username = document.getElementById("username");
//         const password = document.getElementById("password");
//         const inputPassword = document.getElementById("inputPassword");
//         const name1 = document.getElementById("name1");
//         const phone = document.getElementById("phone");
//         const email = document.getElementById("email");

//         const d1 = document.getElementById("d1");
//         const d2 = document.getElementById("d2");
//         const d3 = document.getElementById("d3");
//         const d4 = document.getElementById("d4");
//         const d5 = document.getElementById("d5");
//         const d6 = document.getElementById("d6");

        // let idCheck = false;
        // let pwCheck = false;
        // let pwEqualCheck = false;
        // let nameCheck = false;
        // let emailCheck = false;
        // let phineCheck = false;

//         username.addEventListener("blur", function(){
//             idCheck=false;   

//             if(username.value.length > 1){
//                     d1.innerHTML="";
//                     idCheck = true;
//                 }else{
//                     d1.innerHTML="아이디는 최소 2글자 이상이어야 합니다.";
//             }
//         })

    //     joinButton.addEventListener("click", function(){
    //     if(idCheck&&pwCheck&&pwEqualCheck&&nameCheck&&emailCheck&&phineCheck){
    //         joinForm.submit();
    //     }else{
    //         alert("필수 입력 사항을 입력하세요")
    //         }
    //     }
    // )};

//     //pw길이
//     password.addEventListener("keyup", function(){
//         if(password.value.length > 5){
//             pwCheck=true;
//             d2="";
//         }else{
//             pwCheck=false;
//             d2.innerHTML="6글자 이상이어야 합니다.";
//         }
//     });
//     //pw같은지
//-----------------------------------------------------------




























