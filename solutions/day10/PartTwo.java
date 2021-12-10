package solutions.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day10"));
        List<Long> scores = new ArrayList<Long>();
        while (in.hasNextLine()) {
            String syntax = in.nextLine();
            List<Character> opened = new ArrayList<Character>();
            for (char c : syntax.toCharArray()) {
                if (c == '(' || c == '{' || c == '[' || c == '<') {
                    opened.add(c);
                } else {
                    if (c != ')') {
                        if (opened.get(opened.size() - 1) != c - 2) {
                            opened.clear();
                            break;
                        } else {
                            opened.remove(opened.size() - 1);
                        }
                    } else {
                        if (opened.get(opened.size() - 1) != '(') {
                            opened.clear();
                            break;
                        } else {
                            opened.remove(opened.size() - 1);
                        }
                    }
                }
            }
            if (opened.size() != 0) {
                long score = 0;
                for (int i = opened.size() - 1; i >= 0; i--) {
                    char c = opened.get(i);
                    if (c != '(')
                        c += 2;
                    else
                        c++;
                    score *= 5;
                    score += c == ')' ? 1 : c == ']' ? 2 : c == '}' ? 3 : 4;
                }
                scores.add(score);
            }
        }
        Collections.sort(scores);
        System.out.println(scores.get(scores.size() / 2));
    }
}