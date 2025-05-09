package minsoo.TemplateMethodPattern;

public class Taehyun extends Student {

    public Taehyun(String name) {
        super(name);
    }

    @Override
    public void makeClass() {
        System.out.println("made 4 classes.");
    }

    @Override
    public void useDataStructure() {
        System.out.println("used ArrayList.");
    }

    @Override
    public boolean hasIssue() {
        System.out.println("has no issue");
        return false;
    }
}
