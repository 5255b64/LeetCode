package alibaba;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i=0; i<T; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int n0 = n / 2;
            int n1 = n - n0;
            int m0 = m / 2;
            int m1 = m - m0;
            int fenmu  = m * n;
            int fenzi = n0*m1 + n1*m0;
            if (fenzi == 0) {
                System.out.println(0 + "/" + (fenmu));
            }else {
                int maxCommon = getGreatestCommonDivisor2(fenmu, fenzi);
                System.out.println((fenzi/maxCommon) + "/" + (fenmu/maxCommon));
            }

        }
    }

    public static int getGreatestCommonDivisor2(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisor2(big % small, small);
    }
}