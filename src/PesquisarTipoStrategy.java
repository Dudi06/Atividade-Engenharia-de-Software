import java.util.Scanner;

public class PesquisarTipoStrategy implements MidiaSearchStrategy {
    private Midia[] midias;

    public PesquisarTipoStrategy(Midia[] midias) {
        this.midias = midias;
    }

    @Override
    public void listarMidia() {
        for (Midia m : midias) {
            if (m != null) {
                System.out.println(m.getClass().getSimpleName() + ": " + m.getTitulo());
            }
        }
    }

    @Override
    public void pesquisar() {
        System.out.println("Digite o tipo:");
        Scanner sc = new Scanner(System.in);
        String tipo = sc.nextLine();
        sc.close();
        System.out.println("Pesquisando por tipo: " + tipo);
        for (Midia m : midias) {
            if (m != null && m.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                m.definicao();
            }
        }
    }
}