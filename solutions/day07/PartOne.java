package solutions.day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PartOne {

    // deviation about median is minimum
    
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("inputs/day07")); 
        int[] positions = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(positions);
        int median = positions[positions.length/2];
        int deviation = 0;
        for (int pos : positions)
        {
            deviation += Math.abs(pos - median);
        }
        System.out.println(deviation);
    }
}
