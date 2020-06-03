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
	}else if(document.writeForm.id.value != ""){
		alert("아이디 중복체크를 해주세요. ");
		document.writeForm.id.focus();
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
	opener.writeForm.id.value = id;
	window.close(); // 창 닫고
	opener.writeForm.pwd.focus(); // 포커스 맞추기 
}

function checkPost(){
	window.open("checkPost.jsp","","width=500 height=500");
}