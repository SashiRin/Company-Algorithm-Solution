package wepay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : GraphPath
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class GraphPath {
    /*
    Given a DAG, a source, a target, 给个graph，实现 findMinDist(int src, int des) BFS做出
     */
    // 图给出的形式是node节点
    static class Node {
        int label;
        List<Node> children;
        boolean flag;
        Node(int x) { label = x; children = new ArrayList<Node>(); flag = false;}
    };

    // BFS
    public static int findMinDist(Node source, Node target) {
        int res = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                GraphPath.Node cur = queue.poll();
                cur.flag = true;
                if (cur.label == target.label) {
                    return res;
                }
                for (GraphPath.Node child : cur.children) {
                    if (!child.flag) queue.offer(child);
                }
            }
            res++;
        }
        return res;
    }
    //邻接矩阵
    public static int findMinDist2(int[][] edges, int source, int target) {
        boolean[] visited = new boolean[edges.length];
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                int[] child = edges[cur];
                visited[cur] = true;
                if (cur == target) {
                    return res;
                }
                for (int j = 0; j < child.length; j++) {
                    if (!visited[j] && child[j] == 1) {
                        queue.offer(j);
                    }
                }
            }
            res++;
        }
        return res;
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.children.add(n2);
        n2.children.add(n3);
        n2.children.add(n4);
        n3.children.add(n5);
        n4.children.add(n5);
        n4.children.add(n6);
        n6.children.add(n5);
        int[][] edges = {
                { 0, 1, 0, 0, 0, 0},
                { 1, 0, 1, 1, 0, 0},
                { 0, 1, 0, 0, 1, 0},
                { 0, 1, 0, 0, 1, 1},
                { 0, 0, 1, 1, 0, 1},
                { 0, 0, 0, 1, 1, 0}
        };
        System.out.println(findMinDist2(edges,0, 4));
    }
}
