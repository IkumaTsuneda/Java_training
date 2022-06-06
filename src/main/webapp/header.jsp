<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%HttpSession session2 = request.getSession();
String id = (String)session2.getAttribute("id"); %>

ログインユーザ:<%=id %>

</body>
</html>