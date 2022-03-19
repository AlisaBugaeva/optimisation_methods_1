public class HookeJeevesAlg {


    public static Answer doHookeJeevesAlg(Point T0, FunctionQ Q){
        double eps = 0.00001;
        double delta1 = 0.01;
        double delta2 = 0.01;
        double h = 0.03;
        Point T = T0;
        int counter = 0;

        while (delta1 >= eps && delta2 >=eps){
            T= directionSearch(T0, x2Shift(x1Shift(T0, Q, delta1), Q, delta2), Q, h);
            if(T.equals(T0)){
                delta1= delta1 -eps;
                delta2= delta2 -eps;
            }
            counter ++;
            T0=T;
        }
        return new Answer(Q.countQ(T),T,eps,counter);
    }


    public static Point x1Shift(Point T0, FunctionQ Q, double delta1){
        Point T1;
        Point T1_t = new Point(T0.getX1()+ delta1, T0.getX2());
        if(Q.countQ(T1_t) < Q.countQ(T0)){
            T1=T1_t;
        }
        else{
            Point T1_d = new Point(T0.getX1()- delta1, T0.getX2());
            if(Q.countQ(T1_d) < Q.countQ(T0)){
                T1=T1_d;
            }
            else{
                T1=T0;
            }
        }
        return T1;
    }

    public static Point x2Shift(Point T0, FunctionQ Q, double delta2){
        Point T2;
        Point T1_t = new Point(T0.getX1(), T0.getX2()+ delta2);
        if(Q.countQ(T1_t) < Q.countQ(T0)){
            T2=T1_t;
        }
        else{
            Point T1_d = new Point(T0.getX1(), T0.getX2() - delta2);
            if(Q.countQ(T1_d) < Q.countQ(T0)){
                T2=T1_d;
            }
            else{
                T2=T0;
            }
        }
        return T2;
    }

    public static Point directionSearch(Point T0,Point T2, FunctionQ Q, double h){
        Point T;
        Point X_d = new Point(T0.getX1()+h*(T2.getX1()-T0.getX1()), T0.getX2()+h*(T2.getX2()-T0.getX2()));
        if(Q.countQ(X_d) < Q.countQ(T0)){
            T=X_d;
        }
        else{
            T=T2;
        }
        return T;
    }


}
