# Proxy 패턴

# 발표 목차

1. 프록시 패턴의 정의
2. 프록시 패턴의 장단점
3. 언제 프록시 패턴을 사용하는가?
4. 적용 코드 예시
5. 실무에서의 사용 (Spring AOP)
6. 지금까지 발표한 내용 총정리

---

## 1.  프록시 패턴의 정의

![IMG_9610.PNG](attachment:f13009c2-a768-4fe0-8d22-050acf5bab08:IMG_9610.png)

- 프록시(Proxy)는 **다른 객체에 대한 접근을 제어하기 위한 대리 객체**
- 클라이언트는 프록시를 통해 실제 객체에 접근
- **프록시와 실제 객체는 같은 인터페이스**를 구현하여 클라이언트는 구분하지 못함

> 예시
>
>
> 스프링에서 `@Transactional`을 붙이면 내부적으로 트랜잭션 기능을 가진 프록시가 생성되어 원래의 객체 대신 사용됨
>

---

## 2.  프록시 패턴의 장단점

| 장점 | 단점 |
| --- | --- |
| 접근 제어, 로깅, 보안, 캐싱 가능 | 클래스 수 증가로 관리 어려움 |
| 클라이언트가 프록시와 실체를 구분 못함 | 프록시가 많아지면 성능 문제 발생 |

---

## 3.  언제 프록시 패턴을 사용하는가? (주로 스프링)

- **트랜잭션 처리** (`@Transactional`)
    1. **목적**: 비즈니스 로직 실행 전후에 트랜잭션을 시작하고 커밋 또는 롤백을 처리하고 싶을 때
    2. **프록시 적용 이유**:
    - 트랜잭션 처리는 **비즈니스 로직과 분리**되어야 함
    - 트랜잭션 시작/종료 코드를 **매번 직접 작성하면 중복되고 에러 유발 가능**

  c. **적용 방식(Spring 예시)**

    ```java
    @Transactional
    public void upgradeLevels() {
    // 핵심 로직만 작성
    }
    ```

  스프링은 해당 메서드가 호출되면 **프록시 객체가 대신 실행**, 트랜잭션을 열고 커밋하거나 예외 시 롤백함

  d. **효과**: 핵심 비즈니스 로직은 깨끗하게 유지되고, 트랜잭션 제어는 프록시가 담당

- **보안 처리** (접근 권한 확인)
    1. **목적**: 사용자의 접근 권한을 확인하고, 무단 접근을 방지하고 싶을 때
    2. **프록시 적용 이유**:
    - 서비스 로직 앞단에서 권한 검사를 수행하고, 조건에 따라 로직 실행 여부를 결정해야 함
    - 인증/인가 로직이 퍼지지 않도록 **중앙 집중화 필요**

  c. **적용 방식 (Spring Security 예시)**:

    ```java
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(Long id) { ... }
    ```

  Spring은 **Security 프록시**를 생성하여, 실제 메서드 호출 전에 권한 체크 수행

  d. **효과**: 보안 로직을 분리하면서도 일관된 인증/인가 처리 가능

- **로깅 기능 삽입**
    1. **목적**: 메서드 호출 시점, 파라미터, 실행 시간 등을 기록하고 싶을 때
    2. **프록시 적용 이유**:
    - 로깅은 모든 메서드에 공통으로 필요하지만, 비즈니스 로직마다 직접 넣기 어렵다
    - **프록시로 분리하면 로직과 관심사를 깔끔히 나눌 수 있음**

  **c. 적용 방식 (AOP 예시)**:

    ```java
    @Around("execution(* com.example..*Service.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("start: " + joinPoint.getSignature());
        Object result = joinPoint.proceed();
        log.info("end: " + joinPoint.getSignature());
        return result;
    }
    ```

  **효과**: 서비스 로직을 건드리지 않고 공통 로깅 처리 가능

