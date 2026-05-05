public class Jogo extends Midia {
    private String generoJogo;

    public Jogo(int ID, String titulo, String descricao, String areaConteudo, String generoJogo) {
        super(ID, titulo, descricao, areaConteudo);
        this.generoJogo = generoJogo;
    }

    @Override
    public void definicao() {
        System.out.println("Jogo: " + getTitulo() + " - Gênero: " + generoJogo);
    }

    public String getGeneroJogo() {
        return generoJogo;
    }

    public void setGeneroJogo(String generoJogo) {
        this.generoJogo = generoJogo;
    }
}