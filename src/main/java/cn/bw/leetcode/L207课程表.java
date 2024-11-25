package cn.bw.leetcode;

import java.util.Stack;

public class L207课程表 {

    /**
     * 思路： 拓扑排序
     * 关键点
     * 入度表示依赖数量:
     * 每门课程的入度表示还有多少未完成的先修课程。
     * 入度为 0 表示可以立即选修。
     * 拓扑排序的目标:
     * 找到一种顺序，使所有课程都能被选修。
     * 如果图中有环，则无法完成拓扑排序（最终剩余课程数 numCourses > 0）。
     * 数据结构选择:
     * 使用栈模拟队列来管理入度为 0 的课程（可以替换为 Queue）。
     * 时间复杂度为
     * 𝑂(V+𝐸) E 是先修关系的数量, V是课程
     */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] degree = new int[numCourses];
            for(int[] course:prerequisites){
                degree[course[0]]++;
            }
            Stack<Integer> queue = new Stack<>();
            for(int i=0;i<numCourses;i++){
                if(degree[i]==0){
                    queue.push(i);
                }
            }
            while (!queue.isEmpty()){
                int cur = queue.pop();
                numCourses--;
                for(int[] course:prerequisites){
                    if(course[1]!=cur){
                        continue;
                    }
                    degree[course[0]]--;
                    if(degree[course[0]]==0){
                        queue.push(course[0]);
                    }
                }
            }

            return  numCourses==0;
        }

}
