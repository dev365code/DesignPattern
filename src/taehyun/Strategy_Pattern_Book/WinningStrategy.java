package Strategy_Pattern;

import java.util.Random;

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy() {
        random = new Random(System.nanoTime());
    }

    @Override
    public Hand nextHand() {
        if(!won) {
            prevHand = Hand.getHand(random.nextInt(3)); // 무작위로 손을 낸다.
        }
        return prevHand; // 이기면 이긴 손을 반복
    }

    @Override
    public void study(boolean win) {
        won = win;
    } // 승패에 따라 전략 학습
}
