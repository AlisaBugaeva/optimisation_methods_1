// создаём точку в двумерном пространстве с координатами по x1 и x2

import java.util.Objects;

public class Point {
    private double x1;
    private double x2;

    private double x3;
    private double x4;

    public Point(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getX4() {
        return x4;
    }

    public void setX4(double x4) {
        this.x4 = x4;
    }


    @Override
    public boolean equals(Object o) {
        double epsilon = 5.96e-08;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return (Math.abs(point.getX1() / this.getX1() - 1) < epsilon) && (Math.abs(point.getX2() / this.getX2() - 1) < epsilon) && (Math.abs(point.getX3() / this.getX3() - 1) < epsilon) && (Math.abs(point.getX4() / this.getX4() - 1) < epsilon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2,x3,x4);
    }
}
