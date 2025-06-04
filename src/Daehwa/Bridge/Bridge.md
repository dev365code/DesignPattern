### Bridge 패턴 발표 자료

---

## 1. Bridge 패턴 정의

- **목적**: 구조적 디자인 패턴에 속하며, 추상화(Abstraction)와 구현(Implementor)을 분리하여, 두 축이 독립적으로 확장·변경할 수 있도록 설계
- 그러면 왜? 브릿지 패턴을 사용하는 것일까? Facade 원칙 처럼
- **구조 (UML 다이어그램)**:

  [Abstraction]───holds───>[Implementor]
  ▲                                                       ▲
  [RefinedAbstraction]    [ConcreteImplementor]

    - 설명
        1. **Abstraction(추상화)**
            - 클라이언트가 사용하는 **공통 API**(인터페이스나 추상 클래스)
        2. **RefinedAbstraction**
            - Abstraction을 확장한 클래스(보통 추상화에 기능을 추가)
        3. **Implementor(구현자)**
            - 실제 동작을 수행하는 **구현 인터페이스**
        4. **ConcreteImplementor**
            - Implementor 인터페이스를 실제로 구현한 클래스
- **핵심 원칙**: SOLID원칙 중 하나인 DIP(Dependency Inversion Principle) 준수 — 고수준/저수준 모듈 모두 추상(인터페이스/추상 클래스)에 의존하며, 런타임에 서로 다른 구현체들을 주입해 사용할 수 있습니다.

---

## 2. 내가 작성한 코드로 보는 Bridge 패턴

### 프로젝트 구조

```
package bridge;
├ StudyingAPI.java       // Implementor 인터페이스 
├ StudyingJava.java      // ConcreteImplementor 자바 공부 구현체
├ StudyingSql.java       // ConcreteImplementor sql 공부 구현체
├ Subject.java           // Abstraction 추상클래스
├ SubjectJava.java       // RefinedAbstraction java 과목
├ SubjectSql.java        // RefinedAbstraction sql 과목
└ StudyingMain.java      // Client 
```

- 구조(클래스 다이어그램):

  ![Editor _ Mermaid Chart-2025-05-15-235150.png](attachment:5bcc417c-ca82-49b6-87ff-43457c3f4498:Editor___Mermaid_Chart-2025-05-15-235150.png)


### 주요 코드

```java
// Implementor - 기능 호출 매서드만 정의
public interface StudyingAPI {
    void study(String name, int fromPage, int toPage);
} 

// ConcreteImplementor - name, fromPage, toPage 값을 받아 출력합니다.
public class StudyingJava implements StudyingAPI {
    @Override
    public void study(String name, int fromPage, int toPage) {
        System.out.printf("%s: %d장부터 %d장까지 자바 공부했어%n", name, fromPage, toPage);
    }
}

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

// RefinedAbstraction - study() 호출만 Implementor로 위임.
public class SubjectJava extends Subject {
    public SubjectJava(String name, int fromPage, int toPage, StudyingAPI api) {
        super(name, fromPage, toPage, api);
    }
    @Override
    public void study() {
        api.study(name, fromPage, toPage);
    }
}

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

```

---

## 3. 실무에서 쓰이는 Bridge 패턴 예시

### 3.1 JDBC 드라이버

- **Abstraction**: `java.sql.Connection`, `DriverManager` API
- **Implementor**: `java.sql.Driver` 인터페이스
- **ConcreteImplementor**: `com.mysql.jdbc.Driver`, `oracle.jdbc.OracleDriver` 등
- **장점**: 드라이버 JAR만 교체하면 애플리케이션 코드 수정 없이 다양한 DB 사용 가능
- 상세 설명

  ### **3.1.1. 문제 정의**

    - 한 프로젝트에서 **MySQL → Oracle → PostgreSQL** 등 여러 DB를

      코드 변경 없이 바꿔 쓰고 싶다.


    ### 3.1.2. 구성요소 매핑
    
    | **역할** | **자바 JDBC 클래스/인터페이스** | **설명** |
    | --- | --- | --- |
    | **Abstraction** | java.sql.Connection | 클라이언트가 직접 호출하는 **JDBC API** |
    | **RefinedAbstraction** | (없음: API 그대로 사용) |  |
    | **Implementor** | java.sql.Driver | 드라이버가 반드시 구현해야 할 **인터페이스** |
    | **ConcreteImplementor** | com.mysql.cj.jdbc.Driver,oracle.jdbc.OracleDriver,org.postgresql.Driver | 각 벤더가 제공하는 **구현체** (네트워크·프로토콜 레벨 로직 포함) |
    
    ### **3.1.3. 동작 흐름**
    
    1. **애플리케이션** 
        
        ```java
        Connection conn = DriverManager.getConnection(url, user, pwd); 
        ```
        
    2. DriverManager가 런타임에 바인딩된 Driver 구현체(MySQL, Oracle 등)를 찾아 호출
    3. conn.prepareStatement(), rs.next() 등 모든 호출은
        
        Connection, PreparedStatement, ResultSet 인터페이스(API)에 정의된 대로 실행되며
        
        실제 동작은 **ConcreteImplementor** 쪽에서 처리
        
    
    ### **3.1.4. 장점**
    
    - **코드 수정 無**: getConnection("jdbc:mysql://...") → getConnection("jdbc:oracle:...") URL만 바꾸면 됨
    - **추상화/구현 분리**: 애플리케이션 로직 (Connection API) ↔ 네트워크·프로토콜 로직(Driver 구현체) 완전 분리
    - **DIP 준수**: Connection 인터페이스에만 의존 → 결합도 낮아지고 테스트·교체 용이

