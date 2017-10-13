package models;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class InsertDB {
    private String dbURL = "jdbc:sqlite:eventSchedule.db";
    private Connection conn;
    private Statement statement;
    private List<EventForm> events;

    public void insertDB(String topic, int day, int month, int year, String startTime, String endTime, String place) {
        try {
            Class.forName("org.sqlite.JDBC");
            dbURL = "jdbc:sqlite:eventSchedule.db";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
                String query = "INSERT INTO eventSchedule VALUES ('"+topic+"'," +
                        day+","+month+","+year+",'"+startTime+"'"+",'"+endTime+"'"+",'"+place+"');";
                statement = conn.createStatement();

                statement.executeUpdate(query);       //Here is the problem
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Insert Already");
                }
            } catch (SQLException shouldNotHandleMe) {
                //...
            }
        }
    }
}
