<%@ page contentType="text/html; charset=UTF-8"%>

<h5>Member info.</h5>
<table class="table table-sm">
  <thead>
    <tr>
      	<th scope="col">ID</th>
      	<th scope="col">Name</th>
      	<th scope="col">Password</th>
    </tr>
  </thead>
  <tbody>
	<tr>
		<td>${member.mid}</td>
		<td>${member.mname}</td>
		<td>${member.mpassword}</td>
	</tr>
  </tbody>
</table>