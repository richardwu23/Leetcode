package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class L215数组中的第K个最大元素 {



    public int findKthLargest(int[] nums, int k) {
        // 获取数组长度
        int len = nums.length;
        // 调用快速选择算法，目标是找到第 len-k 个元素（因为数组下标从 0 开始，第 k 大即倒数第 k）
        return quickSelect(nums, 0, len - 1, len - k);
    }


    int quickSelect(int[] nums, int left, int right, int nth) {
        // 如果左右指针重合，直接返回当前值
        if (left == right) return nums[left];

        // 随机选择一个分区点（防止最差情况，保证平均时间复杂度）
        Random random = new Random();
        int pth = left + random.nextInt(right - left);

        // 对数组进行分区操作，并获取分区点的位置
        pth = partition(nums, left, right, pth);

        // 根据分区点的位置判断目标元素在哪个范围
        if (pth < nth) {
            // 如果分区点位置小于目标索引，递归右侧部分
            return quickSelect(nums, pth + 1, right, nth);
        } else if (pth > nth) {
            // 如果分区点位置大于目标索引，递归左侧部分
            return quickSelect(nums, left, pth - 1, nth);
        } else {
            // 如果分区点位置等于目标索引，直接返回结果
            return nums[pth];
        }
    }


    int partition(int[] nums, int left, int right, int pth) {
        // 选取分区点值（pivot），并将其移到右端
        int pivot = nums[pth];
        swap(nums, pth, right);

        // idx 用于追踪小于 pivot 的区域的边界
        int idx = left;

        // 遍历区间 [left, right]
        for (int i = left; i <= right; i++) {
            // 如果当前元素小于 pivot，将其放到 idx 所在位置，并移动 idx
            if (nums[i] < pivot) {
                swap(nums, i, idx);
                idx++;
            }
        }
        // 将 pivot 放回到 idx 所在位置，此时 pivot 左边全小于它，右边全大于等于它
        swap(nums, idx, right);

        // 返回分区点的位置
        return idx;
    }


    void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }





}
