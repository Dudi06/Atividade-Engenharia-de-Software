public class Texto extends Midia {
    private String tipoProducao;
    private int pagina;

    public Texto(int ID, String titulo, String descricao, String areaConteudo, String tipoProducao, int pagina) {
        super(ID, titulo, descricao, areaConteudo);
        this.tipoProducao = tipoProducao;
        this.pagina = pagina;
    }

    @Override
    public void definicao() {
        System.out.println("Texto: " + getTitulo() + " - Tipo: " + tipoProducao + " - Páginas: " + pagina);
    }

    public String getTipoProducao() {
        return tipoProducao;
    }

    public void setTipoProducao(String tipoProducao) {
        this.tipoProducao = tipoProducao;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }
}