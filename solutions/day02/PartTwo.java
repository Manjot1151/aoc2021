package solutions.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day02"));
        int depth = 0;
        int pos = 0;
        int aim = 0;
        while (in.hasNextLine()) {
            String[] instruction = in.nextLine().split(" ");
            int n = Integer.parseInt(instruction[1]);
            switch (instruction[0]) {
                case "down":
                    aim += n;
                    break;

                case "up":
                    aim -= n;
                    break;

                case "forward":
                    pos += n;
                    depth += aim * n;
                    break;
            }
        }
        System.out.println("Depth: " + depth);
        System.out.println("Pos: " + pos);
        System.out.println("Product: " + depth * pos);
    }
}
