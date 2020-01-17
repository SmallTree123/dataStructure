package Queue;

import java.util.Scanner;

public class 环形队列 {
    public static void main(String[] args) {
        ArrayCircleQueue queue=new ArrayCircleQueue(3);
        char key=' ';//接收用户数据
        Scanner scanner=new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("show");
            System.out.println("exit");
            System.out.println("add");
            System.out.println("get");
            System.out.println("head");
            key=scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value=scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int headQueue = queue.headQueue();
                        System.out.printf("头的数据是%d",headQueue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出····");
    }
}

class ArrayCircleQueue{
    private int maxSize;//表示数组的最大容量
    //front指向队列的第一个下表，arr[front]就是第一个元素，front的初始值是front=0
    private int front;//头部
    //rear指向队列最后一个元素的后一个位置，初始值是rear=0
    private int rear;//尾部
    private int[] arr;//该数据存放数据，模拟队列

    public ArrayCircleQueue(int arrMaxSize) {
        maxSize=arrMaxSize;
        arr=new int[maxSize];
    }

    //判断队列是否是满的
    public  boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据到队列

    public void addQueue(int n){
        //首先判断队列是否满的
        if (isFull()){
            System.out.println("队列是满的，不能添加数据···");
            return;
        }
        arr[rear]=n;
        //让rear后移,这里必须考虑取模
        rear=(rear+1)%maxSize;
    }

    //取出数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列是空，不能取数据");
        }
        //首先定义一个临时变量来返回值
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }
    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空的");
            return;
        }
        for (int i=front;i<front+size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //求出当前队列的有效个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            System.out.println("队列空的");
            throw new RuntimeException("队列空的");
        }
        return arr[front];
    }
}
