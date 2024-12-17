package com.example.demo11;
import java.util.Scanner;
public class Calci {
	

	  public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);
	        double num1, num2, result;
	        char operator;

	        System.out.print("Enter first number: ");
	        num1 = input.nextDouble();

	        System.out.print("Enter an operator (+, -, *, /): ");
	        operator = input.next().charAt(0);

	        System.out.print("Enter second number: ");
	        num2 = input.nextDouble();

	        if (operator == '+') {
	            result = add(num1,num2);
	        } else if (operator == '-') {
	            result = subrtact(num1,num2);
	        } else if (operator == '*') {
	            result = num1 * num2;
	        } else if (operator == '/') {
	            if (num2 != 0) {
	                result = num1 / num2;
	            } else {
	                System.out.println("Error: Division by zero is not allowed.");
	                return;
	            }
	        } else {
	            System.out.println("Error: Invalid operator.");
	            return;
	        }

	        System.out.println("Result: " + result);
	  }

	private static double subrtact(double num1, double num2) {
		return num1 - num2;
	}

	private static double add(double num1, double num2) {
		
		return num1+num2;
	}
	

}
