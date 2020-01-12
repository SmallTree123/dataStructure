package LinkedList;

public class SingleLinkedList {
    public static void main(String[] args) {
        HeroNode heroNode1=new HeroNode(1,"111","111");
        HeroNode heroNode2=new HeroNode(2,"222","222");
        HeroNode heroNode3=new HeroNode(3,"333","333");
        HeroNode heroNode4=new HeroNode(4,"444","444");
        SingleLinked singleLinked=new SingleLinked();
        singleLinked.add(heroNode1);
        singleLinked.add(heroNode2);
        singleLinked.add(heroNode3);
        singleLinked.add(heroNode4);
        singleLinked.list();
    }
}
class SingleLinked{
    private HeroNode head=new HeroNode(0,"","");

    public void add(HeroNode heroNode){

        HeroNode temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode;
    }

    public void list(){
        if (head.next==null){
            System.out.println("链表是空的");
            return;
        }

        HeroNode temp=head.next;
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
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

