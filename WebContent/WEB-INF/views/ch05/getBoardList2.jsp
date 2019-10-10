<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*, com.mycompany.web.dto.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h5>게시물 리스트(전체 게시물 수:${totalNo})</h5>
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
  	<c:forEach items="${boardList}" var="board">
		<tr>
	      <th scope="row">${board.bno}</th>
	      <td>${board.btitle}</td>
	      <td>${board.writer}</td>
	      <td><fmt:formatDate value="${board.date}" pattern="yyyy-MM-dd"/></td>
	      <td>${board.hitcount}</td>
	    </tr>
    </c:forEach>
  </tbody>
</table>