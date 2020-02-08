package Sort;

import java.util.Arrays;

public class 希尔排序 {
    public static void main(String[] args) {
        int arr[]={9,9,6,2,5,8,6,2,4,1,0,7,3};
        int temp=0;
        int count=0;
        //交换法
//        for (int gap=arr.length/2;gap>0;gap/=2){
//            for (int i=gap;i<arr.length;i++){
//                //遍历各组中的所有元素(共gap组)步长gap
//                for (int j=i-gap;j>=0;j-=gap){
//                    //如果当前元素大于加上步长之后的那个元素，说明需要交换
//                    if (arr[j]>arr[j+gap]){
//                        temp=arr[j];
//                        arr[j]=arr[j+gap];
//                        arr[j+gap]=temp;
//                    }
//                }
//            }
//            System.out.println("希尔排序第"+(++count)+"轮="+Arrays.toString(arr));
//        }

        //移位法
        for (int gap=arr.length/2;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
               int j=i;
               int temp2=arr[j];
               if (arr[j]<arr[j-gap]){
                   while (j-gap>=0&&temp2<arr[j-gap]){
                       //移动
                       arr[j]=arr[j-gap];
                       j-=gap;
                   }
                   //当退出while之后，就给temp找到插入的位置
                   arr[j]=temp2;
               }

            }
            System.out.println("希尔排序第"+(++count)+"轮="+Arrays.toString(arr));
        }
    }
}
