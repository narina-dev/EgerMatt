<%-- 
    Document   : index
    Created on : Feb 4, 2019, 4:26:15 PM
    Author     : Athena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn</title>
        <style>
               #loginform
               {
                text-align:justify;
                padding: 15px 15px;
                background-color: #003366;
                height:400px;
                border-radius: 15px;
                }
                td
                {
                width: 100px;
                color:white;
                }
                p
                {
                text-align: centre;
                font-size: 16pt;
                color:#000066;
                }
                h3
                {
                text-align: centre;
                background-color: #003366;
                color :#fff;
                }
            </style>
    </head>
    <body>
        <form action="loginController" method="post">
            <table id="loginform" cellspacing="20" align="centre">
                <tr>
                    <td><h3 style="color:red">Log in!!</h3></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name" autocomplete="on" required>
                </tr>
                 <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" autocomplete="on" required>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="login"></td>
                    <td><a href="registration.jsp">Registration</a>
                </tr>
    </body>
</html>
