package Tree;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class 赫夫曼树 {
    public static void main(String[] args) {
        int arr[]={13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }
    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("这是一个空树");
        }
    }

    //创建赫夫曼树的方法
    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes=new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size()>1){
            //排序，从小到大
            Collections.sort(nodes);

            //取出根结点权值最小的两颗二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            //构成一个新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left=leftNode;
            parent.right=rightNode;

            //丛ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            //将parent加入到nodes
            nodes.add(parent);
        }

        return nodes.get(0);

    }
}

//创建结点类
//为了让Node对象持续排序Collections集合排序
//让Node实现Comparable接口
class Node implements Comparable<Node>{
    public int value; //结点权值
    public Node left; //指向左子结点
    public Node right; //指向右子结点

    public Node(int value) {
        this.value = value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}
