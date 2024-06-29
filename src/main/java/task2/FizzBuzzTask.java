package task2;

import lombok.Getter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzzTask {
    @Getter
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    @Getter
    private final AtomicInteger currentNumber = new AtomicInteger(1);
    private final int n;

    public FizzBuzzTask(int n) {
        this.n = n;
    }

    public void fizz() {
        while (true) {
            synchronized (currentNumber) {
                if (currentNumber.get() > n) break;
                int current = currentNumber.get();
                if (current % 3 == 0 && current % 5 != 0) {
                    try {
                        queue.put("fizz");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    currentNumber.incrementAndGet();
                }
            }
        }
    }

    public void buzz() {
        while (true) {
            synchronized (currentNumber) {
                if (currentNumber.get() > n) break;
                int current = currentNumber.get();
                if (current % 5 == 0 && current % 3 != 0) {
                    try {
                        queue.put("buzz");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    currentNumber.incrementAndGet();
                }
            }
        }
    }

    public void fizzbuzz() {
        while (true) {
            synchronized (currentNumber) {
                if (currentNumber.get() > n) break;
                int current = currentNumber.get();
                if (current % 3 == 0 && current % 5 == 0) {
                    try {
                        queue.put("fizzbuzz");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    currentNumber.incrementAndGet();
                }
            }
        }
    }

    public void number() {
        while (true) {
            synchronized (currentNumber) {
                if (currentNumber.get() > n) break;
                int current = currentNumber.get();
                if (current % 3 != 0 && current % 5 != 0) {
                    try {
                        queue.put(Integer.toString(current));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    currentNumber.incrementAndGet();
                }
            }
        }
    }
}