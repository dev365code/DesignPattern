public class SubscriberA implements Observer {

    @Override
    public void update() {
        System.out.println("유튜버로부터 A에게 알림이 도착했습니다.");
    }

    @Override
    public String toString() {
        return "SubscriberA";
    }
}
