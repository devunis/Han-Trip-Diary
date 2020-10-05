<%@ page import="model.BoardDAO" %><%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2020-10-02
  Time: 오후 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    String pass= request.getParameter("password");
    int num = Integer.parseInt(request.getParameter("num"));

    //데이터 베이스 연결
    BoardDAO bdao = new BoardDAO();
    String password = bdao.getPass(num);

    //기존 패스워드 값과 delete form에서 작성한 패스워드를 비교
    if(pass.equals(password)){
        //패스워드가 둘다 같다면
        bdao.deleteBoard(num);
        response.sendRedirect("BoardList.jsp");
    }else{
        %>
        <script>
                alert("패스워드가 틀려서 삭제할수 없습니다. 패스워드를 확인해 주세요.");
                history.go(-1);
        </script>
    }
%>

</body>
</html>
