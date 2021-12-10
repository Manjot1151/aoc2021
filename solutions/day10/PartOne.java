package solutions.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day10"));
        long errorSum = 0;
        while (in.hasNextLine()) {
            String syntax = in.nextLine();
            List<Character> opened = new ArrayList<Character>();
            for (char c : syntax.toCharArray()) {
                if (c == '(' || c == '{' || c == '[' || c == '<') {
                    opened.add(c);
                } else {
                    if (c != ')') {
                        if (opened.get(opened.size() - 1) != c - 2) {
                            errorSum += (c == ']') ? 57 : c == '}' ? 1197 : 25137;
                            break;
                        } else {
                            opened.remove(opened.size() - 1);
                        }
                    } else {
                        if (opened.get(opened.size() - 1) != '(') {
                            errorSum += 3;
                            break;
                        } else {
                            opened.remove(opened.size() - 1);
                        }
                    }
                }
            }
        }
        System.out.println(errorSum);
    }
}