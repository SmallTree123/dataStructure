package Sort;

import java.util.Arrays;

public class 归并排序 {
    public static void main(String[] args) {
        int arr[]={101,34,119,3,45,1,3,330};
        int temp[]=new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println("归并排序后的数组="+Arrays.toString(arr));
    }
    //分+合并的方法
    public static void mergeSort(int arr[],int left,int right,int temp[]){
        if (left<right){
            int mid=(left+right)/2;//中间索引
            //向左递归进行分解
            mergeSort(arr,left,mid,temp);
            //向右递归进行分解
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    //合并的方法
    public static void merge(int arr[],int left,int mid,int right,int temp[]){
        int i=left;//初始化i，左边有序序列的初始索引
        int j=mid+1;//初始化j，右边有序序列的初始索引
        int t=0;//指向temp数组的当前索引

        //(一)
        //先把左右两边的数据按照规则填充到temp数组中
        //直到左右两边的有序序列有一边处理完毕为止
        while (i<=mid&&j<=right){
            //如果左边的有序序列当前元素小于等于右边的
            //即将左边的当前元素填充到temp数组中
            //然后 t++;i++
            if (arr[i]<=arr[j]){
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }else {
                temp[t]=arr[j];
                t+=1;
                j+=1;
            }
        }

        //(二)
        //把有剩余数据的一边的数据依次填充到temp数组中
        while (i<=mid){ //左边的有序序列中还有剩余的元素，全部填充到temp数组中
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while (j<=right){ //右边的有序序列中还有剩余的元素，全部填充到temp数组中
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }
        //(三）
        //将temp数组的元素拷贝到arr
        //注意并不是每次拷贝所有
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }
    }
}
