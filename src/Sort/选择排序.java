package Sort;

import java.util.Arrays;

public class 选择排序 {
    public static void main(String[] args) {
        int arr[]={101,34,119,3,45,1,3,2330};
        for (int i=0;i<arr.length-1;i++){
            int minIndex=i;
            int min=arr[i];
            for (int j=i+1;j<arr.length;j++){
                if (min>arr[j]){
                    minIndex=j;
                    min=arr[j];
                }
            }
            if (minIndex!=i){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }

        }

        System.out.println(Arrays.toString(arr));
    }
}
