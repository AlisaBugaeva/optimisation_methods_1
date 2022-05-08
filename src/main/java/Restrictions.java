public class Restrictions {
    private double x1Min;
    private double x1Max;
    private double x2Min;
    private double x2Max;

    public Restrictions(double x1Min, double x1Max, double x2Min, double x2Man) {
        this.x1Min = x1Min;
        this.x1Max = x1Max;
        this.x2Min = x2Min;
        this.x2Max = x2Man;
    }

    public double getX1Min() {
        return x1Min;
    }

    public void setX1Min(double x1Min) {
        this.x1Min = x1Min;
    }

    public double getX1Max() {
        return x1Max;
    }

    public void setX1Max(double x1Max) {
        this.x1Max = x1Max;
    }

    public double getX2Min() {
        return x2Min;
    }

    public void setX2Min(double x2Min) {
        this.x2Min = x2Min;
    }

    public double getX2Max() {
        return x2Max;
    }

    public void setX2Max(double x2Max) {
        this.x2Max = x2Max;
    }
}
