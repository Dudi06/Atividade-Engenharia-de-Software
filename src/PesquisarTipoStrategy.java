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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o tipo de mídia para pesquisa (Jogo, Video, Texto): ");
        String tipo = scanner.nextLine().trim();

        boolean encontrou = false;
        for (Midia m : midias) {
            if (m != null && m.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                m.definicao();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma mídia encontrada para o tipo '" + tipo + "'.");
        }
    }
}