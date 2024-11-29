package cn.bw.leetcode;

public class L4寻找两个正序数组的中位数 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length, len2=nums2.length;

        int total = len1+len2;
        int left=(total+1)>>1, right=(total+2)>>1;

        if(total%2==0){
            return (getKth(nums1,0,len1-1,nums2,
                    0,len2-1,left)+
                    getKth(nums1,0,len1-1,nums2,
                            0,len2-1,right))*0.5;
        }else {
            return getKth(nums1,0,len1-1,nums2,
                    0,len2-1,left);
        }

    }

    private int getKth(int[] nums1,int s1,int e1,
                       int[] nums2, int s2,int e2, int k){

        int len1=e1-s1+1, len2=e2-s2+1;
        // 确保 nums1 是较短的数组
        if(len1>len2) return getKth(nums2, s2, e2, nums1, s1, e1, k);
        if(len1==0) return nums2[s2+k-1];
        if(k==1) return Math.min(nums1[s1],nums2[s2]);

        //选择两个数组中第 k/2 个元素进行比较
        int i1=s1+Math.min(len1,k/2)-1;
        int i2=s2+Math.min(len2,k/2)-1;

        // 如果 nums1 的第 i1 个元素大于 nums2 的第 i2 个元素,
        if(nums1[i1]>nums2[i2]){
            // 排除 nums2 的 [s2, i2] 部分，并更新 k
            return getKth(nums1, s1, e1, nums2,
                    i2+1, e2, k-(i2-s2+1)) ;
        }else {
            // 排除 nums1 的 [s1, i1] 部分，并更新 k
            return getKth(nums1, i1+1, e1,
                    nums2, s2, e2, k-(i1-s1+1));
        }

    }

}
