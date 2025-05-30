import java.util.ArrayList;
import java.util.List;

public class Bag implements Component {

    List<Component> componentList = new ArrayList<>();
    String name;
    int price;

    public Bag(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void add(Component component) {
        componentList.add(component);
    }

    public void delete(Component component) {
        componentList.remove(component);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void showPrice() {
        for (Component component : componentList) {
            component.showPrice();
        }
        System.out.println("[Bag - " + this.name + "] = " + this.price + "원");
    }
}
