<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Para que no cree una nueva sessión -->
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/menu.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ext-all.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ext-all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/MenuClientes.js"></script>

<title>Insert title here</title>
<%
	HttpSession sessionJSP = request.getSession(false);
	if(!(sessionJSP !=null) || !(sessionJSP.getAttribute("usr") != null)){
		response.sendRedirect("../login.jsp");
		
		return;
	}
	
	String  url = request.getPathInfo();
	
%>
</head>
<body>


<%@include file="/jsp/header.jsp" %>

<h1>Administrar Clientes</h1>

<!-- <form id="menuItems" action=""> -->
<!-- <ul> -->
<!-- <li id="consultar"><a href="#" onclick="goAction('consultar')">Consultar </a></li> -->
<!-- <li id="buscar"><a href="#" onclick="goAction('buscar')">Buscar</a></li> -->
<!-- <li id="nuevo"><a href="#" onclick="goAction('nuevo')">Nuevo</a></li> -->
<!-- <li id="eliminar"><a href="#" onclick="goAction('eliminar')">Eliminar</a></li> -->
<!-- </ul> -->
<!-- </form> -->

<dir id="menuCtes">
</div>

<%@include file="/jsp/footer.jsp" %>
</body>
</html>