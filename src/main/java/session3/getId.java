package session3;

public class getId {
    private static int counter; // initialized to 0 by default

    public static synchronized int getID()
    {
        return counter++;
    }
}
