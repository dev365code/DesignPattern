package Strategy_Pattern;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;
    private int currentHandValue = 0;
    private int[][] history = {
            {1, 1, 1}, // 손에 대한 확률 기록
            {1, 1, 1},
            {1, 1, 1},
    };

    public ProbStrategy() {
        random = new Random(System.nanoTime());
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handValue = 0;
        if(bet < history[currentHandValue][0]) {
            handValue = 0; // 가위
        } else if(bet < history[currentHandValue][0] + history[currentHandValue][1]) {
            handValue = 1; // 바위
        } else {
            handValue = 2; // 보
        }
        prevHandValue = currentHandValue;
        currentHandValue = handValue;
        return Hand.getHand(handValue); // 확률적으로 손을 선택
    }

    private int getSum(int handValue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[handValue][i];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if(win) {
            history[prevHandValue][currentHandValue]++; // 이기면 손을 업데이트
        } else {
            history[prevHandValue][(currentHandValue + 1) % 3]++; // 진 경우 다른 손을 업데이트
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
