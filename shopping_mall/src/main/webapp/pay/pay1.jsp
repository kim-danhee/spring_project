<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	Random rd = new Random();
	String pgcode = "";
	int a = 0;
	while(a <6){
		pgcode += rd.nextInt(9);
		a++;
	}
	request.setAttribute("pgcode", pgcode);
%>
<title>Pay - 상품정보 및 갯수에 맞는 금액 설정</title>
</head>
<body>
<form id="frm" method="post" action="./pay2.do" enctype="application/x-www-form-urlencoded">
상품코드 (숫자 난수 6자리) : <input type="text" name="product_code" readonly="readonly" value="<%=pgcode%>"><br>
상품명 : <input type="text" name="product_name" readonly="readonly" value="중앙 컴퓨터"><br>
상품금액 : <input type="text" name="product_money" readonly="readonly" value="10000"><br>
상품수량 : <select name="product_ea" onchange="select_ea(this.value)">
<option value="1">1 EA</option>
<option value="2">2 EA</option>
<option value="3">3 EA</option>
</select><br>
총 결제금액 : <input type="text" name="price" readonly="readonly" value="10000"><br>
<input type="button" value="상품구매확정" onclick="basket()">
</form>
</body>
<script>
function select_ea(z){
	var m = frm.product_money.value;
	var sum = m * z;
	frm.price.value = sum;
}
function basket(){
	frm.submit();
}
</script>
</html>