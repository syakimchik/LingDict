package by.yakimchiks.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	
	public void AddRecordsToDataBase(String path_file){
		try{
			BufferedReader in = new BufferedReader(new FileReader(path_file));
			String str;
			while((str = in.readLine())!=null){
				int k = str.indexOf(' ');
				String word = str.substring(0, k);
				String code = str.substring(k+1, str.length());
				try{
					statement.execute("INSERT INTO words ( word_name,code ) VALUES ('"+word+"','"+code+"' );");
				}
				catch (SQLException e) {
					// TODO: handle exception
					System.err.println("SQL error:");
					e.printStackTrace();
				}
			}
			in.close();
		}
		catch (IOException e) {
			// TODO: handle exception
			System.err.println("Error: properties");
			e.printStackTrace();
		}
	}
	
	public Statement getStatement(){
		return statement;
	}
	
	public ResultSet execSql(String query) throws SQLException{
		resultSet = statement.executeQuery(query);
		return resultSet;
	}
}
