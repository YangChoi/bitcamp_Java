let httpRequest = null;
function startMethod(){
	httpRequest = new XMLHttpRequest();
	// 응답 메서드
	httpRequest.onreadystatechange = resultProcess;
	// xml 을 요청한다. 
	httpRequest.open("GET", "ajaxExam01.xml", true);
	httpRequest.send(null); // send 안은 써도 그만 안써도 그만 
}

// 응답 메서드
function resultProcess(){
	if(httpRequest.readyState == 4){
		if(httpRequest.status == 200){
			//document.getElementById("displayArea").innerText = httpRequest.responseText;
			document.getElementById("displayArea").innerHTML = httpRequest.responseText;
			// innerText면 코드 자체가 뜨게 되고 innerHTML이면 태그 자체를 읽어낸다. 
			
			//document.getElementById("displayArea").style.display = 'visible';
			document.getElementById("displayArea").style.display = 'block';
		}
	}
}