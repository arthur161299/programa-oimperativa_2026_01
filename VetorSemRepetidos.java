import java.util.Scanner;

public class VetorSemRepetidos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[10];
        int numero;
        boolean repetido;

        for (int i = 0; i < 10; i++) {

            System.out.print("Digite um número: ");
            numero = sc.nextInt();

            repetido = true;

            while (repetido) {
                repetido = false;

                for (int j = 0; j < i; j++) {
                    if (numero == vetor[j]) {
                        repetido = true;
                        System.out.println("Número repetido! Digite outro:");
                        numero = sc.nextInt();
                        break;
                    }
                }
            }

            vetor[i] = numero;
        }

        System.out.println("\nNúmeros digitados:");
        for (int i = 0; i < 10; i++) {
            System.out.print(vetor[i] + " ");
        }

        sc.close();
    }
}