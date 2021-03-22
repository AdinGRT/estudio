<%@page import="modelo.Producto"%>
<%@page import="dao.ProductoDao"%>
<%@page import="dao.CategoriaDao"%>
<%@page import="modelo.Categoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>exGuateDigi</title>
    </head>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous">
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="index.jsp">Examen Practica</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    <a class="nav-link active" href="categoria.jsp">Categoria</a>
                    <a class="nav-link" href="producto.jsp">Producto</a> 
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </div>
            </div>
        </nav>


        <h1>CATEGORIA</h1>
        <br>
        <br>
        <ol>
            <% CategoriaDao categoriaDao = new CategoriaDao(); %>
            <% for (Categoria c : categoriaDao.listar()) {%>
            <a href="#"><li><%=c.getNombreCategoria()%></li></a>
                    <%}%>
        </ol>
        <br>
        <br>
        <br>
        <br>
        <h2>CATEGORIAS CON VENTAS EN 2019</h2>
        <% ProductoDao productoDao = new ProductoDao();%>

        <ul class="nav nav-pills">
            
            <% for (Categoria c : categoriaDao.listar_mas_vendidas()) {%>
            <li class="nav-item dropdown">
                
                <a class="nav-link dropdown-toggle" data-toggle= "dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><%=c.getNombreCategoria()%></a>

                <div class="dropdown-menu">
                    <% for (Producto p : productoDao.listaPorCategoria(c.getCodigoCategoria())) {%>
                    <a class="dropdown-item" href="ServletTal?codigoProducto=<%= p.getCodigoProducto() %>"><%= p.getNombreProducto()%></a>
                    <% } %>
                </div>

            </li>
            <% }%>
        </ul>

        

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
            integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous"></script>
    </body>
</html>