package basic;

// ConcreteCommand 클래스 1
public class PizzaStaff implements Command {
    PizzaChief pizzaChief;

    public PizzaStaff(PizzaChief pizzaChief) {
        this.pizzaChief = pizzaChief;
    }

    @Override
    public void execute() {
        pizzaChief.makePizza();
    }
}
