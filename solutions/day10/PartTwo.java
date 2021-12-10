package solutions.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day10"));
        List<Long> scores = new ArrayList<Long>();
        while (in.hasNextLine()) {
            String syntax = in.nextLine();
            Stack<Character> opened = new Stack<Character>();
            for (char c : syntax.toCharArray()) {
                if (c == '(' || c == '{' || c == '[' || c == '<') {
                    opened.push(c);
                } else {
                    if (c != ')') {
                        if (opened.peek() != c - 2) {
                            opened.clear();
                            break;
                        } else {
                            opened.pop();
                        }
                    } else {
                        if (opened.peek() != '(') {
                            opened.clear();
                            break;
                        } else {
                            opened.pop();
                        }
                    }
                }
            }
            if (opened.size() != 0) {
                long score = 0;
                while (opened.size() != 0) {
                    char c = opened.pop();
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