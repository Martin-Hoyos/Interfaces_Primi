<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Vuelos_pri.Vuelo" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultados de Vuelos</title>
</head>
<body>
<nav>
    <a href="Princiapl.jsp">Inicio</a>
    <a href="#ofertas">Ofertas</a>
    <a href="#destinos">Destinos</a>
    <a href="#contacto">Contacto</a>
    <a href="#login">Iniciar Sesión</a>
</nav>
<h2>Resultados de búsqueda de vuelos</h2>
    <%
        List<Vuelo> vuelos = (List<Vuelo>) request.getAttribute("vuelos");
        if (vuelos != null && !vuelos.isEmpty()) {
    %>
        <table border='1'>
            <tr>
                <th>Origen</th>
                <th>Destino</th>
                <th>Fecha</th>
                <th>Precio</th>
            </tr>
            <%
                for (Vuelo vuelo : vuelos) {
            %>
                <tr>
                    <td><%= vuelo.getOrigen() %></td>
                    <td><%= vuelo.getDestino() %></td>
                    <td><%= vuelo.getFecha() %></td>
                    <td><%= vuelo.getPrecio() %></td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>Vuelo no encontrado.</p>
    <%
        }
    %>
</body>
</html>
