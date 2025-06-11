
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<h2>로그인</h2>
<form method="post" action="result.jsp">
  <input type="hidden" name="action" value="login">
  <p>아이디: <input type="text" name="userid"></p>
  <p>비밀번호: <input type="password" name="userpw"></p>
  <p><button type="submit">로그인</button></p>
</form>
</body>
</html>
