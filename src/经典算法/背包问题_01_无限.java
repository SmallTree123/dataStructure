package 经典算法;

public class 背包问题_01_无限 {
    public static void main(String[] args) {
        int[] w={1,4,3};//保存物品重量
        int[] val={1500,3000,2000};//物品的价格
        int m=4;//背包的容量
        int n=val.length; //物品的个数

        //创建二维数组
        //v[i][j] 表示在前i个物品中能够装入容量weij的背包中的最大价值
        int[][] v=new int[n+1][m+1];
        //为了记录放入商品的情况，我们定一个二维数组
        int[][] path=new int[n+1][m+1];

        //初始化第一行和第一列，这里体现出过程就行，默认就是0
        for (int i = 0; i < v.length; i++) {
            v[i][0]=0;//将第一列设置为0
        }
        for (int i = 0; i < v.length; i++) {
            v[0][i]=0;//将第一行设置为0；
        }

        //采取动态规划处理
        for (int i = 1; i < v.length; i++) { //不处理第一行
            for (int j = 1; j < v[0].length; j++) { //不处理第一列
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
//                    v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if (v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        //把当前的情况记录到path
                        path[i][j]=1;
                    }else {
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }

        int i=path.length-1; //行的最大下标
        int j=path[0].length-1;//列的最大下标
        while (i>0&&j>0){
            if (path[i][j]==1){
                System.out.println("第"+i+"个商品放入背包");
                j-=w[i-1];
            }
            i--;
        }
    }
}
