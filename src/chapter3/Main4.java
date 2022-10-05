package chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Main4 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        //добавляем расчёт
        LongAdder stat = new LongAdder();
        IntStream.range(0, 500).forEach(
                i -> executorService.submit(() -> stat.add(i))
        );

        executorService.awaitTermination(3, TimeUnit.SECONDS);

        //только на этой строчке производится подсчёт результата
        System.out.println("\nРезультат: " + stat.sum());
        executorService.shutdown();
    }
}
