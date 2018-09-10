package com.myJSFApplication.jsf;

import com.myJSFApplication.dto.FlightDTO;
import com.myJSFApplication.ejb.FlightsService;
import com.myJSFApplication.ejb.FlightsServiceImpl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name="flight_bean_controller")
public class FlightBeanController {
    private String hour;
    private int id;
    private String departure;
    private String destination;
    private Date date1;
    private Date date2;
    private int price;
    private String msg;

    private List<FlightDTO> list = new ArrayList<>();

    @EJB
    private FlightsService fs = new FlightsServiceImpl();;

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    <h:outputText value="#{flight_bean_controller.list}" id="results"/>
    public List<FlightDTO> getList() {
        return list;
    }

    public void setList(List<FlightDTO> list) {
        this.list = list;
    }

    public String proceed() {
        //only departure 1
        if (departure != null && destination == null && date1 == null && date2 == null) {
            list = fs.getFlightsOnlyDeparture(departure, price);        }

        //only destination 2
        if (departure == null && destination != null && date1 == null && date2 == null) {
            list = fs.getFlightsOnlyDestination(destination, price);
        }

        //only date1 3
        if (departure == null && destination == null && date1 != null && date2 == null) {
            list = fs.getFlightsOnlyDate1(date1, price);
        }

        //only date2 4
        if (departure == null && destination == null && date1 == null && date2 != null) {
            list = fs.getFlightsOnlyDate2(date2, price);
        }

        //only departure destination 5
        if (departure != null && destination != null && date1 == null && date2 == null) {
            list = fs.getFlightsOnlyDepartureDestination(departure , destination, price);
        }

        //only departure date1 6
        if (departure != null && destination == null && date1 != null && date2 == null) {
            list = fs.getFlightsOnlyDepartureDate1(departure , date1, price);
        }

        //only departure date2 7
        if (departure != null && destination == null && date1 == null && date2 != null) {
            list = fs.getFlightsOnlyDepartureDate2(departure , date2, price);
        }

        //only destination date1 8
        if (departure == null && destination != null && date1 != null && date2 == null) {
            list = fs.getFlightsOnlyDestinationDate1(destination , date1, price);
        }

        //only destination date2 9
        if (departure == null && destination != null && date1 == null && date2 != null) {
            list = fs.getFlightsOnlyDestinationDate2(destination , date2, price);
        }

        //only date1 date2 10
        if (departure == null && destination == null && date1 != null && date2 != null) {
            list = fs.getFlightsOnlyDate1Date2(date1 , date2, price);
        }

        //only departure destination date1 11
        if (departure != null && destination != null && date1 != null && date2 == null) {
            list = fs.getFlightsOnlyDepartureDestinationDate1(departure, destination , date1, price);
        }

        //only departure destination date2 12
        if (departure != null && destination != null && date1 == null && date2 != null) {
            list = fs.getFlightsOnlyDepartureDestinationDate2(departure, destination , date2, price);
        }

        //only departure date1 date2 13
        if (departure != null && destination == null && date1 != null && date2 != null) {
            list = fs.getFlightsOnlyDepartureDate1Date2(departure, date1 , date2, price);
        }

        //only destination date1 date2 14
        if (departure == null && destination != null && date1 != null && date2 != null) {
            list = fs.getFlightsOnlyDestinationDate1Date2(destination, date1 , date2, price);
        }

        //all null 15
        if (departure == null && destination == null && date1 == null && date2 == null) {
            list = fs.getFlightsAll(price);
        }

        //all NOT null 16
        if (departure != null && destination != null && date1 != null && date2 != null) {
            list = fs.getFlights(departure, destination, date1, date2, price);
        }

        if (list.isEmpty()) {
            msg = "No results found with entered criteria.";
        } else {
            msg = "";
        }

        return null;
    }
}
