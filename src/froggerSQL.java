import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class froggerSQL {

	public static void DisplayRecords(ResultSet rs) throws SQLException {
		while (rs.next()) {
			int id = rs.getInt("id");
			String Name = rs.getString("Name");
			int Score = rs.getInt("Score");
			
			System.out.println("Player ID: " + id);
			System.out.println("Player Name: " + Name);
			System.out.println("Player Name: " + Score);
		}
	}
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Driver Loaded");
			
			String dbUrl = "jdbc:sqlite:frogger.db";
			conn = DriverManager.getConnection(dbUrl);
			
			if (conn != null) {
				System.out.println("Connected Sucessfully");
				
				DatabaseMetaData db = conn.getMetaData();
				System.out.println("Driver Name:" + db.getDriverName());
				System.out.println("Driver Version" + db.getDriverVersion());
				System.out.println("Product Name" + db.getDatabaseProductName());
				System.out.println("Product Name" + db.getDatabaseProductVersion());
				
				String sqlCreateTable = "CREATE TABLE IF NOT EXISTS FROGSCORE" + 
				"(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
				"NAME TEXT NOT NULL, " +
				"SCORE INT NOT NULL)";
				try (PreparedStatement pstmtCreateTable =  conn.prepareStatement(sqlCreateTable)) {
					pstmtCreateTable.executeUpdate();
					System.out.println("Table Successfully Created");
				}
				
				String sqlInsert = "INSERT INTO FROGSCORE (NAME, SCORE) VALUES (?, ?)";
				try (PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert)) {
					pstmtInsert.setString(1, "");
					pstmtInsert.setInt(2, 0);
					pstmtInsert.executeUpdate();
				}
				
				String sqlSelect = "SELECT * FROM FROGSCORE";
				try(PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect)) {
					ResultSet rs = pstmtSelect.executeQuery();
					DisplayRecords(rs);
					rs.close();
				}
				
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
}
