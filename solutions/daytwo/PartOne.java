package solutions.daytwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/daytwo"));
        int depth = 0;
        int pos = 0;
        while (in.hasNextLine())
        {
            String[] instruction = in.nextLine().split(" ");
            int n = Integer.parseInt(instruction[1]);
            switch (instruction[0])
            {
                case "down":
                    depth += n;
                    break;

                case "up":
                    depth -= n;
                    break;
                
                case "forward":
                    pos += n;
                    break;
            }
        }
        System.out.println("Depth: " + depth);
        System.out.println("Pos: " + pos);
        System.out.println("Product: " + depth*pos);
    }
}
