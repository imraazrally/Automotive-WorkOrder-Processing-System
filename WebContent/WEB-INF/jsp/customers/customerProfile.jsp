<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Guest Page</title>
		<link rel="stylesheet" type="text/css" href="CSS/customers/adminHomeScreen.css">
		<link rel="stylesheet" type="text/css" href="CSS/customers/resultTableStyle.css">
	</head>


	<body>
		<div id="screen" style="height:600px;">
			<div id="titleBar">
				<div id="titleBarContent">
					Welcome, ${profile.customerInfo.FName}!
				</div>
			</div>
			
			<div id="screenBody" style="height:600px;">
					
					<!-- Customer Information -->
					
					<u><b>Customer Details</b></u><br>
					First Name : ${profile.customerInfo.FName}<br>
					Last Name :	 ${profile.customerInfo.LName}<br>
					E-mail: 	 ${profile.customerInfo.email}<br>
					Phone: 		 ${profile.customerInfo.phone}<br>
					Address:	 ${profile.customerInfo.address}<br>
					<hr>
					
					<!-- Vehicles Belonging to the Customer -->
					<table id="tblResults">
						<tr>
							<th>Year</th>
							<th>Make</th>
							<th>Model</th>
							<th>Cylinders</th>
							<th>Engine-CC</th>
							<th>Option</th>
						</tr>
						
						<c:forEach items="${profile.vehiclesStorage.vehicles}" var="vehicle">
							<tr>
								<td><c:out value="${vehicle.info.year}"/></td>
								<td><c:out value="${vehicle.info.make}"/></td>
								<td><c:out value="${vehicle.info.model}"/></td>
								<td><c:out value="${vehicle.info.cylinders}"/></td>
								<td><c:out value="${vehicle.info.cc}"/></td>
								<td><a href="">[Select]</a></td>
							</tr>
						</c:forEach>
				
					</table>
					
			</div>
		</div>
	</body>
</html>