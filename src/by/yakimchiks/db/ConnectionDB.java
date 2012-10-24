package by.yakimchiks.db;

import java.sql.*;

public class ConnectionDB {
	private Connection connection = null;
	private ResultSet resultSet = null;
	private Statement statement = null;
	private static final String url = "jdbc:sqlite:database/dictionary.sqlite";
	
	public ConnectionDB() {
		// TODO Auto-generated constructor stub
		try{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void connect(){
		
	}
	
	public void execSql() throws SQLException{
		resultSet = statement.executeQuery("select Name from my");
		
		while(resultSet.next()){
			System.out.println("Name "+resultSet.getString("Name"));
		}
	}
}
