/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gyro.bab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author mapluzdell
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/gyrobab";
    private static final String USER = "patxmay";
    private static final String PASSWORD = "Uhaina99*";

	public static Connection getConnection() {
    	try {
        	return DriverManager.getConnection(URL, USER, PASSWORD);
    	} catch (SQLException e) {
        	e.printStackTrace();
        	return null;
    	}
	}
}
    
