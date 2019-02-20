package dao;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/imagedao")
@MultipartConfig(maxFileSize = 80177215)    // upload file's size up to 80MB
public class imagedao extends HttpServlet {

    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/ecommerce";
    private String dbUser = "ecommerce";
    private String dbPass = "ecommerce";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // initial values
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        String productPrice = request.getParameter("productPrice");
        int price = Integer.parseInt(productPrice);
        String imageUrl = "none";
        String folder = "Images";
        Part filePart = request.getPart("image");

        // save image
        if (filePart != null) {
            // prepare save directory & filename a.k.a. image url
            String userDir = System.getProperty("user.home");
            File saveDir = new File(userDir + File.separator + folder);
            imageUrl = extractFileName(filePart);
            // create directory if doesn't exist
            // Windows: C:\Username\Images, Linux: /home/username/Images
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            filePart.write(saveDir.getPath() + File.separator + imageUrl);
        } else {
            imageUrl = "none";
        }

        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client

        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // constructs SQL statement
            String sql = "INSERT INTO products (product_name, product_description, product_price,imageUrl) values (?, ?, ?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, productName);
            statement.setString(2, productDescription);
            statement.setString(3, productPrice);
            statement.setString(4, imageUrl);
             
            /* the commented code is nanzenz
            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(3, inputStream);
            }*/

            // sends the statement to the database server

            int row = statement.executeUpdate();

            if (row > 0) {
                message = "File uploaded and saved into database";
            }

        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);

            // forwards to the message page
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}

