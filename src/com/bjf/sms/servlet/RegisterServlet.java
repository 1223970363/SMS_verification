package com.bjf.sms.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Phone=request.getParameter("Phone");
        String Password=request.getParameter("password");
        String Code=request.getParameter("Code");
        ServletContext session=request.getServletContext();
        Object num=session.getAttribute("Num");

        if(Code.equals(num)) {
            Gson gson=new Gson();
            String jsonStr=gson.toJson("1");
            response.getWriter().print(jsonStr);
        }else{
            Gson gson=new Gson();
            String jsonStr=gson.toJson("0");
            response.getWriter().print(jsonStr);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
