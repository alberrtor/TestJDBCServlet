<%@ page import="net.javagurus.dto.ClienteDTO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<link rel="stylesheet" type="text/css" href="css/resultCtes.css">
<title>Insert title here</title>
<%!ArrayList<ClienteDTO> ctes;%>
<%
	ctes = (ArrayList<ClienteDTO>) request.getAttribute("ctes");
%>

</head>
<body>
	<%@include file="header.jsp"%>

	<div id="resultCtes">
		<table>
			<thead>
				<tr style="background-color: #f0a64e;">
					<th class="border">IdBanco</th>
					<th class="border">IdCliente</th>
					<th class="border">Nombre</th>
					<th class="border">APaterno</th>
					<th class="border">AMaterno</th>
					<th class="border">Edad</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${ctes}">

				<tr style="background-color: #f0a64e;">
					<th class="border">${item.idbanco}</th>
					<th class="border">${item.idcliente}</th>
					<th class="border">${item.nombre}</th>
					<th class="border">${item.apaterno}</th>
					<th class="border">${item.amaterno}</th>
					<th class="border">${item.edad}</th>
				</tr>
			</c:forEach>
		</table>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>