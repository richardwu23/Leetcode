package cn.bw.leetcode;

public class L43字符串相乘 {

    /**
     * 思路：模拟，从后向前， 不断更新 当前位和进位
     * 当前位   result[i + j + 1]
     * 进位  result[i + j]
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))return "0";

        int len1=num1.length(),len2=num2.length();
        int[] ans = new int[len1+len2];

        for(int i=len1-1;i>=0;i--){
            int digit1 = num1.charAt(i)-'0';
            for(int j=len2-1;j>=0;j--){
                int digit2=num2.charAt(j)-'0';

                int multiple= digit1 * digit2;
                int sum = multiple + ans[i+j+1];

                ans[i+j+1]= sum%10;
                ans[i+j] +=sum/10;
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i:ans){
            if((builder.length()==0 &&i==0))continue;
            builder.append(i);
        }

        return builder.toString();
    }

}
