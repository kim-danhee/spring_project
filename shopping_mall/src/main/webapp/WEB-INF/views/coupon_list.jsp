<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="cp" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 페이징 사용법</title>
</head>
<body>
	<p>쿠폰리스트</p>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>쿠폰명</th>
				<th>할인률</th>
				<th>사용 유/무</th>
				<th>만료기한</th>
			</tr>
		</thead>
		<tbody> 
			<tr>
				<td>${stringList[0]}</td>
				<td>${stringList[1]}</td>
				<td>${stringList[2]}</td>
				<td>${stringList[3]}</td>
				<td>${stringList[4]}</td>
			</tr>

		</tbody>
	</table>
</body>
</html>