import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Util {

    public static boolean validate(String name) {

        if (name == null || name.equals("")) {
            System.out.println("name cannot be null");
            return false;
        }

        if (name.trim().equals("")) {
            System.out.println("when trimmed name is null");
            return false;
        }

        if (!Character.isLetter(name.charAt(0))) {
            System.out.println("Character is not starting with letter");
            return false;
        }

        if (name.split(" ").length > 1) {
            System.out.println("the word consists of more 2 words");
            return false;
        }

        for (int i = 1; i < name.length(); i++) {

            char c = name.charAt(i);

            if (!(Character.isDigit(c) || Character.isLetter(c))) {
                System.out.println("character is not digit or ltter");
                return false;
            }

        }
        return true;

    }

}
