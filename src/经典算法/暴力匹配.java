package 经典算法;

public class 暴力匹配 {
    public static void main(String[] args) {

        String str1=" sadasd,ootkry hello tfb";
        String str2="hello";
        int i = violenceMatch(str1, str2);
        System.out.println(i);
    }

    //暴力匹配算法实现
    public static int violenceMatch(String str1,String str2){
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();

        int s1Len=s1.length;
        int s2Len=s2.length;

        int i=0; //指向s1
        int j=0; //指向s2

        while (i<s1Len && j<s2Len){
            if (s1[i]==s2[j]){ //匹配成功
                i++;
                j++;
            }else {  //没有匹配成功
                i=i-(j-1);
                j=0;
            }
        }

        //判断是否匹配成功
        if (j==s2Len){
            return i-j;
        }else {
            return -1;
        }
    }
}
