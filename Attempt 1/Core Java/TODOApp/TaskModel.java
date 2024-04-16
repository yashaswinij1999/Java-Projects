import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TaskModel {

    public static void addCategoryName(String name) {

        String path = "C:/Users/yashu/Desktop/Yashu/Project";
        File f = new File(path);
        Scanner sc = new Scanner(System.in);
        String str = name + ".txt";

        File[] files = f.listFiles();
        BufferedWriter bw = null;

        try {

            for (File f1 : files) {

                if (f1.getName().equals(str)) {

                    System.out.println("entered duplicate name , try again");
                    String catName = sc.next();
                    addCategoryName(catName);

                }

            }
            bw = new BufferedWriter(new FileWriter(str));
            bw.close();

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

    public static void addTask(String name, TaskBean t) {

        String path = "C:/Users/yashu/Desktop/Yashu/Project";

        File f = new File(path);
        String str = name + ".txt";

        BufferedWriter bw = null;
        List<TaskBean> l = null;
        LocalDateTime ldt = LocalDateTime.now();

        String sentence = t.getTaskName() + " : " + t.getDescription() + " : " + t.getPlannedDate() + " : "
                + t.getStatus() + " : " + t.getPriority() + " : " + t.getTags() + " : "
                + ldt;

        File[] files = f.listFiles();

        try {

            for (File f1 : files) {

                if (f1.getName().equals(str)) {

                    bw = new BufferedWriter(new FileWriter(str, true));
                    bw.write(sentence);
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

    public static boolean checkIfCategoryNameExists(String name) {

        Thread t = new Thread();

        String path = "C:/Users/yashu/Desktop/Yashu/Project";
        File f = new File(path);

        // System.out.println("is file exists = " + f.exists());
        // System.out.println("is file : " + f.isFile());
        // System.out.println("is directory : " + f.isDirectory());

        String str = name + ".txt";
        File[] files = f.listFiles();

        for (File f1 : files) {

            if (f1.getName().equals(str)) {

                System.out.println("file exists");
                return true;

            }

        }
        System.out.println("file not found");
        return false;

    }

    public static boolean loadCategory(String name, String taskName) {

        String path = "C:/Users/yashu/Desktop/Yashu/Project";
        File f = new File(path);

        // System.out.println("is file exists = " + f.exists());
        // System.out.println("is file : " + f.isFile());
        // System.out.println("is directory : " + f.isDirectory());

        String str = name + ".txt";

        File[] files = f.listFiles();

        for (File f1 : files) {

            if (f1.getName().equals(str)) {

                return true;

            }

        }
        System.out.println("file not found");
        return false;

    }

    public static void LoadTaskName(String CatName, String taskName, String existingName, String replacedName) {

        String path = "C:/Users/yashu/Desktop/Yashu/Project";
        File f = new File(path);

        BufferedReader br = null;
        BufferedWriter bw = null;

        List<String> l = new ArrayList<>();
        String str = CatName + ".txt";
        String line;

        File[] files = f.listFiles();

        try {

            for (File f1 : files) {

                if (f1.getName().equals(str)) {

                    br = new BufferedReader(new FileReader(f1));

                    while ((line = br.readLine()) != null) {

                        if (line.contains(taskName)) {

                            System.out.println(line);

                            line = line.replace(existingName, replacedName);
                            l.add(line);
                            bw = new BufferedWriter(new FileWriter(f1));

                        } else {

                            l.add(line);

                        }

                    }

                }

            }

            for (String s : l) {

                bw.write(s);
                bw.newLine();
                bw.flush();
                System.out.println(s);

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

    public static void deleteCategoryName(String name) {

        String path = "C:/Users/yashu/Desktop/Yashu/Project";
        File f = new File(path);

        // System.out.println("is file exists = " + f.exists());
        // System.out.println("is file : " + f.isFile());
        // System.out.println("is directory : " + f.isDirectory());

        String str = name + ".txt";

        File[] files = f.listFiles();

        for (File f1 : files) {

            if (f1.getName().equals(str)) {

                f1.delete();
            }

        }

    }

    public static void deleteTaskName(String catName, String taskName) {

        String path = "C:/Users/yashu/Desktop/Yashu/Project";
        File f = new File(path);

        // System.out.println("is file exists = " + f.exists());
        // System.out.println("is file : " + f.isFile());
        // System.out.println("is directory : " + f.isDirectory());

        BufferedReader br = null;
        String line = "";
        List<String> l;
        BufferedWriter bw = null;
        LinkedHashSet<String> st = new LinkedHashSet<>();

        String str = catName + ".txt";

        File[] files = f.listFiles();

        try {

            l = new ArrayList<>();

            for (File f1 : files) {

                if (f1.getName().equals(str)) {

                    br = new BufferedReader(new FileReader(f1));

                    while ((line = br.readLine()) != null) {

                        if (line.contains(taskName)) {

                            System.out.println(line);
                            line = line.replaceAll(line, "");

                            l.add(line);

                        }
                        l.add(line);

                        bw = new BufferedWriter(new FileWriter(f1));

                    }

                }

            }

            for (String s : l) {

                bw.write(s);
                bw.newLine();
                bw.flush();
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

    public static void listCateGory() {

        String path = "C:/Users/yashu/Desktop/Yashu/Project";
        File f = new File(path);

        File[] files = f.listFiles();

        for (File file : files) {

            if (file.getName().endsWith("txt")) {

                System.out.println(file.getName());

            }

        }

    }

    public static void listTasks(String catName) {

        String path = "C:/Users/yashu/Desktop/Yashu/Project";
        File f = new File(path);
        File[] files = f.listFiles();

        String line = "";
        String str = catName + ".txt";

        StatusCamparator sc = new StatusCamparator();
        BufferedReader br = null;
        TreeSet<String> t = new TreeSet<>(sc);
        BufferedWriter bw = null;

        try {

            for (File file : files) {

                if (file.getName().equals(str)) {

                    br = new BufferedReader(new FileReader(file));

                    while ((line = br.readLine()) != null) {

                        // System.out.println(line);
                        t.add(line);
                    }

                    // bw = new BufferedWriter(new FileWriter(file));

                }

            }

            for (String s : t) {

                System.out.println(s);
                // bw.write(s);
                // bw.newLine();
                // bw.flush();

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

    public static void searchCategoryName(String name) {

        String path = "C:/Users/yashu/Desktop/Yashu/Project";
        File f = new File(path);
        File[] files = f.listFiles();
        String str = name + ".txt";

        try {

            for (File f1 : files) {

                if (f1.getName().equals(str)) {

                    System.out.println(" file name " + name + " exists ");

                }
                throw new IllegalArgumentException("unable to find the file");

            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public static void searchTaskName(String CatName, String taskName) {

        String path = "C:/Users/yashu/Desktop/Yashu/Project";
        File f = new File(path);
        String str = CatName + ".txt";
        String line = "";
        BufferedReader br = null;

        File[] files = f.listFiles();

        try {

            for (File f1 : files) {

                int count = 1;

                if (f1.getName().equals(str)) {

                    br = new BufferedReader(new FileReader(f1));

                    while ((line = br.readLine()) != null) {

                        if (line.contains(taskName)) {

                            System.out.println(line);

                        }

                    }
                    count = 0;

                }

            }

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();

        }

    }

    public static <XSSFWorkbook> void exportToExcel() {

        XSSFWorkbook rf = new XSSFWorkbook

    }

}

class TestModel {

    public static void main(String[] args) {

        TaskModel.searchTaskName("yashu", "hopping");

    }

}