package indeed;

import java.util.HashSet;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : JobStorage
 * Creator : Edward
 * Date : Sep, 2017
 * Description :

 You are given a list of jobs, each job has an ID number(type is long).
 Implement two functions,
 1.expire(long jobid) to set a job as "expired"
 2.isexpired(long jobid) to check if a job is "expired"
 给一群jobid，类型是long，实现两个方法
 1.expire(long jobid)
 2.isexpired(long jobid)

 */
public class JobStorage {

    HashSet<Long> set = new HashSet<>();
    public JobStorage(List<Long> jobids){
        for (Long id: jobids) {
            set.add(id);
        }
    }
    public void expire(long jobid){
        if (set.contains(jobid)){
            set.remove(jobid);
        }
    }
    public boolean isexpired(long jobid){
        return set.contains(jobid);
    }
    /**
     * follow up :
     * 全放进map里面空间就不够了，面试中不让用map。
     long是64个bit。
     64bit的操作系统里面，16GB的内存如何存下4 Billion个jobid。
     还有用16MB怎么存下一大堆jobid。
     （意思是怎么存比较节约内存）。
     expire的job id比较多，可以考虑如何压缩去存expire job id。

     可能用bitSet，还有就是讨论job id的范围。还有trie可以用。
     job id
     （这里用4位表示long，前面的0省略）
     0001
     0010
     0100
     1000

     开一个四个长度的bit数组（好像没有bit数组），这样的话如果4个job id都expire，只需要保存1111即可
     检查某个job id是否expire，只需要检查某一位上是不是1就可以。
     这样的话，存储空间从16位降到了4位。
     这里面的hash function就是 id & 1111

     可能需要用到bloom filter的思想了。
     http://www.cnblogs.com/heaad/archive/2011/01/02/1924195.html
     下面这个博客里面的一些思想可以借鉴。
     http://www.drfish.me/大数据/2015/12/07/大数据常用技巧之位图法/
     */
}
