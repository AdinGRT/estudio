<%-- 
    Document   : index
    Created on : Sep 27, 2020, 11:24:19 PM
    Author     : adingrt
--%>

<%--Directiva que indica al navegador que es una pagina web --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            out.println("Hola Mundo desde JSP");
        %>
        <%--Expression: redirecciona a la pagina listarLibros.jsp--%>
        <jsp:forward page="listarLibros.jsp"></jsp:forward>
    </body>
</html>
