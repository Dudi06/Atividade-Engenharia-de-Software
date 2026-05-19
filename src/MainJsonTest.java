import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainJsonTest {

    private Main app;
    private MidiaFactory factory;

    @Before
    public void setUp() {
        factory = new MidiaFactory() {};
        app = new Main(factory, null);
    }

    @Test
    public void testCadastrarDoJson() {
        String json = "["
                + "  { \"tipo\":\"Jogo\", \"titulo\":\"GeoExplorer\", \"descricao\":\"Jogo de geografia\","
                + "    \"areaConteudo\":\"Geografia\", \"generoJogo\":\"Aventura\" },"
                + "  { \"tipo\":\"Video\", \"titulo\":\"Introdução à Física\", \"descricao\":\"Vídeo aula\","
                + "    \"areaConteudo\":\"Física\", \"duracao\":12 },"
                + "  { \"tipo\":\"Texto\", \"titulo\":\"Contos Brasileiros\", \"descricao\":\"Literatura\","
                + "    \"areaConteudo\":\"Português\", \"tipoProducao\":\"Conto\", \"pagina\":25 }"
                + "]";

        app.cadastrarDoJson(json);

        Midia[] lista = app.midiaLista;
        int count = 0;
        for (Midia m : lista) {
            if (m != null) count++;
        }
        assertEquals(3, count); // três mídias cadastradas

        // Verifica os tipos e valores específicos
        boolean jogoOk = false, videoOk = false, textoOk = false;

        for (Midia m : lista) {
            if (m == null) continue;
            if (m.getTitulo().equals("GeoExplorer") && m instanceof Jogo) {
                Jogo j = (Jogo) m;
                assertEquals("Aventura", j.getGeneroJogo());
                jogoOk = true;
            } else if (m.getTitulo().equals("Introdução à Física") && m instanceof Video) {
                Video v = (Video) m;
                assertEquals(12, v.getDuracao());
                videoOk = true;
            } else if (m.getTitulo().equals("Contos Brasileiros") && m instanceof Texto) {
                Texto t = (Texto) m;
                assertEquals("Conto", t.getTipoProducao());
                assertEquals(25, t.getPagina());
                textoOk = true;
            }
        }

        assertTrue(jogoOk);
        assertTrue(videoOk);
        assertTrue(textoOk);
    }

    @Test(expected = org.json.JSONException.class)
    public void testCadastrarDoJsonComJsonInvalido() {
        String jsonInvalido = "{ \"tipo\":\"Jogo\" "; // JSON malformado
        app.cadastrarDoJson(jsonInvalido); // deve lançar JSONException
    }
}