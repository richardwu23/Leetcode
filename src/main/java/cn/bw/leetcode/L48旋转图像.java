package cn.bw.leetcode;

public class L48旋转图像 {


    //先沿 对角线 翻转， 再水平翻转
    //注意 对角线 翻转的写法， 和 水平翻转的写法

    // **第一步：矩阵转置**
    // 将矩阵的第 r 行第 c 列元素与第 c 行第 r 列元素互换
    // c = r 起始的意思是 对角线的 右侧开始翻

    // **第二步：水平翻转每一行**
    // 将每一行的元素从左到右翻转

    public void rotate(int[][] matrix) {
        int rows=matrix.length, cols=matrix[0].length;

        for(int r=0;r<rows;r++){
            for(int c=r;c<cols;c++){
                int t = matrix[r][c];
                matrix[r][c]=matrix[c][r];
                matrix[c][r]=t;
            }
        }

        for(int r=0;r<rows;r++){
            // 遍历当前行的前一半元素
            for(int c=0;c<cols/2;c++){
                int t = matrix[r][c];
                //注意 rows-c-1
                matrix[r][c]=matrix[r][cols-c-1];
                matrix[r][cols-c-1] = t;
            }
        }



    }


}