- **캐싱 기능 구현**
    1. **목적**: 반복되는 동일한 요청에 대해 빠르게 응답하고 성능을 개선하고 싶을 때
    2.  **프록시 적용 이유**:
    - 프록시는 요청 값을 키로 사용해 캐시에 저장된 결과가 있다면 실제 객체를 호출하지 않고 캐시된 값을 반환
    - 실제 객체의 **불필요한 호출을 줄여 성능 최적화**

  c. **적용 방식 (Spring Cache 예시)**:

    ```java
    @Cacheable("user")
    public User getUser(Long id) { ... }
    ```

  d. **효과**: 동일한 요청에 대해 빠른 응답 → DB 부담 감소, 응답 시간 개선

- **RMI(Remote Method Invocation) - 클라이언트에서 바로 서버로 접속이 불가능한 환경일때, 가상환경에 인터페이스를 두고 통신하는 방식**
    1. **목적**: 네트워크 상의 다른 서버에 있는 객체의 메서드를 마치 로컬 객체처럼 호출하고 싶을 때
    2.  **프록시 적용 이유**:
    - 원격 객체에 직접 접근할 수 없으므로, 로컬에 **대리 객체(프록시)**를 만들어 중계
    - 프록시는 네트워크 전송, 응답 해석 등의 작업을 처리

  **c.  동작 예시**:

    ```java
    Hello stub = (Hello) Naming.lookup("//localhost/Hello");
    stub.sayHello();
    ```

  → stub이 바로 프록시 객체. 내부적으로 네트워크 요청을 보내고 응답을 돌려받음

  **d.  효과**: 개발자는 네트워크 구분 없이 객체처럼 사용할 수 있음

- **Nginx 프록시 서버**: 정적 리소스 압축, 포트 감추기, 보안 강화
    1. **목적**: 실제 서버 앞단에서 트래픽을 필터링하거나 부하 분산, 정적 파일 제공 등을 하고 싶을 때
    2. **프록시 적용 이유**:
    - 직접 애플리케이션 서버에 접근하면 보안/성능 이슈 발생
    - **Nginx**를 앞단에 두고 **리버스 프록시**로 설정 → 트래픽 중계, 정적 파일 처리, 포트 은닉, gzip 압축 가능

      **c.  예시 설정**:

    ```java
    location /api {
        proxy_pass http://localhost:8080;
    }
    ```

      d. **효과**:

    - 서버 부하 감소
    - 보안 강화
    - 클라이언트는 Nginx만 알고 내부 서버 구조는 모름
- 한줄 요약


    | **상황** | **프록시가 해결하는 문제** |
    | --- | --- |
    | 트랜잭션 | 커밋/롤백 반복 제어를 추상화 |
    | 보안 | 인증/인가를 공통 처리 |
    | 로깅 | 공통된 메서드 호출 로그 기록 |
    | 캐싱 | 불필요한 재계산 방지, 성능 개선 |
    | RMI | 네트워크 객체를 로컬처럼 사용 |
    | Nginx 프록시 | 요청 중계, 보안 강화, 정적 리소스 처리 |

---

## 4.  적용 코드 예시

이 예제는 **지연 로딩(Lazy Loading)** 프록시 구조로, 많이 쓰이는 **Virtual Proxy** 패턴의 대표적인 형태예요.

예를 들어, 무거운 이미지나 파일을 처음부터 메모리에 올리지 않고, 실제로 필요할 때만 로딩하는 데 이런 프록시가 사용됩니다.

```java
public interface Subject {    
		void request();
}

public class RealSubject implements Subject {

     @Override
     public void request() {
         System.out.println("HelloCoCoWorld!");
     }
 }
 
public class Proxy implements Subject {
     private Subject subject;
          
     @Override    
     public void request() {        
     // 객체의 초기화를 지연시켜 실제로 사용될 때 생성함으로써 메모리 절약 가능        
     if (this.subject == null) {            
     this.subject = new RealSubject();        
     }         
     
     subject.request(); // 프록시가 RealSubject()의 메소드를 호출한다.    
     }
}

public class Main {
    public static void main(String[] args) {
            // RealSubject 클래스의 메소드를 호출하는것이 아닌 Proxy 클래스의 메소드를 호출한다. 
            Subject subject = new Proxy();
            subject.request(); // 내부적으로 RealSubject의 메소드를 호출한다.                }
}

출처: https://dev-coco.tistory.com/177 [슬기로운 개발생활:티스토리]
```

