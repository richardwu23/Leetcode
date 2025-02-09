package cn.bw.leetcode;

public class L165比较版本号 {

    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\."), s2 = version2.split("\\.");
        int len1 = s1.length, len2 = s2.length, i1 = 0, i2 = 0;

        while (i1 < len1 || i2 < len2) {
            int v1 = 0, v2 = 0;

            if (i1 < len1) v1 = Integer.parseInt(s1[i1++]);
            if (i2 < len2) v2 = Integer.parseInt(s2[i2++]);

            if (v1 != v2) return v1 > v2 ? 1 : -1;
        }
        return 0;
    }

}
