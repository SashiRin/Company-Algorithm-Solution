package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : Sqrt
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class Sqrt {
    public static double mySqrt(double x) {
        if (x <= 0) return 0;
        long res = (long) (x * 1000000); // 0.001;
        long low = 1, high = res;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == res){
                return (double) mid / 1000;
            } else if (mid * mid < res) {
                low = (long) mid + 1;
            } else {
                high = (long) mid - 1;
            }
        }
        if (high * high < res) return (double) high / 1000;
        else return (double) low / 1000;
    }
    public static double mySqrt2(double x, double eps) {
        if (x <= 0) return 0;
        double low = 1, high = x;
        double res = (low + high) / 2;
        double mid = res *res;
        while (Math.abs(mid - x) > eps) {
            if (mid > x) high = res;
            else low = res;
            res = (low + high) / 2;
            mid = res * res;
        }
        return res;
    }
    public static double mySqrt3(double x, double eps) {
        if (x <= 0) return 0;
        double res = x;//最终
        double temp = 0;
        while (Math.abs(res - temp) > eps) {
            temp = res;
            res = (res + x/res) / 2;
        }
        return res;
    }
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        long low = 1, high = x;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == x){
                return (int) mid;
            } else if (mid * mid < x) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        if (high * high < x) return (int) high;
        else return (int) low;
    }
    //no one can explain exact the time complexity about Newton Method NP
    public int mySqrt2(int x) {
        if (x <= 0) return 0;
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

}
