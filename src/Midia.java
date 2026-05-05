public class Midia {
    private int ID;
    private String titulo;
    private String descricao;
    private String areaConteudo;

    public Midia(int ID, String titulo, String descricao, String areaConteudo) {
        this.ID = ID;
        this.titulo = titulo;
        this.descricao = descricao;
        this.areaConteudo = areaConteudo;
    }

    public void definicao() {
        
    };

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAreaConteudo() {
        return areaConteudo;
    }

    public void setAreaConteudo(String areaConteudo) {
        this.areaConteudo = areaConteudo;
    }
}