package advanced;

public class Main {
    public static void main(String[] args) {
        // Receiver 인스턴스 생성 (Chief)
        Chief pastaChief = new PastaChief();
        Chief pizzaChief = new PizzaChief();

        // ConcreteCommand 인스턴스 생성 (Staff)
        Staff staff = new Staff();

        // Invoker 인스턴스 생성 (Customer)
        Customer customer = new Customer();

        // 기능의 실행을 요청 (주문을 위해 스태프를 부르고, 스태프에게 음식을 요청)
        // 이는 파스타 스태프 불러서 주문을 완료한 후, 다음에 피자 스태프를 불러서 주문을 완료

        // 저 파스타가 먹고 싶은데요,
        staff.setChief(pastaChief);
        // 파스타 하나 주문할게요.
        customer.setCommand(staff);
        customer.order();

        // 주문이 주방으로 들어감

        // 아 저 피자도 먹고 싶은데요,
        staff.setChief(pizzaChief);
        // 피자 하나 더 주문할게요.
        customer.setCommand(staff);
        customer.order();

        // 만약 피자와 파스타를 둘 다 한번에 주문하고 싶다면?
        // 피자 스태프, 파스타 스태프를 동시에 호출하여 주문
        // 근데 뭔가 원칙에 위배되게 설계하는 것 같음...
        CustomerMulti customerMulti = new CustomerMulti();

        customerMulti.setCommand(new Staff().setChiefMulti(pastaChief), 0);
        customerMulti.setCommand(new Staff().setChiefMulti(pizzaChief), 1);

        customerMulti.order(0);
        customerMulti.order(1);
    }
}
