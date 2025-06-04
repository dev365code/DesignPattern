package Proxy;

public class Main {
    public static void main(String[] args) {
        // RealSubject 클래스의 메소드를 호출하는것이 아닌 Proxy 클래스의 메소드를 호출한다.
        Subject subject = new Proxy();
        subject.request(); // 내부적으로 RealSubject의 메소드를 호출한다.
    }
}
