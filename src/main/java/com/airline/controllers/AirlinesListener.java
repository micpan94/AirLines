package com.airline.controllers;


import com.airlines.models.Passenger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class AirlinesListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        ArrayList<Passenger> passengers = (ArrayList<Passenger>) sc.getAttribute("passenger");

        if (passengers == null) {
            System.out.println("no passenget list created ");
            passengers = new ArrayList<>();

            sc.setAttribute("passengers",passengers);
        }
    }
}
