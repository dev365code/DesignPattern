// Grinder.java
public class Grinder {
    public GrindedCoffeeBean grindCoffeeBean(CoffeeBean bean) {
        System.out.println("커피 갈기: " + bean.getOrigin());
        return new GrindedCoffeeBean(bean);
    }
}
