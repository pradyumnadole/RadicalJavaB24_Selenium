package datadriven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataBaseConnectionOracle {
	
	private Connection connection;
	private static Statement statement;
	private static ResultSet rs;
	
	@BeforeMethod
	@BeforeClass
	public void setUp() {
            String databaseURL = "jdbc:oracle:thin:@localhost:1521:mydatabse";
            String user = "root";
            String password = "root";
            connection = null;
            
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                System.out.println("Connecting to Database...");
                connection = DriverManager.getConnection(databaseURL, user, password);
                if (connection != null) {
                    System.out.println("Connected to the Database...");
                }//
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
            catch (ClassNotFoundException ex) {
               ex.printStackTrace();
            }
    }
	
	@Test
    public void getEmployeesFromDataBase() {
        try {
        	/*
        	 * Selenium code
        	 */
            String query = "select * from employee";
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
               
            	int EmpId= rs.getInt("EmpId");
                String EmpName= rs.getString("EmpName");
                AssertJUnit.assertTrue(EmpName.equals("Anil"));
                String EmpAddress=rs.getString(3);
                String EmpDept=rs.getString("EmpDept");
                Double EmpSal= rs.getDouble(5);
                System.out.println(EmpId+"\t"+EmpName+"\t"+EmpAddress+"\t"+EmpSal+"\t"+EmpDept);
                
                connection.close();
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

}
