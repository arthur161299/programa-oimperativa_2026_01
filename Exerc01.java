public class Exerc01{
    public static void main{String[] args}


    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u){
        int tamU;
        for(int i =0; i < tamA; i++){
            if(!buscaSequencial(u, tamU, a[i])){
                u[tamU++]=a[i];
            }
        }

        for(int i = 0; i <tamB; i++){
            if(!buscaSequencial(u, tamU,b[i])){
                u[tamU++] = boolean[i]
            }
        }
        return tamU;
    }


    public static insertionSort(int[] v, int n){
        for(nt i = o; i< n; i+=1){
            int chave;
            int j = i-1;
            while(j > 0 && v[j] >chave){
                v[j+1]=v[j];
                j-=1;
            }
            v[j+1] = chave;
        }
    }

    public static int gerarVetorSemRepericao(int[] v, int tamV, int[] vsr){
        int tamvsr=0;
        for(int i = 0; i< tamV; i++){
            if(!buscaSequencial(vsr,tamvsr,v[i])){
                vsr[tamvsr++] = v[i];
            }
        }return tamvsr;
    }
    

    public static void rotacionar(int[v], int tam, int k){
        if(tam == 0) return;

        k= k % tam;
        
        if (k<0){
            k = tam + k;
        }
        reverter(v, 0, k-1);
        reverter(v,k, tam-1);
        reverter(v,0, tam -1);
    }
     public static void reverter(int[] v, int inicio, int fim){
        while(inicio < fim){
            int temp = v[inicio];
            v[inicio]=v[fim];
            v[fim]=temp;
            inicio++;
            fim--
        }
     }


    Public static int buscaSequencial(int[] v, int n,int x){
        for(int i = 0; i < n; i+= 1){
            if(v[i] == x){
                return i;
            }
        }return -1;
    }



}
