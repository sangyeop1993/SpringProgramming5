<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/js/jquery-3.4.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
	</head>
	<body>
		<form method="post" action="fileUpload" enctype="multipart/form-data">
			<%-- 문자 파트 --%>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Title</span>
				</div>
				<input name="title" type="text" class="form-control" placeholder="Description of Attached File">
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon2">Description</span>
				</div>
				<input name="description" type="text" class="form-control" placeholder="Description of Attached File">
			</div>
			
			<%-- 파일파트 --%>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroupFileAddon01">Attach1</span>
				</div>
				<div class="custom-file">
				    <input name="attach1" type="file" class="custom-file-input" id="inputGroupFile01">
					<label class="custom-file-label" for="inputGroupFile01">Choose file</label>
				</div>
			</div>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroupFileAddon02">Attach2</span>
				</div>
				<div class="custom-file">
				    <input name="attach2" type="file" class="custom-file-input" id="inputGroupFile02">
					<label class="custom-file-label" for="inputGroupFile01">Choose file</label>
				</div>
			</div>
			<input type="submit" value="File Upload" class="btn btn-danger"/>
		</form>
	</body>
</html>