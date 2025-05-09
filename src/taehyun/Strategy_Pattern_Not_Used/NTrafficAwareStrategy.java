public class NTrafficAwareStrategy implements NRouteStrategy {
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("[교통 회피] " + start + " → " + end + " 경로를 교통정보 기반으로 탐색합니다.");
    }

    @Override
    public int estimateRoute(String start, String end) {
        return 90;
    }
}