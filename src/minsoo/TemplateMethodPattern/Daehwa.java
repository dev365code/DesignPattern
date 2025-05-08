package minsoo.TemplateMethodPattern;

public class Daehwa extends Student {

    public Daehwa(String name) {
        super(name);
    }

    @Override
    public void makeClass() {
        System.out.println("made 5 classes.");
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
