<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			
			body, html {
				height: 100%;
				margin: 0px;
				background-color: #999999;
			}
			
			#wrapper {
				width: 100%;
				height: 100%;
				display: flex;
				flex-direction: column;
			}
			
			#header {
				border-bottom: 1px solid black;
				margin-bottom: 10px;
			}
			
			#content {
				flex-grow: 1;
				display: flex;
				min-height: 0;
			}
			
			#sideBar {
				width: 400px;
				background-color: #ff99c2;
				border-right: 1px solid black;
				padding-right: 10px;
				overflow-y: scroll;
			}
			
			#center {
				flex-grow: 1;
				padding: 10px;
			}
			
			#center iframe {
				margin: 0px;
				width: 100%;
				height: 100%;
			}
			
			#center h4 {
				margin-top: 0px;
			}
			
			#footer {
				border-top: 1px solid black;
				margin-top: 10px;
				margin-bottom: 10px;
			}
		</style>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h3>SpringProgramming5</h3>
			</div>
			<div id="content">
				<div id="sideBar">
					<ul>
						<li><a href="info" target="iframe">Controller</a></li>
						<li><a href="ch02/content" target="iframe">Request Mapping</a></li>
						<li><a href="ch03/content" target="iframe">Request Parameter</a></li>
						<li><a href="ch04/content" target="iframe">Request Header and Cookie setting</a></li>
						<li><a href="ch05/content" target="iframe">From Control to View Data Delivery</a></li>
						<li><a href="ch06/content" target="iframe">Arguments and Return</a></li>
						<li><a href="ch08/content" target="iframe">File Upload</a></li>
						<li><a href="ch09/content" target="iframe">Dependency Injection</a></li>
					</ul>
				</div>
				<div id="center">
					<iframe name= "iframe" src="https://tomcat.apache.org/" frameborder="0"></iframe>
				</div>
			</div>
			<div id="footer">2019. IoT. K.S.Y</div>
		</div>
	</body>
</html>