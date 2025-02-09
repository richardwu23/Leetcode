package cn.bw.leetcode;

public class L14最长公共前缀 {


    /**
     *  s.indexOf(prefix)
     *    return 0 表示 从0开始匹配
     *    return -1 表示 不匹配
     *    return 正整数 表示 prefix在 s中出现的第一次的索引
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        // 注意 i=1
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // 缩短前缀
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }


    public static void main(String[] args){

        String s = "abcde";
        String pre = "bef";
        int i = s.indexOf(pre);


       System.out.println(".");

    }
}
