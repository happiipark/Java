package _0823work;

import java.awt.*;

public class Rectangle extends Shape {

    Point startPos = new Point();
    int width;
    int height;

    Rectangle() {
    }


    public Rectangle(String color, int startPosX, int startPosY, int width, int height) {
        // TODO Auto-generated constructor stub
        super(color);
        this.startPos.x = startPosX;
        this.startPos.y = startPosY;
        this.width = width;
        this.height = height;
    }

    Rectangle(String color, Point startPos, int width, int height) {
        super(color);
        this.startPos = startPos;
        this.width = width;
        this.height = height;
    }

    @Override
    public String ShapeDraw() {  // [원:색(red),중심점(10,10),반지름(20)]
        return String.format("[사각형:색(%s),시작점(%d,%d),너비(%d),높이(%d)]", color,startPos.x,startPos.y,width, height);
    }


}
