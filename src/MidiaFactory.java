import java.util.concurrent.atomic.AtomicInteger;

public interface MidiaFactory {
    AtomicInteger contador = new AtomicInteger(1);

    default Jogo criarJogo(String titulo, String descricao, String areaConteudo, String generoJogo) {
        return new Jogo(contador.getAndIncrement(), titulo, descricao, areaConteudo, generoJogo);
    }

    default Video criarVideo(String titulo, String descricao, String areaConteudo, int duracao) {
        return new Video(contador.getAndIncrement(), titulo, descricao, areaConteudo, duracao);
    }

    default Texto criarTexto(String titulo, String descricao, String areaConteudo, String tipoProducao, int pagina) {
        return new Texto(contador.getAndIncrement(), titulo, descricao, areaConteudo, tipoProducao, pagina);
    }
}