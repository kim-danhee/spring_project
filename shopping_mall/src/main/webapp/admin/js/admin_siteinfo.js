function save(e){ 
	frm.semail.value =e;
	
	if(frm.sptitle.value == ""){
		alert('홈페이지 제목은 필수 입력값입니다.');
	}
	else if(frm.semail.value == ""){
		alert('관리자 메일은 필수 입력값입니다.');
	}
	else if(frm.sjoinpoint.value == ""){
		alert('적립금 설정은 필수 입력값입니다.');
	}
	else if(frm.slevel.value == ""){
		alert('권한레벨은 필수 입력값입니다.');
	}
	else if(frm.scompany.value == ""){
		alert('회사명은 필수 입력값입니다.');
	}
	else if(frm.sbnumber.value == ""){
		alert('사업자등록번호는 필수 입력값입니다.');
	}
	else if(frm.sbossname.value == ""){
		alert('대표자명은 필수 입력값입니다.');
	}
	else if(frm.sbosstel.value == ""){
		alert('대표전화번호는 필수 입력값입니다.');
	}
	else if(frm.spostnum.value == ""){
		alert('사업자 우편번호는 필수 입력값입니다.');
	}
	else if(frm.saddr.value == ""){
		alert('사업장 주소는 필수 입력값입니다.');
	}
	else if(frm.sinfoname.value == ""){
		alert('정보관리 책임자명은 필수 입력값입니다.');
	}
	else if(frm.sinfoemail.value == ""){
		alert('정보책임자 이메일은 필수 입력값입니다.');
	}
	else if(frm.sbank.value != "" && frm.sbanknum.value == ""){
		alert('무통장 은행의 계좌번호를 입력해주세요.');
	}
	else if(frm.smin.value > frm.smax.value){
		alert('최소값과 최대값을 확인해주세요.');
	}
	else if(frm.sdelivery.value == ""){
		alert('배송업체명은 필수 입력값입니다.');
	}
	else if(frm.sdelprice.value == ""){
		alert('배송비는 필수 입력값입니다.');
	}
	else{
	frm.method="get"
	frm.action="./admin_sitecheck.do";
	frm.submit();
	}	
}