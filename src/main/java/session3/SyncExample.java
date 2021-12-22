package session3;

public class SyncExample {
    static int counter = 1;
    public static void main(String[] args) throws InterruptedException{
        /* Example of locking using a synchronized method */

        //use lambda notation for the runnable method
//        Runnable r = () -> {
//            System.out.println("ID value: "+getID());
//        };
//        Thread one = new Thread(r,"one");
//        one.start();
//
//        Thread two = new Thread(r,"two");
//        two.start();
//    }

        /*  Example of locking using an object */
        //use lambda notation for the runnable method

        Runnable r2 = () -> {
            getId id = new getId();
            System.out.println("ID value: "+id.getID());
        };
        Thread one = new Thread(r2,"one");
        one.start();
        Thread two = new Thread(r2,"two");
        two.start();
    }

    public static synchronized int getID()
    {
        return counter++;
    }

}
