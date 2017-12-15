package homeWork.hw8.service;

import homeWork.hw8.Util;
import homeWork.hw8.dao.AirlineDAO;
import homeWork.hw8.etitys.Airline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class for Airline
 *
 * @author Jesus Raichuk
 */
public class AirlineService extends Util implements AirlineDAO {
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
    public void add(Airline airline) {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO AIRLINES (ID, ANAME) VALUES (?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, airline.getId());
            preparedStatement.setString(2, airline.getName());

            preparedStatement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Airline> getAll() {
        List<Airline> airlineList = new ArrayList<Airline>();

        String sql = "SELECT ID, ANAME FROM AIRLINES";

        Statement statement = null;
        try{
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Airline airline = new Airline();
                airline.setId(resultSet.getInt("ID"));
                airline.setName(resultSet.getString("ANAME"));;

                airlineList.add(airline);
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
        return airlineList;
    }
    //!!!
    @Override
    public Airline getById(int id) {
        PreparedStatement preparedStatement = null;

        String sql = "SELECT ID, ANAME FROM AIRLINES WHERE ID=?";

        Airline airline = new Airline();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, (Integer)id);

            ResultSet resultSet = preparedStatement.executeQuery();

            airline.setId(resultSet.getInt("ID"));
            airline.setName(resultSet.getString("ANAME"));

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
        return airline;
    }

    @Override
    public void update(Airline airline) {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE AIRLINES SET ANAME=? WHERE ID=?";
        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, airline.getName());
            preparedStatement.setInt(2, airline.getId());

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
    public void delete(Airline airline) {
        PreparedStatement preparedStatement = null;

        String sql = "DELETE FROM AIRLINES WHERE ID=?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            //connection.setAutoCommit(false);

            preparedStatement.setInt(1, airline.getId());
            //try{
            preparedStatement.executeUpdate();
            //connection.commit();
            //} catch(Exception e) {
            //connection.rollback();}
            //connection.setAutoCommit(true);


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
