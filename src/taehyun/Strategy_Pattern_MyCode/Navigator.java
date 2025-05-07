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
        }
    }
}
