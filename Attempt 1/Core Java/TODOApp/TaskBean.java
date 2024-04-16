import java.io.Serializable;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class TaskBean implements Comparable, Serializable {

    private String taskName;
    private String description;
    private Date plannedEndDate;
    private String Status;
    private String priority;

    private String tags;
    private Date crdDate;

    public TaskBean(String taskName, String decription, Date plannedEndDate, String Status, String priority,
            String tags) {

        this.taskName = taskName;
        this.description = decription;
        this.plannedEndDate = plannedEndDate;
        this.Status = Status;
        this.priority = priority;
        this.tags = tags;

    }

    public TaskBean() {

    }

    public boolean equals(Object o1) {

        if (o1 instanceof TaskBean) {

            TaskBean t = (TaskBean) o1;

            if (this.taskName.equals(t.taskName) || this.description.equals(t.description)
                    || this.plannedEndDate == t.plannedEndDate || this.Status.equals(t.Status)
                    || this.priority.equals(t.priority)
                    || this.tags.equals(t.tags)) {
                return true;
            }

        }
        return false;
    }

    public int hashCode() {

        return (taskName + description + plannedEndDate + Status + priority + tags)
                .hashCode();

    }

    public String toString() {

        return taskName + taskName + description + plannedEndDate + Status + priority + tags;

    }

    public int compareTo(Object o) {

        if (o instanceof TaskBean) {

            TaskBean t = (TaskBean) o;

            return this.Status.compareTo(t.Status);

        } else {

            throw new IllegalArgumentException("Inavalid");
        }

    }

    public void setTaskName(String taskName) {

        if (Util.validate(taskName)) {
            this.taskName = taskName;
        }

    }

    public String getTaskName() {
        return taskName;
    }

    public void setDescription(String description) {

        if (Util.validate(description)) {
            this.description = description;
        }

    }

    public String getDescription() {
        return description;
    }

    public void setStatus(String status) {

        if (Util.validate(status)) {
            this.Status = status;
        }

    }

    public String getStatus() {
        return Status;
    }

    public void setPriority(String priority) {

        if (Util.validate(priority)) {
            this.priority = priority;
        }

    }

    public String getPriority() {
        return priority;
    }

    public void setTags(String tags) {

        if (Util.validate(tags)) {
            this.tags = tags;
        }

    }

    public String getTags() {
        return tags;
    }

    public void setPlannedDate(Date plannedEndDate) {

        this.plannedEndDate = plannedEndDate;

    }

    public Date getPlannedDate() {
        return plannedEndDate;
    }

}

class TestTaskBean {

    public static void main(String[] args) {

        try {

            Set<TaskBean> st = new TreeSet<>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dt1 = sdf.parse("18-08-2023");
            Date dt2 = sdf.parse("18-08-2023");

            TaskBean t1 = new TaskBean("milk", "buying milk", dt1, "completed", "low", "house,utinsil");
            TaskBean t2 = new TaskBean("milk", "buying milk", dt2, "wip", "low", "house,utinsil");
            TaskBean t3 = new TaskBean("milk", "buying milk", dt2, "notStarted", "low", "house,utinsil");
            st.add(t1);
            st.add(t2);
            st.add(t3);
            System.out.println(st);

        } catch (Exception e) {

            // TODO: handle exception
            e.printStackTrace();
        }

    }

}