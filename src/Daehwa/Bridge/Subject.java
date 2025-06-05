package Bridge;

// Subject (Abstraction) - 공통 필드와 생성자, 추상 메서드 정의.
public abstract class Subject {
    protected final String name;
    protected final int fromPage, toPage;
    protected final StudyingAPI api;

    protected Subject(String name, int fromPage, int toPage, StudyingAPI api) {
        this.name = name;
        this.fromPage = fromPage;
        this.toPage = toPage;
        this.api = api;
    }

    public abstract void study();
}
