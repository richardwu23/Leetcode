package cn.bw.leetcode;


/***
 * 二分法排序， 想象成 摆扑克牌 分堆。  top[i] 是每堆 最小
 * 最终的left 表示元素 cur 应该放的位置
 */
public class L300最长增长子序列 {

    public int lengthOfLIS(int[] nums) {

        int len=nums.length;
        int[] tops = new int[len];
        int piles=0;
        for(int i=0;i<len;i++){
            int cur =nums[i];
            int left=0, right=piles;

            while (left<right){
                int mid=(left+right)>>1;
                if(tops[mid]>=cur){
                    right=mid;
                }else {
                    left=mid+1;
                }
            }
            //说明 cur 应该放新堆上
            if(left==piles){
                piles++;
            }
            tops[left]=cur;
        }
        return piles;

    }
}
