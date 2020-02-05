package Recursion;

import java.security.PublicKey;

public class miGong {
    public static void main(String[] args) {

        //先创建一个棋盘
        int[][] map=new int[8][8];
        for (int i=0;i<8;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int j=0;j<8;j++){
            map[j][0]=1;
            map[j][7]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
        map[3][3]=1;
        map[6][5]=1;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }

        //开始运行迷宫
        setWay(map,1,1);
        System.out.println("===================");
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }


    }

    //设置迷宫
    public static boolean setWay(int[][] map,int x,int y){
        if (map[6][6]==2){  //已经找到出口
            return true;
        }else {
            if (map[x][y] == 0) { //说明该条路没有走过
                //按照下-右-上-左的顺序走
                map[x][y] = 2; //设置改点是可以走通的
                if (setWay(map, x + 1, y)) { //下
                    return true;
                }else if (setWay(map, x, y + 1)) {   //右
                    return true;
                } else if (setWay(map, x, y-1)) {  //左
                    return true;
                } else if (setWay(map, x-1, y)) {  //上
                    return true;
                } else {
                    map[x][y] = 3;
                    return false;
                }
            } else {
                return false;
            }

        }
    }
}
