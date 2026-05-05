import java.util.Scanner;

public class PesquisaNomeStrategy implements MidiaSearchStrategy {
    private Midia[] midias;

    public PesquisaNomeStrategy(Midia[] midias) {
        this.midias = midias;
    }

    @Override
    public void listarMidia() {
        for (Midia m : midias) {
            if (m != null) {
                m.definicao();
            }
        }
    }

    @Override
    public void pesquisar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome:");
        String termo = sc.nextLine();
        System.out.println("Pesquisando por nome: " + termo);
        for (Midia m : midias) {
            if (m != null && m.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                m.definicao();
            }
        }
    }
}