package 经典算法;

public class 汉诺塔 {
    private static int count=0;
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
        System.out.println("用了"+count+"步");
    }

    /**
     * 汉诺塔的移动方法，使用分治算法
     * @param num
     * @param a
     * @param b
     * @param c
     */
    public static void hanoiTower(int num,char a,char b,char c){
        //如果只有一个盘
        if (num == 1) {
            count++;
            System.out.println("第1个盘从"+a+"->"+c);
        }else {
            count++;
            //我们可以看作是下面一个盘，上面所有盘
            //先把最上面的盘A->B，移动过程会使用到C
            hanoiTower(num-1,a,c,b);
            //把最下面的盘A-C
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //把B塔所有的盘从B->C,移动过程使用到a塔
            hanoiTower(num-1,b,a,c);
        }
    }
}
