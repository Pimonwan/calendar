/* 5810405207 Pimonwan Sutmee */

package models;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EventDatabase {
	private String dbURL = "jdbc:sqlite:eventSchedule.db";
	private Connection conn;
	private Statement statement;
	
	
	public EventDatabase() {
		try {
            Class.forName("org.sqlite.JDBC");
            setConn(DriverManager.getConnection(dbURL));
//            conn.close();
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
	
	public void insertDB(String topic, int day, int month, int year, String startTime, String endTime, String place){
		String query = "INSERT INTO eventSchedule VALUES ('"+topic+"',"+day+","+month+","+year+",'"+startTime+"','"+endTime+"','"+place+"');";
		try {
			if(getConn() != null) {
				statement = getConn().createStatement();
				statement.executeUpdate(query);
				System.out.println("Insert Succession!!");
			}
			
			statement.close();
//			conn.close();
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
	
	public void deleteDB(String topic) {
		String query = "DELETE FROM eventSchedule WHERE TOPIC = '"+topic+"';";
		System.out.println(query);
		try {
			if(getConn() != null) {
				statement = getConn().createStatement();
				statement.executeUpdate(query);
				System.out.println("Delete Succession!!");
			}
			
			statement.close();
//			conn.close();
			
		} catch (SQLException ex) {
            ex.printStackTrace();
        }
        		  
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
			
}
