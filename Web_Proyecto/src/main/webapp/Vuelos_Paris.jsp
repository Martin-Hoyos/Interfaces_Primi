<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Vuelos_pri.Paris_vuelosClass" %> 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vuelos a París</title>
<link rel="stylesheet" href="Mostrar_Vuelos.css"> 
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<nav>
    <a href="Princiapl.jsp">Inicio</a>
    <a href="#ofertas">Ofertas</a>
    <a href="#destinos">Destinos</a>
    <a href="#contacto">Contacto</a>
    <a href="#login">Iniciar Sesión</a>
</nav>
<h2>Resultados de búsqueda</h2>
    <%
List<Paris_vuelosClass> vuelos = (List<Paris_vuelosClass>) request.getAttribute("Paris_vuelosClass");
    
    // Verificar si la lista no es nula y tiene elementos
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
                for (Paris_vuelosClass vuelo : vuelos) {
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
    %>y>
</html>
