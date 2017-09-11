package houzz;

import java.util.Scanner;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : Fibonacci
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class Fibonacci {
    /**
     * F(n)=F(n-1)+F(n-2)  fibonacci(发音)
     * time : O(n)
     */
    public static int recursion(int n){
        if(n <= 2){
            return 1;
        }else{
            return recursion(n-1) + recursion(n-2);
        }
    }

    public static int iteration(int n){
        if(n <= 2){
            return 1;
        }
        int n1 = 1, n2 = 1, res = 0;
        for(int i = 0; i < n - 2; i ++){
            res = n1 + n2;
            n1 = n2;
            n2 = res;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input this fibonacci n:");
        int n = scanner.nextInt(); // 假设输入为大于零的整数

        System.out.println(recursion(6) + ":" + iteration(6));

        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += iteration(i);
        }
        System.out.println(sum);
    }
}
