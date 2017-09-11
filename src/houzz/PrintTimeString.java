package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : PrintTimeString
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class PrintTimeString {
    /**
     * 打印出"12AM 1AM 2AM... 11AM 12PM 1PM... 11PM"
     */
    public static String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            int temp = i % 12;
            if (i < 12) {
                if (temp == 0) {
                    sb.append("12AM ");
                } else {
                    sb.append(temp + "AM ");
                }
            } else {
                if (temp == 0) {
                    sb.append("12PM ");
                } else {
                    sb.append(temp + "PM ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = print();
        System.out.println(s);
    }
}
