package LinkedList;

import java.nio.file.attribute.FileTime;
import java.sql.SQLOutput;

public class JosepFu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
//        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

//创建一个环形的单向链表
class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private Boy first=new Boy(-1);

    //添加小孩，构建成一个环形的链表
    public void addBoy(int nums){
    //nums作为一个数据校验
         if (nums<0){
             System.out.println("输入的小孩数量不正确");
             return;
         }
         Boy curBoy=null;//辅助指针，用于构建环形链表
         for (int i=1;i<=nums;i++){
             Boy boy=new Boy(i);
             //如果是第一个小孩
             if (i==1){
                 first=boy;
                 first.setNext(first);//构成环
                 curBoy=first;//让curBoy指向第一个小孩
             }else {
                 curBoy.setNext(boy);
                 boy.setNext(first);
                 curBoy=boy;

             }
         }
    }

    public void showBoy(){
        if (first==null){
            System.out.println("链表为空");
            return;
        }

        Boy curBoy=first;
        while (true){
            System.out.println("小孩的编号"+curBoy.getNo());
            if (curBoy.getNext()==first){
                break;
            }
            curBoy=curBoy.getNext();
        }
    }

    public void countBoy(int startNo,int countNum,int nums){
        //先对数据进行校验
        if (first==null || startNo<1 ||startNo>nums){
            System.out.println("数据输入的有错误");
            return;
        }
        //创建一个辅助指针，帮忙小孩出圈
        Boy helper=first;
        while (true){
            if (helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }
        //小孩报数前，先让first和helper移动k-1次
        for (int j=0;j<startNo-1;j++){
            first=first.getNext();
            helper=helper.getNext();
        }
        //当小孩报数时,让first和helper指针同时移动m-1次然后出圈
        //这里是一个循环的操作，直到圈中只有一个节点
        while (true){
            if (helper==first){
                break;
            }
            //让first和helper指针同事移动countNum-1
            for (int j=0;j<countNum-1;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            //这时first指向的节点就是要出圈的小孩
            System.out.println("出圈的小孩是"+first.getNo());
            //这时将first指向的小孩节点出圈
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩是"+first.getNo());
    }


}

//创建boy类，表示一个节点
class Boy{
    private int no;//编号
    private Boy next;//指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
