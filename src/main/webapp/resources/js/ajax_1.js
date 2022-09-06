const d1 = document.querySelector("#d1");
const body = document.querySelector("#body");
const result = document.querySelector("#result");

d1.addEventListener("click", function(){
    console.log("click");
    let t = text.value;

    //1.ajax로 요청하는 객체 생성
    let xhttp = new XMLHttpRequest();

    //2.요청 정보
    xhttp.open("GET", "https://jsonplaceholder.typicode.com/posts/"+t);//메서드 형식,url주소

    //3.요청 발생
    xhttp.send();//post방식일 때에만 send안에 파라미터를 넣음

    //4.응답 결과를 처리
    xhttp.onreadystatechange = function(){
        //this는 xhttp객체를 야기함
        // console.log(this.status);//상태 번호를 알려줌
        // console.log(this.readyState);
        // console.log("==================================");
        
        if(this.readyState == 4 && this.status==200){
            // console.log(this.responseText);//응답이 담겨있음

            let response = this.responseText.trim();//trim=공백 제거
            response = JSON.parse(response);//reponseText를 JSON.parse가 문자열을 객체로 만들어줌??
            console.log(response.userId);//사용자의 아이디
            console.log(response.id);
            console.log(response.title);
            console.log(response.body);

            let h3 = document.createElement("h3");
            let h3text = document.createTextNode(response.userId);
            h3.appendChild(h3text)
            result.append(h3);
            h3.document.createElement("h3");
            h3text = document.createTextNode(response.id);
           
            let h3text_2 = document.createTextNode(response.id);
            h3.appendChild(h3text_2)
            result.append(h3);

            let h3text_3 = document.createTextNode(response.title);
            h3.document.createElement("h3");
            h3.appendChild(h3text)
            h3text = document.createTextNode(response.title);
           
            result.append(h3);

            let h3text = document.createTextNode(response.body);
            h3.document.createElement("h3");
            h3.appendChild(h3text)
            h3text = document.createTextNode(response.body);
            
            result.append(h3);


            

            

        }
        //페이지와 주소는 변하지 않고 내부에서 요청과 응답이 발생한 것
        //응답이 올때까지 기다릴 필요는 없음
        //동기방식은 요청을 보내고 응답이 올때까지 기다려야 하지만
        //비동기 방식은 응답을 기다리지 않을 수 있음..?
    };

    console.log("Ajax발생");
    //프로그램은 위에서부터 읽지만 클릭하면 콘솔에 click이라는 애를 찍은 후에 요청을 보냄
    //응답이 올 때까지 기다리는 것이 아닌 요청을 보내고 ajax를 먼저 console에 찍음...?
})
