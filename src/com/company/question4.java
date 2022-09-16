package com.company;
import java.util.Scanner;

public class question4 {
    public static void main(String[] args) {
        //given a 0-indexed string s and a 0-indexed integer array "spaces" that describes the indices in the original string where spaces will be added, each space should be added at the index in the original string where it appears in "spaces". return the string after adding the spaces.
        String s = GetInputS("Enter s: ");
        int[] spaces = GetInputI("Enter spaces: ");
        System.out.println(ReformatString(s, spaces));
    }
    private static String ReformatString(String s, int[] spaces) {
        String result = "";
        int index = 0;
        for (int i = 0; i < spaces.length; i++) {
            result += s.substring(index, spaces[i]) + " ";
            index = spaces[i];
        }
        result += s.substring(index);
        return result;
    }
    private static String GetInputS(String prompt) {
        
            
        
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (input.contains(" ")) {
            System.out.println("Input cannot contain spaces");
            System.out.print(prompt);
            input = scanner.nextLine();
        }

        return scanner.nextLine();
    }
    private static int[] GetInputI(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] result = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            result[i] = Integer.parseInt(inputArray[i]);
        }
        return result;
        
    }
}
