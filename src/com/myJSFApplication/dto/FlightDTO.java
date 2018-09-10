package com.myJSFApplication.dto;

import com.myJSFApplication.ejb.FlightsService;
import com.myJSFApplication.ejb.FlightsServiceImpl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.Date;

@ManagedBean(name = "flightDto")
public class FlightDTO {

    private int flightId;
    private String departure;
    private String destination;
    private Date date;
    private int price;
    private int tickets;
    private String hour;

    private String result;
    private String result2;

    private boolean what = false;
    private boolean what2 = false;

    @EJB
    private FlightsService fs = new FlightsServiceImpl();;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult2() {
        return result2;
    }

    public void setResult2(String result2) {
        this.result2 = result2;
    }

    public String proceed2() {

        what = fs.insertFlight(departure, destination, date, price, tickets, hour);

        if (what) {
            result = "Successfully entered flight.";
        } else {
            result = "Something went wrong. Flight was not entered.";
        }

        return null;
    }

    public String proceed3() {
        what2 = fs.deleteFlight(flightId);

        if (what2) {
            result2 = "Successfully deleted flight.";
        } else {
            result2 = "Something went wrong. Flight was not deleted. Maybe flight's Id is not correct.";
        }

        return null;
    }

    @Override
    public String toString() {
        String rs = flightId + " " + departure + " " + destination + " " + price + " " + tickets + " " + hour + " " + date.toString();
        return rs;
    }
}
