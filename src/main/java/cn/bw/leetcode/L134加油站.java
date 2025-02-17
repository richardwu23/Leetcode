package cn.bw.leetcode;

/**
 * 计算总加油量和总消耗量：
 *
 * totalGas = sum(gas[i]) 记录总加油量。
 * totalCost = sum(cost[i]) 记录总消耗量。
 * 如果 totalGas < totalCost，说明无论从哪个站点出发，油都不够绕行一圈，返回 -1。
 * 寻找可行的起点：
 *
 * 遍历每个站点，维护 当前油箱油量 tank。
 * tank += gas[i] - cost[i] 表示从 i 号加油站出发，到达下一个加油站后的剩余油量。
 * 如果 tank < 0，表示 无法从 start 到 i+1，需要将起点调整到 i+1，并重置 tank = 0。
 */
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
