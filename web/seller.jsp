<%-- 
    Document   : seller
    Created on : Feb 11, 2019, 12:43:32 PM
    Author     : Athena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seller's page</title>

    </head>
    <body>
        <h1 style:color="blue"> You can now sell</h1>
    <center>
        <h1>File Upload to Database </h1>
        <form method="post" action="imagedao" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Product Name: </td>
                    <td><input type="text" name="productName" size="150"/></td>
                </tr>
                <tr>
                    <td>product Description: </td>
                    <td><input type="text" name="productDescription" size="100"/></td>
                </tr>

                <tr>
                    <td>Product Price </td>
                    <td><input type="number" name="productPrice" size="100"/></td>
                </tr>
                <tr>
                    <td>Product Photo: </td>
                    <td><input type="file" name="image" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Upload">
                    </td>
                </tr>
                <tr>

                </tr>
            </table>
        </form>
    </center>

    <c:forEach items="${imageUrl}" var="imageUrl">
        <img src="${pageContext.request.contextPath}/images/${imageUrl}">
    </c:forEach>

</body>
</html>
