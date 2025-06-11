<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    com.koreait.mvc1.data.MemberDTO loginUser = (com.koreait.mvc1.data.MemberDTO) session.getAttribute("user");
    if(loginUser == null){
        response.sendRedirect("login.jsp");
        return;
    }
%>

<html>
<head><title>회원탈퇴</title></head>
<body>
<h2>회원탈퇴</h2>
<p>정말 탈퇴하시겠습니까?</p>
<form method="post" action="result.jsp">
    <input type="hidden" name="action" value="leave" />
    <input type="hidden" name="userid" value="<%= loginUser.getUserid() %>" />
    <input type="submit" value="회원탈퇴" />
</form>
<p><a href="info.jsp">돌아가기</a></p>
</body>
</html>
