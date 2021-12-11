package solutions.day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class PartOne {
    private static final int size = 10;
    private static HashSet<String> flashed = new HashSet<>();
    private static int[][] energyLevels;
    private static int flashCount = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day11"));
        energyLevels = new int[size][size];
        for (int i = 0; i < size; i++) {
            String line = in.nextLine();
            for (int j = 0; j < size; j++) {
                energyLevels[i] = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
            }
        }
        int steps = 100;
        while (steps-- > 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    flash(i, j);
                }
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (energyLevels[i][j] >= 10) {
                        energyLevels[i][j] = 0;
                    }
                }
            }
            flashed.clear();
        }

        System.out.println(flashCount);
    }

    private static void flash(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            return;
        }

        energyLevels[i][j]++;

        if (energyLevels[i][j] >= 10 && !flashed.contains(i + " " + j)) {
            flashed.add(i + " " + j);
            flashCount++;
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