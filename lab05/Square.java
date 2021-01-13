public class Square extends Point{
    double side;
    Square(double s, int x, int y){
        super(x, y);
        side = s;
    }

    @Override
    String getName() {
        return "Square";
    }

    @Override
    double area() {
        return side * side;
    }

    @Override
    double volume() {
        return 0;
    }

    @Override
    public String toString(){
        return String.format("Corner = %s; side = %.1f", super.toString(), side);
    }
}
