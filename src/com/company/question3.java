package com.company;

import java.util.Scanner;

public class question3 {
    public static void main(String[] args) {
        //given integer n, return a list of all simplified fractions between 0 and 1 (exclusive) such that the denominator is less-than-or-equal-to n. The fractions can be in any order.
        int n = GetInputI("Enter n: ");
        System.out.println(SimplifiedFractions(n));

    }
    private static int GetInputI(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }
    private static String SimplifiedFractions(int n) {
        String result = "";
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (GCD(i, j) == 1) {
                    result += j + "/" + i + ", ";
                }
            }
        }
        return result.substring(0, result.length() - 2);
    }
    private static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
    
}
