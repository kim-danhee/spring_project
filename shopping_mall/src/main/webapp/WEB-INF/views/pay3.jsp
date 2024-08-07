<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.inicis.std.util.SignatureUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String data1 = (String)request.getAttribute("goodcode");
String data2 = (String)request.getAttribute("price");

String mid = "INIpayTest";
String signKey = "SU5JTElURV9UUklQTEVERVNfS0VZU1RS";
String goodcode = data1; 
String mKey = SignatureUtil.hash(signKey, "SHA-256");
String timestamp = SignatureUtil.getTimestamp();
String orderNumber = mid+"_"+goodcode;	
String price = data2;

Map<String, String> signParam = new HashMap<String, String>();
signParam.put("oid", orderNumber);
signParam.put("price", price);
signParam.put("timestamp", timestamp);
/*
out.print(goodcode + " "+price);
out.print(orderNumber);
out.print(timestamp);
*/

String signature = SignatureUtil.makeSignature(signParam);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 및 결제 최종 정보 확정, 결제 API 연동</title>
</head>
<script src="https://stgstdpay.inicis.com/stdjs/INIStdPay.js"></script>
<body>
<form id="frm">
<input type="hidden" name="version" value="1.0"><!-- api 버전 -->
<!-- 결제방식 -->
<input type="hidden" name="gopaymethod" value="<%=request.getAttribute("gopaymethod")%>">
<!-- PG가입 아이디 -->
<input type="hidden" name="mid" value="<%=mid%>">
<!-- PG아이디 및 상품코드번호 -->
<input type="hidden" name="oid" value="<%=orderNumber%>">
<!-- 최종 결제 금액 -->
<input type="hidden" name="price" value="<%=price%>">
<!-- 결제를 진행하는 시간 -->
<input type="hidden" name="timestamp" value="<%=timestamp%>">
<!-- 결제 사항에 대한 정보를 SHA-256으로 암호화된 코드 -->
<input type="hidden" name="signature" value="<%=signature%>">
<!-- 결제 비밀번호 key -->
<input type="hidden" name="mKey" value="<%=mKey%>">
<!-- 결제금액 단위 -->
<input type="hidden" name="currency" value="WON">
<!-- 결제자명 -->
<input type="hidden" name="buyername" value="<%=request.getAttribute("buyername")%>">
<!-- 결제자 연락처 -->
<input type="hidden" name="buyertel" value="<%=request.getAttribute("buyertel")%>">
<!-- 결제자 이메일 -->
<input type="hidden" name="buyeremail" value="<%=request.getAttribute("buyeremail")%>">
<!-- 상품명 -->
<input type="hidden" name="goodname" value="<%=request.getAttribute("goodname")%>">
<!-- 결제자 주소 -->
<input type="hidden" name="rec_post" value="<%=request.getAttribute("rec_post")%>">
<input type="hidden" name="rec_way" value="<%=request.getAttribute("rec_way")%>">
<input type="hidden" name="rec_addr" value="<%=request.getAttribute("rec_addr")%>">
<!-- 결제성공 및 결제실패에 대한 결과값 return 정보 -->
<input type="hidden" name="returnUrl" value="http://localhost:8080/pay/return_url.jsp">
<!-- 결제 취소 시 사용되는 페이지 -->
<input type="hidden" name="closeUrl" value="http://localhost:8080/pay/close.jsp">
<p>----------------------- 상품 정보 -----------------------</p>
상품코드 : <%=request.getAttribute("goodcode")%><br>
상품명 : <%=request.getAttribute("goodname")%><br>
상품수량 : <%=request.getAttribute("goodea")%><br>
<p>----------------------- 결제자 정보 ----------------------</p>
결제자명 : <%=request.getAttribute("buyername")%><br>
연락처 : <%=request.getAttribute("buyertel")%><br>
이메일 : <%=request.getAttribute("buyeremail")%><br>
<p>----------------------- 배송 정보 ------------------------</p>
우편번호 : <%=request.getAttribute("rec_post")%><br>
도로명주소 : <%=request.getAttribute("rec_way")%><br>
상세주소 : <%=request.getAttribute("rec_addr")%><br>
<p>----------------- 결제금액 및 결제수단 ------------------</p>
최종 결제금액 : <%=request.getAttribute("price")%><br>
결제 수단 : <%=request.getAttribute("gopaymethod")%><br><br>
<input type="button" value="결제하기" onclick="payok()">
</form>
</body>
<script>
function payok(){
	INIStdPay.pay("frm");
}
</script>
</html>