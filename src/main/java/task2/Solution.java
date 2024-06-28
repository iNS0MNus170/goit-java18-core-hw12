package task2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        FizzBuzzTask fbt = new FizzBuzzTask(n);
        Thread A = new Thread(fbt::fizz);
        Thread B = new Thread(fbt::buzz);
        Thread C = new Thread(fbt::fizzbuzz);
        Thread D = new Thread(fbt::number);
        A.start();
        B.start();
        C.start();
        D.start();
        try {
            A.join();
            B.join();
            C.join();
            D.join();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(fbt.getQueue());
    }
}