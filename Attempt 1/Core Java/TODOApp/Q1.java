import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

public class Q1 {

    public static void main(String[] args) {

        try {

            String path = "C:/Users/yashu/Desktop/Yashu/Projects/Java/Core Java/TODOApp";
            File f = new File(path);
            System.out.println("is file exists = " + f.exists());
            System.out.println("is file : " + f.isFile());
            File[] files = f.listFiles();
            String line = "";

            try {

                LineNumberReader ln = new LineNumberReader(new BufferedReader(new FileReader("file.txt")));

                while ((line = ln.readLine()) != null) {

                    System.out.println(ln.getLineNumber() + " " + line);

                }

            } catch (Exception e) {

                // TODO: handle exception
                e.printStackTrace();

            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

}
