package ixl;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : ixl
 * File Name : GridGame
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class GridGame {
    public static long countX(String[] steps) {
        long res = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int i = 0; i < steps.length; i++) {
            int blank = steps[i].indexOf(" ");
            int a=Integer.parseInt(steps[i].substring(0,blank));
            minX = Math.min(minX, a);
            int b=Integer.parseInt(steps[i].substring(blank+1));
            minY = Math.min(minY, b);
        }
        res = minX * minY;
        return res;
    }

    public static void main(String[] args) {
        String[] s = {"2 3", "3 7", "4 1"};
        System.out.println(countX(s));
    }
}
