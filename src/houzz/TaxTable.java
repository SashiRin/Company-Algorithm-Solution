package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : TaxTable
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class TaxTable {

    /**
     * 給income 跟一個 taxTable, 實現 calculatorTax() 返回 tax 多少?
     taxTable 如下:
     income   |   rate
     <10k      |  5%
     10k-100k|   10%
     >100k    |  20%
     */

    public static double calculatorTax(int income) {
        double res = 0;
        while (income != 0) {
            if (income <= 10000) {
                res += income * 0.05;
                income = 0;
            } else if (income > 10000 && income <= 100000) {
                int temp = income - 10000;
                res += temp * 0.1;
                income = 10000;
            } else {
                int temp = income - 100000;
                res += temp * 0.2;
                income = 100000;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculatorTax(200000));
    }
}
