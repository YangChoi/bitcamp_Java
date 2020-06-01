function checkForm(){
	if(document.getElementById("subject").value == ""){
		alert("제목을 입력하세요.");
		document.guestbookWriteForm.subject.focus();
	}else if(document.getElementById("content").value == ""){
		alert("내용을 입력하세요");
		document.guestbookWriteForm.content.focus();
	}else {
		document.guestbookWriteForm.submit();
		// html에 name 속성이 있어야 submit이 데이터를 가지고 간다. 
		// submit은 name 속성이 있는 애들만 가지고 간다. 
	}
	

}