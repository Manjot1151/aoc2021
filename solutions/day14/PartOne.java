package solutions.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PartOne {

    // This is a bruteforced solution. See part 2 for a more optimized solution.

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day14"));
        StringBuilder poly = new StringBuilder(in.nextLine());
        List<String[]> instructions = new ArrayList<>();
        in.nextLine();
        while (in.hasNextLine()) {
            instructions.add(in.nextLine().split(" -> "));
        }
        int steps = 10;
        while (steps-- > 0) {
            for (int i = 0; i < poly.length() - 1; i += 2) {
                for (String[] instr : instructions) {
                    if (poly.substring(i, i + 2).equals(instr[0])) {
                        poly.insert(i + 1, instr[1]);
                        break;
                    }
                }
            }
        }
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < poly.length(); i++) {
            char c = poly.charAt(i);
            int fr = freq.getOrDefault(poly.charAt(i), 0) + 1;
            freq.put(c, fr);
        }
        Collection<Integer> frequencies = freq.values();
        System.out.println(Collections.max(frequencies) - Collections.min(frequencies));
    }
}