<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/newCte.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
	<div id="formNewCte">
		<form action="ServletNuevo" method="post">
			<table>
				<tr>
					<th style="background-color: #7c2f97;" colspan="2">Agregar
						Cliente</th>
				</tr>
				<tr>
					<td>Nombre:</td>
					<td><input type="text" name="nombre" /></td>
				</tr>
				<tr>
					<td>APaterno:</td>
					<td><input type="text" name="apaterno" /></td>
				</tr>
				<tr>
					<td>AMaterno:</td>
					<td><input type="text" name="amaterno" /></td>
				</tr>
				<tr>
					<td>Edad:</td>
					<td><input type="text" name="edad" /></td>
				</tr>
				<tr>
					<td>Banco:</td>
					<td><SELECT NAME="cmbBancos" SIZE=1 onChange="">
							<OPTION VALUE="1">Banamex</OPTION>
							<OPTION VALUE="2">BBVA-Bancomer</OPTION>
							<OPTION VALUE="3">Banorte-IXE</OPTION>
							<OPTION VALUE="4">BanRegio</OPTION>
					</SELECT></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						name="btnAgregar" value="Agregar" /></td>
				</tr>
			</table>
		</form>
	</div>
	
	<%@include file="footer.jsp" %>
</body>
</html>