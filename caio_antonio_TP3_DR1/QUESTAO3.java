import java.util.Scanner;

public class QUESTAO3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um nome: ");
        String nome = scanner.nextLine();

        String iniciais = obterIniciais(nome);
        System.out.println("Iniciais: " + iniciais);

        scanner.close();
    }

    public static String obterIniciais(String nome) {
        String[] palavras = nome.split(" ");
        StringBuilder iniciais = new StringBuilder();

        for (String palavra : palavras) {
            palavra = palavra.toLowerCase();
            
            if (!palavra.equals("e") &&
                !palavra.equals("do") &&
                !palavra.equals("da") &&
                !palavra.equals("dos") &&
                !palavra.equals("das") &&
                !palavra.equals("de") &&
                !palavra.equals("di") &&
                !palavra.equals("du")) {
                
                char inicial = Character.toUpperCase(palavra.charAt(0));
                iniciais.append(inicial);
            }
        }

        return iniciais.toString();
    }
}
