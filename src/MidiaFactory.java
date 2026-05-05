public interface MidiaFactory {
    default Jogo criarJogo(int id, String titulo, String descricao, String areaConteudo, String generoJogo) {
        return new Jogo(id, titulo, descricao, areaConteudo, generoJogo);
    }
    default Video criarVideo(int id, String titulo, String descricao, String areaConteudo, int duracao) {
        return new Video(id, titulo, descricao, areaConteudo, duracao);
    }
    default Texto criarTexto(int id, String titulo, String descricao, String areaConteudo, String tipoProducao, int pagina) {
        return new Texto(id, titulo, descricao, areaConteudo, tipoProducao, pagina);
    }
}