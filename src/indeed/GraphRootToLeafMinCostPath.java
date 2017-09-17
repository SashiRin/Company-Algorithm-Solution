package indeed;

import wepay.GraphPath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : GraphRootToLeafMinCostPath
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class GraphRootToLeafMinCostPath {

    static class Node {
        int label;
        List<Node> children;
        boolean flag;
        Node(int x) { label = x; children = new ArrayList<Node>(); flag = false;}
    };

    /*
    找一个图根到叶子的min cost path，有向无环图
     */
    private static List<Integer> res = new ArrayList<>();
    private static int cost = Integer.MAX_VALUE;
    private static String s = "";

    public static List<Integer> minCostPath(Node source) {
        List<Integer> ret = new ArrayList<>();
        findPath(ret, source, 0, "");
        return res;
    }

    private static void findPath(List<Integer> list, Node root, int sum, String path) {
        if (sum > cost || root == null) return;
        list.add(root.label);
        sum += root.label;
        if (root.children.size() == 0) {
            if (sum < cost) {
                cost = sum;
                res = new ArrayList<>(list);
                s = path + root.label;
                return;
            }
        }

        for (Node child : root.children) {
            findPath(list, child, sum, path + root.label + "->");
            list.remove(list.size() - 1);
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
        n2.children.add(n4);
        n2.children.add(n3);
        n3.children.add(n5);
        //n4.children.add(n5);
        n5.children.add(n6);
        minCostPath(n1);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
