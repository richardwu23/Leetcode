package cn.bw.leetcode;

public class L88合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int idx1=m-1, idx2=n-1, idx=m+n-1;

        while (idx2>=0 && idx1>=0){
            nums1[idx--]= nums1[idx1]>nums2[idx2]?
                    nums1[idx1--]:
                    nums2[idx2--];
        }

        for(int i=0;i<=idx2;i++){
            nums1[i]=nums2[i];
        }

    }
}
