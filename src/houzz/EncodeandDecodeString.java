package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : EncodeandDecodeString
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */

public class EncodeandDecodeString {
    /*
    一、进行encode()判断的条件：
        (1)、c是等于0的数字             复制该字符
             c是一般字符，且不为”_”     复制该字符
        以上两个条件等同于：c是一个除了1-9，除了”_”的任意字符
        (5)、c是一般字符，且为”_”       转换为”\Ul”
        (2)、c是数字，且i=n-1           复制该字符
        (3)、c是数字，且i<n-1,且c>0     复制(k+1)次后面的一个字符

        以上四个条件拆分如下：
        c == 0   i==n-1         复制该字符
                 i!=n-1         复制该字符
        c是1-9的数字, 且i=n-1   复制该字符
                      且i<n-1   复制(k+1)次后面的一个字符
        c是一般字符，且为”_”    转换为”\Ul”
        c是一般字符，且不为”_”  转换为”\Ul”
        再化为如下判断条件：
        c是1-9的数字, 且i<n-1   复制(k+1)次后面的一个字符
        c除1-9，且为”_”         转换为”\Ul”
        其余                    复制该字符

        (4)、每个字符译码结束后加一个下划线”_”

        二、进行decode()判断的条件：
        思路：
        根据规则4，用先将str用str.split("_");分成n个String数组strs[].
        n = strs.lenth        k = strs[i].length()

        由encode()得到的译码如下：
        c是1-9的数字, 且i<n-1   复制(k+1)次后面的一个字符     多个字符
        c除1-9，且为”_”         转换为”\Ul”                   多个字符
        其余                    复制该字符                    一个字符
        判断条件为：
        A、k==1,  将该字符原样复原
        B、k>1,   strs[i] == ”\Ul”,  转换为”_”
        strs[i] != ”\Ul”,  转换为k(k = strs[i].length()-1)
     */
    class StringLenException extends RuntimeException {

        public StringLenException(String message) {
            super(message);
        }

    }

    public String encode(String str) throws StringLenException{
        StringBuilder sb = new StringBuilder();
        if(null == str) {
            throw new StringLenException("字符串末初始化！");
        }
        int n = str.length();
        if(n <=0) {
            throw new StringLenException("字符串不能为空！");
        }
        char c = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            // 获得当前字符
            c = str.charAt(i);
            if (c >= '1' && c <= '9' && i != n-1) {    // c是1-9的数字, 且i<n-1   复制(k+1)次后面的一个字符
                k = c -'0' + 1;
                for(int j=0; j<k; j++) {
                    sb.append(str.charAt(i+1));
                }
            } else if (c == '_') {                   // c除1-9，且为”_” 转换为”\Ul”
                sb.append("\\UL");
            }else{                                   //其余 复制该字符
                sb.append(c);
            }
            sb.append("_");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public String decode(String str) {
        StringBuilder sb = new StringBuilder();
        if(null == str) {
            throw new StringLenException("字符串末初始化！");
        }
        if(sb.length() <=0) {
            throw new StringLenException("字符串不能为空！");
        }
        String strs[] = str.split("_");
        char c = 0;
        int k = 0;
        int n = strs.length;
        if(n == 1) {
            sb.append(str);
        } else {
            for(int i=0; i<n; i++) {
                k = strs[i].length();
                c = strs[i].charAt(0);
                if(1 ==k) {             //　　k==1,  将该字符原样复原
                    sb.append(c);
                } else {                //　　k>1,
                    if(strs[i].equals("\\UL")) {//strs[i] == ”\Ul”,  转换为”_”
                        sb.append("_");
                    } else {                    // strs[i] != ”\Ul”,  转换为k(k = strs[i].length()-1)
                        sb.append(k-1);
                    }
                }
            }
        }
        return sb.toString();
    }
    /**
     24ab_2t2
     444_aaaaa_a_b_\UL_ttt_t_2

     04ab_2t2
     0_aaaaa_a_b_\UL_ttt_t_2

     1a0b_2t2
     aa_a_0_b_\UL_ttt_t_2

     aaab_2t2
     a_a_a_b_\UL_ttt_t_2

     24ab_2335t2
     444_aaaaa_a_b_\UL_333_3333_5555_tttttt_t_2

     */
    public static String encodeString(String s) {
        if (s == null || s.length() == 0) return "";
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i));
                count = 1;
            }
        }
        return sb.toString();
    }

    public static String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                count = s.charAt(i) - '0';
            } else {
                for (int j = 0; j < count; j++) {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "a";
        System.out.println(encodeString(s));
        System.out.println(decodeString(encodeString(s)));
    }
}
