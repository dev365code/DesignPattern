package minsoo.TemplateMethodPattern;

public class Minsoo extends Student {

    public Minsoo(String name) {
        super(name);
    }

    @Override
    public void makeClass() {
        System.out.println("Minsoo made 3 classes.");
    }

    @Override
    public void useDataStructure() {
        System.out.println("Minsoo used Array.");
    }

    @Override
    public boolean hasIssue() {
        System.out.println("Minsoo has an issue with github account");
        return true;
    }
}
