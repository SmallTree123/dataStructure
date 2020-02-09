package Sort;

import java.util.Arrays;

public class 基数排序 {
    public static void main(String[] args) {
        int arr[]={234,5,12,556,331,98,0,7667};
        int max=arr[0];//得到数组最大数的位数
        for (int i=1;i<arr.length;i++){
            if (arr[i]>max){
                max-=arr[i];
            }
        }
        //得到最大的位数
        int maxLength=(max+"").length();

        //定义一个二维数组，表示十个桶，每个桶就是一个一维数组
        int[][] bucket=new int[10][arr.length];

        //为了记录每个桶中实际存放了多少个数据，我，我们定义一个一维数组来记录每个桶的每次放入的数据个数
        int[] bucketElementCounts=new int[10];

        for (int i=0,n=1;i<maxLength;i++,n*=10){
            for (int j=0;j<arr.length;j++){
                //取出每个元素得个位得值
                int digitOfElement=arr[j]/n%10;
                //放入对应的捅中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
            int index=0;
            //遍历每一个桶，并将桶中的数据放入到原数组中
            for (int k=0;k<bucketElementCounts.length;k++){
                //如果桶中有数据，我们才放到原来的数组中
                if (bucketElementCounts[k]!=0){
                    //循环该桶即第k个桶
                    for (int l=0;l<bucketElementCounts[k];l++){
                        //取出元素放入到arr
                        arr[index++]=bucket[k][l];
                    }
                }
                //第l轮处理后需要将每个bucketElementCounts[k]=0;
                bucketElementCounts[k]=0;
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
