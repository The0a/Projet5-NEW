package testInterface.Map.ImportMap;

import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Scanner;

//package testInterface;
//
//
//import java.awt.Image;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
public class DAOFichier {

	int longueur, largeur;
	char[][]map = new char[25][25];
	String mapTemp;
	
	public char[][] readFile() throws FileNotFoundException {
//		String FileName = "src/Image/text.txt";

	        // Access to Data Base
	        String url = "jdbc:mysql://localhost:3306/jpublankproject?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	        String login = "root";
	        String passwd = "";
	        Connection connection = null;
	        ResultSet resultSet = null;
//	        char[][]map;
//	        String mapTemp ="";
//	        int longueur, largeur;
//	        try {
//
//	            // 1 : Loading of driver
//	            Class.forName("com.mysql.cj.jdbc.Driver");
//
//	            // 2 : Connection to Data Base
//	            connection = DriverManager.getConnection(url, login, passwd);
//
//	            // 3 :Creation of statement
//
//	            String query = "{call MapById(1)}";
//
//	            java.sql.CallableStatement stmt = connection.prepareCall(query);
//
//	            // 4 : Running request
//	            resultSet = stmt.executeQuery(query);
//
//	            // 5 : Data recovery
//
//	            while (resultSet.next()) {
//	                map = resultSet.getString("Map");
//	                System.out.println(map);
//
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } catch (ClassNotFoundException e) {
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                // 6 : Closing connection
//	                connection.close();
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//
//	            }
//	        }

	


		
		try {

            // 1 : Loading of driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2 : Connection to Data Base
            connection = DriverManager.getConnection(url, login, passwd);

            // 3 :Creation of statement

            String query = "{call MapById(1)}";

            java.sql.CallableStatement stmt = connection.prepareCall(query);

            // 4 : Running request
            resultSet = stmt.executeQuery(query);

            // 5 : Data recovery
            
            while (resultSet.next()) {
            	mapTemp = resultSet.getString("Map");
            }


           
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // 6 : Closing connection
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
//		System.out.println(mapTemp);
//        Scanner scnr = new Scanner(mapTemp);
//        String temp = scnr.nextLine();
        
        int x = 0;
        for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
//				System.out.println(mapTemp);
//				Scanner scnr = new Scanner(new FileReader(FileName));
//				map[i][j] = scnr.nextLine().charAt(x);
//				scnr.close();
				
				map[i][j] = mapTemp.charAt(x);
				
				x++;
				System.out.println(map[i][j]);
			}
			
		}
//        scnr.close();


		
        
		return map;

	}
	
}