package task2;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        System.out.println("Введіть ваше число : ");
        int n = new Scanner(System.in).nextInt();
        FizzBuzzTask fbt = new FizzBuzzTask(n);
        Thread A = new Thread(fbt::fizz);
        Thread B = new Thread(fbt::buzz);
        Thread C = new Thread(fbt::fizzbuzz);
        Thread D = new Thread(() -> {
            try {
                fbt.number();
                while (fbt.getCurrentNumber().get() <= n || !fbt.getQueue().isEmpty()) {
                    System.out.println(fbt.getQueue().take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        A.start();
        B.start();
        C.start();
        D.start();
        try {
            A.join();
            B.join();
            C.join();
            D.join();
        } catch (
                InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}