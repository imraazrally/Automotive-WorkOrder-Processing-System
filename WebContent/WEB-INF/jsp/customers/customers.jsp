
<html>
	<head>
		<title>Guest Page</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> 
		<script src="JS/customers/main.js"></script>
		<link rel="stylesheet" type="text/css" href="CSS/customers/adminHomeScreen.css">
	</head>

	<body>
		<div id="screen" style="height:300px !important">
			
			<div id="titleBar">
				<div id="titleBarContent">
					Customer Information
				</div>
			</div>
			
			<div id="screenBody">
							<div id="results">
												<form id="customerAction">
													<div style="width:100px; display:inline; float:left;">
														<br>First Name:
														<br>Last Name:
														<br>Email:
														<br>Phone:	
														<br>Address: 
													</div>
													
													<div style="display:inline; float:left">
														<br><input type="text" id="addFName"/>
														<br><input type="text" id="addLName"/>
														<br><input type="text" id="addEmail"/>
														<br><input type="text" id="addPhone"/>
														<br><input type="text" id="addAddress"/>
													</div>	
													
													<br><br><br><br><br><br><br><input type="button" value="Create Account" onclick="addCustomer()"/>
												</form>	
							</div>		
			</div>
			
			
		</div>
	</body>
</html>