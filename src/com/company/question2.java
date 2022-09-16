package com.company;

import java.util.Scanner;

public class question2 {
    public static void main(String[] args) {
        //implement pow(x, n), which calculates x raised to the power n (i.e., xn).
        float X = GetInputF("Enter X: ");
        int N = GetInputI("Enter N: ");
        System.out.println(Pow(X, N));
    }
    private static float GetInputF(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextFloat();
    }
    private static int GetInputI(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }
    private static float Pow(float x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            return 1 / Pow(x, -n);
        }
        if (n % 2 == 0) {
            return Pow(x * x, n / 2);
        }
        return x * Pow(x * x, n / 2);
    }

    
}
