public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(-1.2,1);
        Point p2 = new Point(-1.2,-1);

        Point p4 = new Point(3,-1);
        p4.setX3(0);
        p4.setX4(1);

        System.out.println("HookeJeeves algorithm");

        //RosenbrokFunction
        Answer HookeJeevesAns1 = HookeJeevesAlg.doHookeJeevesAlg(p1,(point)->
               100*Math.pow((Math.pow(point.getX1(), 2)- point.getX2()),2) + Math.pow((1- point.getX1()),2),null,2
        );
        System.out.println("Function 1");
        System.out.println(HookeJeevesAns1);

        //2 function
        Answer HookeJeevesAns2 = HookeJeevesAlg.doHookeJeevesAlg(p2,(point)->
                (100*Math.pow(point.getX2()-(Math.pow(point.getX1(), 3)),2)+ Math.pow(1-point.getX2(), 2)),null,2
        );
        System.out.println("Function 2");
        System.out.println(HookeJeevesAns2);

        //3 function
        Answer HookeJeevesAns3 = HookeJeevesAlg.doHookeJeevesAlg(p1,(point)->
                        (100*Math.pow(point.getX2()-(Math.pow(point.getX1(), 3)),2)+ Math.pow(1-point.getX2(), 2)),
                new Restrictions(-1.2,1,-1,1),2
        );
        System.out.println("Function 3");
        System.out.println(HookeJeevesAns3);

        //4 function
        Answer HookeJeevesAns4 = HookeJeevesAlg.doHookeJeevesAlg(p4,(point)->
                        (Math.pow(point.getX1()+10* point.getX2(),2) + 5*Math.pow(point.getX3() - point.getX4(),2)
                                + Math.pow(point.getX2() - 2* point.getX3(),4 ) + 10*Math.pow(point.getX1() - point.getX4(),4 )),
                null,4
        );
        System.out.println("Function 4");
        System.out.println(HookeJeevesAns4);

        System.out.println("");
        System.out.println("NelderMid algorithm");

        Answer NelderMidAlgAns1 = NelderMidAlg.doNelderMidAlg(p1,(point)->
                100*Math.pow((Math.pow(point.getX1(), 2)- point.getX2()),2) + Math.pow((1- point.getX1()),2),null,2
        );
        System.out.println("Function 1");
        System.out.println(NelderMidAlgAns1);

        //2 function
        Answer NelderMidAlgAns2 = NelderMidAlg.doNelderMidAlg(p2,(point)->
                (100*Math.pow(point.getX2()-(Math.pow(point.getX1(), 3)),2)+ Math.pow(1-point.getX2(), 2)),null,2
        );
        System.out.println("Function 2");
        System.out.println(NelderMidAlgAns2);

        //3 function
       Answer NelderMidAlgAns3 = NelderMidAlg.doNelderMidAlg(p1,(point)->
                (100*Math.pow(point.getX2()-(Math.pow(point.getX1(), 3)),2)+ Math.pow(1-point.getX2(), 2)),
                new Restrictions(-1.2,1,-1,1),2
        );
        System.out.println("Function 3");
        System.out.println(NelderMidAlgAns3);

        //4 function
        Answer NelderMidAlgAns4 = NelderMidAlg.doNelderMidAlg(p4,(point)->
                        (Math.pow(point.getX1()+10* point.getX2(),2) + 5*Math.pow(point.getX3() - point.getX4(),2)
                                + Math.pow(point.getX2() - 2* point.getX3(),4 ) + 10*Math.pow(point.getX1() - point.getX4(),4 )),
                null,4
        );
        System.out.println("Function 4");
        System.out.println(NelderMidAlgAns4);
    }
}
