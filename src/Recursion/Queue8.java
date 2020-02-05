package Recursion;

public class Queue8 {

    //定义一个max表示一共有多少个皇后
    int max=8;
    //定义数组array，保存皇后位置的结果例如 arr={0,4,7,5,2,6,1,3};
    int[] array=new int[max];
    //用来记录一共有多少种方法
    static int count=0;
    public static void main(String[] args) {
        Queue8 queue=new Queue8();
        queue.check(0);
        System.out.println("一共有---"+count+"---种方法");
    }

    //编写一个方法，放置第n个皇后
    //特别注意：check是每次递归时进入到check中都有for(int i=0;i<max;i++)因此会有回溯
    public void check(int n){
        if (n==max){
            print();
            return;
        }
        //依次放入皇后 并判断是否有冲突
        for (int i=0;i<max;i++){
            //先把当前这个皇后n放入到该行的第一列
            array[n]=i;
            //判断当前皇后是否和之前的冲突
            if (judge(n)){ //不冲突
                //接着放n+1个皇后，开始递归
                check(n+1);
            }
            //如果有冲突继续执行array[n]=i;

        }

    }

    //查看当前的皇后是否和之前的皇后位置冲突
    public boolean judge(int n){
        for (int i=0;i<n;i++){

            //1,array[i]==array[n]表示判断第n个皇后是否和前面的n-1个皇后在同一列
            //2,Math.abs(n-i)==Math.abs(array[n])-array[i]表示判断第n个皇后和之前的是否在一个斜线上
            //
            if (array[i]==array[n]|| Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    public void print(){
        count++;
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
