package cn.bw.leetcode;

public class L14最长公共前缀 {


    public String longestCommonPrefix(String[] strs) {
        // 如果数组为空或没有元素，返回空字符串
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 初始化前缀为第一个字符串
        String prefix = strs[0];

        // 遍历数组中的每个字符串，从第二个字符串开始
        for (int i = 1; i < strs.length; i++) {
            // 不断截取当前的前缀，直到它是当前字符串的前缀
            //indexOf(prefix) 字符首次出现的索引位置；如果未找到，返回 -1。
            //indexOf(prefix) 返回0，表示从第一个字符开始匹配（即前缀）
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // 缩短前缀
                if (prefix.isEmpty()) {
                    return ""; // 如果前缀为空，直接返回空字符串
                }
            }
        }

        // 返回最终的最长公共前缀
        return prefix;
    }


    public static void main(String[] args){
       String[] strs = {"flower", "flow", "flight"};
       L14最长公共前缀 a = new L14最长公共前缀();
       String ans = a.longestCommonPrefix(strs);

       System.out.println(".");

    }
}
