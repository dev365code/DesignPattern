package Decorator;

// ConcreteComponent: 기본 기능을 수행하는 클래스
public class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent 동작");
    }
}
