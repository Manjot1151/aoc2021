package solutions.dayone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/dayone"));
        List<Integer> nums = new ArrayList<Integer>();
        int cnt = 0;
        while (in.hasNextInt()) {
            nums.add(in.nextInt());
        }
        for (int i = 0; i < nums.size() - 3; i++) {
            if (nums.get(i) < nums.get(i + 3))
                cnt++;
        }
        System.out.println(cnt);
    }
}
