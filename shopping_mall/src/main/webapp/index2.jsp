<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="frm" method="post" action="./loginok.do">
아이디 : <input type="text" name="mid">
<input type="button" value="전송" onclick="click()">
</form>
</body>
<script>
function click(){
	frm.submit();
}
</script>
</html>