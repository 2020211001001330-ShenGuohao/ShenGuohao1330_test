package com.ShenGuohao.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//       // without /
//       System.out.println("before redirect");
//       response.sendRedirect("index.jsp");
//       System.out.println("after redirect");

//       with /
//        System.out.println("before redirect");
//       response.sendRedirect("/ShenGuohao1330_test_war_exploded/index.jsp");
//       System.out.println("after redirect");

// absoulte

        System.out.println("before redirect");
       response.sendRedirect("http://www.baidu.com");
       System.out.println("after redirect");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
