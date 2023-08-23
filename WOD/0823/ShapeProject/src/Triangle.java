package KOSTA._0823;

public class Triangle extends Shape {

    Point p1 = new Point();
    Point p2 = new Point();
    Point p3 = new Point();

//    Point p1,p2,p3 = new Point();
     // 참조형 (class, interface, enum, Array 등) 자료형도 같이 저장 스택 영역에
     // 힙의 참조 주소는 "stack(스택)" 이 가지고 있고 해당 객체를 통해서만 힙 영역에 있는 인스턴스를 컨트롤할 수 있다


     // 인스턴스 변수 -> 스택 영역이 힙에서 꺼내온다
    // 이렇게 동시에 선언과 초기화를 하면 따로 주소를 지정해서 저장 공간을 갖는게 아닌
    // 같은 주소를 가지는 공간을 갖게된다??


    int x, y, z;

    Triangle() {
    }

    Triangle(String color, Point p1, Point p2, Point p3) {
        super(color);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangle(String color, int p1, int p2, int p3, int p4, int p5, int p6) {
        // TODO Auto-generated constructor stub
        super(color);
        this.p1.x = p1;
        this.p1.y = p2;
        this.p2.x = p3;
        this.p2.y = p4;
        this.p3.x = p5;
        this.p3.y = p6;
    }

    @Override
    public String ShapeDraw() {  // [원:색(red),중심점(10,10),반지름(20)]
        return String.format("[삼각형:색(%s),점1(%d,%d),점1(%d,%d),점3(%d,%d)", color,p1.x,p1.y,p2.x,p2.y,p3.x,p3.y);
    }


}


//ISFP?
//ISTP?
//n = 만약에 쟁이
//f = 아 그랬어 (공감 충) me
// P 노 계획 즉흥 그냥 가~