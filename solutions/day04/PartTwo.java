package solutions.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartTwo {
    private static int[] nums;
    private static List<int[][]> boards;
    private static int boardSize = 5;

    public static void main(String[] args) throws FileNotFoundException {
        parseInput();
        int wins = 0;
        for (int num : nums) {
            for (int b = 0; b < boards.size(); b++) {
                int[][] board = boards.get(b);
                if (board == null) {
                    continue;
                }
                for (int i = 0; i < boardSize; i++) {
                    for (int j = 0; j < boardSize; j++) {
                        board[i][j] = (board[i][j] == num) ? -1 : board[i][j];
                    }
                }
                if (isWinner(board)) {
                    wins++;
                    if (wins == boards.size()) {
                        int sum = 0;
                        for (int[] r : board) {
                            for (int c : r) {
                                if (c > 0) {
                                    sum += c;
                                }
                            }
                        }
                        System.out.printf("%d * %d = %d", sum, num, sum * num);
                    }

                    boards.remove(b);
                    boards.add(b, null);
                }
            }
        }
    }

    private static void parseInput() throws FileNotFoundException {
        Scanner in = new Scanner(new File("inputs/day04"));
        String[] numsStr = in.nextLine().split(",");
        nums = new int[numsStr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        boards = new ArrayList<int[][]>();
        while (in.hasNextLine()) {
            int[][] board = new int[boardSize][boardSize];
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    board[i][j] = in.nextInt();
                }
            }
            boards.add(board);
        }
    }

    private static boolean isWinner(int[][] board) {
        for (int i = 0; i < boardSize; i++) {
            boolean foundCol = true;
            boolean foundRow = true;
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] != -1)
                    foundCol = false;
                if (board[j][i] != -1)
                    foundRow = false;
            }
            if (foundRow || foundCol)
                return true;
        }
        return false;
    }
}
