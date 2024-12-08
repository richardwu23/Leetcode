package cn.bw.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L46全排列 {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new LinkedList<>();
        Deque<Integer> path = new LinkedList<>();
        backtrack(nums, path, rs, new boolean[nums.length]);
        return rs;
    }

    void backtrack(int[] nums,
                           Deque<Integer> path, // 当前排列路径
                           List<List<Integer>> rs, // 最终结果列表
                           boolean[] v) { // 记录数组中的元素是否已被使用
        // 如果当前路径长度等于 nums 的长度，说明已经完成一个排列
        if (path.size() == nums.length) {
            // 将当前路径转换为一个列表，并加入结果集 rs
            rs.add(new LinkedList<>(path));
            return; // 回溯结束，返回上一层
        }

        // 遍历 nums 数组中的每一个元素
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素未被使用
            if (!v[i]) {
                // 将当前元素加入到路径中
                path.add(nums[i]);
                // 标记当前元素为已使用
                v[i] = true;

                // 递归调用 backtrack 进入下一层
                backtrack(nums, path, rs, v);

                // 回溯操作：恢复状态
                v[i] = false; // 取消当前元素的标记
                path.removeLast(); // 从路径中移除当前元素
            }
        }
    }

}
