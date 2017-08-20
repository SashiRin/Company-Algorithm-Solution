

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static int res = 0;

    public static int find(String s, String keypad) {


        int[][] board = new int[3][3];
        int k = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {  //build int[][]
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = keypad.charAt(k++) - '0';
            }
            System.out.println(Arrays.toString(board[i]));
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (s.charAt(0) - '0' == board[i][j]) {
                    dfs (s, board, i, j, 0, map, 0, 2);
                }
            }
        }

        return map.get(s);
    }
    public static void dfs(String s, int[][] board, int i, int j, int cur, HashMap<String, Integer> map, int step, int max) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (cur == s.length() || max < 0) return;

        int c = board[i][j];
        if (c == s.charAt(cur) - '0') {
            if (cur < s.length() - 1 && c == s.charAt(cur + 1) - '0') {
                cur++;
                map.put(s.substring(0, cur + 1), step);
            }
            if (!map.containsKey(s.substring(0, cur + 1))) {
                map.put(s.substring(0, cur + 1), step);
            } else {
                map.put(s.substring(0, cur + 1), Math.min(step, map.get(s.substring(0, cur + 1))));
            }
            max--;
            dfs(s, board,i - 1, j, cur + 1, map, step + 1, max);
            dfs(s, board,i + 1, j, cur + 1, map, step + 1, max);
            dfs(s, board, i, j - 1,cur + 1, map, step + 1, max);
            dfs(s, board, i, j + 1,cur + 1, map, step + 1, max);
            dfs(s, board,i - 1, j - 1,cur + 1, map, step + 1, max);
            dfs(s, board,i + 1, j + 1,cur + 1, map, step + 1, max);
            dfs(s, board,i - 1, j + 1,cur + 1, map, step + 1, max);
            dfs(s, board,i + 1, j - 1,cur + 1, map, step + 1, max);
            max++;
        } else {
            max--;
            dfs(s, board,i - 1, j, cur + 1, map, step + 1, max);
            dfs(s, board,i + 1, j, cur + 1, map, step + 1, max);
            dfs(s, board, i, j - 1,cur + 1, map, step + 1, max);
            dfs(s, board, i, j + 1,cur + 1, map, step + 1, max);
            dfs(s, board,i - 1, j - 1,cur + 1, map, step + 1, max);
            dfs(s, board,i + 1, j + 1,cur + 1, map, step + 1, max);
            dfs(s, board,i - 1, j + 1,cur + 1, map, step + 1, max);
            dfs(s, board,i + 1, j - 1,cur + 1, map, step + 1, max);
            max++;
        }
    }


    public static void main(String[] args) {

        String s = "4729";
        String keypad = "923857614";
        System.out.println(find(s, keypad));
    }
}