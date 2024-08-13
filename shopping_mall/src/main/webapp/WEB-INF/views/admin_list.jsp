<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 등록 페이지</title>
<link rel="stylesheet" type="text/css" href="./css/basic.css">
<link rel="stylesheet" type="text/css" href="./css/login.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/main.css?v=1">
<link rel="icon" href="./img/logo.png" sizes="128x128">
<link rel="icon" href="./img/logo.png" sizes="64x64">
<link rel="icon" href="./img/logo.png" sizes="32x32">
<link rel="icon" href="./img/logo.png" sizes="16x16">
<script src="./js/jquery.js"></script>
</head>
<body>
	<form>
		<header class="headercss">
			<div class="header_div">
				<p>
					<img src="./img/logo.png" class="logo_sm"> ADMINISTRATOR
				</p>
				<p>
					홍길동 관리자 <a href="#">[개인정보 수정]</a> <a href="#">[로그아웃]</a>
				</p>
			</div>
		</header>
		<nav class="navcss">
			<div class="nav_div">
				<ol>
					<li title="쇼핑몰 상품관리">쇼핑몰 관리자 리스트</li>
					<li title="쇼핑몰 회원관리">쇼핑몰 회원관리</li>
					<li title="쇼핑몰 상품관리">쇼핑몰 상품관리</li>
					<li title="쇼핑몰 기본설정">쇼핑몰 기본설정</li>
					<li title="쇼핑몰 기본설정">쇼핑몰 공지사항</li>
				</ol>
			</div>

		</nav>
		<main class="maincss">
			<section>
				<p>신규등록 관리자</p>
				<ol class="new_admin_title2">
					<li>NO</li>
					<li>관리자명</li>
					<li>아이디</li>
					<li>전화번호</li>
					<li>이메일</li>
					<li>담당부서</li>
					<li>담당직책</li>
					<li>가입일자</li>
					<li>승인여부</li>
				</ol>
				<ol class="new_admin_none">
					<li>신규 등록된 관리자가 없습니다.</li>
				</ol> 
				<cr:forEach var="listdata" items="${list}">
				<ol class="new_admin_lists2">
					<li>${listdata.midx}</li>
					<li>${listdata.mname}</li>
					<li>${listdata.mid}</li>
					<li>${listdata.mhp}</li>
					<li>${listdata.memail}</li>
					<li>${listdata.mteam}</li>
					<li>${listdata.mposition}</li>
					<li>${listdata.mdate}</li>
					<input type="button" value="승인" class="new_addbtn1" title="승인" id="btn1"> 
					<input type="button" value="미승인" class="new_addbtn2" title="미승인"></li>
				</ol>
				</cr:forEach>
			</section>
			<section></section>
			<section></section>
		</main>
		<footer class="main_copyright">
			<div>Copyright ⓒ 2024 shopbag All rights reserved.</div>
		</footer>
	</form>
</body>
<script>
	
</script>
</html>