package referenceModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoBase{

	private static Connection connection = null;
	private static DaoBase daoBase=null;

	private DaoBase(){}

	public static DaoBase getInstance(){
		if(daoBase==null)
			daoBase = new DaoBase();
		return daoBase;
	}


	public Statement getStatment() throws SQLException, ClassNotFoundException{
		if(connection == null){
			String url = "jdbc:mysql://localhost:3306/Les";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root","");
		}
		return connection.createStatement();
	}

	public ResultSet executeSelect(String select) throws ClassNotFoundException, SQLException{
		Statement stmt = getStatment();
		return stmt.executeQuery(select);
	}

	public void executeInsert(String insert) throws ClassNotFoundException, SQLException {
		Statement stmt = getStatment();
		stmt.executeUpdate(insert);
		stmt.close();
	}

	public void executeDelete(String delete) throws ClassNotFoundException, SQLException {
		Statement stmt = getStatment();
		stmt.executeUpdate(delete);
		stmt.close();
	}

	public void executeUpdate(String update) throws ClassNotFoundException, SQLException {
		Statement stmt = getStatment();
		stmt.executeUpdate(update);
		stmt.close();
	}
}