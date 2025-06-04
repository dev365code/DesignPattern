# 1.  Facade란?

![image.png](attachment:314412ba-bbfe-45d3-8bd9-4593f9824867:image.png)

- **Facade 패턴이란? 복잡한 서브 시스템의 기능들을 하나의 단순한 인터페이스로 감싸서 제공하는 디자인 패턴**
- Client :  서브 시스템에 직접 접근하는 대신 Facade 사용
- Facade : 서브시스템 기능을 편리하게 사용할 수 있도록 하기 위해 여러 시스템과 상호 작용하는 복잡한 로직을 재정리해서 높은 레벨의 인터페이스를 구성,  간단한 창구 역할
- Additional Facade : 파사드 클래스는 반드시 한개만 존재해야 한다는 규칙은 없고, 연관 되지 않은 기능이 있다면 얼마든지 파사드2로 분리가능. 파사드2는 다른 파사드에서 사용가능하며 클라이언트에서 직접 접근 가능 → 나중에 재귀적 파사드로 사용 가능
- cf) 재귀적 파사드란? 간단하게 말하자면 하위 요소들을 인터페이스로 묶고, 그 인터페이스들을 하나의 인터페이스로 조종가능!
- SubSystem(하위 시스템) : 수십 가지 라이브러리 혹은 클래스들

간략하게 예를 들자면,

- 나 = Client, TV 리모컨 = Facade, TV 본체 내부의 전자 회로, 스피커, 채널 조정 회로 = 서브 시스템
- Client가 복잡한 TV의 작동방식을 몰라도, TV 리모컨의 버튼 딸깍으로 TV 사용가능

# 1.  Facade란?

![image.png](attachment:314412ba-bbfe-45d3-8bd9-4593f9824867:image.png)

- **Facade 패턴이란? 복잡한 서브 시스템의 기능들을 하나의 단순한 인터페이스로 감싸서 제공하는 디자인 패턴**
- Client :  서브 시스템에 직접 접근하는 대신 Facade 사용
- Facade : 서브시스템 기능을 편리하게 사용할 수 있도록 하기 위해 여러 시스템과 상호 작용하는 복잡한 로직을 재정리해서 높은 레벨의 인터페이스를 구성,  간단한 창구 역할
- Additional Facade : 파사드 클래스는 반드시 한개만 존재해야 한다는 규칙은 없고, 연관 되지 않은 기능이 있다면 얼마든지 파사드2로 분리가능. 파사드2는 다른 파사드에서 사용가능하며 클라이언트에서 직접 접근 가능 → 나중에 재귀적 파사드로 사용 가능
- cf) 재귀적 파사드란? 간단하게 말하자면 하위 요소들을 인터페이스로 묶고, 그 인터페이스들을 하나의 인터페이스로 조종가능!
- SubSystem(하위 시스템) : 수십 가지 라이브러리 혹은 클래스들

간략하게 예를 들자면,

- 나 = Client, TV 리모컨 = Facade, TV 본체 내부의 전자 회로, 스피커, 채널 조정 회로 = 서브 시스템
- Client가 복잡한 TV의 작동방식을 몰라도, TV 리모컨의 버튼 딸깍으로 TV 사용가능

# **2.  Facade에 대해 자세히 알아보기**

## 언제 Facade 패턴을 사용해야 하나?

- 시스템이 너무 복잡할때
- 그래서 간단한 인터페이스를 통해 복잡한 시스템을 접근하도록 하고 싶을때
- 시스템을 사용하고 있는 외부와 결합도가 너무 높을 때 의존성을 낮추기 위해서

## **장점**

### **1. 시스템의 복잡성 숨김**

- 클라이언트는 복잡한 서브시스템의 내부 구조를 알 필요 없이, 단순화된 인터페이스만 사용하면 됨.
- 개발 과정이 단순해지고, 실수나 오류 가능성이 줄어듦.

### **2. 의존성 감소**

- 클라이언트는 여러 서브시스템에 직접 의존하지 않고, 오직 Facade 인터페이스에만 의존함.
- 시스템 간 **결합도를 낮추어** 유지보수와 확장성에 유리함.

### **3. 유지보수 및 확장 용이**

- 서브시스템이 변경되더라도 Facade 인터페이스는 그대로 유지 가능.
- 시스템 업그레이드나 구조 변경 시, **클라이언트 코드에 영향을 최소화**할 수 있음.

## **단점**

### **1. Facade의 과도한 책임**

- Facade가 너무 많은 기능을 감싸려 하면, 오히려 Facade 자체가 복잡해짐.
- 단일 책임 원칙(SRP)을 위반하게 될 수도 있음.

### **2. 서브시스템에 대한 의존성**

- Facade는 서브시스템을 감싸고 있지만 내부적으로는 여전히 의존하고 있음.
- 서브시스템이 크게 변경되면 Facade도 함께 수정해야 할 수 있음.

