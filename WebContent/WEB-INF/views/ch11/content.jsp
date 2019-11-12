<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/js/paho-mqtt-min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css">
		<script type="text/javascript" src="<%=application.getContextPath()%>/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			// MQTT Broker와 연결하기
			client = new Paho.MQTT.Client(location.hostname, 61614, "clientId"+new Date().getTime());
			// Message를  수신했을 때 자동으로 실행(콜백) 되는 함수
			client.onMessageArrived = function(message) {
				$("#divReceive").append(message.payloadString + "<br/>");
			}
			
			client.connect({onSuccess:onConnect});
			
			// 연결이 완료되었을 때 자동으로 실행(콜백) 되는 함수
			function onConnect() {
			  client.subscribe("/test/pub");
			}
			
			function sendM(){
				var message = new Paho.MQTT.Message($("#sendMessage").val());
				message.destinationName = "/drone/sub";
				client.send(message);
			}
		</script>
	</head>
	<body>
		<h5>수신된 메시지</h5>
		<div id="divSend">
		<input id="sendMessage" type="text"/>
		<button onclick="sendM()">버튼</button>
		</div>
		<div id="divReceive"></div>
	</body>
</html>