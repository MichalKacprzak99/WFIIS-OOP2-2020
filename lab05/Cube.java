public class Cube extends Square{
    double depth;

    Cube(double s, int x, int y){
        super(s, x, y);
        depth = s;
    }

    @Override
    String getName() {
        return "Cube";
    }

    @Override
    double area() {
        return super.area() * 6;
    }

    @Override
    double volume() {
        return super.area() * depth;
    }

    @Override
    public String toString(){
        return String.format("%s; depth = %.1f", super.toString(), depth);
    }
}
