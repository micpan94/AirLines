package com.airline.controllers;

import com.airlines.models.Passenger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class MainPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        now its only for local variables we will chagne this in future
        resp.getWriter().println("Added new passenger");

        ServletContext sc = this.getServletContext();

        List<Passenger> passengerList = (List<Passenger>) sc.getAttribute("passengers");

        resp.setContentType("text/html");

        resp.getWriter().println("number of passengers " + passengerList.size());




    }
}
