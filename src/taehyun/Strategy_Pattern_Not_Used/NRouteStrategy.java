public interface NRouteStrategy {
    void buildRoute(String start, String end);
    int estimateRoute(String start, String end);
}