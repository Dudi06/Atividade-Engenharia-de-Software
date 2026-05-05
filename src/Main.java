public class Main {
    private Midia[] midiaLista;
    private MidiaFactory midiaFactory;
    private MidiaSearchStrategy searchStrategy;
    private int index = 0;

    public Main(MidiaFactory factory, MidiaSearchStrategy strategy) {
        this.midiaFactory = factory;
        this.searchStrategy = strategy;
        this.midiaLista = new Midia[10];
    }

    public Midia[] getMidiaLista() {
        return midiaLista;
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
        if (index >= midiaLista.length) {
            System.out.println("Lista cheia!");
            return;
        }
        Jogo novoJogo = midiaFactory.criarJogo(1, "Aventura Matemática", "Jogo de puzzle", "Matemática", "Puzzle");
        Video novoVideo = midiaFactory.criarVideo(2, "Vídeo de Teste", "Descrição", "Matemática", 20);
        Texto novoTexto = midiaFactory.criarTexto(3, "Redação enem", "Texto dissertativo", "Português", "Redação", 1);

        midiaLista[index++] = novoJogo;
        if (index < midiaLista.length) midiaLista[index++] = novoVideo;
        if (index < midiaLista.length) midiaLista[index++] = novoTexto;

        System.out.println("Mídias cadastradas: Jogo, Vídeo, Texto.");
    }

    public static void main(String[] args) {
        MidiaFactory fabrica = new MidiaFactory() {};

        Main app = new Main(fabrica, null);

        app.cadastrar();

        app.setSearchStrategy(new PesquisaNomeStrategy(app.getMidiaLista()));
        System.out.println("\n=== Teste Pesquisa por Nome ===");
        app.pesquisar();

        app.setSearchStrategy(new PesquisarTipoStrategy(app.getMidiaLista()));
        System.out.println("\n=== Teste Pesquisa por Tipo ===");
        app.pesquisar();
    }
}
