<%@ page import="model.BoardDAO" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2020-10-01
  Time: 오후 8:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    request.setCharacterEncodig("euc-kr");
%>
<!--데이터를 한번에 받아오는 빈클래스를 사용하도록-->
<jsp:useBean id="boardbean" class="model.BoardBean">
    <jsp:setProperty name="boardbean" property="*"/>
</jsp:useBean>

<%
    //데이터베이스 객체 생성
    BoardDAO bdao = new BoardDAO();
    bdao.rewriteBoard(boardbean);

    //답변 데이터를 모두 저장 후 전체 게시글 보기를 설정
    response.sendRedirect("BoardList.jsp");
%>

</body>
</html>
