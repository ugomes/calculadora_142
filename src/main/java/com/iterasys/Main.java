package com.iterasys;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static float somar (float num1, float num2) {

        float resultado = num1 + num2;
        System.out.println("A soma de " + num1 + " e " + num2 + " é: " + resultado);
        return resultado;
    }
    public static float subtrair (float num1, float num2) {

        float resultado = num1 - num2;
        System.out.println("A subtração de " + num1 + " e " + num2 + " é: " + resultado);
        return resultado;
    }
    public static float multiplicar (float num1, float num2) {

        float resultado = num1 * num2;
        System.out.println("A multiplicação de " + num1 + " e " + num2 + " é: " + resultado);
        return resultado;
    }
    public static float dividir (float num1, float num2) {
     
            float resultado = num1 / num2;
           return resultado;
        }
    

    public static String dividirTry (int num1, int num2){
        try{
            return String.valueOf(num1/num2);
        } catch(Exception e) {
            return "Divisão por zero não é permitida.";
        }
    }
}
   