package Search;

import sun.net.idn.Punycode;
/*
查找有规律的数据的时候比二分法好
 */
public class 插值查找 {
    public static void main(String[] args) {

        int max=10000;
        int arr[]=new int[max];
        for (int i=0;i<max;i++){
            arr[i]=i+1;
        }

        int valueSearch = insertValueSearch(arr, 0, arr.length - 1, max);
        System.out.println("索引是："+valueSearch);
    }
    public static int insertValueSearch(int arr[],int left,int right,int findVal){
        if (left>right ||findVal<arr[0]||findVal>arr[arr.length-1]){
            return -1;
        }
        //取出mid
        int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal=arr[mid];
        if (findVal>midVal){
            return insertValueSearch(arr,mid+1,right,findVal);
        }else if (findVal<midVal){
            return insertValueSearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }

    }
}
