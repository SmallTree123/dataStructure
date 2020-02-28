package 经典算法;

import java.util.Arrays;

public class kmp {
    public static void main(String[] args) {
        String str1="BBC ABCDAB ABCDABCDABDE";
        String str2="ABCDABD";

        int next[]=kmpNext("ABCDABD");
        int index= kmpSearch(str1, str2, next);
        System.out.println("部分匹配表: "+Arrays.toString(next));
        System.out.println("匹配的索引是: "+index);
    }

    /**
     * kmp搜索算法
     * @param str1 源字符串
     * @param str2 子串
     * @param next  部分匹配表，是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1,String str2,int[] next){
        //遍历
        for (int i = 0,j = 0; i < str1.length(); i++) {
            //需要处理str1.charAt(i)！=str2.charAt(j)，去调整j的大小
            //kmp核心算法
            while (j > 0 && str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
           if (str1.charAt(i)==str2.charAt(j)){
               j++;
           }
           if (j==str2.length()){
               return i-j+1;
           }
        }
        return -1;
    }

    /**
     * 获取到一个字符串(子串)的部分匹配值
     * 对于bread字符串
     * 前缀 b,br,bre,brea
     * 后缀 r,re,rea,read
     * 根据前后缀有多少相同的字符串来制作部分匹配表
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest){
        //创建一个next数组保存部分匹配值
        int[] next=new int[dest.length()];
        next[0]=0; //如果字符串长度是1，部分匹配值就是0
        for (int i = 1,j = 0; i < dest.length(); i++) {
            //dest.charAt(i)!=dest.charAt(j)，我们需要从next[j-1]获取新的j
            //直到发现//dest.charAt(i)==dest.charAt(j)成立才退出
            //这是kmp算法的核心点
            while (j > 0 && dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];
            }
            //dest.charAt(i)==dest.charAt(j)满足时，部分匹配值就+1
            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
