package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17电话号码字母组合 {

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        // 调用回溯函数，从第0个数字开始递归构建字母组合
        backtrack(digits, 0, map, new StringBuilder(), results);
        return results;
    }

    // 回溯函数
    private void backtrack(String digits,
                           int idx, // 当前处理的数字的索引
                           Map<Character, String> map, // 数字到字母的映射
                           StringBuilder sb, // 临时存储当前构建的字母组合
                           List<String> res) { // 存储最终结果
        // 如果已经处理完所有数字，将当前构建的组合加入结果列表
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        // 获取当前索引对应的数字，并找到映射的字母字符串
        char c = digits.charAt(idx);
        String letters = map.get(c);

        // 遍历该数字对应的每个字母，尝试将其加入当前路径
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i)); // 选择当前字母
            backtrack(digits, idx + 1, map, sb, res); // 递归处理下一个数字
            sb.deleteCharAt(sb.length() - 1); // 回溯，撤销选择
        }
    }

    public static void main(String[] args) {
        L17电话号码字母组合 lc = new L17电话号码字母组合();
        System.out.println(lc.letterCombinations("23"));
    }

}
