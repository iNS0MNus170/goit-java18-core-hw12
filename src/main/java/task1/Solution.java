package task1;

public class Solution {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long current = System.currentTimeMillis();
                long seconds = (current - start) / 1000;
                if(seconds%5!=0) {
                    System.out.println(seconds);
                }
                if (seconds >= 60) {
                    System.exit(0);
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long current = System.currentTimeMillis();
                long seconds = (current - start) / 1000;
                System.out.println("Минуло "+seconds+" секунд");
                if (seconds >= 60) {
                    System.exit(0);
                }
            }
        }).start();
    }
}
