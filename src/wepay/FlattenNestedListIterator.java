package wepay;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : FlattenNestedListIterator
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class FlattenNestedListIterator {
    //设计一个iterator，每次next返回的结果是1,2,3,4,5 以后写 [1, 2, [3, [4], 5], 6]
    Stack<NestedInteger> stack = new Stack<>();
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    public Integer next() {
        return stack.pop().getInteger();
    }

    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }


    class NestedInteger {

        Integer value;
        List<NestedInteger> list;

        NestedInteger() {
            value = new Integer(0);
            list = new ArrayList<>();
        }
        NestedInteger(int value) {
            this.value = value;
        }
        NestedInteger(int value, List<NestedInteger> list) {
            this.value = value;
            this.list = list;
        }

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger() {
            return value != null;
        }
        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return value;
        }
        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return list;
        }

        public Integer next() {
            return value; // 例子，真正函数不是这么写的
        }
        public boolean hasNext() {
            return true; // 例子，真正函数不是这么写的
        }
    }

}
