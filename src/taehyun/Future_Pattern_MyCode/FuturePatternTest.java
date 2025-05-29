import java.util.concurrent.*;

public class FuturePatternTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        System.out.println("라면을 끓여봅시다!");

        // 1. 물 끓이기 작업을 Future로 비동기 처리
        Future<String> boilingWaterFuture = executor.submit(() -> {
            System.out.println("물을 끓이는 중...");
            Thread.sleep(3000); // 물 끓이는 데 3초
            return "물이 끓었습니다!";
        });

        try {
            // 다른 작업을 하다가...
            System.out.println("김치 꺼내기, 젓가락 준비 중...");

            // 2. 물이 다 끓었는지 확인하고 결과 받기 (blocking)
            String result = boilingWaterFuture.get(); // 여기서 기다림 (blocking)
            System.out.println(result);

            // 3. 물이 끓은 후에 나머지 작업 실행
            System.out.println("스프 넣기...");
            Thread.sleep(1000);

            System.out.println("면 넣기...");
            Thread.sleep(1000);

            System.out.println("끓이는 중...");
            Thread.sleep(1000);

            System.out.println("라면 완성!");

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
