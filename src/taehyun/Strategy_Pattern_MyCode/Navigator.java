public class Navigator {
    private RouteStrategy strategy;

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void navigate(String from, String to) {
        if (strategy == null) {
            System.out.println("경로 탐색 전략이 설정되지 않았습니다.");
        } else {
            strategy.buildRoute(from, to);
            int time = strategy.estimateRoute(from, to);
            System.out.println("예상 소요 시간: " + time + "분");
        }
    }
}
/*
* strategy는 인터페이스 타입의 필드입니다.
이 필드를 통해 다양한 경로 탐색 전략(예: 자동차, 도보, 자전거 등)을 동적으로 설정할 수 있습니다.
RouteStrategy는 아마도 아래와 같은 인터페이스일 것입니다:
public interface RouteStrategy {
    void buildRoute(String from, String to);
    int estimateRoute(String from, String to);
}
    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }
setStrategy() 메서드를 통해 외부에서 전략 객체를 주입할 수 있습니다.

즉, 현재 상황에 맞는 경로 탐색 알고리즘을 런타임 중에 변경 가능.
    public void navigate(String from, String to) {
        if (strategy == null) {
            System.out.println("경로 탐색 전략이 설정되지 않았습니다.");
        } else {
            strategy.buildRoute(from, to);
            int time = strategy.estimateRoute(from, to);
            System.out.println("예상 소요 시간: " + time + "분");
        }
    }
}
navigate()는 실제 경로 탐색을 수행하는 메서드입니다.
설정되어 있다면:
buildRoute()로 경로를 구축하고 estimateRoute()로 소요 시간을 예측한 뒤 콘솔에 출력합니다.
* */