package com.company;

import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        //switch case
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a what would you like to view?");
        sleep(1000);
        System.out.println("1. parentheses");
        sleep(200);
        System.out.println("2. power");
        sleep(200);
        System.out.println("3. Simple fractions");
        sleep(200);
        System.out.println("4. Spaces");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                question2 class2 = new question2();
                class2.main(args);
                break;
            case 2:
                System.out.println("You entered 2");
                break;
            case 3:
                System.out.println("You entered 3");
                break;
            default:
                System.out.println("You entered something else");
        }
        int n = GetInt("Enter n: ");
        String[] result = GenerateParenthesis(n);
        System.out.println(Arrays.toString(result));
    }
    private static int GetInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }
    private static String[] GenerateParenthesis(int n) {
        HashMap<Integer, String[]> map = new HashMap<>();
        map.put(0, new String[]{""});
        map.put(1, new String[]{"()"});
        for (int i = 2; i <= n; i++) {
            String[] temp = new String[0];
            for (int j = 0; j < i; j++) {
                String[] left = map.get(j);
                String[] right = map.get(i - j - 1);
                for (String l : left) {
                    for (String r : right) {
                        temp = Arrays.copyOf(temp, temp.length + 1);
                        temp[temp.length - 1] = "(" + l + ")" + r;
                    }
                }
            }
            map.put(i, temp);
        }
        return map.get(n);
    }
}
