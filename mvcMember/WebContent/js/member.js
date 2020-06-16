function checkWriteForm() {
	if (document.writeForm.name.value == "") {
		alert("이름을 입력하세요");
		document.writeForm.name.focus();
	} else if (document.writeForm.id.value == "") {
		alert("아이디를 입력하세요");
	} else if (document.writeForm.pwd.value == "") {
		alert("비밀번호를 입력하세요.");
	} else if (document.writeForm.pwd.value != document.writeForm.repwd.value) {
		alert("비밀번호가 일치하지 않습니다");
	}else if(document.writeForm.id.value != document.writeForm.id.idDuplicationCheck.value){
		alert("아이디 중복체크를 해주세요. ");
		
	}else {
		document.writeForm.submit();
	}
}

// 로그인시 
function checkLoginForm(){
	if(document.loginForm.id.value ==""){
		alert("아이디를 입력하세요");
	}else if(document.loginForm.pwd.value == ""){
		alert("비밀번호를 입력하세요");
	}else {
		document.loginForm.submit();
	}
}

// 회원정보 수정시 
function checkModifyForm() {
	if (document.modifyForm.name.value == "") {
		alert("이름을 입력하세요");
		document.modifyForm.name.focus();
	} else if (document.modifyForm.pwd.value == "") {
		alert("비밀번호를 입력하세요.");
	} else if (document.modifyForm.pwd.value != document.modifyForm.repwd.value) {
		alert("비밀번호가 일치하지 않습니다");
	}else {
		document.modifyForm.submit();
	}
}
function checkId(){
	// var보다는 지역변수 let을 더 추천
	let id = document.writeForm.id.value;
	if(id == ""){
		alert("아이디를 먼저 입력해주세요");
	}else {
		window.open("checkId.jsp?id="+id , "", "width=300 heigth=100 location=yes");
	}
}

function checkIdClose(id){
	// document는 현재의 창을 말하는 것 
	// opener를 하면 원래 열려있던 창 
	opener.writeForm.id.value= id;
	// 중복확인 버튼 눌렀는지 안눌렀는지 확인 
	opener.writeForm.idDuplicationCheck.value=id; 
	window.close(); // 창 닫고
	opener.writeForm.pwd.focus(); // 포커스 맞추기 
}

function checkPost(){
	window.open("checkPost.jsp","","width=500 height=500 scrollbars=yes");
}

// 여러개의 form을 관리해주는 객체 forms
function checkPostClose(zipcode, address){	
	/*
	opener.document.forms[0].zipcode.value = zipcode;
	opener.document.forms[0].addr1.value = address;
	window.close();
	opener.document.forms[0].addr2.focus(); // 상세주소에 포커스 
	*/
	// 그러나 아래의 코드가 더 자주 쓰인다. 
	opener.document.getElementById("zipcode").value = zipcode;
	opener.document.getElementById("addr1").value = address;
	window.close();
	opener.document.getElementById("addr2").focus(); // 상세주소에 포커스 
	
}




























