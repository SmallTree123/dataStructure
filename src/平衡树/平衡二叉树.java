package 平衡树;

public class 平衡二叉树 {
    public static void main(String[] args) {
//        int arr[]={4,3,6,5,7,8};
        int arr[]={10,12,8,9,7,6};
        AVLTree avlTree=new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));

        }

        //遍历
        System.out.println("中序遍历");
        avlTree.inFixOrder();

        System.out.println("在没有平衡处理之前");
        System.out.println(avlTree.getRoot().height());
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
    }
}

//创建AVL(平衡二叉树)
class AVLTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    //查找要删除的结点
    public Node search(int value){
        if (root==null){
            return null;
        }else {
            return root.search(value);
        }
    }
    //查找要删除的父节点
    public Node searchParent(int value){
        if (root==null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    /**
     * 1,返回的以node为根节点的二叉排序树的最小结点的值
     * 2,删除node为根节点的二叉排序树的最小结点
     * @param node 传入的结点(当做二叉排序树的根节点)
     * @return 返回的以node 为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(Node node){
        Node target=node;
        //循环查找左子结点，就会有最小值
        while (target.left!=null){
            target=target.left;
        }
        //这时target就指向了最小结点
        //删除结点
        delNode(target.value);
        return target.value;
    }
    public void delNode(int value){
        if (root==null){
            return;
        }else {
            //需要先去找到要删除的结点
            Node targetNode = search(value);
            //如果没有要找到山的虎结点
            if (targetNode==null){
                return;
            }
            //如果我们发现当前这科二叉排序树只有一个结点
            if (root.left==null && root.right==null){
                root=null;
                return;
            }

            //去查找targetNode的父节点
            Node parent = root.searchParent(value);
            //如果要删除的结点是叶子结点
            if (targetNode.left==null && targetNode.right==null){
                //判断targetNode是父节点的左子结点还是右子节点
                if (parent.left!=null && parent.left.value==value){  //是左子结点
                    parent.left=null;
                }else if (parent.right!=null && parent.right.value==value){ //是右子节点
                    parent.right=null;
                }
            }else if (targetNode.left!=null && targetNode.right!=null){ //是有两个子树的结点
                int minVal=delRightTreeMin(targetNode.right);
                targetNode.value=minVal;
            }else {  //是只有一颗子树的结点
                //如果要删除的结点有左子结点
                if (targetNode.left!=null){
                    if (parent!=null){
                        //如果targetNode是parent的左子结点
                        if (parent.left.value==value){
                            parent.left=targetNode.left;
                        }else { //targetNode是parent的右子节点
                            parent.right=targetNode.left;
                        }
                    }else {
                        root=targetNode.left;
                    }

                }else {  //如果要删除的结点是右子节点
                    if (parent!=null){
                        //如果targetNode是parent的左子结点
                        if (parent.left.value==value){
                            parent.left=targetNode.right;
                        }else {  //如果targetNode是parent的右子节点
                            parent.right=targetNode.right;
                        }
                    }else {
                        root=targetNode.right;
                    }


                }
            }
        }
    }

    public void add(Node node){
        if (root==null){
            root=node;
        }else {
            root.add(node);
        }
    }
    public void inFixOrder(){
        if (root!=null){
            root.inFixOrder();
        }else {
            System.out.println("二叉排序树是空的");
        }
    }
}

class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加结点
    public void add(Node node){
        if (node==null){
            return;
        }

        //判断传入的结点的值和当前子树的结点值大小
        if (node.value<this.value){
            //如果当前左子结点为空
            if (this.left==null){
                this.left=node;
            }else {
                //递归左子树
                this.left.add(node);
            }
        }else { //添加的结点的值大于当前子树的值
            if (this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
        //当添加完一个节点之后，如果:(右子树的高度-左子树的高度) > 1，左旋转
        if (rightHeight()-leftHeight()>1){
            leftRotate();
        }
        if (leftHeight()-rightHeight()>1){
            rightRotate();
        }
    }

    //返回左子树的高度
    public int leftHeight(){
        if (left==null){
            return 0;
        }
        return left.height();
    }
    //返回右子树的高度
    public int rightHeight(){
        if (right==null){
            return 0;
        }
        return right.height();
    }


    //返回当前节点的高度，以该节点为根节点的树的高度
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
    }

    //左旋转的方法
    private void leftRotate(){
        //创建新的结点，以当前根节点的值
        Node newNode=new Node(value);
        //把新的节点的左子树设置成当前节点的左子树
        newNode.left=left;
        //把新的结点的右子树设置为当前节点右子树的左子树
        newNode.right=right.left;
        //把当前结点的值替换成右子结点的值
        value=right.value;
        //把当前结点的右子树设置成右子树的右子树
        right=right.right;
        //把当前结点的左子结点设置成新的结点
        left=newNode;
    }

    //右旋转
    private void rightRotate(){
        Node newNode=new Node(value);
        newNode.right=right;
        newNode.left=left.right;
        value=left.value;
        left=left.left;
        right=newNode;
    }

    //查找要删除结点
    public Node search(int value){
        if (this.value==value){
            return this;
        }else if (value<this.value){
            if (this.left==null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right==null){
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除的父节点
    public Node searchParent(int value){
        if ((this.left!=null && this.left.value==value)||(this.right!=null && this.right.value==value)){
            return this;
        }else {
            if (value<this.value && this.left!=null){
                return this.left.searchParent(value); //向左递归查找
            }else if (value>=this.value && this.right!=null){
                return this.right.searchParent(value);//向右递归查找
            }else{
                return null; //没有找到父节点
            }
        }
    }


    //中序遍历
    public void inFixOrder(){
        if (this.left!=null){
            this.left.inFixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.inFixOrder();
        }
    }
}