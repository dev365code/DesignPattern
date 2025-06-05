// Person.java
public class Person {
    private final Refrigerator refrigerator;
    private final Grinder grinder;
    private final Filter filter;
    private final WaterPurifier waterPurifier;

    public Person() {
        this.refrigerator = new Refrigerator();
        this.grinder = new Grinder();
        this.filter = new Filter();
        this.waterPurifier = new WaterPurifier();
    }

    public Coffee makeCoffee() {
        CoffeeBean coffeeBean = refrigerator.getCoffeeBean();
        GrindedCoffeeBean grindedBean = grinder.grindCoffeeBean(coffeeBean);
        filter.put(grindedBean);
        String hotWater = waterPurifier.getHotWater();
        return putWaterToFilter(filter, hotWater);
    }

    private Coffee putWaterToFilter(Filter filter, String hotWater) {
        System.out.println("필터에 " + hotWater + " 붓기");
        return new Coffee("부드러운 원두커피");
    }
}
