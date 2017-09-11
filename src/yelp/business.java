package yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : yelp
 * File Name : business
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class business {
    /**
    我遇到的是将两个sorted list of businesse合成一个，按review个数从高到低排。 
    代码好像十行都不到，不紧张的话十分钟以内肯定能做完。

    题目是merge两个sorted的表，凭记忆大概是这样： list1: [{'id':'0000', 'value':900}, 
    {'id':'0001', 'value:850'}, {'id':'0001', 'value:800'}]  
    list2: [{'id':'0000', 'value':830}, {'id':'0001', 'value:820'}, 
             {'id':'0001', 'value:790'}]   然后根据value来merge这两个数组。
     **/

    public static List<BusinessInfo> businessInfos(List<BusinessInfo> l1, List<BusinessInfo> l2) {
        List<BusinessInfo> res = new ArrayList<>();
        for (BusinessInfo cur : l1) {
            res.add(cur);
        }
        for (BusinessInfo cur : l2) {
            res.add(cur);
        }
        Collections.sort(res, new Comparator<BusinessInfo>(){
            public int compare(BusinessInfo a, BusinessInfo b) {
                return b.numReviews - a.numReviews;
            }
        });
        //Collections.sort(res); // 里面写好的；
        return res;
    }
}
