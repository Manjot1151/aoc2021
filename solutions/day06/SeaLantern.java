package solutions.day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class SeaLantern {
    public static long predictPopulation(int days) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("inputs/day06")).useDelimiter(",");
        HashMap<Integer, Long> timerCount = new HashMap<>();
        while (in.hasNextInt())
        {
            int timer = in.nextInt();
            timerCount.put(timer, timerCount.getOrDefault(timer, 0L) + 1);
        }
        while (days-->0)
        {
            HashMap<Integer, Long> newTimerCount = new HashMap<>();
            for (Entry<Integer, Long> e : timerCount.entrySet())
            {
                if (e.getKey() == 0)
                {
                    newTimerCount.put(6, newTimerCount.getOrDefault(6, 0L) + e.getValue());
                    newTimerCount.put(8, e.getValue());
                }
                else
                {
                    newTimerCount.put(e.getKey() - 1, newTimerCount.getOrDefault(e.getKey() - 1, 0L) + e.getValue());
                }
            }
            timerCount = newTimerCount;
        }
        return timerCount.values().stream().mapToLong(Long::longValue).sum();
    }
}
