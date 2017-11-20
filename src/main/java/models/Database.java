/* 5810405207 Pimonwan Sutmee */
package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Database {
    private Connection conn;
    private List<EventForm> events;

    public Database() {
        this.conn = null;
        events = new ArrayList<EventForm>();
    }

    public Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:eventSchedule.db";
            conn = DriverManager.getConnection(dbURL);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public List<String> getEventForMonth(int eventMonth, int eventYear) {
        List<String> days = new ArrayList<String>();
        try {
            Connection conn = this.getConnection();
            String query = "Select * from eventSchedule WHERE Month =" + eventMonth
                    + " AND Year = " + eventYear + ";";
            if (conn != null) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    if (resultSet != null) {
                        String day = resultSet.getString("Day");
                        if (!days.contains(day)) {
                            days.add(day);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException shouldNotHandleMe) {
                //...
            }
        }
        Collections.sort(days);
        return days;
    }

    public List<EventForm> getEventsForDate(int day, int month, int year) {
        try {
            Connection conn = this.getConnection();
            String query = "Select * from eventSchedule WHERE Day =" + day + " AND Month =" + month
                    + " AND Year = " + year + ";";
            if (conn != null) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    if (resultSet != null) {
                        String topic = resultSet.getString("Topic");
                        double startTime = Double.parseDouble(resultSet.getString("Start_Time"));
                        double endTime = Double.parseDouble(resultSet.getString("End_Time"));
                        String place = resultSet.getString("Place");
                        String date = resultSet.getString("Day") + "/" + resultSet.getString("Month") +
                                "/" + resultSet.getString("Year");

                        events.add(new EventForm(topic, date, startTime, endTime, place));
                    }
                }
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException shouldNotHandleMe) {
                //...
            }
        }

        return this.events;
    }

    public void insert(String topic, int day, int month, int year, double startTime, double endTime, String place) {
        try {
            Connection conn = this.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT into eventSchedule (Topic,Day,Month,Year,Start_Time,End_Time,Place) VALUES (?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,topic);
            ps.setString(2,day+"");
            ps.setString(3,""+month);
            ps.setString(4,""+year);
            ps.setString(5, String.valueOf(startTime));
            ps.setString(6, String.valueOf(endTime));
            ps.setString(7,place);

            ps.executeUpdate();

            ResultSet tablekeys = ps.getGeneratedKeys();
            tablekeys.next();
            int a = tablekeys.getInt(1);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Insert Already");
                }
            } catch (SQLException shouldNotHandleMe) {
                System.out.println(shouldNotHandleMe.getMessage());
            }
        }
    }

    public void delete(Object topic, int day, int month, int year, Object startTime, Object endTime, Object place) {
        try {
            Connection conn = this.getConnection();
            String sql = "DELETE FROM eventSchedule WHERE Topic ='" + topic + "' AND Day = " +
                    day + " AND Month =" + month + " AND Year =" + year + " AND Start_Time ='" + startTime + "'" + " AND End_Time = '" + endTime + "'" + " AND Place = '" + place + "';";
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Delete Already");
                }
            } catch (SQLException shouldNotHandleMe) {
                System.out.println(shouldNotHandleMe.getMessage());
            }
        }
    }

    public void update(Object topic, int day, int month, int year, Object startTime, Object endTime, Object place, int id){
        try {
            Connection conn = this.getConnection();
            String sql =  "UPDATE eventSchedule"+
            " SET Topic = '"+topic+"'"+
            ",Day = '"+day+"'"+
            ",Month = '"+month+"'"+
            ",Year = '"+year+"'"+
            ",Start_Time = '"+startTime+"'"+
            ",End_Time = '"+endTime+"'"+
            ",Place = '"+place+"'"+ " WHERE ID = "+id+";";

            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Update Already");
                }
            } catch (SQLException shouldNotHandleMe) {
                System.out.println(shouldNotHandleMe.getMessage());
            }
        }
    }

    public int getId(String topic, String day, String month, String year, String startTime, String endTime, String place){
//        public int getId(String topic){

        int id = -1;
        try {
            Connection conn = this.getConnection();
//            String sql = "SELECT ID FROM eventSchedule WHERE Topic ='" + topic + "' AND Day = " +
//                    day + " AND Month =" + month + " AND Year =" + year + " AND Start_Time ='" + startTime + "'" + " AND End_Time = '" + endTime + "'" + " AND Place = '" + place + "';";
            String sql = "SELECT ID FROM eventSchedule WHERE Topic ='" + topic + "' AND Day = " +
                    day + " AND Month =" + month + " AND Year =" + year + " AND Start_Time ='" + startTime + "'" + " AND End_Time = '" + endTime + "'" + " AND Place = '" + place + "';";

            if (conn != null) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    if (resultSet != null) {
                        id = resultSet.getInt("ID");
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException shouldNotHandleMe) {
                System.out.println(shouldNotHandleMe.getMessage());
            }
        }
        return id;
    }

    public List<EventForm> getEvents(){ return this.events; }
    public void clearEvents(){ this.events.clear(); }
}