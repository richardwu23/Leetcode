package cn.bw.leetcode;

public class L88合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int idx1=m-1, idx2=n-1, idx=m+n-1;
        // 从后向前遍历，比较 nums1 和 nums2 的当前元素，将较大的放入 nums1 的末尾
        while (idx2>=0 && idx1>=0){
            nums1[idx--]= nums1[idx1]>nums2[idx2]?
                    nums1[idx1--]:
                    nums2[idx2--];
        }
        // 如果 nums2 中还有剩余的元素（nums1 已经处理完）
        // 将 nums2 中的剩余元素拷贝到 nums1 的开头
        for(int i=0;i<=idx2;i++){
            nums1[i]=nums2[i];
        }

    }
}
