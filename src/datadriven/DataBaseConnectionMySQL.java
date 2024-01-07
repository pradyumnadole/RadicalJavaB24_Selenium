package datadriven;

import org.testng.annotations.Test;

import datadriven.ReadExcelSheet;

import org.testng.annotations.BeforeMethod;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataBaseConnectionMySQL {
	
	private Connection connection;
	private static Statement statement;
	private static ResultSet rs;	
	
	//install MySQL database
	//Open the command line client
	//Create database using--> create database mydatabase;
	//then swithch to database using --> use mydatabase;
	//then create the table --> create table Employee(id int(10),name varchar(40));
	//insert data using --> insert into Employee (id,name) values(10,"Anil");
	//commit;
	
	
	@BeforeClass
    public void setUp() throws InstantiationException, IllegalAccessException {
            String databaseURL = "jdbc:mysql://localhost:3306/mydatabase";
            String user = "root"; //root
            String password = "admin";
            connection = null;
            
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
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
            	int EmpId= rs.getInt("id");
                String EmpName= rs.getString("name");
                String Empcity= rs.getString("city");
                System.out.println("Employee Details =======");
                System.out.println(EmpId+"\t"+EmpName+"\t"+Empcity+"\n");
                Assert.assertTrue(EmpName.equals("Anil"));
                //provide assert statement as per your requirement.
                //here compare your database data with your value present on UI with assert and selenium
            }
            
            connection.close();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

}
