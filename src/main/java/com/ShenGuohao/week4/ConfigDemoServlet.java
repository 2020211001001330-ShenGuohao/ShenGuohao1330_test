package com.ShenGuohao.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = {"/config"},
            initParams = {
              @WebInitParam(name ="name",value = "ShenGuohao"),
              @WebInitParam(name = "StudentId",value = "2020211001001330")
            }
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          ServletConfig config=getServletConfig();
          String name= config.getInitParameter("name");
          String StudentId=config.getInitParameter("StudentId");

        PrintWriter writer = response.getWriter();
        writer.println("name: "+name);
        writer.println("StudentId: "+StudentId);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
