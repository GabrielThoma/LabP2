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
    void testNomeAno() {
        String msg = "Esperando Nome e Ano";
        assertEquals( "Avatar, 2009", this.filmeBase.getNome() + "," + " " + this.filmeBase.getAno(), msg);
    }
}

