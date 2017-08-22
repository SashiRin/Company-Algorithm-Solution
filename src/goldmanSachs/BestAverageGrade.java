package goldmanSachs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : goldmanSachs
 * File Name : BestAverageGrade
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class BestAverageGrade {

    /**
     * input是String[][]，两列，第一列是名字，第二列是分数。要计算每一个人的平均分数，返回最高的分数。注意要用double。
     * @param s
     * @return
     */

    public static int bestGrade(String[][] s) {
        double res = 0;
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (String[] nameGrade : s) {
            String name = nameGrade[0];
            int grade = Integer.parseInt(nameGrade[1]);
            if (map.containsKey(name)) {
                List<Integer> temp = map.get(name);
                int cur = temp.get(temp.size() - 1);
                temp.add(cur + grade);
                map.put(name, temp);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(grade);
                map.put(name, temp);
            }
        }
        for (Map.Entry<String, List<Integer>> nameGrade : map.entrySet()) {
            List<Integer> temp = nameGrade.getValue();
            double avg = temp.get(temp.size() - 1) / temp.size();
            res = Math.max(res, avg);
        }
        return (int)res;
    }

    public static void main(String[] args) {
        String[][] s = {{"a", "99"}, {"a", "88"}, {"b", "80"}};
        System.out.println(bestGrade(s));
    }
}
