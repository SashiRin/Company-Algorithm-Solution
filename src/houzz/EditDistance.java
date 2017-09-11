package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : EditDistance
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        //f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
        //f(i, j - 1) represents insert operation
        //f(i - 1, j) represents delete operation
        //f(i - 1, j - 1) represents replace operation
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)//f(0, k) = f(k, 0) = k
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i + 1][j + 1]++;//step+1 because we use one insert/delete/replace
                }
            }
        }
        return cost[m][n];
    }

}
