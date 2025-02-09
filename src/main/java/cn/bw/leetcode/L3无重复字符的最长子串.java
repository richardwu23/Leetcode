package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

/**
 * 解法： 滑动窗口 + 哈希表
 * map 统计 字符 s[i] 最后一次出现的索引
 idx 不重复的字符的 最右边的

 */
public class L3无重复字符的最长子串 {


    public int lengthOfLongestSubstring(String s) {
        // 使用滑动窗口
        Set<Character> set = new HashSet<>(); // 用于存储窗口中的字符
        int maxLength = 0; // 记录最长子串的长度
        int left = 0; // 窗口的左边界

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 如果当前字符已存在于集合中，则缩小窗口
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // 将当前字符加入集合，并更新最大长度
            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    //将 i 初始化为 -1 可以简化计算并确保初始的无重复子串从索引 0 开始时能正确计入长度。
    public int lengthOfLongestSubstring1(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int l=-1, ans=0, len=s.length();
        for(int r=0;r<len;r++){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                l = Math.max(l,map.get(c));
            }
            map.put(c,r);
            ans = Math.max(ans,r-l);
        }

        return ans;

    }







    public int lengthOfLongestSubstring0(String s) {
        int len=s.length(), result=0, idx=0;

        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                idx = Math.max(map.get(c),idx);
            }
            result = Math.max(result, i-idx+1);
            map.put(c,i+1);
        }
        return result;

    }

    public static class L889前序和后序构造二叉树 {

        public TreeNode constructFromPrePost(int[] preorder,
                                             int[] postorder) {
            int len=preorder.length;
            int[] map = new int[len+1];
            for(int i=0;i<len;i++){
                map[postorder[i]]=i;
            }
            return build(preorder,0,len,
                    postorder,0,len,map);

        }

        TreeNode build(int[] pre,
                       int preL,int preR,
                       int[] pst, int pstL,
                       int pstR,int[] map){
            if(preL>preR||pstL>pstR) return null;
            if(preL==preR) return null;
            if(preL+1==preR) return new TreeNode(pre[preL]);

            int leftSize = map[pre[preL+1]]-pstL+1;
            TreeNode rightChild=build(pre,preL+1,preL+1+leftSize,
                    pst,pstL,pstL+leftSize,map);
            TreeNode leftChild = build(pre,preL+1+leftSize,preR,
                    pst,pstL+leftSize,pstR-1,map);
            return new TreeNode(pre[preL],leftChild,rightChild);
        }

    }
}
