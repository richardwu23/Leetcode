package cn.bw.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L347前k个高频元素 {

    /**
     * 思路： 先统计频率，再插入优先级队列，超过k 就弹出 频率小的
     *
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (int i : map.keySet()) {
            if (pq.size() < k) {
                pq.add(i);
            } else {
                if (map.get(i) > map.get(pq.peek())) {
                    pq.poll();
                    pq.add(i);
                }
            }
        }

        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = pq.poll();
        }
        return results;
    }

}
