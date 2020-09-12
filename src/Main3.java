import java.util.ArrayList;
import java.util.Stack;

public class Main3 {
    /* 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。 */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /* 将链表中的所有的值遍历出来放进栈中，在从栈中遍历出来放入到list中 */
        ArrayList<Integer> list = new ArrayList<>();
        //定义一个栈
        Stack<Integer> stack = new Stack<>();


        //将链表中所有的数取出来，压入栈中
        while (listNode != null){
            stack.push(listNode.val);
            //一定要更新 listNode，否则会陷入死循环
            listNode = listNode.next;
        }

        //将栈中的所有值取出放进到list中
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}


class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
