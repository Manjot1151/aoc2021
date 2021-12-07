package solutions.day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartOne {
    private static int size = 1000;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day05"));
        int[][] plane = new int[size][size];
        while (in.hasNextLine()) {
            String[] ends = in.nextLine().split(" -> ");
            String[] end1 = ends[0].split(",");
            String[] end2 = ends[1].split(",");
            int x1 = Integer.parseInt(end1[0]);
            int y1 = Integer.parseInt(end1[1]);
            int x2 = Integer.parseInt(end2[0]);
            int y2 = Integer.parseInt(end2[1]);
            if (x1 != x2 && y1 != y2)
                continue;
            int incX = (int) Math.signum(x2 - x1);
            int incY = (int) Math.signum(y2 - y1);
            for (int i = 0; i <= Math.abs(x2 - x1) || i <= Math.abs(y2 - y1); i++) {
                plane[x1 + i * incX][y1 + i * incY]++;
            }
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // System.out.print(plane[i][j] + " ");
                if (plane[i][j] >= 2) {
                    count++;
                }
            }
            // System.out.println();
        }
        System.out.println("Overlaps: " + count);
    }
}
