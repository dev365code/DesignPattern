package basic;

// ConcreteCommand 클래스 2
public class PastaStaff implements Command {
    PastaChief pastaChief;

    public PastaStaff(PastaChief pastaChief) {
        this.pastaChief = pastaChief;
    }

    @Override
    public void execute() {
        pastaChief.makePasta();
    }
}
