package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        //given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
        //for example, given n = 3, a solution set is:
        //[
        //  "((()))",
        //  "(()())",
        //  "(())()",
        //  "()(())",
        //  "()()()"
        //]
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
