package cn.bw.leetcode;

public class L26删除有序数组中的重复项 {

    /**
     * 遍历数组时，比较当前元素 nums[i] 与去重后最后一个元素 nums[idx]。
     * 如果发现新元素，将其移动到去重部分的下一个位置。
     * 最后，返回去重后数组的长度。
     *
     * 注意点
     *输入要求：数组必须是 有序的，因为代码逻辑依赖于相邻的重复元素会连续出现。
     *原地操作：去重是在输入数组本身上完成的，没有分配额外空间。
     */
    public int removeDuplicates(int[] nums) {
        int len=nums.length;

        int idx=0;
        for(int i=0;i<len;i++){
            if(nums[i]!=nums[idx]){
                nums[++idx]=nums[i];
            }

        }
        return idx+1;

    }
}
