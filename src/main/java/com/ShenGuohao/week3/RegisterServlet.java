package com.ShenGuohao.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(loadOnStartup = 1,urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    Connection con=null;
    PreparedStatement sql=null;
    ResultSet res=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("register:doGet()-->con:"+con);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID=request.getParameter("ID");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("Email");
        String Gender=request.getParameter("Gender");
        String birthday=request.getParameter("birthday");

        PrintWriter out=response.getWriter();
        response.setContentType("text/html");

        try {
             sql=con.prepareStatement("INSERT INTO usertable values (?,?,?,?,?,?)");
             sql.setString(1,ID);
             sql.setString(2,username);
             sql.setString(3,password);
             sql.setString(4,Email);
             sql.setString(5,Gender);
             sql.setString(6,birthday);

             sql.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

        try {
            sql=con.prepareStatement("SELECT * FROM usertable");
            res= sql.executeQuery();

            /*
                    out.println  ("<html><body>\n" +
                "        <table width=\"600\" border=\"1\">\n" +
                "            <tr>\n" +
                "                 <td>ID</td>\n" +
                "                 <td>Username</td>\n" +
                "                 <td>Password</td>\n" +
                "                 <td>Email</td>\n" +
                "                 <td>Gender</td>\n" +
                "                 <td>Birthday</td>\n" +
                "            </tr>\n" );

               while (res.next()){
                   ID=res.getString("ID");
                   username=res.getString("username");
                   password=res.getString("password");
                   Email=res.getString("Email");
                   Gender=res.getString("Gender");
                   birthday=res.getString("birthday");

                   out.println("<tr>");
                   out.println("<td>"+ID+"</td>");
                   out.println("<td>"+username+"</td>");
                   out.println("<td>"+password+"</td>");
                   out.println("<td>"+Email+"</td>");
                   out.println("<td>"+Gender+"</td>");
                   out.println("<td>"+birthday+"</td>");
                   out.println("</tr>");
               }
                 out.println("        </table>\n" +
                         "</body></html>");
              */
 //           request.setAttribute("res",res);

//             request.getRequestDispatcher("userList.jsp").forward(request,response);
           response.sendRedirect("Login.jsp");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void init() throws ServletException {
        super.init();
        /*
        ServletContext context=getServletContext();
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        String url=context.getInitParameter("url");
        String driver=context.getInitParameter("driver");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("register:init()-->con:"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        */

        con=(Connection) getServletContext().getAttribute("con");
    }
}
