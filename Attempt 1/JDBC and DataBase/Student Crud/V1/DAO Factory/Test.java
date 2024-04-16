import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        int choice = 0;

        System.out.println(" Please enter your choice ");
        choice = sc1.nextInt();

        if (choice == 1 || choice == 2) {

            DAO d = getInstance(choice);
            d.retrieve();

        } else {

            throw new IllegalArgumentException("Invalid Input");

        }

    }

    public static DAO getInstance(int choice) {

        while (choice != 3) {

            System.out.println("");
            System.out.println("press 1 to save data using file");
            System.out.println("press 2 to save data using database");
            System.out.println("press 3 to exit");
            System.out.println("");

            switch (choice) {

                case 1:
                    FileDao f = new FileDao();
                    return f;

                case 2:
                    DataBaseDAO d = new DataBaseDAO();
                    return d;

            }

        }
        throw new IllegalArgumentException("Invalid input");
    }

}
