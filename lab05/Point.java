public class Point extends Shape{
    double x_cord, y_cord;
    Point(double x, double y){
        x_cord = x;
        y_cord = y;
    }

    @Override
    String getName() {
        return "Point";
    }

    @Override
    double area() {
        return 0;
    }

    @Override
    double volume() {
        return 0;
    }

    @Override
    public String toString(){
        return String.format("[%.1f, %.1f]", x_cord, y_cord);
    };
}