public class NStrategy_Pattern_Test {
    public static void main(String[] args) {
        NRouteStrategy shortest = new NShortestPathStrategy();
        shortest.buildRoute("서울", "부산");
        System.out.println("예상 소요 시간: " + shortest.estimateRoute("서울", "부산") + "분\n");

        NRouteStrategy trafficAware = new NTrafficAwareStrategy();
        trafficAware.buildRoute("서울", "부산");
        System.out.println("예상 소요 시간: " + trafficAware.estimateRoute("서울", "부산") + "분\n");

        NRouteStrategy scenic = new NScenicRouteStrategy();
        scenic.buildRoute("서울", "부산");
        System.out.println("예상 소요 시간: " + scenic.estimateRoute("서울", "부산") + "분");
    }
}
