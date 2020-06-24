function checkWriteForm() {
	//if(document.getElementById("name").value == "") { // 이거는 id속성으로 해서 찾는것
	if (document.writeForm.name.value == "") { // name 속성으로 찾는 법
		alert("이름을 입력하세요");
		document.writeForm.name.focus();
	} else if (document.writeForm.id.value == "") {
		alert("아이디를 입력하세요");
	} else if (document.writeForm.pwd.value == "") {
		alert("비밀번호를 입력하세요.");
	} else if (document.writeForm.pwd.value != document.writeForm.repwd.value) {
		alert("비밀번호가 일치하지 않습니다");
	}else if(document.writeForm.check.value != document.writeForm.id.value){
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
		document.writeForm.id.focus();		
	}else {
		window.open("/miniProject/member/checkId.do?id="+id , "", "width=300 heigth=100 location=yes");
	}
}

function checkIdClose(id){
	// document는 현재의 창을 말하는 것 
	// opener를 하면 원래 열려있던 창 
	opener.document.writeForm.check.value= id;
	// 중복확인 버튼 눌렀는지 안눌렀는지 확인 
	opener.document.writeForm.id.value=id; 
	window.close(); // 창 닫고
	opener.writeForm.pwd.focus(); // 포커스 맞추기 
}

function checkPost(){
	window.open("checkPost.do","","width=700 height=500 scrollbars=yes");
}

function overlapCheck(){
	 document.writeForm.checkValue = false;
}

// 여러개의 form을 관리해주는 객체 forms
function checkPostClose(zipcode, address){	
 
	opener.document.getElementById("zipcode").value = zipcode;
	opener.document.getElementById("addr1").value = address;
	window.close();
	opener.document.getElementById("addr2").value = "";
	opener.document.getElementById("addr2").focus(); // 상세주소에 포커스 
	
}




























