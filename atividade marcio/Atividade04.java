import java.util.Scanner;

public class Atividade04 {

    static final int MAX = 100;
    static Produto[] produtos = new Produto[MAX];
    static int total = 0;

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int opc;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar");
            System.out.println("3 - Filtrar por categoria");
            System.out.println("4 - Ordenar por nome");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Atualizar preço");
            System.out.println("7 - Listagem com subtotal por categoria");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opc = in.nextInt();

            switch (opc) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> filtrarCategoria();
                case 4 -> ordenar();
                case 5 -> remover();
                case 6 -> atualizarPreco();
                case 7 -> listarPorCategoria();
            }

        } while (opc != 0);
    }

    
    static void cadastrar() {
        in.nextLine();
        
        Produto p = new Produto();

        System.out.print("Nome: ");
        p.nome = in.nextLine();

        System.out.print("Quantidade em estoque: ");
        p.quantidadeEmEstoque = in.nextInt();

        System.out.print("Preço unitário: ");
        p.precoUnitario = in.nextDouble();

        in.nextLine();
        System.out.print("Categoria: ");
        p.categoria = in.nextLine();

        System.out.print("Quantidade mínima: ");
        p.quantidadeMinima = in.nextInt();

        produtos[total] = p;
        total++;

        System.out.println("Produto cadastrado com sucesso!");
    }

    
    static void listar() {
        System.out.println("\n--- LISTAGEM ---");

        for (int i = 0; i < total; i++) {
            Produto p = produtos[i];
            System.out.printf("%s | Qtde: %d | R$ %.2f | Cat: %s\n",
                    p.nome, p.quantidadeEmEstoque, p.precoUnitario, p.categoria);
        }
    }

    
    static void filtrarCategoria() {
        in.nextLine();
        System.out.print("Categoria: ");
        String cat = in.nextLine();

        System.out.println("\n--- Produtos da categoria " + cat + " ---");

        for (int i = 0; i < total; i++) {
            Produto p = produtos[i];
            if (p.categoria.equalsIgnoreCase(cat)) {
                System.out.printf("%s | Qtde: %d | R$ %.2f\n",
                        p.nome, p.quantidadeEmEstoque, p.precoUnitario);
            }
        }
    }

    
    static void ordenar() {
        for (int i = 0; i < total - 1; i++) {
            for (int j = 0; j < total - 1 - i; j++) {
                if (produtos[j].nome.compareToIgnoreCase(produtos[j+1].nome) > 0) {
                    Produto temp = produtos[j];
                    produtos[j] = produtos[j + 1];
                    produtos[j + 1] = temp;
                }
            }
        }

        System.out.println("Ordenado com sucesso!");
    }

  
    static void remover() {
        in.nextLine();
        System.out.print("Nome do produto a remover: ");
        String alvo = in.nextLine();

        for (int i = 0; i < total; i++) {
            if (produtos[i].nome.equalsIgnoreCase(alvo)) {

                
                for (int j = i; j < total - 1; j++) {
                    produtos[j] = produtos[j + 1];
                }

                total--;
                System.out.println("Removido!");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    
    static void atualizarPreco() {
        in.nextLine();
        System.out.print("Nome do produto: ");
        String alvo = in.nextLine();

        for (int i = 0; i < total; i++) {
            if (produtos[i].nome.equalsIgnoreCase(alvo)) {
                System.out.print("Novo preço: ");
                produtos[i].precoUnitario = in.nextDouble();
                System.out.println("Preço atualizado!");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    
    static void listarPorCategoria() {

        System.out.println("\n--- LISTAGEM POR CATEGORIA ---");

        double totalGeral = 0;

        for (int i = 0; i < total; i++) {

            if (!categoriaJaListada(i)) {

                String catAtual = produtos[i].categoria;
                double subtotal = 0;

                System.out.println("\nCategoria: " + catAtual);

                for (int j = 0; j < total; j++) {
                    if (produtos[j].categoria.equalsIgnoreCase(catAtual)) {

                        Produto p = produtos[j];

                        double sub = p.precoUnitario * p.quantidadeEmEstoque;

                        System.out.printf("  %s | %d x R$ %.2f\n",
                                p.nome, p.quantidadeEmEstoque, p.precoUnitario);

                        subtotal += sub;
                    }
                }

                System.out.printf("Subtotal: R$ %.2f\n", subtotal);
                totalGeral += subtotal;
            }
        }

        System.out.printf("\nTOTAL GERAL: R$ %.2f\n", totalGeral);
    }

    static boolean categoriaJaListada(int index) {
        for (int i = 0; i < index; i++) {
            if (produtos[i].categoria.equalsIgnoreCase(produtos[index].categoria)) {
                return true;
            }
        }
        return false;
    }
}
