package session3;

public class SingleThread {
    public static void main(String []args) {
        final String File1 ="/Users/a206073/IdeaProjects/Streams_Collections_Exceptions/src/main/java/session3/file1.txt";
        final String File1out ="/Users/a206073/IdeaProjects/Streams_Collections_Exceptions/src/main/java/session3/file1out.txt";
        final String File2 ="/Users/a206073/IdeaProjects/Streams_Collections_Exceptions/src/main/java/session3/file2.txt";
        final String File2out ="/Users/a206073/IdeaProjects/Streams_Collections_Exceptions/src/main/java/session3/file2out.txt";

        String[] inFiles = {File1,File2};
        String[] outFiles = {File1out, File2out};
        try {
            for(int i=0;i<inFiles.length;i++){
                Adder add=new Adder(inFiles[i],outFiles[i]);
                add.doAdd();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
