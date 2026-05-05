public class Video extends Midia {
    private int duracao; // em minutos

    public Video(int ID, String titulo, String descricao, String areaConteudo, int duracao) {
        super(ID, titulo, descricao, areaConteudo);
        this.duracao = duracao;
    }

    @Override
    public void definicao() {
        System.out.println("Vídeo: " + getTitulo() + " - Duração: " + duracao + " min");
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}