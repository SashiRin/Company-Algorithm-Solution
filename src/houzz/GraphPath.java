package houzz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : GraphPath
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class GraphPath {
    /*
    Given a DAG, a source, a target, and number n, 找出从source到target的长度为n的路径的个数
     */
    // 图给出的形式是node节点
    static class Node {
      int label;
      List<Node> children;
      Node(int x) { label = x; children = new ArrayList<Node>(); }
    };
    
    public static int res = 0;
    public static int findNumberPath(Node source, Node target, int path) {
        findPath(source, target, path);
        return res;
    }

    private static void findPath(Node node, Node target, int path) {
        if (node == null) return;
        if (path == 0 && node.label == target.label) {
            res++;
        }
        for (Node child : node.children) {
            findPath(child, target, path - 1);
        }
    }
    // BFS
    public static int findNumberPath3(GraphPath.Node source, GraphPath.Node target, int path) {
        int ret = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                GraphPath.Node cur = queue.poll();
                for (GraphPath.Node child : cur.children) {
                    queue.offer(child);
                }
                if (cur.label == target.label && path == 0) {
                    ret++;
                }
            }
            path--;
        }
        return ret;
    }

    // 图给出的形式是矩阵,可以转化为node形式，加一个label用来区分每个顶点，或者直接做：

    public static int findNumberPath2(int[][] edges, int source, int target, int path) {
        dfs(edges, source, target, path);
        return res;
    }
    public static void dfs(int[][] edges, int source, int target, int path) {
        if (path == 0 && source == target) {
            res++;
        }
        for (int i = 0; i < edges[source].length; i++) {
            if (edges[source][i] == 1) {
                dfs(edges, i, target, path - 1);
            }
        }
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
        n5.children.add(n6);
        int[][] edges = {
                { 0, 1, 0, 0, 0},
                { 0, 0, 1, 1, 0},
                { 0, 0, 0, 0, 1},
                { 0, 0, 0, 0, 1},
                { 0, 0, 0, 0, 0},
        };
        System.out.println(findNumberPath2(edges, 0, 1, 1));
    }
}
