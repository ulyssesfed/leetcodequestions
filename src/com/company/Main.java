package com.company;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        int choice = 1;

        while (choice != 0) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Hello " + name);
                    LinearSearch(ArrInput(), IntInput());
                    break;
                case 2:
                    System.out.println("Hello " + name);
                    BubbleSort(ArrInput());
                    break;
                case 3:
                    System.out.println("Hello " + name);
                    BinarySearch(ArrInput(), IntInput());
                    break;
                case 4:
                    System.out.println("Hello " + name);
                    System.out.println("Enter a word");
                    String i = scanner.next();
                    Api(i);
                    break;
                default:
                    System.out.println("Goodbye " + name);
                    break;
            }
        }

    }

    private static void LinearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Found at index: " + i);
                return;
            }
        }
        System.out.println("Not found");
    }
    private static void BinarySearch(int[] arr, int keys){
        int low = 0;
        int high = arr.length - 1;
        int mid = (low + high) / 2;
        while (low <= high){
            if (arr[mid] == keys){
                System.out.println("Found at index: " + mid);
                return;
            }
            else if (arr[mid] < keys){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        System.out.println("Not found");
    }

    public static void BubbleSort(int[] arr) {
        //sorts the array in ascending order and then prints the array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
            System.out.println(Arrays.toString(arr));
        }


    private static int[] ArrInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public static void Api(String Word) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/" + Word))
                .header("x-rapidapi-Key", " 999a050cddmshd9501c9427020a9p1d3474jsnf42cf1447fde")
                .header("X-RapidAPI-Host", "wordsapiv1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    private static int IntInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the key: ");
        return sc.nextInt();
    }
}
