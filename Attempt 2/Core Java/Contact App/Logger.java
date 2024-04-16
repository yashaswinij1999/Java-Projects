
public class Logger {

    private static Logger log = null;
    static int count = 0;

    private Logger() {
        System.out.println("no arg constructor");
    }

    public static Logger getInstance() {

        if (log == null) {
            log = new Logger();
            count++;
        }
        System.out.println("No of times the object created " + count);
        return log;
    }

}

class Test {

    public static void main(String[] args) {

        Logger l = Logger.getInstance();
        Logger l1 = Logger.getInstance();
        System.out.println(l == l1);

    }

}
