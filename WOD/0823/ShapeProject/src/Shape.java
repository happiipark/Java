package KOSTA._0823;

public abstract class Shape {

    public String color;

    Shape() {
    }

    Shape(String color) {
        this.color = color;
    }

    public abstract String ShapeDraw();
    // 껍데기만 필요해서 만든 함수 shape 자식클래스들이 필요해서 작성

}
