public class Answer {
    private double Q;
    private Point T;
    private double eps;
    private int counter;
    private  int n;

    public Answer(double Q, Point t, double eps, int counter, int n) {
        this.Q = Q;
        T = t;
        this.eps = eps;
        this.counter = counter;
        this.n = n;
    }

    @Override
    public String toString() {
        if(n==2)
        return "Answer: minQ =" + Q +
                ", T=(" + T.getX1() +","+T.getX2()+
                "), eps=" + eps +
                ", counter=" + counter;
        else
            return "Answer: minQ =" + Q +
                    ", T=(" + T.getX1() +","+T.getX2()+","+T.getX3()+","+T.getX4()+
                    "), eps=" + eps +
                    ", counter=" + counter;
    }
}
