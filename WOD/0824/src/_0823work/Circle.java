package _0823work;


import java.awt.*;

public class Circle extends Shape {

    Point center = new Point();
    int radius;

    Circle() {
    }

    public Circle(String color, int center1, int center2, int radius) {
        // TODO Auto-generated constructor stub
        super(color);
        this.center.x = center1;
        this.center.y = center2;
        this.radius = radius;
    }

    public Circle(String color, Point point, int radius) {
        // TODO Auto-generated constructor stub
        super(color);
        this.center = point;
        this.radius = radius;
    }

    @Override
    public String ShapeDraw() {  // [원:색(red),중심점(10,10),반지름(20)]
//		return "[원:색("+color+"), 중심점(";
        return String.format("[원:색(%s),중심점(%d,%d),반지름(%d)]", color,center.x,center.y,radius);


    }


}
