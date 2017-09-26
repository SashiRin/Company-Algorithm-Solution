package indeed;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : ExcelSheetColumnTitle
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;// 因为下面是A开始，从1 开始
            sb.append((char)('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