### **요약**

- **Proxy 객체는 RealSubject와 동일한 인터페이스를 구현**해서 대체 가능
- **RealSubject는 실제 작업을 담당하는 객체**
- **Proxy는 필요 시점까지 RealSubject 생성을 지연시켜 메모리 사용을 최적화**
- **클라이언트는 둘의 차이를 인지하지 못하고 인터페이스만 보고 사용**

---

## **5.  실무에서의 사용: Spring AOP(관점지향프로그래밍)**

- @Transactional, @Cacheable, @Secured 등은 **프록시 기반** 기능
- 스프링 컨테이너가 자동으로 **프록시 객체를 생성하여 DI 주입**
- **JDK Dynamic Proxy** 또는 **CGLIB(코드생성 라이브러리) Proxy** 사용

```java
<bean id="userService" class="UserServiceTx">
  <property name="userService" ref="userServiceImpl" />
  <property name="transactionManager" ref="transactionManager" />
</bean>

<bean id="userServiceImpl" class="UserServiceImpl" />
```

3줄 요약

- 프록시는 클라이언트와 객체 사이에서 객체 **접근 흐름을 제어하고, 부가기능을 삽입**하기 위한 대표적인 디자인 패턴
- 실무에서 매우 자주 사용됨 (스프링 AOP, 트랜잭션, 보안, 캐싱 등)
- **핵심은 인터페이스 기반 설계와 위임**

---

## **6.  지금까지 발표한 내용 총정리**

| **항목** | **파사드 (Facade)** | **브릿지 (Bridge)** | **데코레이터 (Decorator)** | **프록시 (Proxy)** |
| --- | --- | --- | --- | --- |
| **핵심 목적** | 복잡한 시스템을 단순화 | 추상화와 구현 분리 | 기능을 동적으로 확장 | 접근 제어 및 대리 |
| **구조 요약** | 여러 객체 → 하나로 묶음 | 추상(Abstraction) → 구현체(Implementor) 분리 | 같은 인터페이스로 계층 구조 | 원본 객체와 동일 인터페이스로 대리 객체 |
| **주요 동작** | 복잡한 내부 호출 숨김 | 구현을 런타임에 바꿈 | 실행 중 기능 추가 | 로깅, 캐싱, 인증 등 제어 |
| **상속/구성 관계** | 구성(Composition) | 구성 (둘 다 인터페이스 이용) | 상속 + 구성 모두 사용 | 구성 (원본 객체 참조) |
| **인터페이스** | 외부에 단일 진입점 제공 | 추상화 계층과 구현 계층 인터페이스 있음 | 동일한 인터페이스 기반 | 동일한 인터페이스 기반 |
| **실무 예시** | RestTemplate, ServiceFacade | 메시지 전송: Kakao vs Email | Spring의 BeanPostProcessor | @Transactional, @Cacheable |
| **런타임 동작 변경** | ❌ (정적 구성) | ⭕ (전략처럼 구현 변경 가능) | ⭕ (기능 추가 가능) | ⭕ (지연 로딩, 접근 제어) |
| **대표 키워드** | 단순화, Wrapper | 분리, 다형성 | 기능확장, 꾸미기 | 통제, 대리 |
| **어떤 문제 해결?** | 복잡한 시스템 인터페이스를 통합 | 기능 변화에 유연하게 대응 | 클래스 수정 없이 기능 확장 | 직접 접근 시 제어가 필요한 경우 |

### 한줄 요약

- **파사드**: 복잡한 시스템을 단순하게 만들어 **외부와 내부를 구분**
- **브릿지**: 추상화와 구현을 **독립적으로 변경 가능하게 분리**
- **데코레이터**: 기존 기능에 **유연하게 확장을 덧붙임**
- **프록시**: 객체 접근을 **통제하고 감시하거나 지연시킴**

### 그럼 언제 써야하나?