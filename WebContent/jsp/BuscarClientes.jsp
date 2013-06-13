<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="net.javagurus.dto.ClienteDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Buscar Clientes</title>
<link rel="stylesheet" type="text/css" href="css/busCtes.css"></link>
<link rel="stylesheet" type="text/css" href="css/footer.css"></link>
<link rel="stylesheet" type="text/css" href="css/header.css"></link>

</head>
<body>
<%@include file="header.jsp" %>
<div id="buscarClientes">
<form action="ServletBuscar"  method="post">
	<table>
		<tr>
	    	<th style="background-color:#7c2f97;" colspan="2">Buscar Clientes</th>
	    </tr>
	    <tr>
	    	<td  >Clientes del banco: </td>
	    	<td>
	    	<SELECT NAME="cmbBancos" SIZE=1 onChange=""> 
				<OPTION VALUE="1">Banamex</OPTION>
				<OPTION VALUE="2">BBVA-Bancomer</OPTION>
				<OPTION VALUE="3">Banorte-IXE</OPTION>
				<OPTION VALUE="4">BanRegio</OPTION> 
			</SELECT>
	    	</td>
	    </tr>
	    <tr>
	    	<td colspan="2" align="right"><input type="submit" name="btnBuscar" value="Buscar" /></td>
	    </tr>
	</table>
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
