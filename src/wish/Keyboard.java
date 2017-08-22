package wish;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wish
 * File Name : Keyboard
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class Keyboard {
    public static int keyBoard(String s, String keypad) {
        if (keypad == null || keypad.length() == 0) return 0;
        int res = 0;
        int[][] board = new int[3][3];
        int k = 0;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {  //build int[][]
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = keypad.charAt(k++) - '0';
            }
        }

        int x = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                HashSet<Integer> temp = new HashSet<>();
                dfsNum(board, i, j, temp);
                map.put(board[i][j], temp);
            }
        }

        while (x < s.length() - 1) {
            HashSet<Integer> temp = map.get(s.charAt(x) - '0');
            if (temp.contains(s.charAt(x + 1) - '0')) {
                res++;
            } else if ((s.charAt(x) - '0') == (s.charAt(x + 1) - '0')){
                x++;
                continue;
            } else {
                res += 2;
            }
            x++;
        }

        return res;
    }

    public static void dfsNum(int[][] board, int i, int j, HashSet<Integer> set) {
        if (determineOneStep(board,i - 1, j)) {
            set.add(board[i - 1][j]);
        }
        if (determineOneStep(board,i + 1, j)) {
            set.add(board[i + 1][j]);
        }
        if (determineOneStep(board,i, j + 1)) {
            set.add(board[i][j + 1]);
        }
        if (determineOneStep(board,i, j - 1)) {
            set.add(board[i][j - 1]);
        }
        if (determineOneStep(board,i - 1, j - 1)) {
            set.add(board[i - 1][j - 1]);
        }
        if (determineOneStep(board,i + 1, j + 1)) {
            set.add(board[i + 1][j + 1]);
        }
        if (determineOneStep(board,i - 1, j + 1)) {
            set.add(board[i - 1][j + 1]);
        }
        if (determineOneStep(board,i + 1, j - 1)) {
            set.add(board[i + 1][j - 1]);
        }
    }

    public static boolean determineOneStep(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        return true;
    }
}
