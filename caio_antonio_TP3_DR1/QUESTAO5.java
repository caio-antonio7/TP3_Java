import java.util.LinkedList;
import java.util.List;

interface CartaoWeb {
    String showMessage();
}

class CartaoWEB {
    private String email;
    private String nome;

    public CartaoWEB(String email, String nome) {
        if (isValidEmail(email)) {
            this.email = email;
        } else {
            this.email = "email invalido";
        }
        this.nome = nome;
    }

    private boolean isValidEmail(String email) {
      
        return !email.isEmpty();
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}

class DiaDosNamorados implements CartaoWeb {
    private CartaoWEB cartaoWEB;

    public DiaDosNamorados(CartaoWEB cartaoWEB) {
        this.cartaoWEB = cartaoWEB;
    }

    @Override
    public String showMessage() {
        return String.format("mensagem para: %s\nParabéns, %s pelo Dia dos Namorados.\n======================================",
                cartaoWEB.getEmail(), cartaoWEB.getNome());
    }
}

class Natal implements CartaoWeb {
    private CartaoWEB cartaoWEB;

    public Natal(CartaoWEB cartaoWEB) {
        this.cartaoWEB = cartaoWEB;
    }

    @Override
    public String showMessage() {
        return String.format("mensagem para: %s\nFeliz Natal, %s!\n======================================",
                cartaoWEB.getEmail(), cartaoWEB.getNome());
    }
}

class Aniversario implements CartaoWeb {
    private CartaoWEB cartaoWEB;

    public Aniversario(CartaoWEB cartaoWEB) {
        this.cartaoWEB = cartaoWEB;
    }

    @Override
    public String showMessage() {
        return String.format("mensagem para: %s\nFeliz Aniversário, %s!\n======================================",
                cartaoWEB.getEmail(), cartaoWEB.getNome());
    }
}

class Pascoa implements CartaoWeb {
    private CartaoWEB cartaoWEB;

    public Pascoa(CartaoWEB cartaoWEB) {
        this.cartaoWEB = cartaoWEB;
    }

    @Override
    public String showMessage() {
        return String.format("mensagem para: %s\nFeliz Páscoa, %s!\n======================================",
                cartaoWEB.getEmail(), cartaoWEB.getNome());
    }
}

public class QUESTAO5 {
    public static void main(String[] args) {
        List<CartaoWeb> cartoes = new LinkedList<>();

        cartoes.add(new DiaDosNamorados(new CartaoWEB("email1@example.com", "João")));
        cartoes.add(new Natal(new CartaoWEB("email2@example.com", "Maria")));
        cartoes.add(new Aniversario(new CartaoWEB("email3@example.com", "Pedro")));
        cartoes.add(new Pascoa(new CartaoWEB("email4@example.com", "Ana")));
        cartoes.add(new DiaDosNamorados(new CartaoWEB("email5@example.com", "Lucas")));

        cartoes.forEach(cartao -> {
            System.out.println(cartao.showMessage());
        });
    }
}
