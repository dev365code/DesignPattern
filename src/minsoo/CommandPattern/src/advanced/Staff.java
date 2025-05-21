package advanced;

// ConcreteCommand 클래스 2
public class Staff implements Command {
    Chief chief;

    public void setChief(Chief chief) {
        this.chief = chief;
    }

    public Staff setChiefMulti(Chief chief) {
        Staff staff = new Staff();
        staff.setChief(chief);
        return staff;
    }

    @Override
    public void execute() {
        chief.make();
    }
}
