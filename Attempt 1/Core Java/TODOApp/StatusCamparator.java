import java.util.Comparator;

import javax.swing.text.TabStop;

public class StatusCamparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        if (o1 instanceof String && o1 instanceof String) {

            String t1 = (String) o1;
            String t2 = (String) o2;

            return t2.compareTo(t1);

        }
        throw new IllegalArgumentException("Invalid input");
    }

}
