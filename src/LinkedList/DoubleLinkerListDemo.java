package LinkedList;

public class DoubleLinkerListDemo {
    public static void main(String[] args) {

        HeroNode2 heroNode1=new HeroNode2(1,"111111","111");
        HeroNode2 heroNode2=new HeroNode2(2,"222222","222");
        HeroNode2 heroNode3=new HeroNode2(3,"333222","333");
        HeroNode2 heroNode4=new HeroNode2(4,"444222","444");
        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.list();

    }
}
class  DoubleLinkedList{
    private HeroNode2 head=new HeroNode2(0,"","");

    public HeroNode2 getHead(){
        return head;
    }

    //双向链表的添加
    public void add(HeroNode2 heroNode){

        HeroNode2 temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        //当循环到最后一个节点时让他的pre指向前一个节点
        temp.next=heroNode;
        heroNode.pre=temp;
    }

    //双向链表的遍历
    public void list(){
        if (head.next==null){
            System.out.println("链表是空的");
            return;
        }

        HeroNode2 temp=head.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.println(temp.toString());
            temp=temp.next;
        }

    }
}

//定义HeroNode，每个对象就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
