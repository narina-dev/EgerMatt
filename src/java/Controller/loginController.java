/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.loginBean;
import dao.userdao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Athena
 */
@WebServlet(name = "loginController", urlPatterns = {"/loginController"})
public class loginController extends HttpServlet {
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        get from form
      String name = request.getParameter("name");
      String password = request.getParameter("password");
      
    
     
      
      loginBean lBean = new loginBean();
     // set to bean
            lBean.setname(name);
            lBean.setPassword(password);
            
            
            try {
                userdao.login(lBean);
                if(lBean.isValid()){
                      RequestDispatcher rd=request.getRequestDispatcher("seller.jsp");
                       rd.include(request,response);
                       response.sendRedirect("seller.jsp");
                }else{
                      RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
                       rd.include(request,response);
                      
                      
                       response.setContentType("text/html");
                        PrintWriter out = response.getWriter();
                        out.println("<HTML><BODY><p style=color:red> The password and name you entered does not match"
                                +"</BODY></HTML>" );
                       out.close();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    }
}

   
   
