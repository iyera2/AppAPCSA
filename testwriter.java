import java.io.*;

public class testwriter {
    public static void main(String[] args){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("testing");
            myWriter.close();
            System.out.println("Wrote to file");
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
