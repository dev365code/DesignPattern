public class Main {
    public static void main(String[] args) {
        // 관찰 대상자 생성(유튜버)
        Subject youtuber = new Youtuber();

        // 관찰자 생성(구독자)
        Observer subscriberA = new SubscriberA();
        Observer subscriberB = new SubscriberB();

        // 구독자가 유튜버 구독
        youtuber.registerObserver(subscriberA);
        youtuber.registerObserver(subscriberB);

        // 구독자에게 새로운 알림 통보
        youtuber.notifyObservers();

        // A 구독 취소
        youtuber.removeObserver(subscriberA);

        // B 에게만 알림 통보
        youtuber.notifyObservers();
    }
}
