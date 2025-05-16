package basic;

public class Customer {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void order() {
        command.execute();
    }
}
