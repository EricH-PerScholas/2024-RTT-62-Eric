package org.example;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        String dburl = "jdbc:mysql://192.168.2.100:3306/classic_models";
        String user = "dev";
        String password = "ultra30dev";
        System.out.println("-------- MySQL JDBC Connection Demo ------------");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(dburl, user, password);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the first name of the employee you want to search for: ");
            String input = scanner.nextLine();
            String lastnameInput = "Doe";

            String selectSQL = "Select * FROM employees where firstname = ? or lastname = ? ";

            //Statement stmt = connection.createStatement();
            PreparedStatement stmt = connection.prepareStatement(selectSQL);
            stmt.setString(1, input);
            stmt.setString(2, lastnameInput);

            int x = stmt.executeUpdate();

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                String employeeID = result.getString("id");
                String fname = result.getString("firstname");
                String lname = result.getString("lastname");
                String email = result.getString("email");
                String jobTitle = result.getString("job_title");
                System.out.println(employeeID + " | " + fname + " | " + lname + " | " + email + " | " + jobTitle);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
