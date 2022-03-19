public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(-1.2,1);

        //RosenbrokFunction
        Answer HookeJeevesAns = HookeJeevesAlg.doHookeJeevesAlg(p1,(point)->
        { double res= 100*Math.pow((Math.pow(point.getX1(), 2)- point.getX2()),2) + Math.pow((1- point.getX1()),2);
            System.out.println(res);
            return res;
        }
        );
        System.out.println(HookeJeevesAns);
    }
}
