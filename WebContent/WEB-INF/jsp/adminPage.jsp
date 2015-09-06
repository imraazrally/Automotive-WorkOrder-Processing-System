<html>
	<head>
	<title>Admin Page</title>
	<link rel="stylesheet" type="text/css" href="CSS/customers/adminHomeScreen.css">
	</head>

	<body>
		<div id="screen" style="height:500px">
			<div id=titleBar>
				<div id="titleBarContent">
					Hi <b>${key.username}</b>, welcome to admin home!<br>	
				</div>
			</div>
			
			<div id="screenBody" style="height:500px">
				<i>Below are services available to you,</i>
				
				<hr>
				
				<b><u>Customers</u></b>
				<br><a href="customers.html">1. Add New Customers</a>
				<br><a href="selectCustomerUsingPhone.html">2. Lookup Customer Using Phone</a>
				<br><a href="selectCustomerUsingName.html">3. Lookup Customer Using Name</a>
				
				<hr>
				
				<b><u>Parts</u></b>
				<br>4. Lookup Parts with SKU
				<br>5. Lookup Parts with Vehicle Info.
				<br>6. Create Parts Work-Order 
			</div>
			
			
		
		</div>
	</body>
</html>