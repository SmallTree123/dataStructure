package Sort;

import java.util.Arrays;

public class 插入排序 {
    public static void main(String[] args) {
        int arr[]={101,34,119,3,45,1,3,330};
        for(int i=1;i<arr.length;i++){
            //定义待插入的数
            int insertVal=arr[i];
            int insertIndex=i-1;
            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
        }

        System.out.println(Arrays.toString(arr));
    }
}