### **3. 유지보수의 복잡성**

- 하나의 인터페이스로 추상화되면서, 단순한 작업도 Facade를 통해 처리해야 할 수 있음.
- 계층이 늘어나면서 오히려 **불필요한 복잡성**을 유발할 가능성 있음.

## 요약 정리

| **장점** | **단점** |
| --- | --- |
| 시스템 복잡성 숨김 | Facade의 과도한 책임 |
| 클라이언트 의존성 감소 | 서브시스템 변경 시 영향 |
| 유지보수 및 확장 용이 | 추상화 계층 증가로 인한 관리 비용 |

# 3. 내가 만든 코드

커피를 만든다고 가정을 해보면, 냉장실에 보관 중이던 원두를 꺼낸 다음에, 그라인드를 이용해서 원두를 갈고 갈은 원두를 필터에 놓은 다음, 뜨거운 물을 부어 부드러운 원두커피를 마실 수 있다.

<aside>

<클래스 구성>

**CoffeeBean**: 원두의 정보를 담는 클래스입니다.

**GrindedCoffeeBean**: 갈린 원두를 나타내는 클래스입니다.

**Refrigerator**: 원두를 보관하고 꺼내는 기능을 제공합니다.

**Grinder**: 원두를 가는 기능을 제공합니다.

**Filter**: 갈린 원두를 담는 필터 역할을 합니다.

**WaterPurifier**: 뜨거운 물을 제공하는 기능을 합니다.

**Person**: 커피를 만드는 주체로, 각 구성 요소를 조합하여 커피를 만듭니다.

**Main**: 프로그램의 시작점으로, 커피를 만드는 과정을 실행합니다.

</aside>

<aside>

커피 제조 과정을 요약하기

1. **냉장고에서 원두 꺼내기**: Refrigerator 클래스의 getCoffeeBean() 메서드를 통해 원두를 꺼냅니다.
2. **원두 갈기**: Grinder 클래스의 grindCoffeeBean() 메서드를 사용하여 원두를 갈아 GrindedCoffeeBean을 생성합니다.
3. **필터에 갈은 원두 넣기**: Filter 클래스의 put() 메서드를 통해 갈은 원두를 필터에 넣습니다.
4. **뜨거운 물 준비하기**: WaterPurifier 클래스의 getHotWater() 메서드를 사용하여 뜨거운 물을 준비합니다.
5. **커피 만들기**: Person 클래스의 putWaterToFilter() 메서드를 통해 필터에 뜨거운 물을 부어 커피를 만듭니다.
6. **완성된 커피 반환**: makeCoffee() 메서드는 최종적으로 만들어진 Coffee 객체를 반환합니다.
</aside>

## Facade 원칙 적용 전 내 코드

```java
// PersonWithoutFacade.java
public class PersonWithoutFacade {
    private final Refrigerator refrigerator;
    private final Grinder grinder;
    private final Filter filter;
    private final WaterPurifier waterPurifier;

    public PersonWithoutFacade() {
        this.refrigerator = new Refrigerator();
        this.grinder = new Grinder();
        this.filter = new Filter();
        this.waterPurifier = new WaterPurifier();
    }

    public Coffee makeCoffee() {
		    // 냉장고에서 커피콩 꺼내기
        CoffeeBean coffeeBean = refrigerator.getCoffeeBean();       
        // 커피 갈기       
        GrindedCoffeeBean grinded = grinder.grindCoffeeBean(coffeeBean); 
        // 필터에 갈은 커피 넣기 
        filter.put(grinded);                                 
        // 뜨거운 물 뽑기           
        String hotWater = waterPurifier.getHotWater();   
        // 커피 추출                
        return putWaterToFilter(filter, hotWater);                       
    }

    private Coffee putWaterToFilter(Filter filter, String hotWater) {
        System.out.println("필터에 " + hotWater + " 붓기");
        return new Coffee("부드러운 원두커피");
    }
}
```

> 문제점:
>

> PersonWithoutFacade는 Refrigerator, Grinder, Filter, WaterPurifier 네 가지 저수준 요소에 모두 의존하기 때문에, 이 클래스 하나만으로도 변경에 취약하고 유지보수가 어렵습니다.
>

## Facade 원칙 적용 후 내 코드

