package solutions.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class PartOne {
    private static Map<String, ArrayList<String>> paths = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day12"));
        while (in.hasNextLine()) {
            String[] caves = in.nextLine().split("-");
            if (!paths.containsKey(caves[0]))
                paths.put(caves[0], new ArrayList<String>());
            if (!paths.containsKey(caves[1]))
                paths.put(caves[1], new ArrayList<String>());
            if (!caves[1].equals("start"))
                paths.get(caves[0]).add(caves[1]);
            if (!caves[0].equals("start"))
                paths.get(caves[1]).add(caves[0]);
        }
        System.out.println(findPaths("start", new HashSet<String>()));
    }

    private static int findPaths(String currentCave, HashSet<String> hasVisited) {
        if (currentCave.equals("end"))
            return 1;
        if (hasVisited.contains(currentCave) && isLowerCase(currentCave))
            return 0;
        HashSet<String> newHasVisited = new HashSet<>(hasVisited);
        newHasVisited.add(currentCave);

        int pathsFound = 0;
        for (String nextCave : paths.get(currentCave)) {
            pathsFound += findPaths(nextCave, newHasVisited);
        }
        return pathsFound;
    }

    private static boolean isLowerCase(String s) {
        return s.equals(s.toLowerCase());
    }
}