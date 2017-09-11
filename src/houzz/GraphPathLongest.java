package houzz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : GraphPathLongest
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class GraphPathLongest {
    /*
    given a undirectd and acyclic graph, 一个source和一个target，找出source到target的最长path
     */
    // 图给出的形式是node节点

    static class Node {
        int label;
        List<Node> children;
        boolean flag;
        Node(int x) { label = x; children = new ArrayList<Node>(); flag = true;}
    };

    static List<Integer> res ;

    public static List<Integer> findNumberPath(Node source, Node target) {
        List<Integer> ret = new ArrayList<>();
        findPath(ret, source, target);
        return res;
    }

    private static void findPath(List<Integer> ret, Node node, Node target) {       //可返回boolean进一步提升效率
        if (node == null) return;
        ret.add(node.label);
        node.flag = false;
        if (node.label == target.label) {
            res = new ArrayList(ret);;
            System.out.println("dfds");
            return;
        }
        for (Node child : node.children) {
            if (child.flag) {
                findPath(ret, child, target);
                ret.remove(ret.size() - 1);
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
        n5.children.add(n6);
        List<Integer> ret = findNumberPath(n1, n5);
        for (int num : ret) {
            System.out.println(num);
        }
    }
}
