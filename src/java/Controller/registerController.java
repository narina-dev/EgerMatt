/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.registerBean;
import dao.registerdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Athena
 */
@WebServlet(name = "registerController", urlPatterns = {"/registerController"})
public class registerController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String location = request.getParameter("location");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // check if the page has been submitted:
        if (password != null && confirmPassword != null) {

            // check if they are equal:
            if (!password.equals(confirmPassword)) {
                //controller will foward the request back to the jsp with a signal that something is up
                request.setAttribute("bad_form", true);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/registration.jsp");
                rd.forward(request,response);
               
               
                       //response.sendRedirect("registration.jsp");

        } else {
             registerBean rBean = new registerBean();
                rBean.setName(name);
                rBean.setEmail(email);
                rBean.setLocation(location);
                rBean.setPassword(password);

                try {
                    registerdao.register(rBean);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(registerController.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("seller.jsp");
            }
        }

    }

}
