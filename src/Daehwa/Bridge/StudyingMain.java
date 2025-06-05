package Bridge;

// Client - Client는 오직 Subject 추상화와 StudyingAPI 인터페이스만 알고 있습니다.
public class StudyingMain {
    public static void main(String[] args) {
        StudyingAPI javaImpl = new StudyingJava();
        StudyingAPI sqlImpl = new StudyingSql();

        Subject subjectJava = new SubjectJava("Daehwa", 1, 2, javaImpl);
        Subject subjectSql = new SubjectSql("Taehyun", 3, 4, sqlImpl);

        subjectJava.study(); // Daehwa: 1장부터 2장까지 자바 공부했어
        subjectSql.study();  // Taehyun: 3장부터 4장까지 sql 공부했어
    }
}
