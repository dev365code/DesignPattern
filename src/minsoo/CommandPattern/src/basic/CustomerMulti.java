package basic;

public class CustomerMulti {
    Command[] command = new Command[2];

    public void setCommand(Command command, int index) {
        if (index < 0 || index >= 2) {
            System.out.println("인덱스가 잘못되었습니다.");
            return ;
        }
        this.command[index] = command;
    }

    public void order(int index) {
        this.command[index].execute();
    }
}
