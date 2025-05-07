public class Strategy_Navi_Test {
    public static void main(String[] args) {
        Navigator navigator = new Navigator();

        navigator.setStrategy(new ShortestPathStrategy());
        navigator.navigate("서울", "부산");

        navigator.setStrategy(new TrafficAwareStrategy());
        navigator.navigate("서울", "부산");

        navigator.setStrategy(new ScenicRouteStrategy());
        navigator.navigate("서울", "부산");
    }
}
