function add(){
	if(frm.mid.value ==""){
		alert("아이디를 입력하세요.");
	}
	else if(frm.mpw.value == ""){
		alert("비밀번호를 입력해주세요.");
	}
	else if(frm.mpw.value != frm.mpw_ck.value){
		alert("비밀번호가 일치하지 않습니다.");
	}
	else if(frm.mname.value == ""){
		alert("담장자 이름을 입력해주세요.");
	}
	else if(frm.memail.value == ""){
		alert("담당자 이메일을 입력해주세요.");
	}
	else{
		frm.method="post";
		frm.action="./add_masterok.do";
		frm.submit();
	}
	
	
};
