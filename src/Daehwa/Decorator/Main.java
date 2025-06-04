package Decorator;

// Main 클래스: 실제 실행 예제
public class Main {
    public static void main(String[] args) {
        Component component = new ConcreteComponent(); // 기본 객체
        Component decorator = new ConcreteDecoratorA(component); // 데코레이터로 감싸기

        decorator.operation(); // 동작 실행
    }
}
