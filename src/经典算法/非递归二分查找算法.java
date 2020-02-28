package 经典算法;

public class 非递归二分查找算法 {
    public static void main(String[] args) {
        int arr[]={1,3,5,8,10,11,67,100};
        System.out.println(binarySearch(arr,100));
    }

    /**
     * 二分查找算法的非递归实现
     * @param arr 待查找的数组
     * @param target 需要查找的数
     * @return 返回对应的下标,-1表示没找到
     */
    public static int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (arr[mid]==target){
                return mid;
            }else if (arr[mid]>target){
                right=mid-1;//需要想左边查找
            }else {
                left=mid+1;//需要向右边查找
            }
        }
        return -1;
    }
}
