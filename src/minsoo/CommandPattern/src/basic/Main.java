package basic;

public class Main {
    public static void main(String[] args) {
        // Receiver 인스턴스 생성 (Chief)
        PastaChief pastaChief = new PastaChief();
        PizzaChief pizzaChief = new PizzaChief();

        // ConcreteCommand 인스턴스 생성 (Staff)
        PastaStaff pastaStaff = new PastaStaff(pastaChief);
        PizzaStaff pizzaStaff = new PizzaStaff(pizzaChief);

        // Invoker 인스턴스 생성 (Customer)
        Customer customer = new Customer();

        // 기능의 실행을 요청 (주문을 위해 스태프를 부르고, 스태프에게 음식을 요청)
        // 이는 파스타 스태프 불러서 주문을 완료한 후, 다음에 피자 스태프를 불러서 주문을 완료
        customer.setCommand(pastaStaff);
        customer.order();

        customer.setCommand(pizzaStaff);
        customer.order();

        // 만약 피자와 파스타를 둘 다 한번에 주문하고 싶다면?
        // 피자 스태프, 파스타 스태프를 동시에 호출하여 주문
        CustomerMulti customerMulti = new CustomerMulti();

        customerMulti.setCommand(pizzaStaff, 0);
        customerMulti.setCommand(pastaStaff, 1);

        customerMulti.order(0);
        customerMulti.order(1);
    }
}
