public class NStrategy_Pattern_Test {
    public static void main(String[] args) {
        RouteStrategy shortest = new ShortestPathStrategy();
        shortest.buildRoute("서울", "부산");
        System.out.println("예상 소요 시간: " + shortest.estimateRoute("서울", "부산") + "분\n");

        RouteStrategy trafficAware = new TrafficAwareStrategy();
        trafficAware.buildRoute("서울", "부산");
        System.out.println("예상 소요 시간: " + trafficAware.estimateRoute("서울", "부산") + "분\n");

        RouteStrategy scenic = new ScenicRouteStrategy();
        scenic.buildRoute("서울", "부산");
        System.out.println("예상 소요 시간: " + scenic.estimateRoute("서울", "부산") + "분");
    }
}
