package cn.bw.leetcode;

public class L4寻找两个正序数组的中位数 {




    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int total = m + n;

        if (total % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, total / 2 + 1);
        } else {
            return (findKth(nums1, 0, nums2, 0, total / 2) +
                    findKth(nums1, 0, nums2, 0, total / 2 + 1)) * 0.5;
        }
    }

    private int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 处理边界情况
        if (i >= nums1.length) return nums2[j + k - 1]; // nums1 用完，直接取 nums2 的第 k 个
        if (j >= nums2.length) return nums1[i + k - 1]; // nums2 用完，直接取 nums1 的第 k 个
        if (k == 1) return Math.min(nums1[i], nums2[j]); // k == 1 直接返回最小值

        // 计算新位置的索引
        int mid1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }


    /**
     * i：数组 nums1 中分割的位置，左边有 i 个元素。
     * j：数组 nums2 中分割的位置，左边有 j 个元素。

     * 分割线将两个数组划分为“左侧”和“右侧”两部分：
     * 左侧部分包含 i 个来自 nums1 的元素和 j 个来自 nums2 的元素。

     * 左侧部分的最大值（max(nums1[i-1], nums2[j-1])）小于等于
     * 右侧部分的最小值（min(nums1[i], nums2[j])）

     * 逻辑意义：
     * 如果 nums1[i] < nums2[j - 1]，说明 nums1[i] 太小，分割线需要右移（增大i）。
     * 如果 nums1[i] >= nums2[j - 1]，说明 i 可能是正确分割点，分割线需要左移或保持不变。
     *
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短的数组
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays1(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int left = 0, right = m;
        while (left < right) {
            int i = left + (right - left) / 2; // nums1 的分割位置
            int j = totalLeft - i; // nums2 的分割位置

            //nums1[i] 右侧最小， nums2[j - 1] 左侧最大
            if (nums1[i] < nums2[j - 1]) {
                left = i + 1; // i 需要增大
            } else {
                right = i; // i 需要减小
            }
        }

        int i = left;
        int j = totalLeft - i;

        // 分割线左边的最大值
        int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
        int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
        int leftMax = Math.max(nums1LeftMax, nums2LeftMax);

        if ((m + n) % 2 == 1) {
            return leftMax;
        }

        // 分割线右边的最小值
        int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
        int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];
        int rightMin = Math.min(nums1RightMin, nums2RightMin);

        // 如果总长度为偶数，中位数是左右两部分的平均值
        return (leftMax + rightMin) / 2.0;
    }


    /**
     * left 中位数 左边界， right 中位数 右边界
     *
     *
     *
     */
    public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
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

    //找到 nums1 和 nums2 中 第k小的数
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
