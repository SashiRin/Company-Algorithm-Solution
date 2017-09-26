package indeed;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : UnrolledLinkedList
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
class Node{

    public char[] chars = new char[5]; //定长5,反正总要有定长。
    public int len; //表示数组里面实际有几个字母
    public Node next;

    public Node(){}
}
public class UnrolledLinkedList {
    /**
     * Given a LinkedList, every node contains a array. Every element of the array is char
     implement two functions
     1. get(int index) find the char at the index
     2. insert(char ch, int index) insert the char to the index
     */

    private Node head;
    private int totalLen; //这个totalLen代表所有char的个数

    public UnrolledLinkedList(Node head, int total) {
        this.head = head;
        this.totalLen = total;
        //可能totalLen是不给的，要遍历一遍去求。以下代码是求长度
        int count = 0;
        Node cur = head;
        while (cur != null) {
            count += cur.len;
            cur = cur.next;
        }
        totalLen = count;
    }

    public char get(int index) {
        if (index < 0 || index >= totalLen || totalLen == 0) {
            return ' ';
        }

        Node cur = head;
        while (cur != null && index >= 0) {
            if (index >= cur.len) {
                index -= cur.len;
            } else {
                return cur.chars[index];
            }
            cur = cur.next;
        }

        return ' ';
    }

    //insert需要考虑1.普通插进去。2.插入的node满了，要在后面加个node。
    //3.插入的node是空的，那就要在尾巴上加个新node。(这不就是结尾的意思吗？？？？？)
    //还需要考虑每个node的len，以及totalLen的长度变化。
    public void insert(char ch, int index){
        if (index > totalLen) return;

        Node cur = head;
        while(cur != null && index >= 0){
            if (index >= cur.len) {
                index -= cur.len;
            } else {
                if (cur.len == 5) {
                    Node newNode = new Node();
                    newNode.chars[0] = cur.chars[4];
                    newNode.len = 1;
                    newNode.next = cur.next;
                    cur.next = newNode;
                    cur.len -= 1;
                }
                cur.len += 1;
                int i = cur.len - 1;
                for(; i > index; i--){
                    cur.chars[i] = cur.chars[i-1];
                }
                cur.chars[i] = ch;
                break;
            }
            cur = cur.next;
        }

        if (cur == null) {
            Node newNode = new Node();
            newNode.chars[0] = ch;
            newNode.len = 1;
            /* 不知所云，个人认为直接下面写
            Node tail = new Node();
            tail.next = head;
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = newNode;*/
            cur.next = newNode;
            newNode.next = null;
        }
        totalLen += 1;
    }

    /**
     * delete 是follow up
     * 1.普通的去掉一个node里面的点。2.去掉node之后，这个点空了，那就把点删掉。
     //也要考虑每个node里面长度的变化。
     * @param index
     */
    public void delete(int index){
        if (index < 0 || index >= totalLen) {
            return;
        }
        Node prev = new Node();
        prev.next = head;
        Node cur = head;
        while(cur != null && index >= 0){
            if (index >= cur.len) {
                index -= cur.len;
            }
            else {
                if (cur.len == 1) {
                    prev.next = cur.next;
                }
                else {
                    for (int i = index; i < cur.len-1; i++) {
                        cur.chars[i] = cur.chars[i+1];
                    }
                    cur.len -= 1;
                }
            }

            prev = prev.next;
            cur = cur.next;
        }
        totalLen -= 1;
    }

    //链表题到时候画一个下面的小case，就能对准index了。
    public static void main(String[] args) {
        Node n1 = new Node(); //a b
        Node n2 = new Node(); //b
        Node n3 = new Node(); //a b c d e

        n1.chars[0] = 'a';
        n1.chars[1] = 'b';
        n2.chars[0] = 'b';
        n3.chars[0] = 'a';
        n3.chars[1] = 'b';
        n3.chars[2] = 'c';
        n3.chars[3] = 'd';
        n3.chars[4] = 'e';

        n1.next = n2;
        n2.next = n3;
        n1.len = 2;
        n2.len = 1;
        n3.len = 5;
    }


}
