import java.util.Stack;

public class Main5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //向“队列中”塞入数据时，都塞入到 stack1 中
        stack1.push(node);
    }

    public int pop() {
        //“队列中”出数据的时候
        //如果stack2中有就先从栈顶出
        //如果stack2中没有，就先将stack1中的数据一一出入到stack2中
        if(!stack2.empty()){
            return stack2.pop();
        }else{
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

    }
}
