package emp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Operations {
    DbConnection con = new DbConnection();
    Connection connected = con.getConnection();
    Scanner scan = new Scanner(System.in);

    void addRecord() {
        ResultSet rowExist=null;
        System.out.println("Enter id");
        String id = scan.next();
        int rowCount=0;
        String checkId = "select count(emp_id)  from details where emp_id = ?";
        try (PreparedStatement preparedStatement = connected.prepareStatement(checkId)) {
            preparedStatement.setString(1, id);
            rowExist=preparedStatement.executeQuery();
            while(rowExist.next()){
                rowCount=rowExist.getInt(1);

            }
            if (rowCount>0) {
                System.out.println("The Employee id exists");
            } else {
                String insertrecord1 = "INSERT INTO details(emp_id,emp_name,emp_role,salary,department) values(?,?,?,?,?)" +
                        " (?, ?, ?,?,?);";
                String insertrecord2 = "INSERT INTO personal(emp_id,address,phone_no,emp_age,joining_date) values(?,?,?,?,?)" +
                        " (?, ?, ?,?,?);";
                System.out.println("Enter id");
                String eid = scan.next();
                System.out.println("Enter Name");
                String name = scan.next();
                System.out.println("Enter role");
                String role = scan.next();
                System.out.println("Enter salary");
                String salary = scan.next();
                System.out.println("Enter department");
                String dep = scan.next();
                PreparedStatement Statement = connected.prepareStatement(insertrecord1);
                Statement.setString(1, id);
                Statement.setString(2, name);
                Statement.setString(3, role);
                Statement.setString(4, salary);
                Statement.setString(5, dep);
                preparedStatement.execute();
                System.out.println("Added to details table");
                System.out.println("Enter Address");
                String address = scan.next();
                System.out.println("Enter phone");
                String phone = scan.next();
                System.out.println("Enter age");
                String age = scan.next();
                System.out.println("Enter Joining date");
                String date = scan.next();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                java.util.Date date2 = null;
                try {
                    date2 = dateFormat.parse(date);

                } catch (ParseException e1) {

                    e1.printStackTrace();
                }
                java.sql.Date data = new java.sql.Date(date2.getTime());
                PreparedStatement Statement1 = connected.prepareStatement(insertrecord2);
                Statement1.setString(1, eid);
                Statement1.setString(2, address);
                Statement1.setString(3, phone);
                Statement1.setString(4, age);
                Statement1.setDate(5, data);
                System.out.println(preparedStatement);
                preparedStatement.execute();
                System.out.println("Sucessfully inserted");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void displayAll() {
        ResultSet rs = null;
        String display = "select d.emp_id,d.emp_name,d.emp_role,d.salary,d.department,p.joining_date,p.phone_no,p.emp_age,p.address from details as d,personal as p where d.emp_id=p.emp_id;";
        System.out.println("Id\tName\t\tRole\t\t\tSalary\t\tDepartment\t\tJoining Date\t\tPhone\t\tAge\t\tAddress");
        try (PreparedStatement preparedStatement = connected.prepareStatement(display)) {
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3)
                        + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6)
                        + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8) + "\t\t" + rs.getString(9));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void displayRecord() {
        ResultSet rs = null;
        System.out.println("Enter the employee id to display:");
        String eid = scan.next();
        String display = "select d.emp_id,d.emp_name,d.emp_role,d.salary,d.department,p.joining_date,p.phone_no,p.emp_age,p.address from details as d,personal as p where d.emp_id=? and p.emp_id=? Limit 1;";
        System.out.println("Id\tName\t\tRole\t\t\tSalary\t\tDepartment\t\tJoining Date\t\tPhone\t\tAge\t\tAddress");
        try {
            PreparedStatement preparedStatement = connected.prepareStatement(display);
            preparedStatement.setString(1, eid);
            preparedStatement.setString(2, eid);
            rs = preparedStatement.executeQuery();
            rs.next();
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3)
                    + "\t\t" + rs.getString(4) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6)
                    + "\t\t" + rs.getString(7) + "\t\t" + rs.getString(8) + "\t\t" + rs.getString(9));


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void deleteRecord() {
        System.out.println("Enter emp_id to delete");
        String id = scan.next();
        String q1 = "delete from personal where emp_id=?";
        String q2 = "delete from details where emp_id=?";
        try {
            PreparedStatement preparedStatement = connected.prepareStatement(q1);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Deleted from personal");
            PreparedStatement preparedStatement1 = connected.prepareStatement(q2);
            preparedStatement1.setString(1, id);
            preparedStatement1.executeUpdate();
            System.out.println("Deleted from details");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void UpdateRecord() {
        ResultSet rowExist=null;
        System.out.println("Enter id to update");
        String id = scan.next();
        int rowCount=0;
        String checkId = "select count(emp_id)  from details where emp_id = ?";
        try (PreparedStatement preparedStatement = connected.prepareStatement(checkId)) {
            preparedStatement.setString(1, id);
            rowExist = preparedStatement.executeQuery();
            while (rowExist.next()) {
                rowCount = rowExist.getInt(1);
            }
            if (rowCount > 0) {
                String insertrecord1 = "INSERT INTO details(emp_name,emp_role,salary,department) values(?,?,?,?,?)" +
                        " ( ?, ?,?,?);";
                String insertrecord2 = "INSERT INTO personal(address,phone_no,emp_age,joining_date) values(?,?,?,?,?)" +
                        " ( ?, ?,?,?);";
                System.out.println("Enter Name");
                String name = scan.next();
                System.out.println("Enter role");
                String role = scan.next();
                System.out.println("Enter salary");
                String salary = scan.next();
                System.out.println("Enter department");
                String dep = scan.next();
                PreparedStatement Statement = connected.prepareStatement(insertrecord1);
                Statement.setString(1, name);
                Statement.setString(2, role);
                Statement.setString(3, salary);
                Statement.setString(4, dep);
                preparedStatement.execute();
                System.out.println("Added to details table");
                System.out.println("Enter Address");
                String address = scan.next();
                System.out.println("Enter phone");
                String phone = scan.next();
                System.out.println("Enter age");
                String age = scan.next();
                System.out.println("Enter Joining date");
                String date = scan.next();
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                java.util.Date date2 = null;
                try {
                    date2 = dateFormat.parse(date);

                } catch (ParseException e1) {

                    e1.printStackTrace();
                }
                java.sql.Date data = new java.sql.Date(date2.getTime());
                PreparedStatement Statement1 = connected.prepareStatement(insertrecord2);
                Statement1.setString(1, address);
                Statement1.setString(2, phone);
                Statement1.setString(3, age);
                Statement1.setDate(4, data);
                System.out.println(preparedStatement);
                preparedStatement.execute();
                System.out.println("Sucessfully inserted");
            }
          else{
              System.out.println("not added successful");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}





