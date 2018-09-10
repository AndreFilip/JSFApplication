package com.myJSFApplication.ejb;

import com.myJSFApplication.dao.FlightsDAO;
import com.myJSFApplication.dto.FlightDTO;

import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

@Stateless
public class FlightsServiceImpl implements FlightsService{

    private FlightsDAO flightsDAO = new FlightsDAO();

    @Override
    public List<FlightDTO> getFlights(String departure, String destination, Date date1, Date date2, int price) {
        return flightsDAO.getFlightsResult(departure, destination, date1, date2, price);
    }

    @Override
    public List<FlightDTO> getFlightsOnlyDeparture(String departure, int price) {
        return flightsDAO.getFlightsOnlyDeparture(departure, price);
    }

    @Override
    public List<FlightDTO> getFlightsOnlyDestination(String destination, int price) {
        return flightsDAO.getFlightsOnlyDestination(destination, price);
    }

    @Override
    public List<FlightDTO> getFlightsOnlyDate1(Date date1, int price) {
        return flightsDAO.getFlightsOnlyDate1(date1, price);

    }

    @Override
    public List<FlightDTO> getFlightsOnlyDate2(Date date2, int price) {
        return flightsDAO.getFlightsOnlyDate2(date2, price);
    }

    @Override
    public List<FlightDTO> getFlightsOnlyDepartureDestination(String departure, String destination, int price) {
            return flightsDAO.getFlightsOnlyDepartureDestination(departure, destination, price);

        }

    @Override
    public List<FlightDTO> getFlightsOnlyDepartureDate1(String departure, Date date1, int price) {
        return flightsDAO.getFlightsOnlyDepartureDate1(departure, date1, price);

    }

    @Override
    public List<FlightDTO> getFlightsOnlyDepartureDate2(String departure, Date date2, int price) {
        return flightsDAO.getFlightsOnlyDepartureDate2(departure, date2, price);

    }

    @Override
    public List<FlightDTO> getFlightsOnlyDestinationDate1(String destination, Date date1, int price) {
        return flightsDAO.getFlightsOnlyDestinationDate1(destination, date1, price);

    }

    @Override
    public List<FlightDTO> getFlightsOnlyDestinationDate2(String destination, Date date2, int price) {
        return flightsDAO.getFlightsOnlyDestinationDate2(destination, date2, price);

    }

    @Override
    public List<FlightDTO> getFlightsOnlyDate1Date2(Date date1, Date date2, int price) {
        return flightsDAO.getFlightsOnlyDate1Date2(date1, date2, price);

    }

    @Override
    public List<FlightDTO> getFlightsOnlyDepartureDestinationDate1(String departure, String destination, Date date1, int price) {
        return flightsDAO.getFlightsOnlyDepartureDestinationDate1(departure, destination, date1, price);
    }

        @Override
    public List<FlightDTO> getFlightsOnlyDepartureDestinationDate2(String departure, String destination, Date date2, int price) {
            return flightsDAO.getFlightsOnlyDepartureDestinationDate2(departure, destination, date2, price);

        }

    @Override
    public List<FlightDTO> getFlightsOnlyDepartureDate1Date2(String departure, Date date1, Date date2, int price) {
        return flightsDAO.getFlightsOnlyDepartureDate1Date2(departure, date1, date2, price);

    }

    @Override
    public List<FlightDTO> getFlightsOnlyDestinationDate1Date2(String destination, Date date1, Date date2, int price) {
        return flightsDAO.getFlightsOnlyDestinationDate1Date2(destination, date1, date2, price);

    }

    @Override
    public List<FlightDTO> getFlightsAll(int price) {
        return flightsDAO.getFlightsAll(price);
    }

    @Override
    public boolean insertFlight(String departure, String destination, Date date, int price, int tickets, String hour) {

        return flightsDAO.insertFlight( departure,  destination,  date,  price,  tickets,  hour);
    }

    @Override
    public boolean deleteFlight(int id) {
        return flightsDAO.deleteFlight(id);
    }

    @Override
    public List<String> getNewListDeparture() {
        return flightsDAO.getNewListDeparture();
    }

    @Override
    public List<String> getNewListDestination() {
        return flightsDAO.getNewListDestination();
    }
}
