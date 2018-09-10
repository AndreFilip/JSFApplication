package com.myJSFApplication.jsf;


import com.myJSFApplication.ejb.FlightsService;
import com.myJSFApplication.ejb.FlightsServiceImpl;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="flights_list_bean")
@SessionScoped
public class FlightsListBean {
    private List<String> departures = new ArrayList<>();
    private List<String> destinations = new ArrayList<>();

    @EJB
    private FlightsService fs = new FlightsServiceImpl();;

    public List<String> getDepartures() {
        return departures;
    }

    public void setDepartures(List<String> departures) {
        this.departures = departures;
    }


    public List<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }

    public String newLists() {
        departures = fs.getNewListDeparture();
        destinations = fs.getNewListDestination();
        return null;
    }
}
