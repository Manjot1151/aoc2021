package solutions.day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day09"));
        List<int[]> grid = new ArrayList<int[]>();
        while (in.hasNextLine()) {
            int[] row = Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            grid.add(row);
        }
        int riskSum = 0;
        for (int i = 0; i < grid.size(); i++) {
            int[] row = grid.get(i);
            for (int j = 0; j < row.length; j++) {
                boolean isSafeCol = true;
                boolean isSafeRow = true;
                for (int k = (i == 0) ? i : i - 1; k <= i + 1 && k < grid.size(); k++) {
                    if (k == i)
                        continue;
                    if (grid.get(k)[j] <= grid.get(i)[j]) {
                        isSafeCol = false;
                        break;
                    }
                }
                if (!isSafeCol)
                    continue;
                for (int k = (j == 0) ? j : j - 1; k <= j + 1 && k < row.length; k++) {
                    if (k == j)
                        continue;
                    if (grid.get(i)[k] <= grid.get(i)[j]) {
                        isSafeRow = false;
                        break;
                    }
                }
                if (isSafeRow) {
                    riskSum += row[j] + 1;
                }
            }
        }
        System.out.println(riskSum);
    }
}