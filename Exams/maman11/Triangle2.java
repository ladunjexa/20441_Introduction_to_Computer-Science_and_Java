/**
 * class Triangle2 is used to check the feasibility of a triangle 
 * according to side lengths as well as to identify the type of the triangle.
 */

/**
 * @author Liron Abutbul
 * @version 26/10/2022
 */

import java.util.Scanner;
public class Triangle2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in); // creating a Scanner object for interaction
        System.out.println ("This program check the feasibility of a triangle according to "
            + "side lengths as well as to identify the type of the triangle.");
        System.out.println ("Please enter the three lengths"
            + " of the triangle's sides");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        /**
         * condition tests whether the lengths of the sides can represent a triangle 
         * by a necessary condition for the existence of a triangle,
         * which is that the sum of every two sides in a triangle is greater than 
         * the third side.
         */
        if(a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("The numbers: " + a + ", " + b + " and " + c + 
                " cannot represent a triangle");
        }

        /**
         * condition tests weather the lengths of the sides can present a 
         * equilateral triangle by an intelligent comparison of the lengths of the sides, 
         * which claims that if the first side is equal to the second, 
         * and the second is equal to the third, then the triangle is equilateral.
         */
        else if(a == b && b == c) {
            System.out.println("The numbers: " + a + ", " + b + " and " + c + 
                " represent an equilateral triangle");            
        }

        /**
         * condition tests weather the lengths of the sides can present a isosceles triangle 
         * by comparing each side to the other.
         */
        else if(a == b || b == c || a == c) {
            System.out.println("The numbers: " + a + ", " + b + " and " + c + 
                " represent an isosceles triangle");
        }

        /**
         * condition tests weather the lengths of the sides can present a right-angle 
         * triangle by using the pythagorean theorem: {a^2 + b^2 = c^2}
         */
        else if((Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) || (Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2)) || (Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2))) {
            System.out.println("The numbers: " + a + ", " + b + " and " + c + 
                " represent a right-angle triangle");
        } 
        else 
            System.out.println("The numbers: " + a + ", " + b + " and " + c + 
                " represent a common triangle");
    }

}
