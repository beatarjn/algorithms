package org.example.recursion;

public class Factorial {

//    Zaimplementuj operację obliczającą silnię podanej liczby.
    // 5! = 1*2*3*4*5 --> 120
    // 0! =1
    // 1! = 1


    public static void main(String[] args) {
        System.out.println(factorial(5));

    }

    public static int factorial(int number) {
        if (number <= 0) {
            return 1;
        }
        return number * factorial(number - 1);
    }
}
