package cn.bw.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L397整数替换 {

    // key：n， value：替换次数
    Map<Long, Integer> map = new HashMap<>();
    public int integerReplacement1(int n) {
        return dfs(n * 1L);
    }
    int dfs(long n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int ans = n % 2 == 0 ? dfs(n / 2) : Math.min(dfs(n + 1), dfs(n - 1));
        map.put(n, ++ans);
        return ans;
    }

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        // 奇数变为 1 需要 2步
        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }


}
