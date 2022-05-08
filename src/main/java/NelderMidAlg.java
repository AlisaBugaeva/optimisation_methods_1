public class NelderMidAlg {

    public static Answer doNelderMidAlg(Point T0, FunctionQ Q, Restrictions restrictions,int n){
        double alpha = 1;
        double betta = 2;
        double gamma = 0.5;
        double l = 5;
        double eps = 0.00001;


        //Задаём начальный многогранник
        Point[] X = new Point[n+1];
        X[0] = T0;
        X[1] = new Point(X[0].getX1() + l, X[0].getX2());
        X[2] = new Point(X[0].getX1(), X[0].getX2()+l);
        if (n == 4) {
            X[1].setX3(X[0].getX3());
            X[1].setX4(X[0].getX4());
            X[2].setX3(X[0].getX3());
            X[2].setX4(X[0].getX4());

            X[3] = new Point(X[0].getX1(), X[0].getX2());
            X[4] = new Point(X[0].getX1(), X[0].getX2());
            X[3].setX3(X[0].getX3()+l);
            X[3].setX4(X[0].getX4());
            X[4].setX3(X[0].getX3());
            X[4].setX4(X[0].getX4()+l);
        }

        double sum;
        double criterion;
        int counter=0;
        Point C = new Point(0,0);
        do {
            sum=0;
            counter++;
            //сортируем точки
            sort(Q,X);

            for (int i = 0; i <= n-1; i++) {
                C = new Point(X[i].getX1(), X[i].getX2());
            }
            C.setX1(C.getX1()/n);
            C.setX2(C.getX2()/n);
            C.setX3(C.getX3()/n);
            C.setX4(C.getX4()/n);

            X[n] = reflectionOperation(n,Q, C, alpha, betta, gamma, X, restrictions);

            for (int i = 1; i <= n; i++) {
                sum += Math.pow(Q.countQ(X[i]) - Q.countQ(X[0]), 2);
            }
            criterion = Math.sqrt(sum/n);

        }while (criterion > eps);



     return new Answer(Q.countQ(X[0]),X[0],eps,counter,n);
    }

    public static Point reflectionOperation(int n, FunctionQ Q, Point C, double alpha, double betta, double gamma, Point[] X,Restrictions restrictions){ //alpha

        double QCountU;
        Point U = new Point( C.getX1() + alpha*(C.getX1() - X[n].getX1()),
                C.getX2() + alpha*(C.getX2() - X[n].getX2()));
        if(n==4){
            U.setX3(C.getX3() + alpha*(C.getX3() - X[n].getX3()));
            U.setX4(C.getX4() + alpha*(C.getX4() - X[n].getX4()));
        }


        QCountU = Q.countQ(U);


        if(Q.countQ(X[0]) <= QCountU && QCountU <= Q.countQ(X[n-1]) ){
            return U;
        }
        else if(Q.countQ((U)) < Q.countQ(X[0])){
            return stretchOperation(betta, C, U , Q, restrictions,n);
        }
        else return compressionOperation(gamma, C, U , Q , n,  X, restrictions);
    }

    public static Point stretchOperation(double betta,Point C, Point U, FunctionQ Q, Restrictions restrictions, int n){ //betta

        double QCountV;

        Point V = new Point( C.getX1() + betta*(U.getX1() - C.getX1()),
                C.getX2() + betta*(U.getX2() - C.getX2()));
        if(n==4){
            U.setX3(C.getX3() + betta*(U.getX3() - C.getX3()));
            U.setX4(C.getX4() + betta*(U.getX4() - C.getX4()));
        }


        QCountV = Q.countQ(V);


        if(QCountV < Q.countQ(U)){
            return V;
        }
        else return U;
    }

    public static Point compressionOperation(double gamma, Point C, Point U, FunctionQ Q, int n, Point[] X, Restrictions restrictions){ //gamma

        Point W;
        double QCountW;
        if(Q.countQ(U) < Q.countQ(X[n])){
            W = new Point( C.getX1() + gamma*(U.getX1() - C.getX1()),
                    C.getX2() + gamma*(U.getX2() - C.getX2()));
            if(n==4){
                U.setX3(C.getX3() + gamma*(U.getX3() - C.getX3()));
                U.setX4(C.getX4() + gamma*(U.getX4() - C.getX4()));
            }
        }
        else{
            W = new Point( C.getX1() + gamma*(X[n].getX1() - C.getX1()),
                    C.getX2() + gamma*(X[n].getX2() - C.getX2()));
            if(n==4){
                U.setX3(C.getX3() + gamma*(X[n].getX3() - C.getX3()));
                U.setX4(C.getX4() + gamma*(X[n].getX4() - C.getX4()));
            }
        }



        QCountW = Q.countQ(W);


        if(QCountW < Math.min(Q.countQ(X[n]), Q.countQ(U))){
            return W;
        }
        else{
            //пересчитываем все точки
            for(int i = 1; i<=n; i++){
                X[i] = new Point((X[0].getX1()+X[i].getX1())/2,(X[0].getX2()+X[i].getX2())/2);
                if(n==4){
                    X[i].setX3((X[0].getX3()+X[i].getX3())/2);
                    X[i].setX4((X[0].getX4()+X[i].getX4())/2);
                }
            }
            return X[n];
        }
    }

    public static void sort(FunctionQ Q, Point[] array) {
        // i - номер прохода
        for (int i = 0; i < array.length - 1; i++) {
            // внутренний цикл прохода
            for (int j = array.length - 1; j > i; j--) {
                if (Q.countQ(array[j - 1]) >= Q.countQ(array[j])) {
                    Point tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }


}
