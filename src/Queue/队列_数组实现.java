package Queue;

import java.security.Key;
import java.security.PrivateKey;
import java.util.Scanner;

public class 队列_数组实现 {
    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(3);
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
                        System.out.printf("取出的数据是%d",headQueue);
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

class ArrayQueue{
    private int maxSize;//表示数组的最大容量
    private int front;//头部
    private int rear;//尾部
    private int[] arr;//该数据存放数据，模拟队列

    public ArrayQueue(int arrMaxSize) {
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;//指向队列头部，分析出front是指向队列头的前一个位置
        rear=-1; //指向队列尾部，指向队列尾的数据(就是队列的最后一个数据  )
    }

    //判断队列是否是满的
    public  boolean isFull(){
        return rear == maxSize-1;
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
        rear++;//让rear后移
        arr[rear]=n;
    }
    //取出数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列是空，不能取数据");
        }
        front++;//front后移
        return arr[front];
    }
    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空的");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            System.out.println("队列空的");
            throw new RuntimeException("队列空的");
        }
        return arr[front+1];
    }
}
