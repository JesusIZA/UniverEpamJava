package homeWork.hw8.service;

import homeWork.hw8.Util;
import homeWork.hw8.dao.FlightDAO;
import homeWork.hw8.etitys.Flight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for Flight
 *
 * @author Jesus Raichuk
 */
public class FlightService extends Util implements FlightDAO {
    Connection connection = getConnection();

    @Override
    public  void stopConnection(){
        if(connection != null){
            try {
                connection.close();
                System.out.println("Connection stopped!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void add(Flight flight) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO FLIGHTS (ID, AID, PFROM, PTO, TIMEINAIR) VALUES (?, ?, ?, ?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, flight.getId());
            preparedStatement.setInt(2, flight.getAid());
            preparedStatement.setString(3, flight.getForm());
            preparedStatement.setString(4, flight.getTo());
            preparedStatement.setDouble(5, flight.getTimeInAir());

            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flightList = new ArrayList<Flight>();

        String sql = "SELECT ID, AID, PFROM, PTO, TIMEINAIR FROM FLIGHTS";

        Statement statement = null;
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("ID"));
                flight.setAid(resultSet.getInt("AID"));
                flight.setForm(resultSet.getString("PFROM"));
                flight.setTo(resultSet.getString("PTO"));
                flight.setTimeInAir(resultSet.getDouble("TIMEINAIR"));

                flightList.add(flight);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flightList;
    }
    //!!!
    @Override
    public Flight getById(int id) {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, AID, PFROM, PTO, TIMEINAIR FROM FLIGHTS WHERE ID=?";

        Flight flight = new Flight();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (Integer)id);

            ResultSet resultSet = preparedStatement.executeQuery();

            flight.setId(resultSet.getInt("ID"));
            flight.setAid(resultSet.getInt("AID"));
            flight.setForm(resultSet.getString("PFROM"));
            flight.setTo(resultSet.getString("PTO"));
            flight.setTimeInAir(resultSet.getDouble("TIMEINAIR"));

            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flight;
    }

    @Override
    public void update(Flight flight) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE FLIGHTS SET AID=?, PFROM=?, PTO=?, TIMEINAIR=? WHERE ID=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, flight.getAid());
            preparedStatement.setString(2, flight.getForm());
            preparedStatement.setString(3, flight.getTo());
            preparedStatement.setDouble(4, flight.getTimeInAir());
            preparedStatement.setInt(5, flight.getId());


            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(Flight flight) {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM FLIGHTS WHERE ID=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, flight.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
