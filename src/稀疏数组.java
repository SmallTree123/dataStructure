public class 稀疏数组 {

    public static void main(String[] args) {
        //创建一个原始的二位数组11  11
       //0表示没有棋子，1表示黑子，2表示篮子
        int chessArr[][] =new int[11][11];
        chessArr[1][2]=1;
        chessArr[2][3]=2;
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        System.out.println("计算原始棋盘中有多少非零的数");
        int sum=0;
        for (int[] row : chessArr) {
            for (int data : row) {
                if (data!=0){
                    sum++;
                }
            }
        }
        System.out.println("sum==="+sum);

        //创建稀疏数组
        System.out.println("创建稀疏数组");
        int sparArr[][]=new int[sum+1][3];
        sparArr[0][0]=11;
        sparArr[0][1]=11;
        sparArr[0][2]=sum;
        for (int[] row : sparArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将原始数组中的数据存到稀疏数组中
        int count=0;
        for (int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if (chessArr[i][j]!=0){
                    count++;
                    sparArr[count][0]=i;
                    sparArr[count][1]=j;
                    sparArr[count][2]=chessArr[i][j];
                }
            }
        }

        //存放之后的稀疏数组
        System.out.println("存放之后的稀疏数组");
        for (int[] row : sparArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //通过稀疏数组还原之前的数组
        for (int i=1;i<3;i++){

            chessArr[sparArr[i][0]][sparArr[i][1]]=sparArr[i][2];

        }

        System.out.println("还原之后的原始数组");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}
