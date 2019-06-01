//package testInterface;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class DBCo {
//
//	public void DBRequest() {
//
//		// Access to Data Base
//		String url = "jdbc:mysql://localhost:3306/jpublankproject?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//		String login = "root";
//		String passwd = "";
//		Connection connection = null;
//		ResultSet resultSet = null;
//
//		try {
//
//			// 1 : Loading of driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			// 2 : Connection to Data Base
//			connection = DriverManager.getConnection(url, login, passwd);
//
//			// 3 :Creation of statement
//
//			String query = "{call MapById(1)}";
//
//			java.sql.CallableStatement stmt = connection.prepareCall(query);
//
//			// 4 : Running request
//			resultSet = stmt.executeQuery(query);
//
//			// 5 : Data recovery
//
//			while (resultSet.next()) {
//				String mapFinal = resultSet.getString("Map");
//				System.out.println(mapFinal);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				// 6 : Closing connection
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//
//			}
//		}
//	}
//}