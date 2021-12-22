package com.java.threads;

public class OddEvenExample {

        // Starting the counter
        int contr = 1;
        static int NUM;
        // Method for printing the odd numbers
        public void displayOddNumber()
        {
            synchronized (this)
            {
                while (contr < NUM)
                {
                    while (contr % 2 == 0)
                    {
                        try
                        {
                            wait();
                        }
                        catch (InterruptedException ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                    System.out.print(contr + " ");
                    contr = contr + 1;
                    notify();
                }
            }
        }

        public void displayEvenNumber()
        {
            synchronized (this)
            {
                while (contr < NUM)
                {
                    while (contr % 2 == 1)
                    {
                        try
                        {
                            wait();
                        }
                        catch (InterruptedException ex)
                        {
                            ex.printStackTrace();
                        }
                    }

                    System.out.print(contr + " ");

                    contr = contr +1;

                    notify();
                }
            }
        }

        public static void main(String[] argvs)
        {
            NUM = 20;
            OddEvenExample oe = new OddEvenExample();
            Thread th1 = new Thread(new Runnable()
            {
                public void run()
                {
                    oe.displayEvenNumber();
                }
            });
            Thread th2 = new Thread(new Runnable()
            {
                public void run()
                {
                    oe.displayOddNumber();
                }
            });

            th1.start();
            th2.start();
        }
    }


