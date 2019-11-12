<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/js/jquery-3.4.1.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			var ws = null;
			
			$(function() {
				ws = new WebSocket("ws://"+location.host+"<%=application.getContextPath()%>/websocket/temperature");
				ws.onopen = onConnect;
				ws.onmessage = onMessage;
				ws.onclose = onDisconnect;
			});
			
			function onConnect() {
				console.log("WebSocket 연결성공");
			}
			
			function onMessage(event) {
				var message = event.data;
				$("#receiveDiv").append(message+"<br/>");
			}
			
			function onDisconnect() {
				console.log("WebSocket 연결끊김");
			}
		</script>
	</head>
	<body>
		<h5>Web Socket 메시지 수신</h5>
		<div id="receiveDiv"></div>
	</body>
</html>