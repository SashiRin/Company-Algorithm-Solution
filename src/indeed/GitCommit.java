package indeed;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : GitCommit
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
class GitNode{
    int id;
    List<GitNode> parents;
    public GitNode(int id){
        this.id = id;
        this.parents = new ArrayList<>();
    }
}
public class GitCommit {
    /**
     * 给出一个Git的commit，找出所有的parents。每个节点都有一个或多个parent。
     另外每个commit都是带着ID的。就是没太懂它是输出所有的commit还是要求逐层打印。

     第二题就是找到两个commit的公共祖先。
     Git的commit是可以分叉的也可以合并，所以这题其实是个图。
     其实就是BFS和双向BFS，注意好对复杂度的分析吧。优化就是双向BFS吧。
     好像不太对。

     * @param node
     * @return
     */
    public List<GitNode> findAllCommits(GitNode node){
        List<GitNode> res = new ArrayList<>();
        Queue<GitNode> queue = new LinkedList<>();
        Set<GitNode> visited = new HashSet<>(); //去重

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()){
            GitNode cur = queue.poll();
            res.add(cur);
            for (GitNode par: cur.parents){
                if (!visited.contains(par)){
                    queue.offer(par);
                    visited.add(par);
                }
            }
        }
        return res;
    }

    /**
     * 找到两个commit的最近公共parent commit。而且被要求优化，因为是follow up，所以到时候时间肯定
     剩下不多，面试时候要直接出最优解。
     */
    public GitNode findLCA(GitNode node1, GitNode node2){
        if (node1 == null || node2 == null) return null;

        Queue<GitNode> q1 = new LinkedList<>();
        q1.offer(node1);
        Queue<GitNode> q2 = new LinkedList<>();
        q2.offer(node2);

        Set<GitNode> s1 = new HashSet<>();
        Set<GitNode> s2 = new HashSet<>();
        s1.add(node1);
        s2.add(node2);
//        int len1 = 1, len2 = 1; //万一是要求最短路径长度呢。

        //while里面是&&,因为一旦其中一个终结那也不用搜了。
        while (!q1.isEmpty() && !q2.isEmpty()){
            //每个BFS都是一层一层的扫
            int size1 = q1.size();
            while (size1-- > 0){
                GitNode cur1 = q1.poll();
                for (GitNode par1 : cur1.parents) {
                    if (s2.contains(par1)){
                        return par1;
                    }
                    if (!s1.contains(par1)){
                        q1.offer(par1);
                        s1.add(par1);
                    }
                }
            }

            int size2 = q2.size();
            while (size2-- > 0){
                GitNode cur2 = q2.poll();
                for (GitNode par2 : cur2.parents) {
                    if (s1.contains(par2)){
                        return par2;
                    }
                    if (!s2.contains(par2)){
                        q2.offer(par2);
                        s2.add(par2);
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        GitCommit test = new GitCommit();
        /*
        *
        *   5 <-  4  <- 2
        *    \       \
        *     \ <- 3 <- 1
        * */
        GitNode g1 = new GitNode(1);
        GitNode g2 = new GitNode(2);
        GitNode g3 = new GitNode(3);
        GitNode g4 = new GitNode(4);
        GitNode g5 = new GitNode(5);

        g1.parents.add(g3);
        g1.parents.add(g4);
        g2.parents.add(g4);
        g3.parents.add(g5);
        g4.parents.add(g5);

        GitNode res = test.findLCA(g2, g3);
        System.out.println(res.id);
    }

}
