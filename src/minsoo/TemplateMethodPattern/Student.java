package minsoo.TemplateMethodPattern;

abstract public class Student {
    private String name;

    public Student() { }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public final void doHomework() {
        System.out.println("Homework started.");
        makeClass();
        useDataStructure();
        finishHomework();

        if (!hasIssue()) {
            reportHomework();
            System.out.println("There is NO issue with the homework.");
        }
    }

    abstract public void makeClass();
    abstract public void useDataStructure();

    public void finishHomework() {
        System.out.println("Homework finished.");
    }

    abstract public boolean hasIssue();

    public void reportHomework() {
        System.out.println(name + " has finished the homework.");
    }
}
