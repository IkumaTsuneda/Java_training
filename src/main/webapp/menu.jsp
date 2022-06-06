<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="login-failure.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>
<%@ include file = "header.jsp"%>
<h2>メニュー</h2>
  <form action="user-list-servlet" method="POST">
    <input type="submit" value="一覧表示">
  </form>
  <%@ include file = "footer.jsp"%>
</body>
</html>