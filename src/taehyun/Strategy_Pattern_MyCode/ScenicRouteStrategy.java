public class ScenicRouteStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("[경치 좋은 길] " + start + " → " + end + " 풍경 좋은 길을 따라 탐색합니다.");
    }

    @Override
    public int estimateRoute(String start, String end) {
        return 120;
    }
}