import java.util.Comparator;

public class StringNameComparator implements Comparator {

    public int compare(Object o1, Object o2) {

        String s1 = (String) o1;
        String s2 = (String) o2;

        if (s1 instanceof String && s2 instanceof String) {

            return s1.compareTo(s2);

        }
        throw new IllegalArgumentException();
    }

}
