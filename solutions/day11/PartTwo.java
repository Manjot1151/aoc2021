package solutions.day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class PartTwo {
    private static final int size = 10;
    private static HashSet<String> flashed = new HashSet<>();
    private static int[][] energyLevels;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day11"));
        energyLevels = new int[size][size];
        for (int i = 0; i < size; i++) {
            String line = in.nextLine();
            for (int j = 0; j < size; j++) {
                energyLevels[i] = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
            }
        }
        int steps = 0;
        while (flashed.size() != size * size) {
            steps++;
            flashed.clear();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    flash(i, j);
                }
            }
            if (flashed.size() == size * size)
                continue;

            for (String s : flashed) {
                int[] coord = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
                energyLevels[coord[0]][coord[1]] = 0;
            }
        }

        System.out.println(steps);
    }

    private static void flash(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            return;
        }

        energyLevels[i][j]++;

        if (energyLevels[i][j] >= 10 && !flashed.contains(i + " " + j)) {
            flashed.add(i + " " + j);
            flash(i - 1, j);
            flash(i + 1, j);
            flash(i, j - 1);
            flash(i, j + 1);
            flash(i - 1, j - 1);
            flash(i - 1, j + 1);
            flash(i + 1, j - 1);
            flash(i + 1, j + 1);
        }
    }
}