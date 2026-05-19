import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class PesquisaTest {

    private Main app;
    private MidiaFactory factory;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        factory = new MidiaFactory() {};
        app = new Main(factory, null);
        // Redireciona a saída do console para capturar
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // Popula o array com as 3 mídias do método cadastrar()
    private void popularMidias() {
        app.cadastrar();
    }

    @Test
    public void testPesquisaPorNome() {
        popularMidias();

        // Simula digitar "Matemática" como termo de busca
        String input = "Matemática\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        MidiaSearchStrategy strategy = new PesquisaNomeStrategy(app.midiaLista);
        app.setSearchStrategy(strategy);
        app.pesquisar();

        String output = outContent.toString();
        // Deve encontrar o jogo "Aventura Matemática"
        assertTrue(output.contains("Jogo: Aventura Matemática"));
        // Não deve encontrar o vídeo nem o texto
        assertFalse(output.contains("Vídeo: Vídeo de Teste"));
        assertFalse(output.contains("Texto: Redação exemplar"));
    }

    @Test
    public void testPesquisaPorTipo() {
        popularMidias();

        // Simula digitar "Video" como tipo
        String input = "Video\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        MidiaSearchStrategy strategy = new PesquisarTipoStrategy(app.midiaLista);
        app.setSearchStrategy(strategy);
        app.pesquisar();

        String output = outContent.toString();
        // Deve encontrar apenas o vídeo
        assertTrue(output.contains("Vídeo: Vídeo de Teste"));
        assertFalse(output.contains("Jogo: Aventura Matemática"));
        assertFalse(output.contains("Texto: Redação exemplar"));
    }

    @Test
    public void testListarMidia() {
        popularMidias();

        PesquisaNomeStrategy strategy = new PesquisaNomeStrategy(app.midiaLista);
        strategy.listarMidia();

        String output = outContent.toString();
        // Deve listar todas as três mídias
        assertTrue(output.contains("Jogo: Aventura Matemática"));
        assertTrue(output.contains("Vídeo: Vídeo de Teste"));
        assertTrue(output.contains("Texto: Redação exemplar"));
    }
}