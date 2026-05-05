public class PesquisarTipoStrategy implements MidiaSearchStrategy {
    private Midia[] midias;
    private String tipo = "Jogo"; // exemplo: busca por Jogo

    public PesquisarTipoStrategy(Midia[] midias) {
        this.midias = midias;
    }

    @Override
    public void listarMidia() {
        for (Midia m : midias) {
            if (m != null) System.out.println(m.getClass().getSimpleName() + ": " + m.getTitulo());
        }
    }

    @Override
    public void pesquisar() {
        System.out.println(">>> Pesquisando por tipo '" + tipo + "':");
        for (Midia m : midias) {
            if (m != null && m.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
                m.definicao();
            }
        }
    }
}