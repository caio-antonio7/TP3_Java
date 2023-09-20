import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


class NotaBit {
    private BigDecimal valor;

    public NotaBit(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}


class Cliente {
    private String nome;
    private List<String> emails;
    private String seguroSocial;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String zipCode;
    private BigDecimal saldo;

    public Cliente(String nome, List<String> emails, String seguroSocial, String logradouro, String numero, String bairro, String cidade, String zipCode, BigDecimal saldo) {
        this.nome = nome;
        this.emails = emails;
        this.seguroSocial = seguroSocial;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.zipCode = zipCode;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getEmails() {
        return emails;
    }

    public String getSeguroSocial() {
        return seguroSocial;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getZipCode() {
        return zipCode;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0) {
            saldo = saldo.add(valor);
            System.out.println("Depósito de B$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

   
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(saldo) <= 0) {
            BigDecimal valorRestante = valor;
            List<NotaBit> notas = new ArrayList<>();
            BigDecimal[] valoresNotas = {new BigDecimal("50"), new BigDecimal("10"), new BigDecimal("5"), new BigDecimal("1")};

            for (BigDecimal notaValor : valoresNotas) {
                BigDecimal quantidadeNotas = valorRestante.divideAndRemainder(notaValor)[0];
                if (quantidadeNotas.compareTo(BigDecimal.ZERO) > 0) {
                    notas.add(new NotaBit(notaValor));
                    valorRestante = valorRestante.subtract(quantidadeNotas.multiply(notaValor));
                }
            }

            System.out.println("Notas entregues:");
            for (NotaBit nota : notas) {
                BigDecimal quantidade = valor.divideAndRemainder(nota.getValor())[0];
                System.out.println(quantidade + " de B$" + nota.getValor());
            }

            saldo = saldo.subtract(valor);
            System.out.println("Saque de B$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }
}


class ClienteVIP extends Cliente {
    public ClienteVIP(String nome, List<String> emails, String seguroSocial, String logradouro, String numero, String bairro, String cidade, String zipCode, BigDecimal saldo) {
        super(nome, emails, seguroSocial, logradouro, numero, bairro, cidade, zipCode, saldo);
    }

    @Override
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(new BigDecimal("50")) > 0) {
            super.sacar(valor);
        } else {
           
            BigDecimal valorRestante = valor;
            List<NotaBit> notas = new ArrayList<>();
            BigDecimal[] valoresNotas = {new BigDecimal("5"), new BigDecimal("1")};

            for (BigDecimal notaValor : valoresNotas) {
                BigDecimal quantidadeNotas = valorRestante.divideAndRemainder(notaValor)[0];
                if (quantidadeNotas.compareTo(BigDecimal.ZERO) > 0) {
                    notas.add(new NotaBit(notaValor));
                    valorRestante = valorRestante.subtract(quantidadeNotas.multiply(notaValor));
                }
            }

            System.out.println("Notas entregues:");
            for (NotaBit nota : notas) {
                BigDecimal quantidade = valor.divideAndRemainder(nota.getValor())[0];
                System.out.println(quantidade + " de B$" + nota.getValor());
            }

            super.sacar(valor);
        }
    }
}

public class QUESTAO6 {
    public static void main(String[] args) {
      
        Cliente clienteStandard = new Cliente("Cliente Standard", new ArrayList<>(), "123-45-6789",
                "Rua Standard", "123", "Bairro Standard", "Cidade Standard", "12345-678", new BigDecimal("1000"));

        ClienteVIP clienteVIP = new ClienteVIP("Cliente VIP", new ArrayList<>(), "987-65-4321",
                "Rua VIP", "456", "Bairro VIP", "Cidade VIP", "98765-432", new BigDecimal("2000"));

       
        clienteStandard.depositar(new BigDecimal("500"));
        clienteVIP.depositar(new BigDecimal("1000"));

        clienteStandard.sacar(new BigDecimal("300"));
        clienteVIP.sacar(new BigDecimal("75"));
    }
}
