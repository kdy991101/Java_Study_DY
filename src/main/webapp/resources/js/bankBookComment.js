// const btn = document.querySelector("#btn");
const contents = document.querySelector("#contents");
const writer = document.querySelector("#writer");
const commentList = document.querySelector("#commentList");
const more = document.querySelector("#more");


//page번호 담는 변수
let page = 1;
alert
//bookNum을 담을 변수
const bookNum = btn.getAttribute("data-bookNum")
getCommentList(page, bookNum);

btn.addEventListener("click", function(){
    let wv = writer.value;
    let cv = contents.value;

    //--ajax------
    //1.XMLHTTPRequest 생성
    const xhttp = new XMLHttpRequest();

    //2.메서드, url준비
    // 요청을 보낼 주소 작성
    xhttp.open("POST", "./commentAdd");//파라이터방식으로 3개를 보내줌
  
    //3.요청을 전송  메서드 형식이 post일 떄에는enctype
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4.요청 발생, 전송(post일 경우 파라미터를 추가)
    xhttp.send("bookNum="+bookNum+"&writer="+wv+"&contents="+cv);

    //5.응답 처리
    xhttp.onreadystatechange=function(){
        if(this.readyState==4 && this.status==200){
            let result=xhttp.responseText.trim();
            // 응답은 responsText에 담김
            console.log(result);
            result = JSON.parse(result);
            if(result.result==1){
                alert("댓글 등록 성공");

                // if(commentList.children.length != 0){
                //     commentList.children[0].remove;
                // }//이렇게 되면 tr태그만 없어짐...?
                for(let i=0; i<commentList.children.length;){
                    commentList.children[0].remove();
                }//내용을 비워줌
                page=1;

                getCommentList(page, bookNum);//댓글이 등록되면 무조건 위(최신)에있어야 하기 떄문에 1
            }else{
                alert("댓글 등록 실패");
            }
        
        }
    } 

})//clicunck이벤트

function getCommentList(p, bn){
    //1.xmlhttpRequest
    const xhttp = new XMLHttpRequest();

    //2.메서드 url준비
    xhttp.open("GET", "./commentList?page="+p+"&bookNum=" + bn);

    //3. 요청 전송
    xhttp.send();

    //4.응답 처리
    xhttp.addEventListener("readystatechange", function(){
        if(xhttp.readyState==4 && xhttp.status==200){
            console.log(xhttp.responseText);

            //1.번 결과물에 사용
            // commentList.innerHTML=xhttp.responseText.trim();

            //2.json결과물에 사용
            //json 오브젝트타입으로 변경해줘야 함
            let result = JSON.parse(xhttp.responseText.trim());
            
            // let result = document.createElement("table");
            // let resultAttr = document.createAttribute("class");
            // resultAttr.value = "table";
            // console.log(resultAttr.value);
            // result.setAttributeNode(resultAttr);
            // //<table class = "table table-striped"></table>
            // // commentList.innerHTML="";

            let pager = result.pager;
            let ar = result.list;

            let tb = document.createElement("tbody");

            for(let i=0; i<ar.length; i++){

                let tr= document.createElement("tr");//<tr></tr>
                let td = document.createElement("td");//<td></td>

                let tdText = document.createTextNode(ar[i].contents);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode(ar[i].writer);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");

                // let date = new Date(ar[i].regDate);
                // console.log(date);
                // let year = date.getFullYear();
                // let month = date.getMonth()+1;
                // let d = date.getDate();
                // tdText = document.createTextNode(year+"-"+month+"-"+d);
                // console.log(year);
                // console.log(month);
                // console.log(d);

                tdText = document.createTextNode(ar[i].regDate);
                
                td.appendChild(tdText);
                tr.appendChild(td);
                

                td = document.createElement("td");
                tdText = document.createTextNode("수정");
                let tdAttr = document.createAttribute("class");
                tdAttr.value="update";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value=ar[i].num;
                td.setAttributeNode(tdAttr);
                td.appendChild(tdText);
                tr.appendChild(td);

                td = document.createElement("td");
                tdText = document.createTextNode("삭제");
                tdAttr = document.createAttribute("class");
                tdAttr.value = "delete";
                td.setAttributeNode(tdAttr);
                tdAttr = document.createAttribute("data-comment-num");
                tdAttr.value=ar[i].num;
                td.setAttributeNode(tdAttr)
                td.appendChild(tdText);
                tr.appendChild(td);

  
                tb.appendChild(tr);
                //append=추가

                if(page >= pager.totalPage){
                    more.classList.add("disabled");
                }else{
                    more.classList.remove("disabled");
                }
                commentList.append(tb);

            }

            // let t = commentList.children;

            // if(t.length != 0){
            //     commentList.children[0].remove();
            // }
            //============================================================
            //자식만 삭제,어떤 애들 지울건지 선택해 줘야 함
            //예외처리
            //  try{
                //  console.log(commentList.children());
                //  throw new Error("오류 발생");//error객체
                //  }
                //  //해당 이벤트 객체를 받아줘야 함
                //  catch(exception){
                    
                    //  }
                    //  //예외가 발생하든 안하든 실행~
                    //  finally{
                        
            //  }
            //============================================================
            
            // commentList.append(result); 
            
        }
    })
};
//-------------더보기-------------------


