# Java 메모리 구조

## 1. JVM(Java Virtual Machine)

자바 가상 머신 JVM(Java Virtual Machine)은 **자바 프로그램 실행환경을 만들어주는 소프트웨어**

자바 코드를 컴파일하여 .class 바이트 코드로 만들면 이 코드가 자바 가상 머신 환경에서 실행 됨.

JVM은 자바 실행 환경 JRE(Java Runtime Enviromment)에 포함

자바 코드는 JVM을 통해 실행되므로 Window, Linux와 같은 다른 OS에서도 동일하게 실행 할 수 있다는 장점이 있다!

-> **JVM을 사용하면 하나의 바이트 코드(.class)로 모든 플랫폼에서 동작 가능**

<img src = "https://github.com/happiipark/Java/assets/124240328/4b107b07-5436-4b7e-961f-1114ff8e53e1" width="500" height="400"/>

### JVM의 OS에서의 실행 과정

<img src = "https://github.com/happiipark/Java/assets/124240328/434e8337-e242-4a58-bfae-ed31b49ffaec" width="700" height="500"/>

1. 자바로 개발된 프로그램을 실행하면 JVM은 OS로부터 메모리를 할당
2. 자바 컴파일러가(.javac)가 자바 소스코드(.java)를 자바 바이트코드(.class)로 컴파일
3. Class Loader를 통해 JVM Runtime Data Area로 로딩
4. Runtime Data Area에 로딩 된 .class들은 Execution Engine을 통해 해석
5. 해석된 바이트코드는 Runtime Data Area의 각 영역에 배치되어 수행하며 이 과정에서 Execution에 의해 GC의 작동과 스레드 동기화가 이루어짐

**모든 자바 프로그램은 JVM을 통해 실행, 일단 프로그램이 실행되면 JVM은 OS로 부터 프로그램을 수행하는데 필요한 메모리를 할당받는다**

-> 이 메모리를 가지고 JVM은 용도에 따라 구분해서 사용

---

## 2.메모리 영역

### Method 영역

static 영역(== class, method 영역으로도 불림)은 전역변수나 static으로 선언되는 것들을 메모리에 상주 시킴

* 클래스 정보, static 변수, 변수 정보, 메소드 정보 등을 저장
* 패키지나 클래스 정보가 올라간다
* static이 선언된 클래스 멤버도 올라간다
* static (전역)변수는 어디든 접근이 가능해지므로 읽기 전용이 아닌 경우는 가능한 사용하지 않는다
* JVM이 동작해서클래스가 로딩될 때 생성
* JVM이 종료될때까지 유지된다.

---
  
### Heap(힙) 영역
힙 영역은 인스턴스를 생성할 때 생성되는 메모리 형식

  ```
  Instance instance = new Instance(); // -> heap에 존재
  ```
  
* "new"를 사용하여 객체를 만들 때 저장
*  참조형 (class, interface, enum, Array 등) 자료형도 같이 저장
*  힙의 참조 주소는 "stack(스택)" 이 가지고 있고 해당 객체를 통해서만 힙 영역에 있는 인스턴스를 핸들링할 수 있다
*  GC( Garbage Collection )가 정리하기 전까지는 남아있는다

---

### Stack(스택) 영역

스택 영역은 int, long, boolean 등 기본 자료형을 생성할 때 저장하는 공간으로, 임시적으로 사용되는 변수나 정보들이 저장되는 영역

* 쓰레드 별로 1개만 생성
* 하나의 쓰레드는 내부적으로 static, stack, heap 영역을 갖게됨
* Ex) 임의의 쓰레드 A는 다른 쓰레드에 접근할 수 없지만, static과 heap 영역을 공유하여 사용 가능
* 메소드가 호출될 때마다 생성
* 메서드 실행이 끝나면 pop이 되어 제거
  
