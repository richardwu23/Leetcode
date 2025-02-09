package cn.bw.leetcode;

public class L274H指数 {

    public int hIndex(int[] citations) {
        int n = citations.length;
        // cnt数组用于统计引用次数的分布
        // cnt[i]表示有多少篇论文的引用次数为 i（当 i = n 时表示引用次数 ≥ n 的论文数）
        int[] cnt = new int[n + 1];

        // 将所有论文的引用数分布计入 cnt 数组
        // 对于引用次数大于 n 的情况，我们直接将其计为 n（这样统计后 cnt[n]表示的是"引用次数≥n"的论文数）
        for (int c : citations) {
            cnt[Math.min(c, n)]++;
        }

        // s 用于累计统计有多少篇论文的引用次数至少达到某个数值
        int s = 0;
        // 从大到小遍历 i，从 n 开始往下，因为 h 指数不可能大于 n
        // 我们期望找到最大的 i，使得有至少 i 篇论文的引用次数 ≥ i
        for (int i = n; i >= 0; i--) {
            //i 从大到小，因此是累加
            s += cnt[i];
            if (s >= i) {
                return i;
            }
        }

        // 理论上不会执行到这里，因为当 i=0 时，s>=0 一定满足，但为了代码完整性，仍可以保留
        return 0;
    }

}