more.addEventListener("click", function(){
    //more를 클릭하면 page번호를 보내야 함
    page++; //page=page+1;
    console.log(page);
    console.log(bookNum);

    getCommentList(page, bookNum);

});

//=====================delete, update================================
commentList.addEventListener("click", function(event){
    console.log(event.target);
    //===================update=============================
    
    if(event.target.className == "update"){
        // let check = window.confirm("수정 하고싶어??");

        // let contents = event.target.previousSibling.previousSibling.previousSibling;
        // console.log(contents);
        // let v = contents.innerHTML;
        // contents.innerHTML = "<textarea>"+v+"</textarea>";

        let contents = event.target.previousSibling.previousSibling.previousSibling.innerHTML;
        let writer = event.target.previousSibling.previousSibling.innerHTML;
        let num = event.target.getAttribute("data-comment-num");
        console.log(contents);
        document.querySelector("#updateContents").value=contents;
        document.querySelector("#updateWriter").value=writer;
        document.querySelector("#num").value=num;

        document.querySelector("#up").click();//이벤트 강제 발생시킴
        //강제로 실행시킬 때 target은 수정임
        

        
    }


   //===================delete=============================
    if(event.target.className=="delete"){
        let check = window.confirm("삭제하시겠습니까?");
        if(check){
            let num = event.target.getAttribute("data-comment-num");
            console.log("Num : ",num);

            //1.XMLFTTPRequest생성
            const xhttp = new XMLHttpRequest();

            //2.요청 정보(url,메서드)
            xhttp.open("POST", "./commentDelete");

            //3. header정보 encType
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            //4. 요청을 보내는데 파라미터와 함꼐 
            xhttp.send("num="+num);

            //5.응답 처리
            xhttp.onreadystatechange=function(){
                if(xhttp.readyState==4&&xhttp.status==200){
                    let result = xhttp.responseText.trim();
                        if(result==1){
                            alert("삭제 성공");
                            page=1;
                            getCommentList(page, bookNum);
                            for(let i=0; i<commentList.children.length;){
                                commentList.children[0].remove();
                            }
                        }else{
                            alert("삭제 실패");
                        }
                }
            }

        }
    }
    

});

//=======================modal update버튼
const update = document.querySelector("#update");
update.addEventListener("click", function(){
    //modal에서 num, ccontents
    let num = document.getElementById("num").value;
    let contents = document.querySelector("#updateContents").value;

    //--ajax--
    //1.xhttpRequest생성
    const xhttp = new XMLHttpRequest();

    //2. request  정보
    xhttp.open("POST", "commentUpdate");

    //3. header 저보(enctype)
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    //4. 요청 실행
    xhttp.send("num="+num+"&contents="+contents);

    //5. 응답 처리
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState==4&&xhttp.status==200){
            let result = xhttp.responseText.trim();

            if(result>0){
                alert("수정 완료");
                
                for(let i=0; i<commentList.children.length;){
                    commentList.children[0].remove();
                }

                page=1;

                getCommentList(page, bookNum);
            }else{
                alert("수정 실패");
            }
        }
    }
})



























