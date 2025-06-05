// Main.java
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Coffee coffee = person.makeCoffee();
        System.out.println("완성된 커피: " + coffee);
    }
}