let httpRequest = null;
function startMethod(){
	httpRequest = new XMLHttpRequest();
	
	httpRequest.onreadystatechange = resultProcess;
	
	httpRequest.open("GET", "ajaxExam02.xml", true);
	httpRequest.send(null);
}
function resultProcess(){
	if(httpRequest.readyState == 4){
		if(httpRequest.status == 200){
			let xmlDoc = httpRequest.responseXML;
			
			var subjectList = xmlDoc.getElementsByTagName("subject");
			let message = "과목 수 : " + subjectList.length +"<br>";
			for(i = 0; i < subjectList.length; i++){
				let subject = subjectList[i].childNodes;
				
				console.log("과목 수 : " + subject.length);
				for(j = 0; j < subject.length; j++){
					if(subject[j].firstChild != null){
						if( j == 1) message += "|";
						message += subject[j].firstChild.nodeValue;
					}
				} // for j
				
				message += "|<br>";
			}// for i
			
			document.getElementById("resultDisplay").innerHTML = message;
		}
	}
}