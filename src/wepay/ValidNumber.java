package wepay;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : ValidNumber
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ValidNumber {
    /*
    String怎么判断是不是纯数字；
    随后变种为包含负数怎么办；
    再变种为两个数字间有符号怎么办。
     */
    /*
    "12.3459" -> 12.3459
    "   12.3459   " -> 12.3459
    "12.3  459" -> Exception
    "1 2.3459" -> Exception
    "12.34x59" -> Exception
    "12.34.59" -> Exception
    e.g. "+.34" -> 0.34
    e.g. "-1.234" -> -1.234
     */
    static class myException extends Exception {
        public myException() {}

        public myException(String message) {
            super(message);
        }

    }
    public static double validNumber(String s) throws myException {
        if (s == null || s.length() == 0) {
            throw new myException("the input is null or empty");
        }
        s = s.trim();
        boolean point = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c == '.') {
                if (point) {
                    throw new myException("it's not a valid number");
                } else {
                    sb.append(c);
                    point = true;
                }
            } else if (c == '+' || c == '-') {
                if (i != 0) {
                    throw new myException("it's not a valid number");
                } else if (c == '-') {
                    sb.append('-');
                }
            }else {
                throw new myException("it's not a valid number");
            }
        }
        return Double.valueOf(sb.toString());
    }

    public static void main(String[] args) throws myException {
        String s = "  -12.3459  ";
        System.out.println(validNumber(s));
    }
}
