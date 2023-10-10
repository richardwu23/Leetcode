package cn.bw.leetcode;

/**
 * 思路：
 * 想象成 十叉树。 十叉树的先序遍历
 * 1.怎么确定一个前缀下 所有子节点 个数
 * 2.如果 第k个 在当前前缀下，怎么继续往下面节点找
 * 3.如果 第k个不在当前前缀下， 那么怎么继续扩大前缀 ，增加范围
 */
public class L440字典序第K小数字 {

    public int findKthNumber(int n, int k) {

        long cur = 1, pre = 1;
        while (cur < k) {
            //获取当前节点下 所有 节点和
            long cnt = getCount(pre, n);
            //不在当前前缀下
            if (cur + cnt <= k) {
                cur += cnt;
                pre++;
            } else {
                //在当前前缀下
                cur += 1;
                pre *= 10;
            }
        }

        return Integer.parseInt(String.valueOf(pre));
    }

    private long getCount(long prefix, long n) {
        long cnt=0, cur=prefix, next=prefix+1;
        while (cur<=n){
            cnt+=Math.min(n+1, next) - cur;
            cur *=10;
            next *=10;
        }

        return cnt;

    }

    public static void main(String[] args){
        L440字典序第K小数字 a = new L440字典序第K小数字();
        a.findKthNumber(13,2);

        System.out.println("....");
    }
}
