public class Answer {
    private double Q;
    private Point T;
    private double eps;
    private int counter;

    public Answer(double Q, Point t, double eps, int counter) {
        this.Q = Q;
        T = t;
        this.eps = eps;
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Answer: minQ =" + Q +
                ", T=(" + T.getX1() +","+T.getX2()+
                "), eps=" + eps +
                ", counter=" + counter;
    }
}
