public class Main {
    private Midia[] midiaLista;
    private MidiaFactory midiaFactory;
    private MidiaSearchStrategy searchStrategy;

    public Main(MidiaFactory factory, MidiaSearchStrategy strategy) {
        this.midiaFactory = factory;
        this.searchStrategy = strategy;
        this.midiaLista = new Midia[10];
    }

    public void pesquisar() {
        if (searchStrategy != null) {
            searchStrategy.pesquisar();
        }
    }

    public void cadastrar() {
        Jogo novoJogo = midiaFactory.criarJogo(9, "teste", "teste", "matematica", "puzzle");
        Video novoVideo = midiaFactory.criarVideo(9, "teste", "teste", "matematica", 20);
        Texto novoTexto = midiaFactory.criarTexto(9, "teste", "teste", "português", "redação", 1);
    }
}