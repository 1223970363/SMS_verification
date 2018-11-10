package com.bjf.sms.servlet;

import com.bjf.sms.util.SendInformationUtil;
import com.google.gson.Gson;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

@WebServlet(name = "PhoneServlet")
public class PhoneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Phone=request.getParameter("Phone");
        String num=SendInformationUtil.getPhoneSendInformation(Phone);

        //System.out.println(num);
        ServletContext session=request.getServletContext();
        session.setAttribute("Num",num);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
