package utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conxBD {
	private static Connection connexion;

    private final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String USER = "system";
    private final String PASS = "ouma";

    @SuppressWarnings("unused")
	private  conxBD() throws SQLException{
        try{
               Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
        connexion= DriverManager.getConnection(DB_URL, USER, PASS);
        }catch(Exception e)
        {System.out.println(e.getMessage());
        	}
    }

    public static Connection getInstance(){
        if (connexion == null)
            try {
                new conxBD();
            }catch(Exception e){
                System.out.println("--"+e.getMessage());
            }
        return connexion;
    }
}
