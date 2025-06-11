
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.koreait.mvc1.data.MemberDTO, com.koreait.mvc1.data.MemberDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  request.setCharacterEncoding("UTF-8");
  // 이 값이 없으면 로그인 못하게 하면 보안적으로도 좋다.
  String action = request.getParameter("action");
  request.setAttribute("action",action);

  MemberDTO dto = new MemberDTO();
  MemberDAO dao = new MemberDAO();


%>

<html>
<head>
    <title>result</title>
</head>
<body>
<c:choose>
  <c:when test="${action eq 'join'}">
    <%
      // 노가다?? useBeans 액션태그가 있긴한데, 잃는것도 있다..
      dto.setUserid(request.getParameter("userid"));
      dto.setUserpw(request.getParameter("userpw"));
      dto.setName(request.getParameter("name"));
      dto.setHp(request.getParameter("hp"));
      dto.setEmail(request.getParameter("email"));
      dto.setGender(request.getParameter("gender"));
      dto.setSsn1(request.getParameter("ssn1"));
      dto.setSsn2(request.getParameter("ssn2"));
      dto.setZipcode(request.getParameter("zipcode"));
      dto.setAddress1(request.getParameter("address1"));
      dto.setAddress2(request.getParameter("address2"));
      dto.setAddress3(request.getParameter("address3"));
      boolean success = dao.insertMember(dto);
      request.setAttribute("success",success);

    %>
    <c:choose>
      <c:when test="${success}">
        <h2>회원가입 성공</h2>
        <p><a href="login.jsp">로그인</a></p>
      </c:when>
      <c:otherwise>
        <h2>회원가입 실패</h2>
        <p><a href="join.jsp">회원가입</a></p>
      </c:otherwise>
    </c:choose>
  </c:when>
  <c:when test="${action eq 'login'}">
    <%
      String userid = request.getParameter("userid");
      String userpw = request.getParameter("userpw");
      MemberDTO loginUser = dao.login(userid, userpw);
      if(loginUser != null){
        session.setAttribute("user",loginUser);
        request.setAttribute("loginUser",loginUser);
      }
    %>
    <c:choose>
      <c:when test="${not empty loginUser}">
        <h2>${loginUser.userid}(${loginUser.name})님, 로그인 성공! 😁</h2>
        <p>[<a href="logout.jsp">로그아웃</a>] | [<a href="info.jsp">정보수정</a>] | [<a href="leave.jsp">회원탈퇴</a>]</p>
      </c:when>
      <c:otherwise>
        <h2>로그인 실패! 😅</h2>
        <p>아이디 또는 비밀번호 또는 코드가 올바르지 않습니다.</p>
        <p><a href="login.jsp">로그인</a></p>
      </c:otherwise>
    </c:choose>
  </c:when>

  <c:otherwise>
    <h2>잘못된 요청입니다. 🏴‍☠️</h2>
  </c:otherwise>
</c:choose>
</body>
</html>
