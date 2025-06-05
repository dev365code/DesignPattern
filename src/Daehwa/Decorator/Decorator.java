package Decorator;

// Decorator: 컴포넌트를 감싸서 기능을 확장하는 추상 클래스
public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation(); // 기본 동작 위임
    }
}
