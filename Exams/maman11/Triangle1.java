/**
 * class Triangle1 is used for calculate perimeter and 
 * area of triangle according to his sides.
 */

/**
 * @author Liron Abutbul
 * @version 26/10/2022
 */

import java.util.Scanner;
public class Triangle1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Creating a Scanner object for interaction.        
        System.out.println("This program calculates the area " +
            "and the perimeter of a given triangle.");
        System.out.println("Please enter the three lengths " +
            "of the triangle's sides.");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        // calculation
        double halfPerimeter = ((a + b + c) / 2.0); // Calculation of half perimeter of the triangle, for the purpose of using the Heron's formula.
        double area = Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c)); // Calculation of area of the triangle using the Heron formula with the HalfPerimeter variable.
        System.out.println("The lengths of the triangle sides are: " + a + ", " + b + ", " + c + ".");
        System.out.println("The perimeter of the triangle is: " + (int)(halfPerimeter * 2));
        System.out.println("The area of the triangle is: " + area);
    }
}
