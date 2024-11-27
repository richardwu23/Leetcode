package cn.bw.leetcode;

import cn.bw.leetcode.common.TreeNode;

public class L333最大二叉搜索子树 {







    class Solution {
        public int largestBSTSubtree(TreeNode root) {

            dfs(root);
            return max;


        }
        //储存最大值
        int max=0;
        public int[] dfs(TreeNode root) {
            if (root == null) {return null;}
            //res[0]表示 当前节点为根的 二叉搜索树的 大小, res[1] 表示左子树 值上限， res[2] 右子树 值下限
            int[] res = new int[3];
            //初始化上界和下界，后面根据子树节点更新
            res[1]=root.val;res[2]=root.val;

            //获取左右子树信息
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);

            //用于标记以该节点为根节点是否能构成二叉搜索树，遇到不符合规则的情况时改为false
            boolean isvaild=true;

            if(left!=null){
                //树大小加上左子树大小
                res[0]+=left[0];
                //更新上下界
                res[1]=Math.min(left[1],res[1]);
                res[2]=Math.max(left[2],res[2]);
                //如果左子树不为空情况下大小为0，说明左子树不符合规则，该节点作为父节点也不符合规则
                //当前节点值不大于左子树的上界说明左子树无法接到当前节点
                //不符合规则时标记为无效
                if(left[0]==0||root.val<=left[2]){
                    isvaild=false;
                }
            }
            if(right!=null){
                //树大小加上右子树大小
                res[0]+=right[0];
                //更新上下界
                res[1]=Math.min(right[1],res[1]);
                res[2]=Math.max(right[2],res[2]);
                //如果右子树不为空情况下大小为0，说明右子树不符合规则，该节点作为父节点也不符合规则
                //当前节点值不小于右子树的下界说明右子树无法接到当前节点
                //不符合规则时标记为无效
                if(right[0]==0||root.val>=right[1]){
                    isvaild=false;
                }
            }
            //树大小加上当前节点
            res[0]++;
            //如果发现树无效，则将树大小设置为0
            if(!isvaild) res[0]=0;
            //更新最大值
            max=Math.max(max,res[0]);
            return res;

        }
    }







    static class Result {
        TreeNode node; // BST根节点
        int size; // BST的size
        int max; // BST的最大值
        int min; // BST的最小值
    }

    public int largestBSTSubtree(TreeNode root) {
        Result r = visit(root);
        return r == null ? 0 : r.size;
    }

    public Result visit(TreeNode node) {
        if (node == null) return null;

        Result l = null, r = null;
        if (node.left != null) l = visit(node.left);
        if (node.right != null) r = visit(node.right);

        // 当前树为BST
        boolean lValid = (l == null || (l.node == node.left && l.max < node.val));
        boolean rValid = (r == null || (r.node == node.right && r.min > node.val));
        if (lValid && rValid) {
            Result result = new Result();
            result.node = node;
            result.max = r == null ? node.val : r.max;
            result.min = l == null ? node.val : l.min;
            result.size = (l == null ? 0 : l.size) + (r == null ? 0 : r.size) + 1;
            return result;
        }

        // 左右子树中找到了BST
        if (l != null && r != null) {
            return l.size > r.size ? l : r;
        }
        if (l != null) return l;
        if (r != null) return r;

        return null;
    }
}
