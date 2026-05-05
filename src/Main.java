public class Main {
    public Midia[] midiaLista;
    private MidiaFactory midiaFactory;
    private MidiaSearchStrategy searchStrategy;

    public Main(MidiaFactory factory, MidiaSearchStrategy strategy) {
        this.midiaFactory = factory;
        this.searchStrategy = strategy;
        this.midiaLista = new Midia[10];
    }

    public void setSearchStrategy(MidiaSearchStrategy strategy) {
        this.searchStrategy = strategy;
    }

    public void pesquisar() {
        if (searchStrategy != null) {
            searchStrategy.pesquisar();
        } else {
            System.out.println("Estratégia de pesquisa não definida.");
        }
    }

    public void cadastrar() {
        Jogo novoJogo = midiaFactory.criarJogo("Aventura Matemática", "Jogo educativo", "Matemática", "Puzzle");
        Video novoVideo = midiaFactory.criarVideo("Vídeo de Teste", "Descrição do vídeo", "Matemática", 20);
        Texto novoTexto = midiaFactory.criarTexto("Redação exemplar", "Texto dissertativo", "Português", "Redação", 1);

        for (int i = 0; i < midiaLista.length; i++) {
            if (midiaLista[i] == null) {
                if (novoJogo != null) {
                    midiaLista[i] = novoJogo;
                    novoJogo = null;
                } else if (novoVideo != null) {
                    midiaLista[i] = novoVideo;
                    novoVideo = null;
                } else if (novoTexto != null) {
                    midiaLista[i] = novoTexto;
                    break;
                }
            }
        }
        System.out.println("Mídias cadastradas com sucesso.");
    }

    public static void main(String[] args) {
        MidiaFactory fabrica = new MidiaFactory() {};

        Main app = new Main(fabrica, null);

        app.cadastrar();

        app.setSearchStrategy(new PesquisaNomeStrategy(app.midiaLista));
        System.out.println("\n=== Pesquisa por Nome ===");
        app.pesquisar();

        app.setSearchStrategy(new PesquisarTipoStrategy(app.midiaLista));
        System.out.println("\n=== Pesquisa por Tipo ===");
        app.pesquisar();
    }
}