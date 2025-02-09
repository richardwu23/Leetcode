package cn.bw.leetcode;

import java.util.*;

public class L1766互质数 {

    /**
     * 1.建图：通过边列表 edges 构建无向图。
     * 2.深度优先搜索（DFS）：
     *  记录每个节点的祖先节点。
     *  判断当前节点的值与祖先节点的值是否互质。
     *  选择最近的符合条件的祖先节点。
     * 3.互质判断：使用 gcd 函数判断两个数是否互质。
     *
     * 如果有多个祖先节点的值和当前节点互质，
     * depth 可以用来比较这些祖先节点的深度，从而选择最近的祖先节点。
     *
     * 恢复状态部分逻辑：
     * 1.递归中的状态维护：
     * 在当前节点被访问时，将当前节点的值 nums[node] 和相关信息（节点编号和深度）保存到 coprimeMap 中。
     * 这样可以保证在递归的子树中，coprimeMap 包含了当前路径上所有可能的祖先节点。
     * 2.回溯时恢复状态：
     * 回溯时需要恢复 coprimeMap 的状态，因为当前节点的值 nums[node] 只对当前子树有效。
     * 如果在访问当前节点之前，coprimeMap 中已经有了 nums[node] 的信息（即 previous != null），我们需要将之前的值恢复，避免影响其他分支的递归。
     * 如果当前节点是第一个使用这个值的节点（即 previous == null），则直接从 coprimeMap 中移除它。
     */

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        // 构建图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // 记录每个数值的最近节点及其深度
        Map<Integer, int[]> coprimeMap = new HashMap<>();
        boolean[] visited = new boolean[n];

        // 深度优先搜索
        dfs(0, -1, 0, nums, graph, coprimeMap, visited, ans);
        return ans;
    }

    private void dfs(int node,
                     int parent,
                     int depth,
                     int[] nums,
                     List<List<Integer>> graph,
                     Map<Integer, int[]> coprimeMap,
                     boolean[] visited,
                     int[] ans) {
        visited[node] = true;

        // 寻找最近的互质祖先
        int closestAncestor = -1;
        int maxDepth = -1;
        for (Map.Entry<Integer, int[]> entry : coprimeMap.entrySet()) {
            int num = entry.getKey();
            int[] ancestorInfo = entry.getValue();
            if (gcd(num, nums[node]) == 1 && ancestorInfo[1] > maxDepth) {
                closestAncestor = ancestorInfo[0];
                maxDepth = ancestorInfo[1];
            }
        }
        ans[node] = closestAncestor;

        // 保存当前节点到 coprimeMap
        int[] previous = coprimeMap.getOrDefault(nums[node], null);
        coprimeMap.put(nums[node], new int[]{node, depth});

        // 遍历子节点
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, node, depth + 1, nums, graph, coprimeMap, visited, ans);
            }
        }

        // 回溯时恢复 coprimeMap
        if (previous == null) {
            coprimeMap.remove(nums[node]);
        } else {
            coprimeMap.put(nums[node], previous);
        }
    }

    // 计算最大公约数
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
