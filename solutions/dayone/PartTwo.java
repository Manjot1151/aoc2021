package solutions.dayone;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/dayone"));
        List<Integer> a = new ArrayList<Integer>();
        int cnt = 0;
        while (in.hasNextInt()) {
            a.add(in.nextInt());
        }
        for (int i = 0; i < a.size() - 3; i++) {
            if (a.get(i) < a.get(i + 3))
                cnt++;
        }
        System.out.println(cnt);
    }
}
