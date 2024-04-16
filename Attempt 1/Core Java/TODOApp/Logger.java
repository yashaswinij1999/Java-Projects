import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.Buffer;
import java.util.Date;

public class Logger {

    private static Logger log = null;
    static int count = 0;

    private Logger() {

    }

    public static Logger getInstance() {

        if (log == null) {

            log = new Logger();
            count++;
            System.out.println("the no of objects created : " + count);

        }
        return log;

    }

    public void log(String data) {

        String path = "C:/Users/yashu/Desktop/Yashu/Project/Log";
        File f = new File(path);
        File[] files = f.listFiles();

        new Thread(new Runnable() {

            String str;
            Date dt = new Date();
            BufferedWriter bw = null;

            public void run() {

                try {

                    for (File f1 : files) {

                        if (f1.getName().equals("log.txt")) {

                            bw = new BufferedWriter(new FileWriter(f1, true));

                            str = data + " : " + dt;

                            bw.write(str);
                            bw.newLine();

                        }
                    }

                } catch (Exception e) {

                    // TODO: handle exception
                    e.printStackTrace();

                } finally {

                    try {

                        if (bw != null) {
                            bw.close();
                        }

                    } catch (Exception e) {

                        // TODO: handle exception
                        e.printStackTrace();

                    }

                }

            }

        }).start();

    }

}

class TestLogger {

    public static void main(String[] args) {

        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();
        System.out.println(log1 == log2);
        log1.log("Good Evening");

    }

}