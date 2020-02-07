package Sort;

import java.util.Arrays;

public class 冒泡排序 {
    public static void main(String[] args) {
        int arr[]={6,3,1,6,0,8};
        int temp=0;
        boolean flag=false;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if (!flag){   //在一次排序中一次交换都没有
                break;
            }else {       //重新将标识符置位false；
                flag=false;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
