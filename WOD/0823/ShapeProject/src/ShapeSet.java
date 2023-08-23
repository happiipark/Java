package KOSTA._0823;

public class ShapeSet {

    Shape[] shapes = new Shape[100];
    int shaCnt;

    public void add(Shape shape) { // circle, Triangle, rectangle 이 shape
        // TODO Auto-generated method stub

        shapes[shaCnt++] = shape;
    }

    void allShapeDraw() {
        for (int i = 0; i < shaCnt; i++) {
            System.out.println(shapes[i].ShapeDraw());
        }
    }


}
