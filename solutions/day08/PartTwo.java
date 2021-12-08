package solutions.day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PartTwo {

    // ugliest solution ever... but it works!

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day08"));
        long sumOfReadings = 0;
        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(" \\| ");
            String[] line0 = line[0].split(" ");
            List<Character>[] tenNums = new ArrayList[10];
            List<Character>[] nums = new ArrayList[10];
            char[] chars = new char[7];
            for (int i = 0; i < 10; i++) {
                tenNums[i] = stringToCharList(line0[i]);
            }
            for (int i = 0; i < 10; i++) {
                boolean remove = true;
                switch (tenNums[i].size()) {
                    case 2 -> {
                        nums[1] = new ArrayList<>(tenNums[i]);
                    }
                    case 4 -> {
                        nums[4] = new ArrayList<>(tenNums[i]);
                    }
                    case 3 -> {
                        nums[7] = new ArrayList<>(tenNums[i]);
                    }
                    case 7 -> {
                        nums[8] = new ArrayList<>(tenNums[i]);
                    }
                    default -> {
                        remove = false;
                    }
                }
                if (remove) {
                    tenNums[i] = null;
                }
            }
            List<Character>[] newNums = new ArrayList[10];
            newNums[7] = new ArrayList<>(nums[7]);
            newNums[7].removeAll(nums[1]);
            chars[0] = newNums[7].get(0); // A

            newNums[7] = new ArrayList<>(nums[7]);
            newNums[8] = new ArrayList<>(nums[8]);
            newNums[8].removeAll(nums[7]);
            newNums[8].add(chars[0]);
            nums[6] = new ArrayList<>(newNums[8]);

            newNums[4] = new ArrayList<>(nums[4]);
            newNums[4].removeAll(nums[1]);
            List<Character> bd = new ArrayList<>(newNums[4]);
            for (List<Character> l : tenNums) {
                if (l == null || l.size() != 6)
                    continue;
                if (!l.containsAll(nums[1])) {
                    nums[6] = new ArrayList<>(l);
                    l = null;
                    continue;
                }
                if (!l.containsAll(bd)) {
                    nums[0] = new ArrayList<>(l);
                    l = null;
                    continue;
                } else {
                    nums[9] = new ArrayList<>(l);
                    l = null;
                    continue;
                }
            }

            newNums[8] = new ArrayList<>(nums[8]);
            newNums[8].removeAll(nums[6]);
            chars[2] = newNums[8].get(0); // C

            newNums[1] = new ArrayList<>(nums[1]);
            newNums[1].remove((Character) chars[2]);
            chars[5] = newNums[1].get(0); // F

            newNums[8] = new ArrayList<>(nums[8]);
            newNums[8].removeAll(nums[9]);
            chars[4] = newNums[8].get(0); // E

            newNums[8] = new ArrayList<>(nums[8]);
            newNums[8].removeAll(nums[0]);
            chars[3] = newNums[8].get(0); // D

            bd.remove((Character) chars[3]);
            chars[1] = bd.get(0);
            newNums[8] = new ArrayList<>(nums[8]);
            for (int i = 0; i < 6; i++) {
                newNums[8].remove((Character) chars[i]);
            }
            chars[6] = newNums[8].get(0);
            nums[2] = new ArrayList<>(List.of(chars[0], chars[2], chars[3], chars[4], chars[6]));
            nums[3] = new ArrayList<>(List.of(chars[0], chars[2], chars[3], chars[5], chars[6]));
            nums[5] = new ArrayList<>(List.of(chars[0], chars[1], chars[3], chars[5], chars[6]));

            String[] line1 = line[1].split(" ");
            int readingInt = 0;
            for (int i = 0; i < 4; i++) {
                List<Character> reading = stringToCharList(line1[i]);
                for (int j = 0; j < nums.length; j++) {
                    List<Character> num = nums[j];
                    if (reading.size() == num.size() && reading.containsAll(num)) {
                        readingInt = readingInt * 10 + j;
                        break;
                    }
                }
            }
            sumOfReadings += readingInt;
        }
        System.out.println(sumOfReadings);
    }

    private static List<Character> stringToCharList(String str) {
        List<Character> chars = str
                .chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());

        return chars;
    }
}
