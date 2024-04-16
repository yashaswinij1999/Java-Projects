
import java.io.File;
import java.util.Scanner;

public class ContactApp {

    public static void run() {

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        menu(1);

        int choice = 0;

        while (choice != 5) {

            System.out.println(" ");
            System.out.println("Press 1 to Create Contacts Book");
            System.out.println("Press 2 to Load Contacts Book");
            System.out.println("Press 3 to Search contacts");
            System.out.println("Press 4 to List contacts");
            System.out.println("Press 5 to Exit");
            System.out.println(" ");

            System.out.println("Enter your choice");
            choice = sc1.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Adding new Contact");
                    System.out.println(" ");
                    System.out.println("Enter the Name of the Contact Book");
                    String name = sc1.next();
                    addContact(name);
                    break;

                case 2:
                    System.out.println("Loading Contacts");
                    break;
                case 3:
                    System.out.println("Search Contacts");
                    break;
                case 4:
                    System.out.println("List Contacts");
                    break;
                case 5:
                    System.out.println("To Exit ");
                    break;
                default:
                    throw new AssertionError();

            }

        }

    }

    public static void menu(int i) {
        System.out.println("-----------------------------------");
        System.out.println("------------- Menu " + i + " --------------");
        System.out.println("-----------------------------------");
    }

    public static void addContact(String name) {

        String path = "C:/Users/yashu/Desktop/Yashu/Projects/Java-Projects/Attempt 2/Core Java/Contact App/Contact Files";
        File f = new File(path);
        System.out.println("is file " + f.isFile());
        System.out.println("is directory " + f.isDirectory());

    }

    public static void main(String[] args) {

        run();

    }

}
