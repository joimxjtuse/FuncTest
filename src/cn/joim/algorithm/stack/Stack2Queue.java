package cn.joim.algorithm.stack;

import java.util.Stack;

/**
 * 据说是滴滴的面试题； 为了防止眼高手低，实践下吧。
 */
public class Stack2Queue {


    public static void main(String[] args) {

        VisualQueue<Integer> queue = new VisualQueue<>();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);

        while (!queue.isEmpty()) {
            System.out.print("  " + queue.pop());
        }
    }


    private static class VisualQueue<V> {

        private Stack<V> stack1 = new Stack<>();

        private Stack<V> stack2 = new Stack<>();


        public void push(V item) {

            stack1.push(item);
        }


        public V pop() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else {
                throw new RuntimeException("empty queue!");
            }
        }

        public boolean isEmpty() {

            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
