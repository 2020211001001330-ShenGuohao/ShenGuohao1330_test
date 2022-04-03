package com.ShenGuohao.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    Connection con=null;
    PreparedStatement sql=null;
    ResultSet res=null;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context=getServletContext();
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        String url=context.getInitParameter("url");
        String driver=context.getInitParameter("driver");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println(" i am in Login(init)-->get Connection!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("登录值"+username+"*");
        System.out.println("登录值"+password+"*");
        PrintWriter out = response.getWriter();
        boolean sign=false;
        try {
            sql=con.prepareStatement("SELECT * FROM usertable");

            res=sql.executeQuery();
            while (res.next()){

                String user=res.getString("username");
                String pass=res.getString("password");

                System.out.println(user.trim()+"*");
                System.out.println(pass.trim()+"*");

                if(username.equals(user.trim()) && password.equals(pass.trim())){
                    sign=true;
                    break;
                }
            }
                 if(sign){
                     out.println("Login success!!!");
                     out.println("Welcome! "+username);
                 }else {
                     out.println("username or password fail!");
                 }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}