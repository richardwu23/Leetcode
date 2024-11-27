package cn.bw.leetcode;

public class L73矩阵置零 {

    /**
     * 第一遍扫描：
     * 遍历矩阵，找到值为 0 的位置。
     * 在矩阵的第一行和第一列中设置标记，标记哪些行和列需要被置为 0。

     * 第二遍扫描：
     * 从第二行和第二列开始遍历矩阵，查看标记。
     * 如果当前元素所在的行或列被标记，则将其置为 0。

     * 3.处理第一行和第一列：
     * 根据标记变量 firstRowZero 和 firstColZero，将第一行和第一列置为 0。
     *
     *
     * 核心问题：标记的覆盖
     * 当你在矩阵中修改值时，如果直接将一个元素设置为 0，可能会影响后续的判断。例如：
     *
     * 如果立即处理一个元素为 0 的行或列，当程序继续遍历这一行或列时，会错误地认为其他元素本来也应该置为 0。
     * 标记第一行和第一列，并分阶段处理，能确保在处理非首行首列的元素时，第一行和第一列还保留标记信息，而不会被提前覆盖。
     * 分阶段处理的优点
     * 第一步：标记第一行和第一列
     * 使用第一行和第一列作为标记位，而不是额外的数组。
     * 记录哪些行和列需要置零，同时不修改矩阵中的实际值。
     * 第二步：处理非首行首列
     * 根据第一行和第一列的标记，置零非首行首列的元素。
     * 在这一阶段，第一行和第一列的标记仍然有效，不会受到置零的影响。
     * 第三步：处理第一行和第一列
     * 由于第一行和第一列已经用作标记，需要最后单独处理它们。
     * 避免在处理非首行首列时，过早将第一行或第一列清零，导致标记丢失。
     */

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length; // 行数
        int cols = matrix[0].length; // 列数

        boolean firstRowZero = false; // 标记第一行是否需要置零
        boolean firstColZero = false; // 标记第一列是否需要置零

        // 第一遍扫描矩阵，记录需要置零的行和列
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // 标记行和列
                    if (i == 0) firstRowZero = true; // 第一行需要置零
                    if (j == 0) firstColZero = true; // 第一列需要置零
                    matrix[i][0] = 0; // 标记当前行
                    matrix[0][j] = 0; // 标记当前列
                }
            }
        }

        // 第二遍扫描矩阵，使用第一行和第一列的标记置零其他元素
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0; // 置零
                }
            }
        }

        // 最后处理第一行
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // 最后处理第一列
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
