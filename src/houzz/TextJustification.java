package houzz;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : TextJustification
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class TextJustification {
    /*
    没有什么特别算法，就是模拟，主要分情况判断。首先分两大类，末行和非末行；然后末行所有单词间放一个空格，
    最后面补充空格；非末行再分两类，如果只有一个单词就靠左放，右边补空格；如果有多个单词，即计算有几个间隔num和几个多余的空格extra
    （除每两个单词间一个空格外多余的），每个间隔再多方extra/num个，前extra%num个间隔再多放个空格。
     */
    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<String>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }


        return lines;
    }
}
