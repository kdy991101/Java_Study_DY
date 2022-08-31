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
function check(){
    const all = document.getElementById("all");
    const cb = document.getElementsByClassName("cb");
    const req = document.getElementsByClassName("req");
    const join = document.getElementById("join");
    const frm = document.getElementById("frm");

    // join.addEventListener("click", function(){
    //     if(all.checked){
    //         frm.submit();
    //     }else{
    //         alert("모두 동의 하십시오.")
    //     }
    // });

    join.addEventListener("click", function(){

        // for(let i=0; i<req.length; i++){
        //     let count = 0;
        //     if(req[i].checked){
        //        count=count+1;
        //            continue;
        //     }
        //     if(count == req.length){
        //         frm.submit();
        //     }else{
        //         alert("필수약관을 모두 동의하셔야 합니다.")
        //     }
        // }

        // //     if(req[0].checked && req[1].checked){
        // //         frm.submit();
        // //     }else{
        // //         alert("필수약관을 모두 동의하셔야 합니다.")
        // //     }
        // }

        //======================================강사님
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
        //=====================================
       
    });

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
}





























