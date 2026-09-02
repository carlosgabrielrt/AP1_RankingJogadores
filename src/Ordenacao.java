public class Ordenacao {

    public static int somaTotal(int[][] tabela){

        int total = 0;
        for (int i = 0; i < tabela.length ; i++) {
            for (int j = 0; j < tabela[i].length; j++) {
                total += tabela[i][j];
            }
        }
        return total;
    }
}