package com.airline.controllers;

import com.airlines.models.Gender;
import com.airlines.models.Passenger;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "AddPassenger")
public class AddPassenger extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("views/add_passenger.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Passenger passenger1 = new Passenger();
        req.setAttribute("errors", false);
        String firstName = req.getParameter("first-name");
        if (firstName.length() == 0) {
            resp.getWriter().println("error");
            req.setAttribute("errors", true);
            req.setAttribute("firstname_error", true);
        } else {
            passenger1.setFirstName(firstName);
        }

        resp.getWriter().println(firstName);
        String lastName = req.getParameter("last-name");
        if (lastName.length() == 0) {
            req.setAttribute("errors", true);
            req.setAttribute("lastname_error", true);
        } else {
            passenger1.setLastName(lastName);
        }

        String dob = req.getParameter("dob");

        String dobArray[] = dob.split("\\/");
        String pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(dob);
        if (m.find()) {
            String mounth = dobArray[0];
            String day = dobArray[1];
            String year = dobArray[2];

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, Integer.parseInt(year));
            cal.set(Calendar.MONTH, Integer.parseInt(mounth));
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));

            Date date = cal.getTime();

            passenger1.setDate(date);
        } else {
            req.setAttribute("errors", true);
            req.setAttribute("date_format_error", true);

            resp.getWriter().println(req.getAttribute("date_format_error"));

        }
        String gender = req.getParameter("gender");
        passenger1.setGender(Gender.valueOf(gender));


        if ((Boolean) req.getAttribute("errors")) {
            RequestDispatcher view = req.getRequestDispatcher("views/add_passenger.jsp");
            view.forward(req, resp);
        } else {
            ServletContext sc = this.getServletContext();
            List<Passenger> passengerList = (ArrayList<Passenger>) sc.getAttribute("passengers");

            passengerList.add(passenger1);

            sc.setAttribute("passengers", passengerList);

            resp.sendRedirect("/");
        }


    }
}
