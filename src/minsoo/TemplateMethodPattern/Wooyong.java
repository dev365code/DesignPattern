package minsoo.TemplateMethodPattern;

public class Wooyong extends Student {

    public Wooyong(String name) {
        super(name);
    }

    @Override
    public void makeClass() {
        System.out.println("made 6 classes.");
    }

    @Override
    public void useDataStructure() {
        System.out.println("used Set.");
    }

    @Override
    public boolean hasIssue() {
        System.out.println("has no issue");
        return false;
    }
}
