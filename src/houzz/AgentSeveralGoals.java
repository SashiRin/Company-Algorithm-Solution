package houzz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : AgentSeveralGoals
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class AgentSeveralGoals {
    /*
    基本上跟 LC 上面 walls and gates 很像，但是有一个agent （起点）和 several goals (终点) 问能不能从一个起点到达所有终点。
    矩阵类似这样：
    0 0 0 1 1 1
    A 1 0 1 G 1
    1 0 G 0 1 1
    1 0 0 1 0 1
    time : O(mn) space : O(mn);
     */
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );
    public static boolean AgentSeveralGoals(char[][] input) {
        int m = input.length;
        if (m == 0) return false;
        int n = input[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (input[row][col] == 'A') {
                    q.add(new int[] { row, col });
                    break;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {  // 遍历上下左右
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || input[r][c] == '1') {
                    continue;
                }
                if (input[r][c] == 'G') {
                    input[r][c] = '0';
                    System.out.println("dfsad");
                } else if (input[r][c] == '0') {
                    input[r][c] = '1';
                }
                q.add(new int[] { r, c });
            }
        }
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (input[row][col] == 'G') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] input = {
                {'0', '0', '0', '1', '1', '1'},
                {'A', '1', '0', '0', 'G', '1'},
                {'1', '0', 'G', '0', '1', '1'},
                {'1', '0', '0', '1', '0', '1'}
        };
        System.out.println(AgentSeveralGoals(input));
    }
}