### 3.2 로깅 프레임워크 (SLF4J)

- **Abstraction**: `org.slf4j.Logger` 인터페이스
- **RefinedAbstraction**: `LoggerFactory`
- **Implementor**: `ch.qos.logback.classic.Logger` (Logback), `org.apache.logging.log4j.Logger` (Log4j2)
- **장점**: 런타임 설정 변경으로 로깅 구현체 변경, 코드 수정 無
- 상세 설명

  ### **3.2.1. 문제 정의**

    - 개발 중 로깅 라이브러리를 **Logback → Log4j2 → JDK logging** 등으로 바꾸고 싶을 때
    - 코드에 new ch.qos.logback.Logger() 같은 구체 클래스가 박혀 있으면 교체할 때마다 난리!

  ### **3.2.2. 구성 요소 매핑**

  | **역할** | **SLF4J 클래스/인터페이스** | **설명** |
      | --- | --- | --- |
  | **Abstraction** | org.slf4j.Logger | 애플리케이션에서 직접 쓰는 **로깅 API** |
  | **RefinedAbstraction** | org.slf4j.LoggerFactory | Logger 인스턴스를 생성해 주는 팩토리 |
  | **Implementor** | (SLF4J 내부) Logger 인터페이스 | SLF4J 바인딩 인터페이스 |
  | **ConcreteImplementor** | ch.qos.logback.classic.Logger (Logback),org.apache.logging.log4j.spi.ExtendedLogger (Log4j2) 등 | 실제 로깅 엔진 구현체 |

  ### **3.2.3. 동작 흐름**

    1. **애플리케이션**

        ```java
        private static final Logger log = LoggerFactory.getLogger(MyService.class);
        log.info("처리 시작");
        ```

    2. LoggerFactory가 런타임에 **classpath**에 있는 로깅 구현체(Logback, Log4j2 등)를 찾아

       적절한 Logger 구현 객체를 반환

    3. log.info() 호출 시, 실제 로그 출력은 **ConcreteImplementor** 쪽에서 처리

  ### **3.2.4. 장점**

    - **설정만 교체**: logback.xml ↔ log4j2.xml 파일 바꾸기만 해도 라이브러리 교체 가능
    - **코드 수정 無**: 소스엔 오로지 org.slf4j.Logger API만 사용
    - **테스트 용이**: 테스트용 로거 구현체를 DI(주입) 받아서 로그 기록 검증 가능

    ---


### 3.3 보고서 생성기 예제

```java
// ReportFormatter (Implementor)
public interface ReportFormatter { ... }
// TextFormatter, HtmlFormatter (ConcreteImplementor)

// Report (Abstraction)
public abstract class Report { ... }
// SalesReport (RefinedAbstraction)

// 사용 예
Report rptText = new SalesReport(data, new TextFormatter());
Report rptHtml = new SalesReport(data, new HtmlFormatter());

```

---

## 4. 요약 정리

1. Bridge 패턴은 **추상(Abstraction)↔구현(Implementor)** 분리를 통해 두 축의 독립적 확장 지원
2. 내가 작성한 코드에서는 `Subject`↔`StudyingAPI` 구조로 패턴이 적용됨
3. JDBC, SLF4J, 커스텀 보고서 생성기 등 실무 프레임워크에 광범위하게 활용
4. **의존 역전(DIP)** 준수로 결합도 낮추고 유지보수·테스트 용이성 확보

---