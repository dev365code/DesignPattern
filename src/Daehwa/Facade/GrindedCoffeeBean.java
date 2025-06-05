// GrindedCoffeeBean.java
public class GrindedCoffeeBean {
    private final CoffeeBean originalBean;

    public GrindedCoffeeBean(CoffeeBean originalBean) {
        this.originalBean = originalBean;
    }

    public CoffeeBean getOriginalBean() {
        return originalBean;
    }
}
