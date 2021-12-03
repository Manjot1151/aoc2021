package solutions.daythree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/daythree"));
        List<String> binaryNums = new ArrayList<String>();
        while (in.hasNextLine())
            binaryNums.add(in.nextLine());

        List<String> binaryNums2 = new ArrayList<String>(binaryNums);
        for (int i = 0; i < 12; i++) {
            if (binaryNums.size() == 1)
                break;
            int cnt1 = 0;
            for (int j = 0; j < binaryNums.size(); j++) {
                if (binaryNums.get(j).charAt(i) == '1')
                    cnt1++;
            }
            int index = i;
            int count1 = cnt1;
            binaryNums.removeIf(n -> n.charAt(index) == ((count1 >= ((binaryNums.size() + 1) / 2)) ? '0' : '1'));
        }
        for (int i = 0; i < 12; i++) {
            if (binaryNums2.size() == 1)
                break;
            int cnt1 = 0;
            for (int j = 0; j < binaryNums2.size(); j++) {
                if (binaryNums2.get(j).charAt(i) == '1')
                    cnt1++;
            }
            int index = i;
            int count1 = cnt1;
            binaryNums2.removeIf(n -> n.charAt(index) == ((count1 >= ((binaryNums2.size() + 1) / 2)) ? '1' : '0'));
        }
        System.out.println(Integer.parseInt(binaryNums.get(0), 2) * Integer.parseInt(binaryNums2.get(0), 2));
    }
}
