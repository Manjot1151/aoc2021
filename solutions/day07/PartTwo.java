package solutions.day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PartTwo {

    // on differentiating, it is found that fuel consumed is minimum when reaching
    // within a range of mean +- 1

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day07"));
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int mean = 0;
        for (int i : nums) {
            mean += i;
        }
        mean /= nums.length;
        System.out.println(Math.min(fuelConsumption(nums, mean), fuelConsumption(nums, mean + 1)));
    }

    private static int fuelConsumption(int[] nums, int pos) {
        int fuelConsumed = 0;
        for (int i : nums) {
            int deviation = pos - i;
            fuelConsumed += (deviation * deviation + Math.abs(deviation)) / 2;
        }
        return fuelConsumed;
    }
}
