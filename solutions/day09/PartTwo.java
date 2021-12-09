package solutions.day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class PartTwo {
    private static List<int[]> grid;
    private static HashSet<String> traversed = new HashSet<String>();;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day09"));
        grid = new ArrayList<int[]>();
        while (in.hasNextLine()) {
            int[] row = Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            grid.add(row);
        }
        List<Integer> basins = new ArrayList<Integer>();
        for (int i = 0; i < grid.size(); i++) {
            int[] row = grid.get(i);
            for (int j = 0; j < row.length; j++) {
                if (traversed.contains(i + " " + j))
                    continue;
                basins.add(getBasinSize(i, j));
            }
        }
        Collections.sort(basins);
        int product = 1;
        for (int i = basins.size() - 1; i > basins.size() - 4; i--) {
            product *= basins.get(i);
        }
        System.out.println(product);
    }

    private static int getBasinSize(int i, int j) {
        if (traversed.contains(i + " " + j))
            return 0;
        else
            traversed.add(i + " " + j);
        if (grid.get(i)[j] == 9)
            return 0;

        int basinSize = 1;
        if (i != 0)
            basinSize += getBasinSize(i - 1, j);
        if (j != 0)
            basinSize += getBasinSize(i, j - 1);
        if (i != grid.size() - 1)
            basinSize += getBasinSize(i + 1, j);
        if (j != grid.get(i).length - 1)
            basinSize += getBasinSize(i, j + 1);
        return basinSize;
    }
}