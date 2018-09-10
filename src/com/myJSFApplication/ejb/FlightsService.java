package com.myJSFApplication.ejb;

import com.myJSFApplication.dto.FlightDTO;

import java.util.Date;
import java.util.List;

public interface FlightsService {
//    String departure, String destination, Date date1, Date date2, int price

    public List<FlightDTO> getFlights(String departure, String destination, Date date1, Date date2, int price);

    public List<FlightDTO> getFlightsOnlyDeparture(String departure, int price);

    public List<FlightDTO> getFlightsOnlyDestination(String destination, int price);

    public List<FlightDTO> getFlightsOnlyDate1(Date date1, int price);

    public List<FlightDTO> getFlightsOnlyDate2(Date date2, int price);

    public List<FlightDTO> getFlightsOnlyDepartureDestination(String departure, String destination, int price);

    public List<FlightDTO> getFlightsOnlyDepartureDate1(String departure, Date date1, int price);

    public List<FlightDTO> getFlightsOnlyDepartureDate2(String departure, Date date2, int price);

    public List<FlightDTO> getFlightsOnlyDestinationDate1(String destination, Date date1, int price);

    public List<FlightDTO> getFlightsOnlyDestinationDate2(String destination, Date date2, int price);

    public List<FlightDTO> getFlightsOnlyDate1Date2(Date date1, Date date2, int price);

    public List<FlightDTO> getFlightsOnlyDepartureDestinationDate1(String departure, String destination, Date date1, int price);

    public List<FlightDTO> getFlightsOnlyDepartureDestinationDate2(String departure, String destination, Date date2, int price);

    public List<FlightDTO> getFlightsOnlyDepartureDate1Date2(String departure, Date date1, Date date2, int price);

    public List<FlightDTO> getFlightsOnlyDestinationDate1Date2(String destination, Date date1, Date date2, int price);

    public List<FlightDTO> getFlightsAll(int price);

    public boolean insertFlight(String departure, String destination,Date date,int price, int tickets,String hour);

    public boolean deleteFlight(int id);

    public List<String> getNewListDeparture();
    public List<String> getNewListDestination();
}
