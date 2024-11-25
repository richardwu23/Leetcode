package cn.bw.leetcode;

public class L134加油站 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0; // 总加油量
        int totalCost = 0; // 总消耗量
        int tank = 0; // 当前油箱剩余油量
        int start = 0; // 起始加油站索引

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i]; // 累计加油量
            totalCost += cost[i]; // 累计消耗量
            tank += gas[i] - cost[i]; // 更新当前油箱剩余油量

            // 如果油箱不足以到达下一个加油站，重置起点
            if (tank < 0) {
                start = i + 1; // 将起点设置为下一个加油站
                tank = 0; // 重置油箱
            }
        }

        // 如果总加油量大于等于总消耗量，返回起始索引，否则返回 -1
        return totalGas >= totalCost ? start : -1;
    }

}
