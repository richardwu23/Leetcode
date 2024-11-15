package cn.bw.leetcode;

import java.util.PriorityQueue;

public class L295数据流中位数 {


    class MedianFinder {

        // 最大堆，用于存储较小的一半数据
        private PriorityQueue<Integer> maxHeap;
        // 最小堆，用于存储较大的一半数据
        private PriorityQueue<Integer> minHeap;

        // 构造函数
        public MedianFinder() {
            // 最大堆：使用逆序排列（默认大顶堆）
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
            // 最小堆：使用默认的顺序（小顶堆）
            minHeap = new PriorityQueue<>();
        }

        // 添加数字到数据流中
        public void addNum(int num) {
            // 先将数添加到最大堆中
            maxHeap.offer(num);

            // 将最大堆的堆顶元素移动到最小堆
            minHeap.offer(maxHeap.poll());

            // 如果最小堆的大小大于最大堆的大小，将最小堆的堆顶元素移回最大堆
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        // 查找中位数
        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                // 如果两个堆大小相等，返回两个堆顶元素的平均值
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                // 如果最大堆的元素多，返回最大堆的堆顶元素
                return maxHeap.peek();
            }
        }
    }

}
