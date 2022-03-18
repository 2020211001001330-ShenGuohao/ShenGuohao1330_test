package com.ShenGuohao.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;

@WebServlet(name = "JdbcServlet",
            urlPatterns = {"/jdbc"},
            initParams = {
             @WebInitParam(name = "username",value = "sa"),
             @WebInitParam(name = "password",value = "sghSGH123"),
             @WebInitParam(name = "driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
             @WebInitParam(name = "url",value = "jdbc:sqlserver://localhost:1433;DatabaseName=Stu;encrypt=false"),
            },
          loadOnStartup = 1
)
public class JdbcServlet extends HttpServlet {

    Connection con;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("(doGet)connection:"+con);
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println("链接数据库成功！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        super.init();
//        String username="sa";
//        String diver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String password="sghSGH123";
//        String url="jdbc:sqlserver://localhost:1433;DatabaseName=Stu;encrypt=false";;

          ServletConfig config=getServletConfig();
          String username=config.getInitParameter("username");
          String password=config.getInitParameter("password");
          String driver=config.getInitParameter("driver");
          String url=config.getInitParameter("url");



        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,password);

            System.out.println("(Init)connection:"+con);


//            Statement sql=con.createStatement();
//            ResultSet res=sql.executeQuery("SELECT * FROM Student");
//            response.setContentType("text/html;charset=UTF-8");
//            PrintWriter writer=response.getWriter();
//            while (res.next()){
//
//                String Sno=res.getString("Sno");
//                String Sname=res.getString("Sname");
//                String Ssex=res.getString("Ssex");
//                String Sage=res.getString("Sage");
//                String Sdept=res.getString("Sdept");
//
//
//
//                writer.print(Sno+"\t");
//                writer.print(Sname+"\t");
//                writer.print(Ssex+"\t");
//                writer.print(Sage+"\t");
//                writer.println(Sdept+"<br>");
//
//            }
//              writer.close();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }
}
