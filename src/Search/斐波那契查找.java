package Search;

import java.security.Key;
import java.util.Arrays;

public class 斐波那契查找 {
    public static int maxSize=20;
    public static void main(String[] args) {
        int arr[]={1,8,10,89,1000,1234};
        int fibSearch = fibSearch(arr, 1234);
        System.out.println(fibSearch);
    }

    //首先获取一个斐波那契数列
    public static int[] fib(){
        int[] f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i=2;i<maxSize;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    //编写斐波那契查找算法
    public static int fibSearch(int[] a,int key){
        int low=0;
        int high=a.length-1;
        int k=0; //表示斐波那契分割数值的下标
        int mid=0;//存放mid值
        int f[]=fib();//获取到斐波那契数列
        while (high>f[k]-1){
            k++;
        }
        //因为f[k]值可能大于a的长度，因此我们需要创建一个新的Arrays类构建一个新的数组并指向a[]
        //不足的部分使用0填充
        int[] temp=Arrays.copyOf(a,f[k]);
        //实际上需要使用a数组最后的数填充temp
        for (int i=high+1;i<temp.length;i++){
            temp[i]=a[high];
        }
        //使用while循环来处理找到我们的数key
        while (low<=high){ //只要这个条件满足，就可以找
            mid=low+f[k-1]-1; //我们应该继续向数组的前面查找(左边)
            if (key<temp[mid]){
                high=mid-1;
                //因为前面有f[k-1]个元素与，所以可以继续拆分f[k-1]=f[k-2]+fk-3]
                k--;
            }else if (key>temp[mid]){ //我们继续向数组的后面查找(右边)
                low=mid+1;
                //因为后面有f[k-2]所以可以继续拆分f[k-1]=f[k-3]+f[k-4]
                k-=2;
            }else { //找到
                //需要确定，返回的是哪个下标
                if (mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }

        }
        return -1;
    }
}
