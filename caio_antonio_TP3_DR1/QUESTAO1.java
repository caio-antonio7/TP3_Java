import java.util.Scanner;

public class QUESTAO1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma string: ");
        String input = scanner.nextLine();

        
        int numCaracteres = input.length();
        System.out.println("Número de caracteres da string: " + numCaracteres);

       
        String maiuscula = input.toUpperCase();
        System.out.println("String em maiúsculo: " + maiuscula);

        
        int numVogais = contarVogais(input);
        System.out.println("Número de vogais na string: " + numVogais);

        
        boolean comecaComINF = input.toUpperCase().startsWith("INF");
        System.out.println("Começa com 'INF' (ignorando maiúsculas/minúsculas): " + comecaComINF);

       
        boolean terminaComNET = input.toUpperCase().endsWith("NET");
        System.out.println("Termina com 'NET' (ignorando maiúsculas/minúsculas): " + terminaComNET);

        
        int numDigitos = contarDigitos(input);
        System.out.println("Número de dígitos na string: " + numDigitos);

       
        String doisPrimeirosDigitos = obterDoisPrimeirosDigitos(input);
        System.out.println("Os 2 primeiros dígitos da string: " + doisPrimeirosDigitos);

        
        boolean ePalindromo = verificarPalindromo(input);
        System.out.println("É um palíndromo: " + ePalindromo);

        scanner.close();
    }

  
    public static int contarVogais(String str) {
        int count = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }


    public static int contarDigitos(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                count++;
            }
        }
        return count;
    }

   
    public static String obterDoisPrimeirosDigitos(String str) {
        String digitos = "";
        for (int i = 0; i < str.length() && digitos.length() < 2; i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                digitos += ch;
            }
        }
        return digitos;
    }

    
    public static boolean verificarPalindromo(String str) {
        str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
