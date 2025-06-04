// Filter.java
public class Filter {
    private GrindedCoffeeBean grindedBean;

    public void put(GrindedCoffeeBean grindedBean) {
        this.grindedBean = grindedBean;
        System.out.println("필터에 갈은 커피 넣기");
    }

    public GrindedCoffeeBean getGrindedBean() {
        return grindedBean;
    }
}
