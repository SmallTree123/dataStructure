package Stack;

public class StackDemo {
    public static void main(String[] args) {
        ArrayStack stack=new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
       stack.list();

    }
}


class ArrayStack{
    private int maxSize;//栈的最大存储量
    private int[] stack;//用来存放数据
    private int top=-1;//栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[this.maxSize];
    }

    public boolean isFull(){
        return top==maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈已经满了");
            return;
        }
        top++;
        stack[top]=value;
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("栈是空的，请先添加数据");
            return 0;
        }
        int value=stack[top];
        top--;
        return value;
    }
    public void list(){
        if (isEmpty()){
            System.out.println("栈是空的，请先添加数据");
            return;
        }
        for (int i=top;i>=0;i--){
            System.out.println(stack[i]);
        }
    }

}
