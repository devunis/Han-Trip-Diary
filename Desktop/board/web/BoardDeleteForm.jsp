<%@ page import="model.BoardDAO" %>
<%@ page import="model.BoardBean" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2020-10-02
  Time: 오후 8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    BoardDAO bdao = new BoardDAO();

    int num = Integer.parseInt(request.getParameter("num"));
    //하나의 게시글을 리턴
    BoardBean bean = bdao.getOneUpdateBoard(request.getParameter("num"));
%>
<center>
    <h2>게시글 삭제</h2>
    <form action = "BoardDeleteProc.jsp" method="post">
        <table width="600" border="1" bgcolor="#87ceeb">
            <tr height="40">
                <td width="120" align="center">작성자</td>
                <td width="180" align="center"><%=bean.getWriter()%></td>
                <td width="120" align="center">작성일</td>
                <td width="180" align="center"><%=bean.getReg_date()%></td>
            </tr>
            <tr heihgt="40">
                <td width="120" align="center">제목</td>
                <td align="center" colspan="3"><%=bean.getSubject()%></td>
            </tr>
            <tr height="40">
                <td width="120" align="center">패스워드</td>
                <td align="left" colspan="3"><input type="password" name="password" size="60"></td>
            </tr>
            <tr height="40">
                <td align="center" colspan="4">
                    <input type="hidden" name="num" value="<%=num%>">
                    <input type="submit" value="글삭제">&nbsp; &nbsp;
                    <input type="button" onclick="location.href='BoardList.jsp'" value="목록보기">
                </td>
            </tr>
        </table>
    </form>
</center>

</body>
</html>
