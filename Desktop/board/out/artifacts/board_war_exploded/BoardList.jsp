<%@ page import="model.BoardDAO" %>
<%@ page import="java.util.Vector" %>
<%@ page import="model.BoardBean" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2020-10-01
  Time: 오후 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    //전체 게시글의 내용을 jsp쪽으로 가져와야 함
    BoardDAO bdao = new BoardDAO();

    //전체 게시글을 리턴 받아주는 소스

    Vector<BoardBean> vec = bdao.getAllBoard();

%>
<center>
    <h2>전체 게시글 보기</h2>
    <table width="700" border="1" bgcolor="#87ceeb">
        <tr height="40">
            <td align="right" colspan="5">
                <input type="button" value="글쓰기" onclick="location.href='BoardWriteForm.jsp'"></td>
        </tr>
        <tr height="40">
        <td width="50" align="center">번호</td>
            <td width="320" align="center">제목</td>
            <td width="100" align="center">작성자</td>
            <td width="150" align="center">작성일</td>
            <td width="80" align="center">조회수</td>
        </tr>
        <%
            for(int i=0; i<vec.size(); i++){
                BoardBean bean = vec.get(i);//벡터에 저장되어 있는 빈클래스를 하나씩 추출
        %>
            <tr height="40">
                <td width="50" align="center"><%=i+1%></td>
                <td width="320" align="left"><a href="BoardInfo.jsp?num=<%=bean.getNum()%>">
                    <a href="BoardInfo.jsp?num=<%=bean.getNum()%>" style="text-decoration:none"></a>
                    <%
                        if(bean.getRe_step() > 1) {
                            for(int j=0; j < (bean.getRe_step()-1)*5; j++){
                                %>&nbsp;
                            <%}
                        }
                    %>

                    <%=bean.getSubject()%></a></td>
                <td width="100" align="center"><%=bean.getWriter()%></td>
                <td width="150" align="center"><%=bean.getReg_date()%></td>
                <td width="80" align="center"><%=bean.getReadcount()%></td>
        </tr>
        <%}%>

    </table>
</center>
</body>
</html>
