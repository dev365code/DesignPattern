public interface RouteStrategy {
    void buildRoute(String start, String end);
    int estimateRoute(String start, String end);
}