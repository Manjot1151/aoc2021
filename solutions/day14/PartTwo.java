package solutions.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day14"));
        String poly = in.nextLine();
        List<String[]> instructions = new ArrayList<>();
        in.nextLine();
        while (in.hasNextLine()) {
            instructions.add(in.nextLine().split(" -> "));
        }
        Map<String, Long> pairFreq = new HashMap<>();
        for (int i = 0; i < poly.length() - 1; i++) {
            String pair = poly.substring(i, i + 2);
            pairFreq.put(pair, pairFreq.getOrDefault(pair, 0l) + 1);
        }
        int steps = 40;
        while (steps-- > 0) {
            Map<String, Long> newPairFreq = new HashMap<>(pairFreq);
            for (String[] instr : instructions) {
                if (pairFreq.getOrDefault(instr[0], 0l) == 0)
                    continue;
                newPairFreq.put(instr[0], newPairFreq.getOrDefault(instr[0], 0l) - pairFreq.getOrDefault(instr[0], 0l));
                String pair1 = instr[0].charAt(0) + instr[1];
                String pair2 = instr[1] + instr[0].charAt(1);
                long freq = pairFreq.getOrDefault(instr[0], 0l);
                newPairFreq.put(pair1, newPairFreq.getOrDefault(pair1, 0l) + freq);
                newPairFreq.put(pair2, newPairFreq.getOrDefault(pair2, 0l) + freq);
            }
            pairFreq = newPairFreq;
        }
        Map<Character, Long> charFreq = new HashMap<>();
        charFreq.put(poly.charAt(poly.length() - 1), 1l);
        for (Map.Entry<String, Long> e : pairFreq.entrySet()) {
            if (e.getValue() == 0)
                continue;
            char c = e.getKey().charAt(0);
            charFreq.put(c, charFreq.getOrDefault(c, 0l) + e.getValue());
        }
        Collection<Long> frequencies = charFreq.values();
        System.out.println(Collections.max(frequencies) - Collections.min(frequencies));
    }
}