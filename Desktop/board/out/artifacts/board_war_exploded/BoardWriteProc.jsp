<%@ page import="model.BoardDAO" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2020-10-01
  Time: 오후 1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    request.setCharacterEncoding("euc-kr");//한글처리
%>
<!--게시글 작성한 데이터를 한번에 읽어드림-->
<jsp:useBean id="boardbean" class="model.BoardBean">
    <jsp:setProperty name="boardbean" property="*"/>
</jsp:useBean>
<%
    //데이터 베이스 쪽으로 빈클래스를 넘겨줌
    BoardDAO bdao = new BoardDAO();
    //데이터 저장 메소드를 호출
    bdao.insertBoard(boardbean);

    //게시글 저장후 전체 게시글 보기
    response.sendRedirect("BoardList.jsp");



%>
</body>
</html>
