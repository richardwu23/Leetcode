package cn.bw.leetcode;

import java.util.*;

public class L2007从双倍数组中还原原数组 {

    /**
     * 排序 + 队列
     * 核心逻辑： 队列放 元素的 倍数。
     * 遍历 changed， 遇到 changed 元素 和 队列中元素相等 说明是 倍数，删除。
     * 如果不是，就加上倍数 放进队列，同时把 它 放到 ori 中去。
     *
     * @param changed
     * @return
     */
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0)return new int[0];

        Arrays.sort(changed);
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ori = new LinkedList<>();


        for(int num:changed){
            if(!queue.isEmpty() && queue.peek()==num){
                queue.poll();
            }else {
                queue.offer(num * 2);
                ori.add(num);
            }
        }

        if(!queue.isEmpty()){
            return new int[0];
        }
        return ori.stream().mapToInt(i->i).toArray();

    }
}
