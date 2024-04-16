import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileApp {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int ch = 0;
        String name = "";
        int age = 0;
        String dob = "";
        int std = 0;
        String sentence = "";
        BufferedWriter bw = null;
        BufferedReader br = null;
        List<String> l = null;
        String existingName = "";
        String replacedName = "";

        System.out.println("enter the path where you want to write");
        String path = sc1.nextLine();

        File f = new File(path);
        System.out.println("is file " + f.isFile());
        System.out.println(" does it exists " + f.exists());
        System.out.println(" is directory " + f.isDirectory());

        File[] array = f.listFiles();

        for (File f1 : array) {

            if (f1.isFile() && f1.exists() && f1.getName().endsWith("txt")) {

                System.out.println("f1.getName = " + f1.getName());

                while (ch != 5) {

                    System.out.println("");
                    System.out.println("press 1 to add");
                    System.out.println("press 2 to update");
                    System.out.println("press 3 to delete");
                    System.out.println("press 4 to retrieve");
                    System.out.println("press 5 to exit");
                    System.out.println("");
                    System.out.println("enter your choice");
                    ch = sc1.nextInt();

                    switch (ch) {

                        case 1:
                            System.out.println("enter name");
                            name = sc1.next();

                            System.out.println("enter age");
                            age = sc1.nextInt();

                            System.out.println("enter dob");
                            dob = sc1.next();

                            System.out.println("enter std");
                            std = sc1.nextInt();

                            sentence = " name " + name + " age " + age + " dob " + dob + " std " + std;
                            // System.out.println(" sentence " + sentence);

                            try {

                                bw = new BufferedWriter(new FileWriter(f1, true));
                                l = new ArrayList<>();
                                l.add(sentence);

                                for (String s : l) {

                                    System.out.println(s);
                                    bw.write(s);
                                    bw.newLine();

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

                            break;

                        case 2:

                            System.out.println("enter name ");
                            existingName = sc1.next();

                            System.out.println("enter replaced name ");
                            replacedName = sc1.next();

                            l = new ArrayList<>();

                            try {

                                br = new BufferedReader(new FileReader(f1));

                                while ((sentence = br.readLine()) != null) {

                                    if (sentence.contains(existingName)) {

                                        sentence = sentence.replace(existingName, replacedName);
                                        l.add(sentence);

                                    } else {

                                        l.add(sentence);

                                    }

                                }
                                br.close();

                                bw = new BufferedWriter(new FileWriter(f1));
                                for (String s : l) {

                                    System.out.println(s);
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

                            break;

                        case 3:
                            System.out.println("to delete");

                            System.out.println("enter name ");
                            existingName = sc1.next();

                            System.out.println("enter deleted name ");
                            replacedName = sc1.next();

                            l = new ArrayList<>();

                            try {

                                br = new BufferedReader(new FileReader(f1));

                                while ((sentence = br.readLine()) != null) {

                                    if (sentence.contains(existingName)) {

                                        sentence = sentence.replaceAll(existingName, "");

                                    } else {

                                        l.add(sentence);

                                    }

                                }
                                br.close();

                                bw = new BufferedWriter(new FileWriter(f1));
                                for (String s : l) {

                                    System.out.println(s);
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
                            break;

                        case 4:
                            System.out.println("to retrieve");

                            try {

                                br = new BufferedReader(new FileReader(f1));

                                while ((sentence = br.readLine()) != null) {

                                    System.out.println(sentence);

                                }

                            } catch (Exception e) {

                                // TODO: handle exception
                                e.printStackTrace();

                            }

                            break;

                        default:
                            System.out.println("invalid ");
                            break;

                        case 5:
                            System.out.println("ok bye bye");

                    }

                }

            }

        }

    }
}