const btn = document.querySelector("#btn");
const contents = document.querySelector("#contents");
const writer = document.querySelector("#writer");
const commentList = document.querySelector("#commentList");
const more = document.querySelector("#more");

getCommentList();

btn.addEventListener("click", function(){
    let bookNum = btn.getAttribute("data-bookNum");
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
                    commentList.children[0].remove;
                }

                getCommentList();
            }else{
                alert("댓글 등록 실패");
            }
        
        }
    } 

})//clicunck이벤트

function getCommentList(){
    //1.xmlhttpRequest
    const xhttp = new XMLHttpRequest();

    //2.메서드 url준비
    xhttp.open("GET", "./commentList?page=1&bookNum=" + btn.getAttribute("data-bookNum"));

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
            let ar = JSON.parse(xhttp.responseText.trim());
            
            // let result = document.createElement("table");
            // let resultAttr = document.createAttribute("class");
            // resultAttr.value = "table";
            // console.log(resultAttr.value);
            // result.setAttributeNode(resultAttr);
            // //<table class = "table table-striped"></table>
            // // commentList.innerHTML="";

            for(let i=0; i<ar.length; i++){

                let tr= document.createElement("tr");//<tr></tr>
                let td = document.createElement("td");//<td></td>

                let tdText = document.createTextNode(ar[i].contents);
                td.appendChild(tdText);
                tr.appendChild(td);

                tdText = document.createTextNode(ar[i].writer);
                td.appendChild(tdText);
                tr.appendChild(td);

                tdText = document.createTextNode(ar[i].regDate);
                td.appendChild(tdText);
                tr.appendChild(td);
  
                commentList.append(tr);
                //append=추가

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
let page = 1;

more.addEventListener("click", function(){
    //more를 클릭하면 page번호를 보내야 함
    page++; //page=page+1;
    
});


























