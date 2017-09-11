package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : DistanceOfBitsBetweenTwoIntegers
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class DistanceOfBitsBetweenTwoIntegers {
    /**
     * 1 -> 01; 2 -> 10; dist = 2;
       先十进制转化二进制，然后就是minDistance函数的调用
     */
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

    public static String toBinary(int num) {  // 一种十进制转化成二进制方法
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            if (num % 2 == 1) {
                sb.append(1);    //该方法对负数不成立
            } else {
                sb.append(0);
            }
            num = num/2;
        }
        String s = sb.reverse().toString();
        return s;
    }

    public static void main(String[] args) {
        int num = 10;
        String j = Integer.toBinaryString(num);  // 一种十进制转化成二进制方法
        System.out.println(toBinary(10));
    }
}
