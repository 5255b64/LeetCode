package zijie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        char[] p = s.toCharArray();
        int j = 0, k = -1, len = s.length();
        int[] nextval = new int[p.length];
        nextval[j] = k;
        while (j < len - 1) {
            if (k == -1 || p[j] == p[k]) {
                ++j;
                ++k;
                if (p[j] != p[k]) {
                    nextval[j] = k;
                } else {
                    nextval[j] = nextval[k];
                }
            } else {
                k = nextval[k];
            }
        }
        k = 0;
        for (int i = 1; i < nextval.length; i++) {
            if (nextval[i] == nextval[0]) {
                k = i;
                break;
            }
        }
        boolean flag = true;
        for (int i = k; i < nextval.length; i += k) {
            flag = true;
            for (j = 0; j < k; j++) {
                if ((i + j + 1) > nextval.length || nextval[j] != nextval[i + j]) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println(s.substring(0, k));
        }
    }
}
