package ua.com.alevel.level1;

import java.util.Scanner;

public class TriangleArea {
    public static Scanner sc = new Scanner(System.in);
    public static void TriangleAreaMain(){
        int temp;
        do {
            int nominator1, nominator2, nominator3, denominator1, denominator2, denominator3, slope1, slope2, slope3,
                    side1, side2, side3, halfPerimeter;
            double area;
            int[] x = new int[3];
            int[] y = new int[3];
            Inicialization(x, y);
            if (x[0] == x[1] && y[0] == y[1] || x[0] == x[2] && y[0] == y[2] || x[1] == x[2] && y[1] == y[2]) {
                System.out.println("The same coordinates exception");
                return;
            }

            if (x[0] == x[1] && x[1] == x[2] || y[0] == y[1] && y[1] == y[2]) {
                System.out.println("The same horizontal or vertical line exception");
                return;
            }

            nominator1 = y[1] - y[0];
            denominator1 = x[1] - x[0];
            nominator2 = y[2] - y[1];
            denominator2 = x[2] - x[1];
            nominator3 = y[0] - y[2];
            denominator3 = x[0] - x[2];

            if (denominator1 == 0) slope1 = 0;
            else slope1 = nominator1 / denominator1;
            if (denominator2 == 0) slope2 = 0;
            else slope2 = nominator2 / denominator2;
            if (denominator3 == 0) slope3 = 0;
            else slope3 = nominator3 / denominator3;

            if ((slope1 == slope2 && slope1 == slope3)) {
                System.out.println("Points make line exception");
                return;
            }

            side1 = (int) Math.sqrt((x[1] - x[0]) * (x[1] - x[0]) + (y[1] - y[0]) * (y[1] - y[0]));
            side2 = (int) Math.sqrt((x[2] - x[1]) * (x[2] - x[1]) + (y[2] - y[1]) * (y[2] - y[1]));
            side3 = (int) Math.sqrt((x[0] - x[2]) * (x[0] - x[2]) + (y[0] - y[2]) * (y[0] - y[2]));

            if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1) {
                System.out.println("The triangle does`nt exist exception");
                return;
            }
            halfPerimeter = (side1 + side2 + side3) / 2;
            area = Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter * side2) * (halfPerimeter * side3));
            System.out.println(area);
            System.out.println("Please press 1 if you want to restart the TriangleArea application," +
                    " otherwise press any other number");
            while(!sc.hasNextInt()){
                sc.next();
            }
            temp = sc.nextInt();
        }while(temp == 1);
    }


    public static void Inicialization(int[] arrayX, int[] arrayY){
        System.out.println("Please input first point`s x");
        while(!sc.hasNextInt()){
            sc.next();
        }
        arrayX[0]= sc.nextInt();

        System.out.println("Please input first point`s y");
        while(!sc.hasNextInt()){
            sc.next();
        }
        arrayY[0]= sc.nextInt();

        System.out.println("Please input second point`s x");
        while(!sc.hasNextInt()){
            sc.next();
        }
        arrayX[1]= sc.nextInt();

        System.out.println("Please input second point`s y");
        while(!sc.hasNextInt()){
            sc.next();
        }
        arrayY[1]= sc.nextInt();

        System.out.println("Please input third point`s x");
        while(!sc.hasNextInt()){
            sc.next();
        }
        arrayX[2]= sc.nextInt();

        System.out.println("Please input third point`s y");
        while(!sc.hasNextInt()){
            sc.next();
        }
        arrayY[2]= sc.nextInt();
    }

}
