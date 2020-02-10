package Search;

import java.util.ArrayList;

public class 二分查找 {
    public static void main(String[] args) {
        //前提必须是是一个有序序列
        int arr[]={1,2,4,5,45,65,90,100,100,100,100,109,200,400};
        String value=binarySearch2(arr,0,arr.length-1,100);
        System.out.println("索引是"+value);
    }
    //数组中没有相同的元素
    public static int binarySearch(int arr[],int left,int right,int findVal){
        //当满足此条件时说明递归整个数组但是没有找到值
        if (left>right){
            return -1;
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if (findVal>midVal){
            return binarySearch(arr,mid+1,right,findVal);
        }else if (findVal<midVal){
            return binarySearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }

    //数组中有相同的元素
    public static String binarySearch2(int arr[],int left,int right,int findVal){
        //当满足此条件时说明递归整个数组但是没有找到值
        if (left>right){
            return -1+"";
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if (findVal>midVal){
            return binarySearch2(arr,mid+1,right,findVal);
        }else if (findVal<midVal){
            return binarySearch2(arr,left,mid-1,findVal);
        }else{
            //查找左边相同的数
            int temp=mid-1;
            ArrayList<Integer> IndexList = new ArrayList<>();
            while (true){
                if (temp<0 || arr[temp]!=findVal){
                    break;
                }
                IndexList.add(temp);
                temp-=1;
            }
            IndexList.add(mid);
            //查找右边相同的数
            temp=mid+1;
            while (true){
                if (temp>arr.length-1 || arr[temp]!=findVal){
                    break;
                }
                IndexList.add(temp);
                temp+=1;
            }
            return IndexList.toString();
        }
    }
}
