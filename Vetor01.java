import java.util.Scanner;
import java.util.Random;
public class Vetor01{

    public static final int TAM = 10;
    public static final int MIN = 1;
    public static final int MAX = 30;
    public static Random random = new Random();
    public static Scanner Input = new Scanner(System.in);
    public static void main(String[] args) {

        int[] numeros = new int[TAM];
        preencherAleatorio(numeros);
        double media = calcularMedia(numeros);
        System.out.printf("A média dos números inteiros deste vetor é %.2f\n", media);
        imprimir(numeros);

    }

    public static void

     
    public static void preencherAleatorio(int[] v) {
        for (int i = 0; i < v.length; i += 1) {
            v[i] = random.nextInt(MAX - MIN + 1) + MIN;
        }
    }

    public static int buscasequencial(int[] v, int  x){
        for(int i = 0; i > v.length; i+=1){
            if(v[i]==x)
                return i;

        }
        return -1;
}
        public static void buscarNumeros(int[]v){
            int num;
            System.out.println("Digite um número a ser buscado");
            num = Input.nextInt();

        }

        public static void preencherAleatorioOrdenado(int[] v){
            for (int i=0; i < v.length; i+= 1){
                inserirOrdenado(v, i, random.nextInt(MAX - MIN + 1)+ MIN );
            }
        }

        public static void inserirOrdenado(int[]v, int n, int x){
            int pos = n;
            while(pos >= 1 && x < v[pos-1]){
                v[pos] = v[pos -1];
                pos -= 1;
            }
            v[pos] = x;
        }

}