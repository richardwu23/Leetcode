package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

public class L108将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        int len=nums.length;
        return build(nums,0,len-1);
    }

    TreeNode build(int[] nums, int left, int right){
        if(left>right)return null;
        if(left==right)return new TreeNode(nums[left]);
        int mid = left + ((right-left)>>1);
        TreeNode root=new TreeNode(nums[mid]);
        root.left = build(nums,left,mid-1);
        root.right = build(nums,mid+1,right);

        return root;
    }
}
