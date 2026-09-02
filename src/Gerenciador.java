import java.util.Random;
import java.util.Scanner;

public class Gerenciador {

    String[] jogadores = new String[5];
    int[][] pontuacao = new int[5][4];
    int[] pontosJogador = new int[jogadores.length];

    public void usarDadosPadrao() {
        String[] nomesPadrao = {"Ana", "Bruna", "Francisco", "Joaquim", "Diego"};
        int[][] pontuacaoPadrao = {
                {80, 90, 70, 85},
                {70, 75, 80, 90},
                {95, 90, 85, 95},
                {60, 80, 70, 75},
                {85, 80, 90, 80}
        };

        for (int i = 0; i < jogadores.length; i++) {
            jogadores[i] = nomesPadrao[i];
            for (int j = 0; j < pontuacao[i].length; j++) {
                pontuacao[i][j] = pontuacaoPadrao[i][j];
            }
        }
    }





    public void JogadorViaTerminal(Scanner scanner) {
        for (int i = 0; i < jogadores.length; i++) {
            System.out.println("Digite o nome do jogador " + (i + 1) + ":");
            jogadores[i] = scanner.next();
        }
        for (String jogador : jogadores) {
            System.out.println(jogador);
        }
    }

    public void preencherPontuacao(Scanner scanner) {
        for (int i = 0; i < pontuacao.length; i++) {
            for (int j = 0; j < pontuacao[i].length; j++) {
                System.out.println("Pontuação do jogador " + (i + 1) + " na rodada " + (j + 1) + ":");
                pontuacao[i][j] = scanner.nextInt();
            }
        }
    }



    public void somaPontosJogador(){
            for (int i = 0; i < jogadores.length; i++) {
                int total = 0;
                for (int j = 0; j < pontuacao[i].length; j++) {
                    total += pontuacao[i][j];
                }
                pontosJogador[i] = total;
            }
        }


    public void gerarPontuacaoAleatoria() {
        Random random = new Random();
        for (int i = 0; i < pontuacao.length; i++) {
            for (int j = 0; j < pontuacao[i].length; j++) {
                pontuacao[i][j] = random.nextInt(101); // gera de 0 a 100
            }
        }
    }


    public void consultarJogador(String nome) {
        boolean encontrado = false;
        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i].equalsIgnoreCase(nome)) {
                encontrado = true;
                System.out.print(jogadores[i] + " - Pontuações: ");
                int total = 0;
                for (int j = 0; j < pontuacao[i].length; j++) {
                    System.out.print(pontuacao[i][j] + " ");
                    total += pontuacao[i][j];
                }
                System.out.println("| Total: " + total);
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Jogador não encontrado!");
        }
    }


    public void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particionar(inicio, fim);
            quickSort(inicio, posicaoPivo - 1);
            quickSort(posicaoPivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        int pivo = pontosJogador[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) { // ">" = ordem decrescente
                i++;
                trocar(i, j);
            }

        trocar(i + 1, fim);
        return i + 1;
    }

    private void trocar(int a, int b) {
        int tempPonto = pontosJogador[a];
        pontosJogador[a] = pontosJogador[b];
        pontosJogador[b] = tempPonto;

        String tempNome = jogadores[a];
        jogadores[a] = jogadores[b];
        jogadores[b] = tempNome;
    }
    public void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            intercalar(inicio, meio, fim);
        }
    }

    private void intercalar(int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        int[] pontosEsq = new int[n1];
        int[] pontosDir = new int[n2];
        String[] nomesEsq = new String[n1];
        String[] nomesDir = new String[n2];

        for (int i = 0; i < n1; i++) {
            pontosEsq[i] = pontosJogador[inicio + i];
            nomesEsq[i] = jogadores[inicio + i];
        }
        for (int j = 0; j < n2; j++) {
            pontosDir[j] = pontosJogador[meio + 1 + j];
            nomesDir[j] = jogadores[meio + 1 + j];
        }

        int i = 0, j = 0, k = inicio;
        while (i < n1 && j < n2) {
            if (pontosEsq[i] >= pontosDir[j]) {
                pontosJogador[k] = pontosEsq[i];
                jogadores[k] = nomesEsq[i];
                i++;
            } else {
                pontosJogador[k] = pontosDir[j];
                jogadores[k] = nomesDir[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            pontosJogador[k] = pontosEsq[i];
            jogadores[k] = nomesEsq[i];
            i++;
            k++;
        }
        while (j < n2) {
            pontosJogador[k] = pontosDir[j];
            jogadores[k] = nomesDir[j];
            j++;
            k++;
        }

    }




    public void mostrarResultado() {
        for (int i = 0; i < jogadores.length; i++) {
            System.out.print(jogadores[i] + ":  ");

            int total = 0;
            for (int j = 0; j < pontuacao[i].length; j++) {
                System.out.print(pontuacao[i][j] + "|");
                total += pontuacao[i][j];
            }
            System.out.println("- Total: " + total);
        }

    }  

    public int somaTotal() {

        int total = 0;
        for (int i = 0; i < pontuacao.length; i++) {
            for (int j = 0; j < pontuacao[i].length; j++) {
                total += pontuacao[i][j];
            }
        }
        return total;
    }

    public int somarPorRodada(int rodada) {
        int total = 0;
        for (int i = 0; i < pontuacao.length; i++) {
            total += pontuacao[i][rodada];
        }
        return total;
    }

    public void mostrarRanking() {
        System.out.println("=== RANKING ===");
        for (int i = 0; i < jogadores.length; i++) {
            System.out.println((i + 1) + "º lugar: " + jogadores[i] + " - " + pontosJogador[i] + " pontos");
        }
    }

}

