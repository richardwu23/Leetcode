package cn.bw.leetcode;

import java.util.LinkedList;
import java.util.List;

public class L118杨辉三角 {


    /**
     [1]
     [1,1]
     [1,2,1]
     [1,3,3,1]
     [1,4,6,4,1]
     计算的二维数组是 c，
     * 每一排的第一个数和最后一个数都是 1，即 c[i][0]=c[i][i]=1。
     * 其余数字，等于左上方的数，加上正上方的数，
     * 即 c[i][j]=c[i−1][j−1]+c[i−1][j]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for(int r=0;r<numRows;r++){
            List<Integer> row=new LinkedList<>();
            for(int c=0;c<=r;c++){
                if(r==c||c==0){
                    row.add(1);
                }else {
                    row.add(res.get(r-1).get(c)+res.get(r-1).get(c-1));
                }
            }
            res.add(row);
        }
        return res;

    }
}
