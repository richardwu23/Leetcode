package cn.bw.leetcode;

public class L88合并两个有序数组 {

    /**
     *  思路：从后向前遍历，比较 nums1 和 nums2 的当前元素，将较大的放入 nums1 的末尾
     *
     *  当主循环结束后，如果 nums2 中还有剩余元素，
     *  而 nums1 中的所有有效元素已经处理完（即 idx1 < 0 且 idx2 >= 0），
     *  这些剩余元素必然小于或等于 nums1 中已经处理的所有元素，
     *  因此直接从 nums2 开头依次拷贝到 nums1 的前部是安全的。
     *
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int idx1=m-1, idx2=n-1, idx=m+n-1;

        while (idx2>=0 && idx1>=0){
            nums1[idx--]= nums1[idx1]>nums2[idx2]?
                    nums1[idx1--]:
                    nums2[idx2--];
        }

        //注意，i<=idx2。 因为idx2=n-1
        for(int i=0;i<=idx2;i++){
            nums1[i]=nums2[i];
        }

    }
}
