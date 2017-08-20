package goldmanSachs;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : goldmanSachs
 * File Name : DotProduct
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class DotProduct {
    /**
     * 给两个数组求点乘（dot product）。
     * @param a
     * @param b
     * @return
     */
    public static int dotProdutc(int[] a, int[] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }
}
