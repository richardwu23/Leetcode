package cn.bw.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L89格雷编码 {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        backtrack(ans, 0, 0, 0, n);
        return ans;
    }

    /**
     * ans：存储 Gray Code 序列的列表。
     * node：当前生成的节点值，表示当前的二进制数。
     * isRightSubtree：指示当前递归是否在右子树中。0 表示左子树，1 表示右子树。
     * 通过 ^1 切换左子树和右子树。
     * depth：当前递归深度。
     * n：目标 Gray Code 的位数。
     *
     * node << 1:
     * 这是将当前节点 node 的二进制值左移一位，相当于在其二进制末尾增加一个 0。
     * 这等价于将 node 乘以 2，形成一个新的值，但并未确定新值的最后一位。
     *
     * 按位或 | 将 isRightSubtree 的值添加到新值的最低位
     * 如果 isRightSubtree == 0，意味着扩展时最低位加上 0
     * 如果 isRightSubtree == 1，意味着扩展时最低位加上 1
     */
    void backtrack(List<Integer> ans,int node,
                   int isRight,
                   int depth,
                   int n){
        if(depth==n){
            ans.add(node);
            return;
        }
        backtrack(ans, node<<1 | isRight, 0, depth+1, n);
        backtrack(ans, node<<1 | isRight^1, 1, depth+1, n);

    }
}
