package com.ShenGuohao.week5;

import com.ShenGuohao.dao.UserDao;
import com.ShenGuohao.model.User;
import com.sun.deploy.util.SessionState;

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
        /*
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
        */
        con=(Connection) getServletContext().getAttribute("con");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println("登录值"+username+"*");
        System.out.println("登录值"+password+"*");
        PrintWriter out = response.getWriter();

        UserDao userDao=new UserDao();
        try {
            User user= userDao.findByUsernamePassword(con,username,password);

            if(user!=null){

//                Cookie c= new Cookie("sessionid",user.getId().trim());
//                c.setMaxAge(10*60);
//                response.addCookie(c);

                String rememberMe=request.getParameter("rememberMe");
                if(rememberMe!=null && rememberMe.equals("1")){

                    Cookie usernameCookies=new Cookie("cusername",user.getUsername().trim());
                    Cookie passwordCookies=new Cookie("cpassword",user.getPassword().trim());
                    Cookie rememberMeCookies=new Cookie("crememberMe",rememberMe);

                    usernameCookies.setMaxAge(10);
                    passwordCookies.setMaxAge(10);
                    rememberMeCookies.setMaxAge(10);

                    response.addCookie(usernameCookies);
                    response.addCookie(passwordCookies);
                    response.addCookie(rememberMeCookies);

                }

                HttpSession session = request.getSession();
                System.out.println("sessionId: "+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user);

                //               request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

            }else{
                request.setAttribute("message","username or password fail");
                request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request,response);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        /*
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
        } */

    }

}
