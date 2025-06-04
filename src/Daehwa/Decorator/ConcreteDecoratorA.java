package Decorator;

// ConcreteDecoratorA: 기능을 확장하는 실제 데코레이터
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation(); // 기존 동작 수행
        addedBehavior();   // 추가 동작 수행
    }

    private void addedBehavior() {
        System.out.println("추가 기능 A 구현");
    }
}
