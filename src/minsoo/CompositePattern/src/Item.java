public class Item implements Component {

    public String name;
    public int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void showPrice() {
        System.out.println("[Item - " + this.name + "] = " + this.price + "원");
    }
}
