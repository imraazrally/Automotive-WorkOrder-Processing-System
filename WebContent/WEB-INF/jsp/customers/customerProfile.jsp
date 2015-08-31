<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
	<title>Guest Page</title>
	<link rel="stylesheet" type="text/css" href="CSS/customers/adminHomeScreen.css">
	</head>

	<body>
		<div id="screen" style="height:600px;">
			<div id="titleBar">
				<div id="titleBarContent">
					Welcome, ${profile.customerInfo.FName}!
				</div>
			</div>
			
			<div id="screenBody" style="height:600px;">
					
					<u><b>Customer Details</b></u><br>
					First Name : ${profile.customerInfo.FName}<br>
					Last Name :	 ${profile.customerInfo.LName}<br>
					E-mail: 	 ${profile.customerInfo.email}<br>
					Phone: 		 ${profile.customerInfo.phone}<br>
					Address:	 ${profile.customerInfo.address}<br>
					<hr>
					
					
			</div>
		</div>
	</body>
</html>