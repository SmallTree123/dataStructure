package Tree;

public class 二叉树 {
    public static void main(String[] args) {
        HeroNode root=new HeroNode(1,"宋江");
        HeroNode node2=new HeroNode(2,"吴用");
        HeroNode node3=new HeroNode(3,"卢俊义");
        HeroNode node4=new HeroNode(4,"林冲");
        HeroNode node5=new HeroNode(5,"鲁智深");
        BinaryTree binaryTree=new BinaryTree(root);
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        System.out.println("前序遍历");
        binaryTree.preOrder();
//        System.out.println("中序遍历 ");
//        binaryTree.infixOrder();
//        System.out.println("后序遍历");
//        binaryTree.postOrder();
//        HeroNode heroNode = binaryTree.preSearch(3);
//        System.out.println(heroNode);
        binaryTree.delNode(3);
        System.out.println("======================");
        binaryTree.preOrder();

    }
}

class BinaryTree{
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }

    }
    //中序遍历
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }

    }
    //后序遍历
    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }

    }

    //前序查找
    public HeroNode preSearch(int no){
        if (this.root!=null){
            return this.root.preSearch(no);
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
        return null;
    }
    //中序查找
    public HeroNode inFixSearch(int no){
        if (this.root!=null){
            return this.root.inFixSearch(no);
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
        return null;
    }
    //后序查找
    public HeroNode postSearch(int no){
        if (this.root!=null){
            return this.root.postSearch(no);
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
        return null;
    }
    //删除节点
    public void delNode(int no){
        if (root!=null){
            //如果只有一个root节点，判断是否是要删除的节点
            if (root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树,s不能删除");
        }
    }
}


//先创建节点
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;//默认null
    private HeroNode right;//默认null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    //前序遍历
    public void  preOrder(){
        System.out.println(this);//先输出父节点
        //递归向左子树前序遍历
        if (this.left !=null){
            this.left.preOrder();
        }
        //递归向右子树遍历
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        //递归向左子树中序遍历
        if (this.left!=null){
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        //递归向左子树后序遍历
        if (this.left!=null){
            this.left.postOrder();
        }
        //递归向右子树后序遍历
        if (this.right!=null){
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    //前序查找
    public HeroNode preSearch(int no){
        //比较当前节点是不是
        if (this.no==no){
            return this;
        }
        //判断当前节点左子节点是否为空，不为空则继续递归前序查找
        HeroNode reNode=null;
        if (this.left!=null){
            reNode=this.left.preSearch(no);
        }
        if (reNode!=null){ //说明左子树找到了
            return reNode;
        }
        //右递归查找
        if (this.right!=null){
            reNode=this.right.preSearch(no);
        }
        return reNode;
    }

    //中序查找
    public HeroNode inFixSearch(int no){
        //判断当前节点左子节点是否为空，不为空则继续递归前序查找
        HeroNode reNode=null;
        if (this.left!=null){
            reNode=this.left.inFixSearch(no);
        }
        if (reNode!=null){ //说明左子树找到了
            return reNode;
        }
        //如果左子树都没找到比较当前节点是不是
        if (this.no==no){
            return this;
        }
        //右递归查找
        if (this.right!=null){
            reNode=this.right.inFixSearch(no);
        }
        return reNode;
    }

    //后序查找
    public HeroNode postSearch(int no){
        //判断当前节点左子节点是否为空，不为空则继续递归前序查找
        HeroNode reNode=null;
        if (this.left!=null){
            reNode=this.left.postSearch(no);
        }
        if (reNode!=null){ //说明左子树找到了
            return reNode;
        }
        //右递归查找
        if (this.right!=null){
            reNode=this.right.postSearch(no);
        }
        //如果左右子树都没找到比较当前节点是不是
        if (this.no==no){
            return this;
        }
        return reNode;
    }

    //删除节点
    public void delNode(int no){
        if (this.left!=null && this.left.no==no){
            this.left=null;
            return;
        }
        if (this.right!=null && this.right.no==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(no);
        }
        if (this.right!=null){
            this.right.delNode(no);
        }

    }
}
