
import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class TaskManager {

    public static void main(String[] args) {

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        int ch = 0;
        String name, taskName, decription, PlannedEndDate, Status, Priority, tags, ExistingName, replacedName;

        BufferedWriter bw = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        StatusCamparator sc = new StatusCamparator();
        TreeSet<TaskBean> st = new TreeSet<>();

        Logger log1 = Logger.getInstance();
        log1.log("Task Manager Started");

        try {

            while (ch != 7) {

                System.out.println("");
                System.out.println("Press 1 to Add Category");
                System.out.println("Press 2 to Load Category");
                System.out.println("Press 3 to Delete Category");
                System.out.println("Press 4 to List Category");
                System.out.println("Press 5 to Search Category");
                System.out.println("Press 6 to Export Category");
                System.out.println("Press 7 to Exit Category");
                System.out.println("");
                System.out.println("Enter your choice");
                ch = sc1.nextInt();

                switch (ch) {

                    case 1:
                        log1.log("adding category name");

                        System.out.println("Enter Category Name ");
                        name = sc1.next();

                        if (Util.validate(name)) {

                            TaskModel.addCategoryName(name);
                            log1.log("File created");

                            while (ch != 6) {

                                System.out.println("");
                                System.out.println("Press 1 to Add task");
                                System.out.println("Press 2 to Load task");
                                System.out.println("Press 3 to Delete task");
                                System.out.println("Press 4 to List task");
                                System.out.println("Press 5 to Search task");
                                System.out.println("Press 6 to Exit Category");
                                System.out.println("");
                                System.out.println("Enter your choice");
                                ch = sc1.nextInt();

                                switch (ch) {

                                    case 1:

                                        System.out.println("Enter task name");
                                        taskName = sc1.next();

                                        System.out.println("Enter decription of the task");
                                        decription = sc2.nextLine();

                                        System.out.println("Enter planned date in dd-MM-YYYY Format");
                                        PlannedEndDate = sc1.next();

                                        System.out.println("Enter status = notstarted,complted,WIP");
                                        Status = sc1.nextLine();

                                        System.out.println("Enter priority = high,low,medium");
                                        Priority = sc1.next();

                                        System.out.println("Enter the tags");
                                        tags = sc2.nextLine();

                                        Date dt1 = sdf.parse(PlannedEndDate);

                                        TaskBean t = new TaskBean(taskName, decription, dt1, Status, Priority,
                                                tags);

                                        TaskModel.addTask(name, t);
                                        break;

                                    case 2:

                                        log1.log("loading task Name ");
                                        System.out.println("Enter the catName");
                                        name = sc1.next();

                                        System.out.println("Enter the taskName which you want to load ");
                                        taskName = sc1.next();

                                        if (Util.validate(name) && Util.validate(taskName)) {

                                            if (TaskModel.checkIfCategoryNameExists(name)) {

                                                System.out
                                                        .println("enter the existing status name ");
                                                ExistingName = sc1.next();

                                                System.out.println("Enter the replaced status name ");
                                                replacedName = sc1.next();

                                                TaskModel.LoadTaskName(name, taskName, ExistingName, replacedName);
                                                log1.log("updated successfully");
                                                System.out.println("Updated the status successFully");

                                            }

                                        }
                                        break;

                                    case 3:

                                        log1.log("entering deleting the task");
                                        System.out.println("enter category Name");
                                        name = sc1.next();

                                        if (Util.validate(name) && TaskModel.checkIfCategoryNameExists(name)) {

                                            System.out.println("enter taskName");
                                            taskName = sc1.next();

                                            if (Util.validate(taskName)) {

                                                TaskModel.searchTaskName(name, taskName);
                                                log1.log("able to find the task name in a file");

                                            }
                                        }
                                        break;

                                    case 5:

                                        log1.log("search tasks");
                                        System.out.println(
                                                "enter the category name in which you want to serach the task");
                                        name = sc1.next();

                                        System.out.println("enter the task Name");
                                        taskName = sc1.next();

                                        if (Util.validate(name) && Util.validate(taskName)) {

                                            if (TaskModel.checkIfCategoryNameExists(name)) {

                                                TaskModel.searchTaskName(name, taskName);

                                            }

                                        }

                                        break;

                                    default:
                                        System.out.println("InValid Task Input");
                                        break;

                                    case 6:
                                        System.out.println("bye bye");

                                }

                            }

                        }

                        break;

                    case 2:
                        log1.log("Loading category Name");

                        System.out.println("Enter the category which you want to load");
                        name = sc1.next();

                        if (Util.validate(name)) {

                            if (TaskModel.checkIfCategoryNameExists(name)) {

                                while (ch != 6) {

                                    System.out.println("");
                                    System.out.println("Press 1 to Add task");
                                    System.out.println("Press 2 to Load task");
                                    System.out.println("Press 3 to Delete task");
                                    System.out.println("Press 4 to List task");
                                    System.out.println("Press 5 to Search task");
                                    System.out.println("Press 6 to Exit Category");
                                    System.out.println("");
                                    System.out.println("Enter your choice");
                                    ch = sc1.nextInt();

                                    switch (ch) {

                                        case 1:
                                            Date dt = new Date();

                                            System.out.println("Enter task name");
                                            taskName = sc1.next();

                                            System.out.println("Enter decription of the task");
                                            decription = sc2.nextLine();

                                            System.out.println("Enter planned date in dd-MM-YYYY Format");
                                            PlannedEndDate = sc1.next();

                                            System.out.println("Enter status = notstarted,complted,WIP");
                                            Status = sc1.next();

                                            System.out.println("Enter priority = high,low,medium");
                                            Priority = sc1.next();

                                            System.out.println("Enter the tags");
                                            tags = sc2.nextLine();

                                            Date dt1 = sdf.parse(PlannedEndDate);

                                            TaskBean t = new TaskBean(taskName, decription, dt1, Status, Priority,
                                                    tags);

                                            TaskModel.addTask(name, t);
                                            break;

                                        case 2:
                                            log1.log("loading task Name ");
                                            System.out.println("Enter the catName");
                                            name = sc1.next();

                                            System.out.println("Enter the taskName which you want to load ");
                                            taskName = sc1.next();

                                            if (Util.validate(name) && Util.validate(taskName)) {

                                                if (TaskModel.checkIfCategoryNameExists(name)) {

                                                    System.out
                                                            .println("enter the existing status name ");
                                                    ExistingName = sc1.next();

                                                    System.out.println("Enter the replaced status name ");
                                                    replacedName = sc1.next();

                                                    TaskModel.LoadTaskName(name, taskName, ExistingName, replacedName);
                                                    log1.log("updated succesfully");

                                                }
                                            }
                                            break;

                                        case 3:

                                            log1.log("entering deleting the task");
                                            System.out.println("enter category Name");
                                            name = sc1.next();

                                            System.out.println("enter taskName");
                                            taskName = sc1.next();

                                            if (Util.validate(name) && Util.validate(taskName)) {

                                                if (TaskModel.checkIfCategoryNameExists(name)) {

                                                    TaskModel.deleteTaskName(name, taskName);
                                                    System.out.println("task deleted");
                                                    log1.log("deleted successfully");

                                                }

                                            }
                                            break;

                                        case 5:
                                            log1.log("search tasks");
                                            System.out.println(
                                                    "enter the category name in which you want to serach the task");
                                            name = sc1.next();

                                            System.out.println("enter the task Name");
                                            taskName = sc1.next();

                                            if (Util.validate(name) && Util.validate(taskName)) {

                                                if (TaskModel.checkIfCategoryNameExists(name)) {

                                                    TaskModel.searchTaskName(name, taskName);

                                                }

                                            }

                                            break;

                                        default:
                                            System.out.println("InValid Task Input");
                                            break;

                                        case 7:
                                            System.out.println("bye bye");

                                    }

                                }

                            }

                        }
                        break;

                    case 3:
                        log1.log("Delete category");
                        System.out.println("enter the category name which you want to delete");
                        name = sc1.next();

                        if (Util.validate(name)) {

                            TaskModel.deleteCategoryName(name);
                            log1.log("file deleted successfully");
                            System.out.println("deleted succesfuuly");

                        }

                        break;

                    case 4:

                        log1.log("listing category");
                        TaskModel.listCateGory();
                        break;

                    case 5:
                        log1.log("search category Name");
                        System.out.println("enter category name which you want to search");
                        name = sc1.next();

                        if (Util.validate(name) && TaskModel.checkIfCategoryNameExists(name)) {

                            TaskModel.searchCategoryName(name);

                        }

                        break;

                    default:
                        System.out.println("Invalid Input");
                        break;

                    case 7:
                        System.out.println("bye bye");

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

}
