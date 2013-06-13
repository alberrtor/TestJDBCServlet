<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="net.javagurus.dto.ClienteDTO"%>
<%@ page session="false" %>
<%-- <jsp:useBean id="ctes" type="java.util.ArrayList<net.javagurus.dto.ClienteDTO>" scope="session" /> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Eliminar Clientes</title>
<link rel="stylesheet" type="text/css" href="css/resultCtes.css"></link>
<link rel="stylesheet" type="text/css" href="css/footer.css"></link>
<link rel="stylesheet" type="text/css" href="css/header.css"></link>
<script type="text/javascript" src="js/eliminarCtes.js"></script>


<%
	HttpSession mySession = request.getSession(false);
		if(mySession == null){
			System.out.print("no existe sesion valida..");
			response.sendRedirect("Login.jsp");
			return;
		}
%>
</head>
<body>
<%@include file="header.jsp" %>
<%!
	ArrayList<ClienteDTO> ctes;
%>
<div id="resultCtes">
<form action="ServletEliminar" id="itemsDetele" method="post">
<table>
	<tr>
    	<th colspan="5" style="background-color:#7c2f97;">Clientes del Banco</th>
    </tr>
       <tr>
       <td>
		<SELECT NAME="cmbClientes" SIZE=1 onChange="">
    <%
    ctes = (ArrayList<ClienteDTO>) request.getAttribute("ctes");
    
    for(int i=0; i < ctes.size(); i++)
	{
		ClienteDTO cte = new ClienteDTO();
		cte = (ClienteDTO) ctes.get(i);
		%>
        	<option VALUE="<%= cte.getIdcliente() %>"> <%= cte.getNombre() +" " + cte.getApaterno() + " " +cte.getAmaterno() %> </option>
        <%}%>
	      </SELECT></td>
            <td><input type="submit" id="eliminar" value="eliminar"/></td>
        </tr>
</table>
</form>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
