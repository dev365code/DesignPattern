public class Main {

    public static void main(String[] args) {
        // 제일 큰 가방 하나 생성
        Bag bag1 = new Bag("구찌", 1000);

        // 가방 1개, 아이템 2개 생성
        Bag bag2 = new Bag("샤넬", 2000);
        Item item1 = new Item("사과", 100);
        Item item2 = new Item("바나나", 200);

        // 위에서 생성한 것들 제일 큰 가방 안에 넣기
        bag1.add(item1);
        bag1.add(item2);
        bag1.add(bag2);

        // 아이템 2개 더 생성
        Item item3 = new Item("계란", 300);
        Item item4 = new Item("메추리알", 400);

        // 두번째 가방에 아이템 2개 넣기
        bag2.add(item3);
        bag2.add(item4);

        bag1.showPrice();

        // 구찌
        // ㄴ 사과
        // ㄴ 바나나
        // ㄴ 샤넬
        //    ㄴ 계란
        //    ㄴ 메추리알
    }
}
