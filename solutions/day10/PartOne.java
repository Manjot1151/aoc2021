package solutions.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day10"));
        long errorSum = 0;
        while (in.hasNextLine()) {
            String syntax = in.nextLine();
            Stack<Character> opened = new Stack<Character>();
            for (char c : syntax.toCharArray()) {
                if (c == '(' || c == '{' || c == '[' || c == '<') {
                    opened.push(c);
                } else {
                    if (c != ')') {
                        if (opened.peek() != c - 2) {
                            errorSum += (c == ']') ? 57 : c == '}' ? 1197 : 25137;
                            break;
                        } else {
                            opened.pop();
                        }
                    } else {
                        if (opened.peek() != '(') {
                            errorSum += 3;
                            break;
                        } else {
                            opened.pop();
                        }
                    }
                }
            }
        }
        System.out.println(errorSum);
    }
}