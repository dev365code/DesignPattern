package Proxy;

public class Proxy implements Subject {
    private Subject subject;

    @Override
    public void request() {
        // 객체의 초기화를 지연시켜 실제로 사용될 때 생성함으로써 메모리 절약 가능
        if (this.subject == null) {
            this.subject = new RealSubject();
        }

        subject.request(); // 프록시가 RealSubject()의 메소드를 호출한다.
    }
}
