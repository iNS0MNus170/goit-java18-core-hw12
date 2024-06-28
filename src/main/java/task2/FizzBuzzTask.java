package task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzzTask {
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private final AtomicInteger currentNumber = new AtomicInteger(1);
    private final int n;

    public FizzBuzzTask(int n) {
        this.n = n;
    }

    public BlockingQueue<String> getQueue() {
        return queue;
    }

    public void fizz() {
        try {
            while (true) {
                int num = currentNumber.get();
                if (num > n) break;
                if (num % 3 == 0 && num % 5 != 0) {
                    queue.put("fizz");
                    currentNumber.incrementAndGet();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void buzz() {
        try {
            while (true) {
                int num = currentNumber.get();
                if (num > n) break;
                if (num % 5 == 0 && num % 3 != 0) {
                    queue.put("buzz");
                    currentNumber.incrementAndGet();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void fizzbuzz() {
        try {
            while (true) {
                int num = currentNumber.get();
                if (num > n) break;
                if (num % 15 == 0) {
                    queue.put("fizzbuzz");
                    currentNumber.incrementAndGet();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void number() {
        try {
            while (true) {
                int num = currentNumber.get();
                if (num > n) break;
                if (num % 3 != 0 && num % 5 != 0) {
                    queue.put(String.valueOf(num));
                    currentNumber.incrementAndGet();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


