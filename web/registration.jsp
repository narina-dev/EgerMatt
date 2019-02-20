<%-- 
    Document   : registration
    Created on : Feb 4, 2019, 4:44:35 PM
    Author     : Athena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Controller.registerController" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register page</title>
        <style>
            #regform
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
        <form action="registerController" method="post">
            <table id="regform" cellspacing="20" align="centre">
                <tr>
                    <td><h3 style="color:black">Register</h3></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" autocomplete="on" required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" autocomplete="on"></td>
                </tr>
                <tr>
                    <td>Location:</td>
                    <td><input type="radio" name="location" value="CBD" required>CBD <br></td>
                    <td><input type="radio" name="location" value="NJOKERIO">NJOKERIO <br></td>
                    <td><input type="radio" name="location" value="GATE"> GATE<br></td>
                    <td><input type="radio" name="location" value="TATTON"> TATTON <br></td>

                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" utocomplete="off" required></td>
                </tr>
                <tr>
                    <td>Confirm Password:</td>
                    <td><input type="password" name="confirmPassword" autocomplete="off" required></td>
                </tr>
                <tr>
                 <%
                   if(request.getAttribute("bad_form") != null && (Boolean)request.getAttribute("bad_form") == true ){
                        response.setContentType("text/html");
                        //PrintWriter out = response.getWriter();
                        out.println("<HTML><BODY><p style=color:red> Please enter matching passwords"
                                +"</BODY></HTML>" );
                       
                   }  
                  %>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="register"></td>
                </tr>

                

            </table>
        </form>



    </body>
</html>
