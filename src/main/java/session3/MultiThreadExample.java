package session3;
//two threads one even one odd
public class MultiThreadExample {
    public static void main(String[] args){
        final String File1 ="/Users/a206073/IdeaProjects/Streams_Collections_Exceptions/src/main/java/session3/file1.txt";
        final String File1out ="/Users/a206073/IdeaProjects/Streams_Collections_Exceptions/src/main/java/session3/file1out.txt";
        final String File2 ="/Users/a206073/IdeaProjects/Streams_Collections_Exceptions/src/main/java/session3/file2.txt";
        final String File2out ="/Users/a206073/IdeaProjects/Streams_Collections_Exceptions/src/main/java/session3/file2out.txt";

        String[] inFiles = {File1,File2};
        String[] outFiles = {File1out, File2out};
        Thread[] threads=new Thread[inFiles.length];
        try {
            for(int i=0;i<inFiles.length;i++){
                Adder adder=new Adder(inFiles[i],outFiles[i]);
                //create instance of thread class
                //Thread thread=new Thread((Runnable) add);
                //thread.start();
                threads[i]=new Thread((Runnable) adder);
                threads[i].start();
            }
            for(Thread thread:threads)
                thread.join();//block until the other thread finishes
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    }

