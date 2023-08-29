# ENUM (열거 타입)

### ENUM을 알기 전에!!

- 과거에는 특정 상수값을 사용하기 위해선 모두 상수로 선언해서 사용!

```
public static final String MON = "Monday";
public static final String TUE = "Tuesday";
public static final String WED = "Wednesday";
```

- 이렇게 사용하면 개발자가 실수하기도 쉽고 한눈에 알아보기도 쉽지 않다 (지금은 잘 보일 수 있으나 많아진다면 어려워 질지도)
- 그리고 관련있는 값들끼리 묶으려면 접두어를 사용해서 점점 변수명도 지저분해짐
- Enum 클래스는 이러한 문제점을 말끔히 해결해주는 유용한 클래스

### ENUM

- 열거타입
- 열거타입이란 한정된 값만을 갖는 데이터 타입을 의미
- 자바에서 서로 연관있는 상수를 편리하게 관리하기 위해 사용 
- 요일, 순위, 성적 등을 나타내기 위해

### 열거 타입의 선언

- 일반 클래스와 똑같이 .java 확장자를 갖으나 class 키워드 대신 enum 키워드로 정의 된다

```
public enum Week {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

- 위는 7개의 요일을 열거 타입으로 상수화 해놓은 예시 MONDAY 부터 SUNDAY 까지를 **'열거 상수'** 라고 한다

### 열거 타입의 변수

- 열거 타입도 데이터 타입의 일종으로 변수를 선언하고 대입이 가능

```
Week today = Week.MONDAY;
```

- 열거 타입은 null을 저장할 수 있다. 열거 타입 또한 참조 타입이기 때문에!

```
Week holiday = null;
```

- 열거 상수는 **'열거 객체'**로 생성됨을 알 수 있다.


---


## JVM 메모리에 올라간 열거 타입

- 자바에서의 열거 타입은 일종의 클래스, 상수 하나당 인스턴스를 하나씩 만들어 public static final 필드로 공개
- 열거 타입의 인스턴스는 클라이언트가 직접 생성할 수 없고, 인스턴스는 런타임에 단 한번만 생성되기에 싱글턴(Singleton)을 보장

- JVM의 메모리 영역을 구분하면 메소드 영역, 힙 영역, 스택 영역 세가지로 나뉨.
- 메소드 영역에 클래스와 클래스 변수(Static Variable)이 저장. 따라서 열거 타입 클래스도 메소드 영역에 저장

<src img ="https://github.com/happiipark/Java/assets/124240328/51e52c3d-c430-492b-945f-0539d0aaefce" width="700" height="400" />

- 내가 정리한 메모리 구조 : https://github.com/happiipark/Java/blob/main/i%20don't%20konw%20about%20you/%EB%A9%94%EB%AA%A8%EB%A6%AC%20%EA%B5%AC%EC%A1%B0/README.md

- 스택 영역은 메소드가 호출될 때 그 메소드와 관련된 로컬 변수와 매개변수가 저장되는 곳.
- 메소드 영역에서 주소값 만 복사해서 결국 같은 열거 객체를 가리키는 것을 확인 가능

```
System.out.println(today == Week.MONDAY);
```


### 열거 타입 메소드

열거 타입은 컴파일 타임에 Enum 이라는 클래스 상속. 

즉 열거 타입에서 사용할 수 있는 메소드는 Enum의 메소드가

#### name

열거 객체가 가지고 있는 문자열 반환

이 때 문자열은 열거 객체를 선언할 때 명시한 상수 이름

```
Week today = Week.MONDAY;
System.out.println(today.name()); // MONDAY
```

#### ordinal

해당 열거 객체가 열거 타입에서 몇 번째 순번인지 반환

이때, 순번이란 열거 타입을 정의할 때 명시된 순서로, 0부터 시작 Week의 순번


```
public enum Week {
    MONDAY, // 0
    TUESDAY, // 1
    WEDNESDAY, // 2
    THURSDAY, // 3
    FRIDAY, // 4
    SATURDAY, // 5
    SUNDAY // 6
}


