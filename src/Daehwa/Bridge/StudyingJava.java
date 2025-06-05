package Bridge;

// ConcreteImplementor - name, fromPage, toPage 값을 받아 출력합니다.
public class StudyingJava implements StudyingAPI {
    @Override
    public void study(String name, int fromPage, int toPage) {
        System.out.printf("%s: %d장부터 %d장까지 자바 공부했어%n", name, fromPage, toPage);
    }
}