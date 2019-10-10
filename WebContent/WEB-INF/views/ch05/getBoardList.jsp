<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*, com.mycompany.web.dto.*" %>

<%
List<Ch05Board> boardList = (List<Ch05Board>)request.getAttribute("boardList");
%>


<table class="table table-sm">
  <thead>
    <tr>
      <th scope="col">No</th>
      <th scope="col">Title</th>
      <th scope="col">Writer</th>
      <th scope="col">Date</th>
      <th scope="col">Hitcounter</th>
    </tr>
  </thead>
  <tbody>
<%for(Ch05Board board:boardList){%>
	<tr>
      <th scope="row"><%=board.getBno()%></th>
      <td><%=board.getBtitle()%></td>
      <td><%=board.getWriter()%></td>
      <td><%=board.getDate()%></td>
      <td><%=board.getHitcount()%></td>
    </tr>
<%}%>
  </tbody>
</table>