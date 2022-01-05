package emp;


import java.util.Scanner;

public class Employees {
    Scanner scan=new Scanner(System.in);
    Operations op=new Operations();
    void menu() {
        int ch;
        try {
            do {
                System.out.println("1.Insert");
                System.out.println("2.Delete");
                System.out.println("3.Update");
                System.out.println("4.Display");
                System.out.println("5.Exit");
                System.out.println("Enter your choice");
                ch = scan.nextInt();
                switch (ch) {
                    case 1:
                        op.addRecord();
                        break;
                    case 2:
                        op.deleteRecord();
                        break;
                    case 3:
                        op.UpdateRecord();
                        break;
                    case 4:
                        System.out.println("1.Display all records");
                        System.out.println("2.Display single record");
                        int choice=scan.nextInt();
                        switch(choice){
                            case 1:op.displayAll();
                            break;
                            case 2:op.displayRecord();
                            break;
                            default:System.out.println("Invalid choice");
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid choice");

                }
            } while (ch != 0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        Employees emp=new Employees();
        emp.menu();
    }
}
