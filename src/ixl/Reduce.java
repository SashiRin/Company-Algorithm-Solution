package ixl;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : ixl
 * File Name : Reduce
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class Reduce {
    static String[] reducedFractionSums(String[] expressions) {
        String[] res = new String[expressions.length];
        int k = 0;

        for (String s : expressions) {
            int plus = s.indexOf("+");  // split the expressions by "+"
            String s1 = s.substring(0, plus);
            String s2 = s.substring(plus + 1);

            int index1 = s1.indexOf("/");   // get the 1/2
            int a1 = Integer.parseInt(s1.substring(0, index1));
            int a2 = Integer.parseInt(s1.substring(index1 + 1));

            int index2 = s2.indexOf("/");   // get the 1/3
            int b1 = Integer.parseInt(s2.substring(0, index2));
            int b2 = Integer.parseInt(s2.substring(index2 + 1));

            int a = a1 * b2+ a2 * b1;
            int b = a2 * b2;
            if(a==0) {
                res[k++] = "0/"+String.valueOf(a2 < b2 ? a2 : b2);
            } else {
                for(int i=a < b ? a : b;i >=1;i--){
                    if(a % i==0 && b % i==0){
                        a=a/i;
                        b=b/i;
                        break;
                    }
                }
                res[k++] = String.valueOf(a) + "/" + String.valueOf(b);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] res = {"111/212+12/122", "14/123+43/1223"};
        reducedFractionSums(res);
    }
}
