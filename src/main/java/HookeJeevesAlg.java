public class HookeJeevesAlg {


    public static Answer doHookeJeevesAlg(Point T0, FunctionQ Q, Restrictions restrictions, int n){
        double eps = 0.00001;
        double delta1 = 0.01;
        double delta2 = 0.01;
        double delta3 = 0.01;
        double delta4 = 0.01;
        double h = 0.03;
        Point T = T0;
        int counter = 0;

        while (delta1 >= eps && delta2 >=eps&&delta3 >= eps && delta4 >=eps){
            if(n == 2)
                T= directionSearch(T0, xShift(xShift(T0, Q, delta1, 1, restrictions,n), Q, delta2,2,restrictions,n), Q, h,n);
            else if(n == 4)
                T= directionSearch(T0, xShift(xShift(xShift(xShift(T0, Q, delta1, 1, restrictions,n), Q, delta2,2,restrictions,n),Q,delta3,3,restrictions,n), Q, delta4,4,restrictions,n), Q, h,n);
            if(T.equals(T0)){
                delta1= delta1 -eps;
                delta2= delta2 -eps;
                delta3= delta3 -eps;
                delta4= delta4 -eps;
            }
            counter ++;
            T0=T;
        }
        return new Answer(Q.countQ(T),T,eps,counter,n);
    }


    public static Point xShift(Point T0, FunctionQ Q, double delta, int i,Restrictions restrictions,int n){
        Point T;
        Point T_t = new Point(0,0);
        Point T_d = new Point(0,0);
        double QCountT_t;
        double QCountT_d;
        if(i==1)
        {
            T_t = new Point(T0.getX1() + delta, T0.getX2());
            T_d = new Point(T0.getX1()- delta, T0.getX2());
            if(n==4){
                T_t.setX3(T0.getX3());
                T_t.setX4(T0.getX4());
                T_d.setX3(T0.getX3());
                T_d.setX4(T0.getX4());
            }
        }
        else if(i == 2)
        {
            T_t = new Point(T0.getX1(), T0.getX2()+ delta);
            T_d = new Point(T0.getX1(), T0.getX2() - delta);
            if(n==4){
                T_t.setX3(T0.getX3());
                T_t.setX4(T0.getX4());
                T_d.setX3(T0.getX3());
                T_d.setX4(T0.getX4());
            }
        }

        else if(i == 3)
        {
            T_t = new Point(T0.getX1(), T0.getX2());
            T_d = new Point(T0.getX1(), T0.getX2());
            if(n==4){
                T_t.setX3(T0.getX3()+ delta);
                T_t.setX4(T0.getX4());
                T_d.setX3(T0.getX3()- delta);
                T_d.setX4(T0.getX4());
            }
        }

        else if(i == 4)
        {
            T_t = new Point(T0.getX1(), T0.getX2());
            T_d = new Point(T0.getX1(), T0.getX2());
            if(n==4){
                T_t.setX3(T0.getX3());
                T_t.setX4(T0.getX4()+ delta);
                T_d.setX3(T0.getX3());
                T_d.setX4(T0.getX4()- delta);
            }
        }

        if((restrictions != null)&&(T_t.getX1()> restrictions.getX1Max() || T_t.getX1()< restrictions.getX1Min() || T_t.getX2()> restrictions.getX2Max() || T_t.getX2()< restrictions.getX2Min())){
            QCountT_t = Double.MAX_VALUE;
        }
        else
        {
            QCountT_t = Q.countQ(T_t);
        }

        if((restrictions != null)&&(T_d.getX1()> restrictions.getX1Max() || T_d.getX1()< restrictions.getX1Min() || T_d.getX2()> restrictions.getX2Max() || T_d.getX2()< restrictions.getX2Min())){
            QCountT_d = Double.MAX_VALUE;
        }
        else
        {
            QCountT_d = Q.countQ(T_d);
        }



        if(QCountT_t < Q.countQ(T0)){
            T=T_t;
        }
        else{
            T = (QCountT_d < Q.countQ(T0)) ? T_d : T0;
        }
        return T;
    }

    public static Point directionSearch(Point T0, Point T2, FunctionQ Q, double h, int n){
        Point X_d = new Point(T0.getX1()+h*(T2.getX1()-T0.getX1()), T0.getX2()+h*(T2.getX2()-T0.getX2()));
        if(n==4){
            X_d.setX3(T0.getX3()+h*(T2.getX3()-T0.getX3()));
            X_d.setX4(T0.getX4()+h*(T2.getX4()-T0.getX4()));
        }
        return  (Q.countQ(X_d) < Q.countQ(T0)) ? X_d : T2;
    }



       /* public static Point x2Shift(Point T0, FunctionQ Q, double delta2){
        Point T2;
        Point T1_t = new Point(T0.getX1(), T0.getX2()+ delta2);
        if(Q.countQ(T1_t) < Q.countQ(T0)){
            T2=T1_t;
        }
        else{
            Point T1_d = new Point(T0.getX1(), T0.getX2() - delta2);
            T2 = (Q.countQ(T1_d) < Q.countQ(T0)) ? T1_d : T0;
        }
        return T2;
    }*/
}
