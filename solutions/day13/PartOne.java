package solutions.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day13"));
        HashSet<String> points = new HashSet<String>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty())
                break;
            points.add(line);
        }

        String line = in.nextLine();
        HashSet<String> newPoints = new HashSet<>(points);
        if (line.contains("x")) {
            int x = Integer.parseInt(line.split("=")[1]);
            for (String s : points) {
                int[] p = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
                if (x == p[0])
                    newPoints.remove(p[0] + "," + p[1]);
                if (p[0] > x) {
                    newPoints.remove(p[0] + "," + p[1]);
                    newPoints.add((2 * x - p[0]) + "," + p[1]);
                }
            }
        } else if (line.contains("y")) {
            int y = Integer.parseInt(line.split("=")[1]);
            for (String s : points) {
                int[] p = Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
                if (y == p[1])
                    newPoints.remove(p[0] + "," + p[1]);
                if (p[1] > y) {
                    newPoints.remove(p[0] + "," + p[1]);
                    newPoints.add(p[0] + "," + (2 * y - p[1]));
                }
            }
        }
        points = newPoints;
        System.out.println(points.size());
    }
}