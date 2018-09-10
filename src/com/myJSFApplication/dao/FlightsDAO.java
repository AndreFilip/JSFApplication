package com.myJSFApplication.dao;

import com.myJSFApplication.dto.FlightDTO;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class FlightsDAO {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/jsfapplicationcoursework";
    static final String USER = "root";
    static final String PASS = "1234";

    Connection conn = null;
    Statement stmt = null;

    private List<FlightDTO> thelist;
    private List<String> listString;
    private Set<String> setString;
    private FlightDTO flightDTO;
    private DateFormat targetFormat;
    private String myDate1, myDate2;

    //filter all 1 ok
    public List<FlightDTO> getFlightsResult(String departure1, String destination1, Date date11, Date date22, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate1 = targetFormat.format(date11);
            myDate2 = targetFormat.format(date22);

            sql = "SELECT * FROM flights WHERE departure='" + departure1 + "' AND destination='" + destination1 + "' AND thedate BETWEEN CAST('" + myDate1 + "' AS DATE) AND CAST('" + myDate2 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                    flightsId = rs.getInt("flightId");
                    departure = rs.getString("departure");
                    destination = rs.getString("destination");
                    date = rs.getDate("thedate");
                    price = rs.getInt("price");
                    tickets = rs.getInt("tickets");
                    hour = rs.getString("hour");

                    flightDTO.setDeparture(departure);
                    flightDTO.setDestination(destination);
                    flightDTO.setFlightId(flightsId);
                    flightDTO.setDate(date);
                    flightDTO.setPrice(price);
                    flightDTO.setTickets(tickets);
                    flightDTO.setHour(hour);

                    thelist.add(flightDTO);
                }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter String departure1, int price1 2 ok
    public List<FlightDTO> getFlightsOnlyDeparture(String departure1, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            sql = "SELECT * FROM flights WHERE departure='" + departure1 + "' AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter String destination1, int price1 3 ok
    public List<FlightDTO> getFlightsOnlyDestination(String destination1, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            sql = "SELECT * FROM flights WHERE destination='" + destination1 + "' AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter Date date11, int price1 4 ok
    public List<FlightDTO> getFlightsOnlyDate1(Date date11, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate1 = targetFormat.format(date11);

            sql = "SELECT * FROM flights WHERE thedate>=CAST('" + myDate1 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter Date date22, int price1 5
    public List<FlightDTO> getFlightsOnlyDate2( Date date22, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate2 = targetFormat.format(date22);

            sql = "SELECT * FROM flights WHERE thedate<=CAST('" + myDate2 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter String departure1, String destination1, int price1 6
    public List<FlightDTO> getFlightsOnlyDepartureDestination(String departure1, String destination1, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            sql = "SELECT * FROM flights WHERE departure='" + departure1 + "' AND destination='" + destination1 + "' AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter String departure1, Date date11, int price1 7
    public List<FlightDTO> getFlightsOnlyDepartureDate1(String departure1, Date date11, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate1 = targetFormat.format(date11);

            sql = "SELECT * FROM flights WHERE departure='" + departure1 + "' AND thedate>=CAST('" + myDate1 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter String departure1, Date date22, int price1 8
    public List<FlightDTO> getFlightsOnlyDepartureDate2(String departure1, Date date22, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate2 = targetFormat.format(date22);

            sql = "SELECT * FROM flights WHERE departure='" + departure1 + "' AND thedate<=CAST('" + myDate2 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter String destination1, Date date11, int price1 9
    public List<FlightDTO> getFlightsOnlyDestinationDate1(String destination1, Date date11, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate1 = targetFormat.format(date11);

            sql = "SELECT * FROM flights WHERE destination='" + destination1 + "' AND thedate>=CAST('" + myDate1 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter String destination1, Date date22, int price1 10
    public List<FlightDTO> getFlightsOnlyDestinationDate2(String destination1, Date date22, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate2 = targetFormat.format(date22);

            sql = "SELECT * FROM flights WHERE destination='" + destination1 + "' AND thedate<=CAST('" + myDate2 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter Date date11, Date date22, int price1 11
    public List<FlightDTO> getFlightsOnlyDate1Date2(Date date11, Date date22, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate1 = targetFormat.format(date11);
            myDate2 = targetFormat.format(date22);

            sql = "SELECT * FROM flights WHERE thedate BETWEEN CAST('" + myDate1 + "' AS DATE) AND CAST('" + myDate2 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter String departure1, String destination1, Date date11, int price1 12
    public List<FlightDTO> getFlightsOnlyDepartureDestinationDate1(String departure1, String destination1, Date date11, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate1 = targetFormat.format(date11);

            sql = "SELECT * FROM flights WHERE departure='" + departure1 + "' AND destination='" + destination1 + "' AND thedate>=CAST('" + myDate1 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter String departure1, Date date11, Date date22, int price1 13
    public List<FlightDTO> getFlightsOnlyDepartureDate1Date2(String departure1, Date date11, Date date22, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate1 = targetFormat.format(date11);
            myDate2 = targetFormat.format(date22);

            sql = "SELECT * FROM flights WHERE departure='" + departure1 + "' AND thedate BETWEEN CAST('" + myDate1 + "' AS DATE) AND CAST('" + myDate2 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter String destination1, Date date11, Date date22, int price1 14
    public List<FlightDTO> getFlightsOnlyDestinationDate1Date2(String destination1, Date date11, Date date22, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate1 = targetFormat.format(date11);
            myDate2 = targetFormat.format(date22);

            sql = "SELECT * FROM flights WHERE destination='" + destination1 + "' AND thedate BETWEEN CAST('" + myDate1 + "' AS DATE) AND CAST('" + myDate2 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter String departure1, String destination1, Date date11, int price1 15
    public List<FlightDTO> getFlightsOnlyDepartureDestinationDate2(String departure1, String destination1, Date date22, int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate2 = targetFormat.format(date22);

            sql = "SELECT * FROM flights WHERE departure='" + departure1 + "' AND destination='" + destination1 + "' AND thedate>=CAST('" + myDate1 + "' AS DATE) AND price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //filter noone 16 ok
    public List<FlightDTO> getFlightsAll(int price1) {
        thelist = new ArrayList<>();

        String sql, departure, destination, hour;
        int flightsId, price, tickets;
        Date date;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            sql = "SELECT * FROM flights WHERE price<=" + price1;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightDTO = new FlightDTO();

                flightsId = rs.getInt("flightId");
                departure = rs.getString("departure");
                destination = rs.getString("destination");
                date = rs.getDate("thedate");
                price = rs.getInt("price");
                tickets = rs.getInt("tickets");
                hour = rs.getString("hour");

                flightDTO.setDeparture(departure);
                flightDTO.setDestination(destination);
                flightDTO.setFlightId(flightsId);
                flightDTO.setDate(date);
                flightDTO.setPrice(price);
                flightDTO.setTickets(tickets);
                flightDTO.setHour(hour);

                thelist.add(flightDTO);
            }

            System.out.println("List : " + thelist);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return thelist;
    }

    //inserting 17 ok
    public boolean insertFlight(String departure1, String destination1, Date date11, int price1, int tickets1, String hour1) {
        boolean resultfinal = false;
        String sql;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

//            e.g. INSERT INTO flights (departure, destination, thedate, price, tickets, hour ) VALUES ('Rome', 'Moscow', '2019-05-10', 221, 61, 06.55 );
            targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            myDate1 = targetFormat.format(date11);

            sql = "INSERT INTO flights (departure, destination, thedate, price, tickets, hour ) VALUES ('" + departure1 + "', '" + destination1 + "', '" + myDate1 + "'," + price1 + ", " + tickets1 + ", " + hour1 + ")";
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

            resultfinal = true;

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return resultfinal;
    }

    //deleting 18 ok
    public boolean deleteFlight(int flightID) {
        boolean resultfinal = false;
        String sql;
        int flightsId = 0;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            sql = "SELECT flightId FROM flights";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                flightsId = rs.getInt("flightId");
                if (flightsId == flightID) {
                    resultfinal = true;
                    break;
                }
            }

            System.out.println(flightsId);
            System.out.println(flightID);
            System.out.println(resultfinal);

            if (resultfinal) {
                sql = "DELETE FROM flights WHERE flightId=" + flightID;
                stmt.executeUpdate(sql);
            }

            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return resultfinal;
    }


    public List<String> getNewListDeparture() {
        listString = new ArrayList<>();
        setString = new LinkedHashSet<>();

        String sql, departure;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            sql = "SELECT departure FROM flights";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                departure = rs.getString("departure");
                listString.add(departure);
            }

            setString.addAll(listString);
            listString.clear();
            listString.addAll(setString);

            System.out.println("???????" + listString);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return listString;
    }

    public List<String> getNewListDestination() {
        listString = new ArrayList<>();
        setString = new LinkedHashSet<>();

        String sql, destination;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            sql = "SELECT destination FROM flights";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                destination = rs.getString("destination");
                listString.add(destination);
            }

            setString.addAll(listString);
            listString.clear();
            listString.addAll(setString);

            System.out.println("???????" + listString);
            stmt.close();
            conn.close();

        }catch (ClassNotFoundException cnfe) {
            System.out.println("ClassNotFoundException with: " + cnfe);
        }catch(SQLException se) {
            System.out.println("SQLException with: " + se);
        }catch (Exception e) {
            System.out.println("Exception with: " + e);
        }finally{

            try {
                if(stmt!=null) stmt.close();
            } catch (SQLException se2){
                se2.printStackTrace();
            }

            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }

        return listString;
    }


}


