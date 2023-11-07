import java.sql.*;
import java.util.Scanner;

public class Postgre {
    public static void main(String[] args) throws SQLException {
        Connection connection;
        Scanner sc = new Scanner(System.in);
        boolean fl = true;
        String login,pass;
        Statement statement = null;
        ResultSet resSet;
        while (statement==null){
            System.out.println("Enter Login:");
            login = sc.next();
            System.out.println("Enter pass:");
            pass = sc.next();
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://192.168.31.210:5432/Salon",login,pass);
                statement = connection.createStatement();
            }
            catch (SQLException e){
                System.out.println("Error");
            }
        }
        System.out.println("Enter id");
        String id = sc.next();
        resSet = statement.executeQuery("SELECT structure_id, structure_name, address, specialty_name, post_index, tel_number, " +
                "num_employees \n" +
                "FROM structure WHERE structure_id = "+ id + ";");

        while (resSet.next()) {
            String t1 = resSet.getString("structure_id");
            String t2 = resSet.getString("structure_name");
            String t3 = resSet.getString("address");
            String t4 = resSet.getString("specialty_name");
            String t5 = resSet.getString("post_index");
            String t6 = resSet.getString("tel_number");
            String t7 = resSet.getString("num_employees");
            System.out.println(t1 + " | " + t2 + " | " + t3 + " | " + t4 +" | "+ t5 + " | " + t6 + " | " + t7 );
        }
        //  System.out.println("-");
    }
}
