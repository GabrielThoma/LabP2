import PacoteFilmNow.Filme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilmeTest {
    private Filme filmeBase;

    @BeforeEach
    void preparaFilmes() {
        this.filmeBase = new Filme("Avatar", "2009", "Disney+");
    }

    @Test
    void testNomeNull() {
        try {
            new Filme(null, "2009", "Disney+");
            fail("Uma exceção era esperada ao passar nome nulo");
        } catch (NullPointerException npe) {
            assertEquals("O nome do filme não pode ser nulo.", npe.getMessage());
        }
    }

    @Test
    void testNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Filme("", "2009", "Disney+");
        });
    }

    @Test
    void testNomeComEspacos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Filme("   ", "2009", "Disney+");
        });
    }

    @Test
    void testLocalNull() {
        assertThrows(NullPointerException.class, () -> {
            new Filme("Avatar", "2009", null);
        });
    }

    @Test
    void testLocalVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Filme("Avatar", "2009", "");
        });
    }

    @Test
    void testAdicionarNovoLocal() {
        this.filmeBase.adicionarPlataforma("Prime Video", 1);
        assertEquals("Prime Video", this.filmeBase.getPlataformas()[1]);
    }

    @Test
    void testNaoRemoverUnicoLocal() {
        this.filmeBase.removerPlataforma(0);
        assertNull(this.filmeBase.getPlataformas()[0]);
    }

    @Test
    void testRemoverLocal() {
        this.filmeBase.adicionarPlataforma("Prime Video", 1);
        this.filmeBase.removerPlataforma(0);
        assertNull(this.filmeBase.getPlataformas()[0]);
        assertEquals("Prime Video", this.filmeBase.getPlataformas()[1]);
    }

    @Test
    void testNaoAdicionarMaisDeCincoLocais() {
        this.filmeBase.adicionarPlataforma("Local 2", 1);
        this.filmeBase.adicionarPlataforma("Local 3", 2);
        this.filmeBase.adicionarPlataforma("Local 4", 3);
        this.filmeBase.adicionarPlataforma("Local 5", 4);

        assertThrows(IllegalArgumentException.class, () -> {
            this.filmeBase.adicionarPlataforma("Local 6", 5);
        });
    }

    @Test
    void testFormatacaoDetalheFilmeComMultiplosLocais() {
        this.filmeBase.adicionarPlataforma("Cinema", 1);
        this.filmeBase.adicionarPlataforma("Star+", 2);

        String detalhe = this.filmeBase.toString();
        assertTrue(detalhe.contains("Disney+, Cinema, Star+"));
    }

    @Test
    void testEqualsMesmoNomeAno() {
        Filme filme2 = new Filme("Avatar", "2009", "Cinema");
        assertEquals(this.filmeBase, filme2);
    }
}