<%-- 
    Document   : home
    Created on : Feb 5, 2019, 12:50:15 PM
    Author     : Athena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
        <jsp:useBean id="user" class="Controller.loginBean" scope="session" />
        <jsp:setProperty property="name" name="user"/>
        <jsp:getProperty property="name" name="user"/>
    </body>
</html>
