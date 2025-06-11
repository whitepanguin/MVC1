
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.koreait.mvc1.data.MemberDTO, com.koreait.mvc1.data.MemberDAO" %>
<%
    MemberDTO user = (MemberDTO) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    MemberDAO dao = new MemberDAO();
    MemberDTO member = dao.getMember(user.getUserid());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>회원수정</h2>
<form method="post" action="result.jsp">
    <%-- join에서 왔어라는 걸 알려주기 위해서 hidden으로 구분해준다 --%>
        <input type="hidden" name="action" value="modify">
        <p>아이디: <input type="text" name="userid" value="<%=member.getUserid()%>" readonly></p>
        <p>비밀번호: <input type="password" name="userpw" value="<%=member.getUserpw()%>"></p>
        <p>이름: <input type="text" name="name" value="<%=member.getName()%>"></p>
        <p>휴대폰: <input type="text" name="hp" value="<%=member.getHp()%>"></p>
        <p>이메일: <input type="text" name="email" value="<%=member.getEmail()%>"></p>
        <p>성별:
            <select name="gender">
                <option value="남자" <%= "남자".equals(member.getGender()) ? "selected" : "" %>>남자</option>
                <option value="여자" <%= "여자".equals(member.getGender()) ? "selected" : "" %>>여자</option>
            </select>
        </p>
        <p>주민등록번호: <input type="text" name="ssn1" value="<%=member.getSsn1()%>"> -
            <input type="password" name="ssn2" value="<%=member.getSsn2()%>"></p>
        <p>우편번호: <input type="text" name="zipcode" value="<%=member.getZipcode()%>"></p>
        <p>주소: <input type="text" name="address1" value="<%=member.getAddress1()%>"></p>
        <p>상세주소: <input type="text" name="address2" value="<%=member.getAddress2()%>"></p>
        <p>참고항목: <input type="text" name="address3" value="<%=member.getAddress3()%>"></p>
        <p><input type="submit" value="정보 수정"></p>

</body>
</html>
