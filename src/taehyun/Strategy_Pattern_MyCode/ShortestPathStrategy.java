public class ShortestPathStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String start, String end) {
        System.out.println("[최단 경로] " + start + " → " + end + " 경로를 탐색합니다.");
    }

    @Override
    public int estimateRoute(String start, String end) {
        return 60;
    }
}
