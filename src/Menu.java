import java.util.Scanner;

public class Menu {

    private Gerenciador gerenciador;
    private Scanner scanner;

    public Menu() {
        gerenciador = new Gerenciador();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            executarOpcao(opcao);
        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\n==========================================");
        System.out.println("     GERENCIADOR DE RANKING DE JOGADORES");
        System.out.println("=========================================");
        System.out.println("1 - Cadastrar jogadores manualmente");
        System.out.println("2 - Usar jogadores padrão");
        System.out.println("3 - Preencher pontuação manualmente");
        System.out.println("4 - Gerar pontuação aleatória");
        System.out.println("5 - Mostrar resultado (todas as pontuações)");
        System.out.println("6 - Ver ranking (Quick Sort)");
        System.out.println("7 - Ver ranking (Merge Sort)");
        System.out.println("8 - Consultar jogador específico");
        System.out.println("9 - Ver soma total do campeonato");
        System.out.println("10 - Ver soma de uma rodada");
        System.out.println("0 - Sair");
        System.out.println("=========================================");
        System.out.print("Escolha uma opção: ");
    }

    private int lerOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Opção inválida! Digite um número.");
            scanner.next();
            System.out.print("Escolha uma opção: ");
        }
        return scanner.nextInt();
    }

    private void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                gerenciador.JogadorViaTerminal(scanner);
                break;
            case 2:
                gerenciador.usarDadosPadrao();
                System.out.println("Jogadores padrão carregados!");
                break;
            case 3:
                gerenciador.preencherPontuacao(scanner);
                break;
            case 4:
                gerenciador.gerarPontuacaoAleatoria();
                System.out.println("Pontuações geradas aleatoriamente!");
                break;
            case 5:
                gerenciador.mostrarResultado();
                break;
            case 6:
                gerenciador.somaPontosJogador();
                gerenciador.quickSort(0, gerenciador.pontosJogador.length - 1);
                gerenciador.mostrarRanking();
                break;
            case 7:
                gerenciador.somaPontosJogador();
                gerenciador.mergeSort(0, gerenciador.pontosJogador.length - 1);
                gerenciador.mostrarRanking();
                break;
            case 8:
                gerenciador.somaPontosJogador();
                gerenciador.quickSort(0, gerenciador.pontosJogador.length - 1);
                System.out.print("Digite o nome do jogador: ");
                scanner.nextLine();
                String nome = scanner.nextLine();
                gerenciador.consultarJogador(nome);
                break;
            case 9:
                System.out.println("Soma total do campeonato: " + gerenciador.somaTotal());
                break;
            case 10:
                System.out.print("Digite o número da rodada (1 a 4): ");
                int rodada = scanner.nextInt() - 1;
                if (rodada >= 0 && rodada <= 3) {
                    System.out.println("Soma da rodada " + (rodada + 1) + ": " + gerenciador.somarPorRodada(rodada));
                } else {
                    System.out.println("Rodada inválida!");
                }
                break;
            case 0:
                System.out.println("Encerrando o programa...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciar();
    }
}

