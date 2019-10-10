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
		<p>
			<a href="join?mid=HI1&mname=홍길동&mpassword=1234567890&mage=25&mbirth=1995-12-25" class="btn btn-dark">get test</a><br/>
			<a href="join2?mid=HI2&mname=홍길동&mpassword=1234567890&mage=25&mbirth=1995-12-25" class="btn btn-dark">get test</a><br/>
		</p>
		<p>
			<form id="joinForm" name="joinForm" method="post" action="join2">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">아이디</span>
					</div>
			  		<input id="mid" name="mid" type="text" value="Hi1" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">이름</span>
					</div>
			  		<input id="mname" name="mname" type="text" value="홍길동" class="form-control" placeholder="Name" aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">비밀번호</span>
					</div>
			  		<input id="mpassword" name="mpassword" type="password" value="1234567890" class="form-control" placeholder="Password" aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">나이</span>
					</div>
			  		<input id="mage" name="mage" type="number" value="25 class="form-control" placeholder="Age" aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">생년월일</span>
					</div>
			  		<input id="mbirth" name="mbirth" type="date" value="1995-12-25" class="form-control" placeholder="Birthday" aria-label="Username" aria-describedby="basic-addon1">
				</div>
				
				<input type="submit" value="회원가입" class="btn btn-dark"/>
			</form>
		</p>
		
		<p>
			<script type="text/javascript">
				function join(){
					//how1
					/*var mid= $("#mid").val();
					if(mid=="") return;
					var mname= $("#mname").val();
					if(mname=="") return;
					var mpassword= $("#mpassword").val();
					if(mpassword=="") return;
					var mage= $("#mage").val();
					if(mage=="") return;
					var mbirth= $("#mbirth").val();
					if(mbirth=="") return;
					var params="";
					params += "mid="+mid+"&";
					params += "mname="+mname+"&";
					params += "mpassword="+mpassword+"&";
					params += "mage="+mage+"&";
					params += "mbirth="+mbirth;
					location.href = "join2?"+params;*/
					
					//how2
					//var joinForm = document.querySelector("#joinForm");
					//joinForm.submit();
					
					//how3
					document.joinForm.submit();
				}
			</script>
			<button onclick="join()" class="btn btn-dark">JavaScript를 이용해서 Data 전달</button>
		</p>
		
		<p>
			<script type="text/javascript">
				function joinAjax() {
					$.ajax({
						url: "join3",
						//data: "mid=fall&mname=홍길동",
						data: {mid: "fall", mname: "홍길동"},
						method: "post",
						success: function(data) {
							var html = "<span>mid: "+data.mid+"</span> <br/>";
							html += "<span>mname: "+data.mname+"</span>";
							$("#resultDiv").html(html);
						}
					});
				}
			</script>
			<button onclick="joinAjax()" class="btn btn-dark">Ajax를 이용해서 Data 전달</button>
			<div id="resultDiv">
			</div>
		</p>
	</body>
</html>