package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gui.MainFrame;
import model.User;

public class Database {

	private static Connection con;
	// private static String url = "jdbc:mysql://localhost/PsychoTechnology";
	// private static final String user = "root";
	// private static final String password = "";
	private static String url = "jdbc:mysql://160.153.128.45/PsychoTechnology?verifyServerCertificate=false&useSSL=true&?zeroDateTimeBehavior=convertToNull";
	private static final String user = "mindbooster";
	private static final String password = "QqZqXrk5YAX3JuBGjCmT";

	public boolean connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.err.println("Database connection error");
			return false;
		}
		return true;
	}

	public synchronized void disconnect() {
		if (con != null) {
			try {
				if (con.isClosed() == false) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println("Database connection error");
			}
		}
	}

	public User fetchUser(String email) {
		String sql = "SELECT * FROM Users WHERE email = ?";
		User user = null;
		if (connect() == true) {
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, email);

				ResultSet results = ps.executeQuery();

				if (results.next()) {

					user = new User();
					user.setId(results.getInt("Id"));
					user.setFirstName(results.getString("firstName"));
					user.setLastName(results.getString("lastName"));
					user.setEmail(results.getString("email"));
					user.setPassword(results.getString("password"));
					user.setAccountActive(results.getBoolean("active"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		return user;
	}
	
	public boolean isUserPremium(int userId) {
		String sql = "SELECT premium FROM UserApps WHERE userId = ? AND appName = ?";
		boolean isUserPremium = false;

		if (connect() == true) {
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, userId);
				ps.setString(2, MainFrame.appName);

				ResultSet results = ps.executeQuery();

				if (results.next()) {
					isUserPremium = results.getBoolean("premium");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
		}
		return isUserPremium;
	}
}