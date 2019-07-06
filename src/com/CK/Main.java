package com.CK;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String version1 = "0.1", version2 = "0.01";
        Solution solution = new Solution();
        System.out.println(solution.compareVersion(version1, version2));
    }
}

class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) return 0;
        String[] vs1 = version1.split("[.]");
        String[] vs2 = version2.split("[.]");
        String[] newArr = new String[Integer.max(vs1.length, vs2.length)];
        boolean vs1LongerThanvs2 = vs1.length > vs2.length;
        if (vs1LongerThanvs2) {
            Arrays.fill(newArr, "0");
            System.arraycopy(vs2, 0, newArr, 0, vs2.length);
        }
        if (!vs1LongerThanvs2) {
            Arrays.fill(newArr, "0");
            System.arraycopy(vs1, 0, newArr, 0, vs1.length);
        }
        int i = 0, j = 0;
        while (i < newArr.length) {
            if (vs1.length == vs2.length) {
                if (Integer.valueOf(vs1[i]) > Integer.valueOf(vs2[i])) return 1;
                if (Integer.valueOf(vs1[i]) < Integer.valueOf(vs2[i])) return -1;
                i++;
            } else if (vs1LongerThanvs2) {
                if (Integer.valueOf(vs1[i]) > Integer.valueOf(newArr[i])) return 1;
                if (Integer.valueOf(vs1[i]) < Integer.valueOf(newArr[i])) return -1;
                i++;
            } else {
                if (Integer.valueOf(newArr[i]) > Integer.valueOf(vs2[i])) return 1;
                if (Integer.valueOf(newArr[i]) < Integer.valueOf(vs2[i])) return -1;
                i++;
            }
        }
        return 0;
    }
}