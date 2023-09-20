import java.util.Scanner;

public class DigitosPorExtenso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre com um número inteiro: ");
        int numero = scanner.nextInt();
        
        String extenso = NumeroPorExtensoConverter.converterParaExtenso(numero);
        System.out.println("Resultado: " + extenso);

        scanner.close();
    }
}

class NumeroPorExtensoConverter {
    private static final String[] unidades = {
        "zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"
    };

    public static String converterParaExtenso(int numero) {
        if (numero == 0) {
            return unidades[0];  
        }

        StringBuilder extenso = new StringBuilder();
        int divisor = 1;

        
        while (numero / divisor >= 10) {
            divisor *= 10;
        }

        while (divisor > 0) {
            int digito = numero / divisor;
            extenso.append(unidades[digito]);

            numero %= divisor;
            divisor /= 10;

            if (divisor > 0) {
                extenso.append(", ");
            }
        }

        return extenso.toString();
    }
}
