package advanced;

// Receiver 클래스 1
public class PizzaChief implements Chief {

    @Override
    public void make() {
        System.out.println("피자를 만듭니다.");
    }
}