System.out.println(Week.MONDAY.ordinal()); // 0
System.out.println(Week.SUNDAY.ordinal()); // 6
```

### compareTo

두 열거 객체간의 순번을 비교하여 상대적 순번 차이 반환 메소드

상대 열거 객체보다 순번이 빠르면 음수, 느리면 양수 반환

```
System.out.println(Week.MONDAY.compareTo(Week.SUNDAY)); // -6
System.out.println(Week.SATURDAY.compareTo(Week.WEDNESDAY)); // 3
```

### valueOf

열거 객체의 상수명과 동일한 문자열 입력받아, 일치하는 열거 객체 반환 

name메소드와 방향이 반대라고 생각!!

외부에서 문자열을 입력받아 열거 객체로 변환할 때 유용한

```
Week yesterday = Week.valueOf("WEDNESDAY");
System.out.println(yesterday); // WEDNESDAY
```


### values 

열거 타입에 선언된 모든 열거 객체를 순번 순서대로 배열로 만듬

열거 타입의 모든 열거 객체를 순회할 때 유용하게 사용하기

```
Week[] days = Week.values();
for (Week day : days) {
    System.out.println(day);
}

/*
    MONDAY
    TUESDAY
    WEDNESDAY
    THURSDAY
    FRIDAY
    SATURDAY
    SUNDAY
*/
```


### 열거 타입 필드

- 열거 타입의 열거 객체도 인스턴스이므로 인스턴스 필드를 가질 수 있다. 
- 이를 통해 상수와 연관된 추가적인 데이터를 상수 자체에 포함하여 관리 가능
- 일반적인 인스턴스 필드를 사용하는 것 처럼, 인스턴스 필드를 명시하고 생성자를 정의
- 이때, 각 열거 객체의 필드는 상수 이름 옆에 괄호 () 를 사용하여 적어준다.

Ex) 요일의 한국어 이름과 한자를 추가

```
public enum Week {
    MONDAY("월요일", "月"),
    TUESDAY("화요일", "火"),
    WEDNESDAY("수요일", "水"),
    THURSDAY("목요일", "木"),
    FRIDAY("금요일", "金"),
    SATURDAY("토요일", "土"),
    SUNDAY("일요일", "日");

    public String korean;
    public String chinese;

    Week(String korean, String chinese) {
        this.korean = korean;
        this.chinese = chinese;
    }
}
```

Week 열거 타입에 korean, chinese 두개의 public 필드 추가

```
Week[] days = Week.values();
for (Week day : days) {  // 향상된 for 문
    System.out.println(day.korean + " (" + day.chinese + ")");
}

/*
    월요일 (月)
    화요일 (火)
    수요일 (水)
    목요일 (木)
    금요일 (金)
    토요일 (土)
    일요일 (日)
*/
```


열거 타입도 일반 클래스와 마찬가지로 메소드를 지원 

필드를 private 으로 닫고, 게터(Getter) 만을 제공

```
public enum Week {
    // ...

    public String getKorean() {
        return korean;
    }

    public String getChinese() {
        return chinese;
    }
}
```

위처럼 메소드 정의 시, 각 열거 객체에서 메소드를 호출 가능

```
System.out.println(Week.SATURDAY.getKorean()); // 토요일
```



### 향상된 for문

#### 조건

1. JDK 1.5 이상
2. 사용할 변수는 지역변수로 인식된다. (For문 안에서 사용되기 때문)
3. 대상은 배열 or 여러 원소를 포함한 자료형이어야 한다.

#### 장점

1. 간편한,가독성 좋은 코드
2. 배열 인덱스 문제 해결 (ArrayIndexOutOfBoundsException 예외를 피할 수 있다.)

#### 단점

1. 인덱스를 사용하지 못한다.(일반 for문의 (int i=0;) 할 때 i 같은 인덱스를 말하는 것) 하지만 방법이 있다.
** 중요 **
2. 배열이나 ArrayList 값을 사용할 순 있지만 절대 수정할 수는 없다.

#### 사용 이유

- 배열처럼 여러 원소로 이루어진 집합의 모든 원소에 대해 특정 작업을 반복하기 위해 사용

#### 자주 사용되는 상황 

1. ArrayList 원소 출력
2. 배열 원소 출력

#### 문법

```
for( 자료형 변수명 : 배열명) {
  문장
 }
```

```
Ex)
String[] arr = {"1-1","1-2","1-3","1-4","1-5"};

for( String s : arr) {
  System.out.println(s);
 }
 
 /*
 * 1-1
 * 1-2
 * 1-3
 * 1-4
 * 1-5
 */
```