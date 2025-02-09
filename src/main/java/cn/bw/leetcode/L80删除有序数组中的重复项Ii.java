package cn.bw.leetcode;

public class L80删除有序数组中的重复项Ii {
    //双指针，快慢指针
//    利用双指针法在遍历过程中直接修改数组，使得每个元素最多保留两次。
//    快指针负责检查所有元素，慢指针负责构造最终结果。
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        // 如果数组长度小于等于 2，所有元素都符合条件，直接返回长度
        if (len <= 2) return len;

        // `s` 指向新数组有效部分的下一个可写位置。
        // `f` 用于遍历数组。
        int s = 2, f = 2;
        while (f < len) {
            //nums[s - 2] 表示有效数组中倒数第二个元素：
            // 不相等，说明 `nums[f]` 仍符合允许出现的规则（每个元素最多两次）。
            if (nums[s - 2] != nums[f]) {
                nums[s++] = nums[f];
            }
            f++;
        }
        return s;
    }

}
