package Actividad1;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class ProgramaAritmetico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        while (true) {
            System.out.println("Bienvenido al programa de instrucción asistida por computadora");
            System.out.println("Elige el nivel de dificultad:");
            System.out.println("1. Números de un dígito");
            System.out.println("2. Números de dos dígitos");

            int nivel = scanner.nextInt();

            System.out.println("Elige el tipo de problema aritmético:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Mezcla aleatoria");

            int tipoProblema = scanner.nextInt();

            int preguntasCorrectas = 0;
            int preguntasIncorrectas = 0;

            while (preguntasCorrectas + preguntasIncorrectas < 10) {
                int num1 = generarNumero(nivel);
                int num2 = generarNumero(nivel);
                char operador = obtenerOperador(tipoProblema);

                int respuestaCorrecta = calcularRespuesta(num1, num2, operador);

                System.out.print("¿Cuánto es " + num1 + " " + operador + " " + num2 + "? ");
                int respuestaUsuario = scanner.nextInt();

                if (respuestaUsuario == respuestaCorrecta) {
                    System.out.println(obtenerRespuestaPositivaAleatoria());
                    preguntasCorrectas++;
                } else {
                    System.out.println(obtenerRespuestaNegativaAleatoria());
                    preguntasIncorrectas++;
                }
            }

            double porcentajeCorrectas = (double) preguntasCorrectas / 10 * 100;

            if (porcentajeCorrectas < 75) {
                System.out.println("Por favor, pide ayuda adicional a tu instructor.");
            } else {
                System.out.println("¡Felicidades, estás listo para pasar al siguiente nivel!");
            }

            System.out.println("¿Quieres probar otra vez? (s/n)");
            char respuesta = scanner.next().charAt(0);

            if (respuesta != 's') {
                break;
            }
        }

        scanner.close();
    }

    private static int generarNumero(int nivel) {
        Random random = new SecureRandom();

        if (nivel == 1) {
            return random.nextInt(10);
        } else if (nivel == 2) {
            return random.nextInt(90) + 10;
        } else {
            return 0;
        }
    }

    private static char obtenerOperador(int tipoProblema) {
        Random random = new SecureRandom();

        if (tipoProblema == 1) {
            return '+';
        } else if (tipoProblema == 2) {
            return '-';
        } else if (tipoProblema == 3) {
            return '*';
        } else if (tipoProblema == 4) {
            return '/';
        } else {
            char[] operadores = {'+', '-', '*', '/'};
            return operadores[random.nextInt(4)];
        }
    }

    private static int calcularRespuesta(int num1, int num2, char operador) {
        switch (operador) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }

    private static String obtenerRespuestaPositivaAleatoria() {
        String[] respuestasPositivas = {"¡Muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!"};
        Random random = new SecureRandom();
        return respuestasPositivas[random.nextInt(respuestasPositivas.length)];
    }

    private static String obtenerRespuestaNegativaAleatoria() {
        String[] respuestasNegativas = {"No. Por favor intenta de nuevo.", "Incorrecto. Intenta una vez más.",
                "¡No te rindas!", "No. Sigue intentando."};
        Random random = new SecureRandom();
        return respuestasNegativas[random.nextInt(respuestasNegativas.length)];
    }
}