import java.util.Random;
import java.util.Scanner;

public class QUESTAO4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho das cadeias de DNA: ");
        int tamanho = scanner.nextInt();

        String dna1 = CadeiaDeDna.gerarCadeiaDeDna(tamanho);
        String dna2 = CadeiaDeDna.gerarCadeiaDeDna(tamanho);

        System.out.println("Cadeia de DNA 1: " + dna1);
        System.out.println("Cadeia de DNA 2: " + dna2);

        String[] filhos = recombinacao(dna1, dna2);
        System.out.println("Filho 1 (recombinação): " + filhos[0]);
        System.out.println("Filho 2 (recombinação): " + filhos[1]);

        String mutacaoResultado = mutacao(filhos[0]);
        System.out.println("Filho 1 (mutação): " + mutacaoResultado);

        scanner.close();
    }

    public static String[] recombinacao(String s1, String s2) {
        Random random = new Random();
        int pontoDeCorte = random.nextInt(s1.length());

        String filho1 = s1.substring(0, pontoDeCorte) + s2.substring(pontoDeCorte);
        String filho2 = s2.substring(0, pontoDeCorte) + s1.substring(pontoDeCorte);

        return new String[]{filho1, filho2};
    }

    public static String mutacao(String s) {
        Random random = new Random();
        int posicaoMutacao = random.nextInt(s.length());

        char[] dna = s.toCharArray();
        char novoCaracter = gerarCaracterAleatorio();

        dna[posicaoMutacao] = novoCaracter;

        return new String(dna);
    }

    public static char gerarCaracterAleatorio() {
        char[] nucleotideos = {'A', 'C', 'G', 'T'};
        Random random = new Random();
        int indice = random.nextInt(nucleotideos.length);
        return nucleotideos[indice];
    }
}

class CadeiaDeDna {
    public static String gerarCadeiaDeDna(int tamanho) {
        StringBuilder dna = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            char nucleotideo = QUESTAO4.gerarCaracterAleatorio();
            dna.append(nucleotideo);
        }

        return dna.toString();
    }
}