```java
// CoffeeMaker.java
public interface CoffeeMaker {
    Coffee makeCoffee();
}

// CoffeeMakerImpl.java
public class CoffeeMakerImpl implements CoffeeMaker {
    private final Refrigerator refrigerator;
    private final Grinder grinder;
    private final Filter filter;
    private final WaterPurifier waterPurifier;

    public CoffeeMakerImpl() {
        this.refrigerator = new Refrigerator();
        this.grinder       = new Grinder();
        this.filter        = new Filter();
        this.waterPurifier = new WaterPurifier();
    }

    @Override
    public Coffee makeCoffee() {
        CoffeeBean bean     = refrigerator.getCoffeeBean();
        GrindedCoffeeBean g = grinder.grindCoffeeBean(bean);
        filter.put(g);
        String hotWater = waterPurifier.getHotWater();
        return putWaterToFilter(filter, hotWater);
    }

    private Coffee putWaterToFilter(Filter filter, String hotWater) {
        System.out.println("필터에 " + hotWater + " 붓기");
        return new Coffee("부드러운 원두커피");
    }
}

// PersonWithFacade.java
public class PersonWithFacade {
    private final CoffeeMaker coffeeMaker;

    public PersonWithFacade() {
        this.coffeeMaker = new CoffeeMakerImpl();
    }

    public Coffee makeCoffee() {
        return coffeeMaker.makeCoffee();
    }
}
```

> 해결:
>

> PersonWithFacade는 CoffeeMaker(고수준 Facade) 하나에만 의존하므로, 내부 구현이 바뀌어도 영향 범위가 최소화됩니다.
>

- 위 과정을 코드화하면 아래와 같습니다.

    ```java
    // Coffee.java
    public class Coffee {
        private final String description;
    
        public Coffee(String description) {
            this.description = description;
        }
    
        @Override
        public String toString() {
            return description;
        }
    }
    
    // CoffeeBean.java
    public class CoffeeBean {
        private final String origin;
    
        public CoffeeBean(String origin) {
            this.origin = origin;
        }
    
        public String getOrigin() {
            return origin;
        }
    }
    
    // GrindedCoffeeBean.java
    public class GrindedCoffeeBean {
        private final CoffeeBean originalBean;
    
        public GrindedCoffeeBean(CoffeeBean originalBean) {
            this.originalBean = originalBean;
        }
    
        public CoffeeBean getOriginalBean() {
            return originalBean;
        }
    }
    
    // Refrigerator.java
    public class Refrigerator {
        public CoffeeBean getCoffeeBean() {
            System.out.println("냉장고에서 커피콩 꺼내기");
            return new CoffeeBean("콜롬비아산 원두");
        }
    }
    
    // Grinder.java
    public class Grinder {
        public GrindedCoffeeBean grindCoffeeBean(CoffeeBean bean) {
            System.out.println("커피 갈기: " + bean.getOrigin());
            return new GrindedCoffeeBean(bean);
        }
    }
    
    // Filter.java
    public class Filter {
        private GrindedCoffeeBean grindedBean;
    
        public void put(GrindedCoffeeBean grindedBean) {
            this.grindedBean = grindedBean;
            System.out.println("필터에 갈은 커피 넣기");
        }
    
        public GrindedCoffeeBean getGrindedBean() {
            return grindedBean;
        }
    }
    
    // WaterPurifier.java
    public class WaterPurifier {
        public String getHotWater() {
            System.out.println("뜨거운 물 뽑기");
            return "뜨거운 물";
        }
    }
    
    // Person.java
    public class Person {
        private final Refrigerator refrigerator;
        private final Grinder grinder;
        private final Filter filter;
        private final WaterPurifier waterPurifier;
    
        public Person() {
            this.refrigerator = new Refrigerator();
            this.grinder = new Grinder();
            this.filter = new Filter();
            this.waterPurifier = new WaterPurifier();
        }
    
        public Coffee makeCoffee() {
            CoffeeBean coffeeBean = refrigerator.getCoffeeBean();
            GrindedCoffeeBean grindedBean = grinder.grindCoffeeBean(coffeeBean);
            filter.put(grindedBean);
            String hotWater = waterPurifier.getHotWater();
            return putWaterToFilter(filter, hotWater);
        }
    
        private Coffee putWaterToFilter(Filter filter, String hotWater) {
            System.out.println("필터에 " + hotWater + " 붓기");
            return new Coffee("부드러운 원두커피");
        }
    }
    
    // Main.java
    public class Main {
        public static void main(String[] args) {
            Person person = new Person();
            Coffee coffee = person.makeCoffee();
            System.out.println("완성된 커피: " + coffee);
        }
    }
    ```


# 4. 참고 (실제 적용 사례)

:images:[Spring - Facade 패턴을 이용한 Mock사용 단위테스트 문제 해결](https://dami97.tistory.com/40#퍼사드%20패턴%20적용%20후의%20장점-1)

:images:[SpringBoot에 Facade 패턴을 어떻게 써먹을 수 있을까?](https://hogwart-scholars.tistory.com/entry/Design-Pattern-Facade-패턴과-이모저모)

[Facade 패턴 정리](https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-%ED%8D%BC%EC%82%AC%EB%93%9CFacade-%ED%8C%A8%ED%84%B4-%EC%A0%9C%EB%8C%80%EB%A1%9C-%EB%B0%B0%EC%9B%8C%EB%B3%B4%EC%9E%90#%ED%8D%BC%EC%82%AC%EB%93%9C_%ED%8C%A8%ED%84%B4_%ED%8A%B9%EC%A7%95)