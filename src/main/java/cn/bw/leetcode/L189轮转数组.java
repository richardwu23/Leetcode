package cn.bw.leetcode;

public class L189轮转数组 {

    /**
     * 我们需要将数组中的元素向右轮转 k 个位置。以下是解决问题的三种方法：
     * <p>
     * 额外数组法：使用一个额外数组，将新位置计算出来后存储。
     * 反转法：通过数组局部和整体反转来实现旋转。
     * 环状替换法：通过逐个元素重新定位，避免额外空间。
     * <p>
     * 这里采用 反转法，因为这种方法空间复杂度为 O(1)，且实现简单。
     * 反转法步骤
     * <p>
     * 反转整个数组：将数组所有元素顺序颠倒。
     * 反转前k 个元素：将前k 个元素还原到正确顺序。
     * 反转后面的元素：将剩余部分元素还原到正确顺序。
     * 关键点
     * k 可能大于数组长度n，因此需要取模操作 k=k%n。
     */
    public void rotate(int[] nums, int k) {

        int len=nums.length;
        //注意 k不能超过数组长度
        k = k%len;
//反转整个数组：将数组所有元素顺序颠倒。
        reverse(nums,0,len-1);
//反转前k 个元素：将前k 个元素还原到正确顺序。
        reverse(nums,0,k-1);
//反转后面的元素：将剩余部分元素还原到正确顺序。
        reverse(nums,k,len-1);

    }

    void reverse(int[] nums, int s, int e){
        while (s<e){
            int t = nums[s];
            nums[s]=nums[e];
            nums[e]=t;

            s++;
            e--;
        }
    }
}
