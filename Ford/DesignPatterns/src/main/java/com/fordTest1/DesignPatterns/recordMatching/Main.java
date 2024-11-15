package com.fordTest1.DesignPatterns.recordMatching;


public class Main {

    public static void main(String[] args) {

         Shape circle = new Circle(4.4);
         Shape rectangle = new Rectangle(5.5,8.9);

        System.out.println("Calculating circle Area " +calculateArea(circle));;
        System.out.println("Calculating rectangle Area " +calculateArea(rectangle));;

    }

    public static Double calculateArea(Shape s) {

          if(s instanceof Rectangle r){
              return r.length()*r.width();
          }
          else if(s instanceof Circle c){
              return Math.PI*c.radius()*c.radius();
          }
          else{
              throw new UnsupportedOperationException("Unsupported");
          }


    }
}



/*
return switch (s) {
            case Circle(double radius) -> Math.PI * radius * radius;
            case Rectangle(double length, double width) -> length * width;
        };
 */
