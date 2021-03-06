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
		<div id="screen" style="height:400px;">
			<div id="titleBar">
				<div id="titleBarContent">
					Please Select a Customer
				</div>
			</div>
			
			<div id="screenBody" style="height:300px;">
				
						<table id="tblResults">
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>E-mail</th>
								<th>Phone</th>
								<th>Address</th>
								<th>Actions</th>
							</tr>
							<c:forEach items="${customers}" var="customer">
								<tr>
									<td><c:out value="${customer.FName}"/></td>
									<td><c:out value="${customer.LName}"/></td>
									<td><c:out value="${customer.email}"/></td>
									<td><c:out value="${customer.phone}"/></td>
									<td><c:out value="${customer.address}"/></td>
									<td><a href='customerProfile.html?id=<c:out value="${customer.customerId}"/>'>[Select]</a></td>
									<td><a href='removeCustomer.html?id=<c:out value="${customer.customerId}"/>'>[Remove]</a></td>

								</tr>
							</c:forEach>
							
						</table>	
				
			</div>
		</div>
	</body>
</html>