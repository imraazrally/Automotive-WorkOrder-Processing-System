<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	</head>
	
	<body>
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>E-mail</th>
				<th>Phone</th>
				<th>Address</th>
			</tr>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td><c:out value="${customer.FName}"/></td>
					<td><c:out value="${customer.LName}"/></td>
					<td><c:out value="${customer.email}"/></td>
					<td><c:out value="${customer.phone}"/></td>
					<td><c:out value="${customer.address}"/></td>
				</tr>
			</c:forEach>
			
		</table>
	</body>
</html>