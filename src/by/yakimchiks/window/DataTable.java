package by.yakimchiks.window;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import by.yakimchiks.db.ConnectionDB;

public class DataTable{

	private ConnectionDB connection;
	
	public DataTable(ConnectionDB _connection){
		this.connection = _connection;
	}
	
	public JTable getTable() throws Exception{
		JTable table1 = new JTable();
		
		DefaultTableModel dtm = new DefaultTableModel();
		
		ResultSet rs = connection.execSql("SELECT * FROM words");
		ResultSetMetaData rsmd = rs.getMetaData();
		
		int cols = rsmd.getColumnCount();
		String c[] = new String[cols];
		for(int i=0; i<cols; i++){
			c[i] = rsmd.getColumnName(i+1);
			dtm.addColumn(c[i]);
		}
		
		Object row[] = new Object[cols];
		while(rs.next()){
			for(int i=0; i<cols; i++){
				row[i] = rs.getString(i+1);
			}
			dtm.addRow(row);
		}
		
		table1.setModel(dtm);
		
		return table1;
	}
	
	public DefaultTableModel getModel() throws Exception{
		DefaultTableModel dtm = new DefaultTableModel();
		
		ResultSet rs = connection.execSql("SELECT * FROM words");
		ResultSetMetaData rsmd = rs.getMetaData();
		
		int cols = rsmd.getColumnCount();
		String c[] = new String[cols];
		for(int i=0; i<cols; i++){
			c[i] = rsmd.getColumnName(i+1);
			dtm.addColumn(c[i]);
		}
		
		Object row[] = new Object[cols];
		while(rs.next()){
			for(int i=0; i<cols; i++){
				row[i] = rs.getString(i+1);
			}
			dtm.addRow(row);
		}
		return dtm;
	}
}
