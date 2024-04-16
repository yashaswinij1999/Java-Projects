import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AmmuContactApp {

    Scanner sc1;
    Scanner sc2;
    final String directory;
    File f;

    {
        sc1 = new Scanner(System.in);
        sc2 = new Scanner(System.in);
        directory = System.getProperty("user.dir");
        f = new File(directory);
        File[] fileArray;

    }

    public void startApp() {

        try {

            int result = menuOneOption();
            processMenuOneOption(result);

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public int menuOneOption() {

        int Option = 0;

        try {

            menu(1);
            System.out.println("Press 1 to Create Contacts Book");
            System.out.println("Press 2 to Load Contacts Book");
            System.out.println("Press 3 to Search contacts");
            System.out.println("Press 4 to List contacts");
            System.out.println("Press 5 for Birthday reminders");
            System.out.println("Press 6 to Exit");
            printNumberOfLines(1);

            System.out.println("Enter choice:");
            Option = sc1.nextInt();

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }
        return Option;

    }

    public void processMenuOneOption(int option) {

        try {

            switch (option) {

                case 1: {

                    createContactApp();
                    break;
                }
                case 2: {

                    loadContactsBook();
                    break;

                }
                case 3: {

                    searchContactApp();
                    break;

                }
                case 4: {

                    ListContactsApp();
                    break;

                }
                case 5: {

                    setBirthDayReminders();
                    break;

                }
                default: {

                    System.out.println("Enter valid input");

                }
                case 6: {

                    System.out.println("Bye Bye");
                    System.exit(0);

                }

            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public void startToCreateContactBook() {

        try {

            int result = menuTwoOption();
            processMenuTwoOption(result);

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }
    }

    public int menuTwoOption() {

        int option = 0;

        try {

            menu(2);
            System.out.println("Press 1 to Add a Contact");
            System.out.println("Press 2 to Edit a Contact");
            System.out.println("Press 3 to Remove a Contact");
            System.out.println("Press 4 to List the Contact");
            System.out.println("Press 5 to Search Contact");
            System.out.println("Press 6 to Go back");
            printNumberOfLines(1);

            System.out.println("Enter your choice ");
            option = sc1.nextInt();

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }
        return option;
    }

    public void processMenuTwoOption(int option) {

        try {

            switch (option) {

                case 1:
                    addContacts();
                    break;

                case 2:
                    editContact();
                    break;

                case 3:
                    removeContact();
                    break;

                case 4:
                    listTheContacts();
                    break;

                case 5:
                    searchContactName();
                    break;

                case 6:
                    System.out.println("previous menu");
                    startApp();
                    break;

                default:
                    System.out.println("invalid input in menuTwo");
                    startToCreateContactBook();
                    break;
            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }
    }

    public void createContactApp() {

        System.out.println();

        String fileName;
        String temp = "";
        boolean checkIfExists = false;
        f = new File(directory);
        File f1 = null;

        System.out.println("the enter the file name without adding .txt");
        fileName = sc1.next();

        if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
            f1 = new File(fileName);
        }

        File[] files = f.listFiles();

        try {

            for (File fi : files) {

                if (fi.getName().endsWith("txt")) {

                    if (fi.getName().equals(fileName)) {

                        checkIfExists = true;

                    }
                    if (checkIfExists == true) {

                        System.out.println("the entered file name is already present , please enter another");
                        temp = sc1.next();

                        if (temp.equals("back")) {

                            startApp();

                        } else {

                            if (temp.contains(".txt")) {
                                checkIfFileNameExists(temp);
                            } else {
                                temp = temp + ".txt";
                                checkIfFileNameExists(temp);
                                printNumberOfLines(1);
                            }

                        }

                    }

                }
                if (checkIfExists == false) {

                    f1.createNewFile();
                    startToCreateContactBook();

                } else {

                    System.out.println("We are unable to create a file");
                    startApp();
                    printNumberOfLines(1);
                }

            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public void checkIfFileNameExists(String fileName) {

        String temp;
        boolean checkIfExists = true;
        f = new File(directory);
        File fi = new File(fileName);

        try {

            File[] files = f.listFiles();

            for (File f1 : files) {

                if (f1.getName().endsWith(".txt")) {

                    if (f1.getName().equals(fileName)) {

                        checkIfExists = true;

                        if (checkIfExists == true) {

                            System.out.println("the emtered name is already prsent try another");
                            temp = sc1.next();

                            if (temp.equals("back")) {

                                startApp();

                            } else {

                                if (temp.contains(".txt")) {
                                    checkIfFileNameExists(temp);
                                } else {
                                    temp = temp + ".txt";
                                    checkIfFileNameExists(temp);
                                }

                            }

                        }

                    }

                } else {

                    fi.createNewFile();
                    startToCreateContactBook();
                    printNumberOfLines(1);

                }

            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public void loadContactsBook() {

        String fileName = "";

        f = new File(directory);

        File[] array = f.listFiles();

        for (File fi : array) {

            if (fi.getName().endsWith("txt")) {

                System.out.println(fi.getName());

            }

        }
        System.out.println("enter the file name which you want to load");
        fileName = sc1.next();

        for (File fi : array) {

            if (fi.getName().endsWith("txt")) {

                if (fi.getName().equals(fileName)) {
                    startToCreateContactBook();

                } else {
                    startApp();
                }
            }
        }

    }

    public void searchContactApp() {

        String fileName = "";
        f = new File(directory);
        File[] fileArray = f.listFiles();
        boolean checkIfExists = false;

        printNumberOfLines(1);
        System.out.println("enter the file name which you want to search");
        printNumberOfLines(1);
        fileName = sc1.next();

        try {

            for (File f1 : fileArray) {

                if (f1.getName().endsWith("txt")) {

                    if (f1.getName().equals(fileName)) {
                        checkIfExists = true;

                        if (checkIfExists == true) {
                            startToCreateContactBook();

                        }

                    } else {

                        if (checkIfExists == false) {
                            System.out.println("file not found");

                        }

                    }

                }

            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public void ListContactsApp() {

        f = new File(directory);
        File[] files = f.listFiles();

        for (File f1 : files) {

            if (f1.getName().endsWith("txt")) {
                System.out.println(f1.getName());

            }

        }
        startToCreateContactBook();
    }

    public void setBirthDayReminders() {

    }

    public void addContacts() {

        f = new File(directory);
        File[] fileArray = f.listFiles();
        String contactBookName;
        String name;
        String dob;
        String address;
        String petName;
        String email1;
        String email2;
        String createdDate;
        BufferedWriter bw = null;
        String temp = "";

        System.out.println("Enter name of the file where you add");
        contactBookName = sc1.next();

        System.out.println("Enter name");
        name = sc1.next();

        System.out.println("Enter dob in YYYY-MM-DD");
        dob = sc1.next();
        LocalDate dt = LocalDate.parse(dob);

        System.out.println("enter address");
        address = sc1.next();

        System.out.println("Enter petname");
        petName = sc1.next();

        System.out.println("enter email");
        email1 = sc1.next();

        System.out.println("enter email2");
        email2 = sc1.next();

        System.out.println("enter created date");
        createdDate = sc1.next();
        LocalDate crdt = LocalDate.parse(createdDate);

        for (File f1 : fileArray) {

            try {

                if (f1.getName().endsWith("txt")) {

                    if (f1.getName().equals(contactBookName)) {

                        bw = new BufferedWriter(new FileWriter(f1, true));
                        temp = name + " : " + dob + " : " + address + " : " + petName + " : " + email1 + " : " + email2
                                + " : " + crdt;
                        System.out.println(temp);
                        bw.write(temp);
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

    }

    public void editContact() {

        String contactName;
        String editWord;
        String replaceWord;
        BufferedReader br = null;
        String line = "";
        BufferedWriter bw = null;
        List<String> l = new ArrayList<>();

        System.out.println("Enter file name where you want to edit");
        contactName = sc1.next();

        System.out.println("the word which you want to edit");
        editWord = sc1.next();

        System.out.println("enter replace word");
        replaceWord = sc1.next();

        File[] fileArray = f.listFiles();

        for (File f1 : fileArray) {

            try {
                br = new BufferedReader(new FileReader(f1));

                if (f1.getName().equals(contactName)) {

                    while ((line = br.readLine()) != null) {

                        if (line.contains(editWord)) {
                            line = line.replace(editWord, replaceWord);
                            l.add(line);

                        } else {
                            l.add(line);
                        }

                    }

                }
                br.close();

                bw = new BufferedWriter(new FileWriter(f1));

                if (f1.getName().equals(contactName)) {

                    for (String s : l) {
                        bw.write(s);
                        bw.newLine();
                    }

                }

            } catch (Exception e) {

                // TODO: handle exception
                e.printStackTrace();

            } finally {

                try {

                    if (br != null) {
                        br.close();
                    }

                } catch (Exception e) {

                    // TODO: handle exception
                    e.printStackTrace();

                }

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
    }

    public void removeContact() {

        Scanner sc1 = new Scanner(System.in);

        System.out.println("Enter the file name in which you want to remove the contact");
        String contactBookName = sc1.next();

        System.out.println("enter the contact which you want to remove");
        String contact = sc1.next();

        String line = "";
        BufferedReader br = null;
        BufferedWriter bw = null;
        List<String> l;

        File f = new File(directory);
        File[] filearray = f.listFiles();

        for (File f1 : filearray) {

            try {

                br = new BufferedReader(new FileReader(f1));

                l = new ArrayList<>();

                if (f1.getName().endsWith(".txt")) {

                    while ((line = br.readLine()) != null) {

                        if (!line.contains(contact)) {
                            l.add(line);
                        }

                    }

                }
                br.close();

                bw = new BufferedWriter(new FileWriter(f1));
                for (String s : l) {
                    bw.write(s);
                    bw.newLine();
                }

            } catch (Exception e) {

                // TODO: handle exception
                e.printStackTrace();

            } finally {

                try {

                    if (br != null) {
                        br.close();
                    }

                } catch (Exception e) {

                    // TODO: handle exception
                    e.printStackTrace();

                }
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

    }

    public void listTheContacts() {

        int choice = 0;

        while (choice != 3) {

            System.out.println("Press 1 : to sort based on name");
            System.out.println("Press 2 : sort based on length ");
            System.out.println("Enter 3 to exit");
            printNumberOfLines(1);

            System.out.println("Enter choice");
            choice = sc1.nextInt();

            switch (choice) {

                case 1:
                    sortBasedOnName();
                    break;

                case 2:
                    sortBasedOnLength();
                    break;

                default:
                    System.out.println("enter right input");

                case 3:
                    System.out.println("bye bye");

            }

        }

    }

    public void sortBasedOnName() {

        System.out.println("Enter the file name in whih you want to sort");
        String fileName = sc1.next();

        f = new File(directory);
        File[] fileArray = f.listFiles();
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        List<String> l;
        StringNameComparator sc = null;

        for (File f1 : fileArray) {

            try {

                br = new BufferedReader(new FileReader(f1));
                sc = new StringNameComparator();
                l = new ArrayList<>();

                if (f1.getName().equals(fileName)) {

                    while ((line = br.readLine()) != null) {

                        l.add(line);
                        Collections.sort(l, sc);

                    }

                }
                br.close();

                bw = new BufferedWriter(new FileWriter(f1));

                for (String s : l) {
                    bw.write(s);
                    bw.newLine();
                }

            } catch (Exception e) {

                // TODO: handle exception
                e.printStackTrace();

            } finally {

                try {

                    if (br != null) {
                        br.close();
                    }

                } catch (Exception e) {

                    // TODO: handle exception
                    e.printStackTrace();

                }
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

    }

    public void sortBasedOnLength() {

        System.out.println("Enter the file name in whih you want to sort");
        String fileName = sc1.next();

        f = new File(directory);
        File[] fileArray = f.listFiles();
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        List<String> l = null;
        StringLengthComparator sl = null;

        for (File f1 : fileArray) {

            try {

                if (f1.getName().endsWith("txt")) {

                    if (f1.getName().equals(fileName)) {

                        br = new BufferedReader(new FileReader(f1));
                        sl = new StringLengthComparator();
                        l = new ArrayList<>();

                        while ((line = br.readLine()) != null) {

                            l.add(line);
                            Collections.sort(l, sl);

                        }

                    }
                    br.close();

                    bw = new BufferedWriter(new FileWriter(f1));

                    for (String s : l) {
                        bw.write(s);
                        bw.newLine();
                    }

                }

            } catch (Exception e) {

                // TODO: handle exception
                e.printStackTrace();

            } finally {

                try {

                    if (br != null) {
                        br.close();
                    }

                } catch (Exception e) {

                    // TODO: handle exception
                    e.printStackTrace();

                }
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

    }

    public void searchContactName() {

        System.out.println("enter the file name in which you want to search");
        String fileName = sc1.next();

        System.out.println("enter the contact Name which yoy want to search");
        String contactName = sc1.next();

        f = new File(directory);
        File[] fileArray = f.listFiles();
        String line;
        BufferedReader br = null;
        int count = 0;

        for (File f1 : fileArray) {

            try {

                if (f1.getName().endsWith("txt")) {

                    if (f1.getName().equals(fileName)) {

                        br = new BufferedReader(new FileReader(f1));

                        while ((line = br.readLine()) != null) {

                            if (line.contains(contactName)) {
                                count++;
                            }

                        }

                    }
                }

            } catch (Exception e) {

                // TODO: handle exception
                e.printStackTrace();

            }

        }
        System.out.println(
                "the contactName " + contactName + " ocurrs in  file name " + fileName + " " + count + " times ");

    }

    public void menu(int num) {

        System.out.println("-------------------------------------");
        System.out.println("                Menu " + num + "              ");
        System.out.println("-------------------------------------");

    }

    public void printNumberOfLines(int num) {

        for (int i = 1; i < num; i++) {
            System.out.println("");
        }

    }

}