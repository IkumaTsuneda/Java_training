<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="java.util.List,model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧表示</title>
</head>
<body>
  <%@ include file="header.jsp"%>
  <h2>ユーザ一覧</h2>
  <%
    List<UserBean> ubList
      = (List<UserBean>) request.getAttribute("ubList");
  %>
  <table>
    <tr>
      <th>ユーザID</th>
      <th>氏名</th>
      <th>年齢</th>
    </tr>
    <%
      for (UserBean ub : ubList) {
    %>
    <tr>
      <td><%=ub.getId()%></td>
      <td><%=ub.getName()%></td>
      <td><%=ub.getAge()%></td>
    </tr>
    <%
      }
    %>
  </table>
  
    <a href="menu.jsp">メニューに戻る</a>

  <%@ include file="footer.jsp"%>

</body>
</html>