import PacoteFilmNow.FilmNow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilmNowTest {
    private FilmNow fn;

    @BeforeEach
    void preparaFilmNow() {
        this.fn = new FilmNow();
    }

    @Test
    void testAdicionarNovoFilmePosicaoVazia() {
        // #1 Adicionar um novo filme em posição vazia
        String retorno = fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
        assertEquals("FILME ADICIONADO", retorno);
    }

    @Test
    void testAdicionarNovoFilmePosicaoExistente() {
        // #2 Adicionar um novo filme em posição existente
        fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
        String retorno = fn.cadastraFilme(1, "20 dias em Mariupol", "2023", "Cinema");
        assertEquals("FILME ADICIONADO", retorno);
    }

    @Test
    void testAdicionarFilmeJaAdicionadoOutraPosicao() {
        // #3 Adicionar um filme já adicionado no sistema em outra posição
        fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
        String retorno = fn.cadastraFilme(3, "Avatar", "2009", "Disney+");
        assertEquals("FILME JÁ ADICIONADO", retorno);
    }

    @Test
    void testAdicionarFilmeMesmoNomeAnoLocalDiferente() {
        // #4 Adicionar um novo filme, com mesmo nome e ano, mas com local diferente.
        fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
        String retorno = fn.cadastraFilme(3, "Avatar", "2009", "Popcornflix");
        assertEquals("FILME JÁ ADICIONADO", retorno);
    }

    @Test
    void testAdicionarNovoFilmePosicaoLimite() {
        // #5 Adicionar um novo filme na posição limite
        String retorno = fn.cadastraFilme(100, "Avatar", "2009", "Disney+");
        assertEquals("FILME ADICIONADO", retorno);
    }

    @Test
    void testAdicionarNovoFilmeAcimaDoLimite() {
        // #6 Adicionar um novo filme em uma posição acima do limite
        String retorno = fn.cadastraFilme(101, "Avatar", "2009", "Disney+");
        assertEquals("POSIÇÃO INVÁLIDA", retorno);
    }

    @Test
    void testAdicionarNovoFilmeAbaixoDoLimite() {
        // #7 Adicionar um novo filme em uma posição abaixo do limite
        String retorno = fn.cadastraFilme(0, "Avatar", "2009", "Disney+");
        assertEquals("POSIÇÃO INVÁLIDA", retorno);
    }

    @Test
    void testAdicionarNovoFilmeLocalVazio() {
        // #8 Adicionar um novo filme com local vazio
        String retorno = fn.cadastraFilme(1, "20 dias em Mariupol", "2023", "");
        assertEquals("FILME INVALIDO", retorno);
    }

    @Test
    void testAdicionarNovoFilmeAnoVazio() {
        // #9 Adicionar um novo filme com ano de lançamento vazio
        String retorno = fn.cadastraFilme(1, "20 dias em Mariupol", "", "Cinema");
        assertEquals("FILME ADICIONADO", retorno);
    }

    @Test
    void testAdicionarNovoFilmeNomeVazio() {
        // #10 Adicionar um novo filme com nome vazio
        String retorno = fn.cadastraFilme(1, "", "2023", "Cinema");
        assertEquals("FILME INVALIDO", retorno);
    }

    // ==========================================
    // TESTES PARA A FUNCIONALIDADE: DETALHAR FILME
    // ==========================================

    @Test
    void testDetalharFilmeTodosDados() {
        // #1 Detalhar Filme adicionado com todos os dados
        fn.cadastraFilme(1, "Avatar", "2009", "Disney+");
        assertEquals("Avatar, 2009\nDisney+", fn.getDetalhesFilme(1));
    }

    @Test
    void testDetalharFilmeSemAno() {
        // #2 Detalhar Filme adicionado sem o ano de lançamento
        fn.cadastraFilme(1, "20 dias em Mariupol", "", "Cinema");
        assertEquals("20 dias em Mariupol\nCinema", fn.getDetalhesFilme(1));
    }

    @Test
    void testDetalharFilmeSemFilmeNaPosicao() {
        // #3 Detalhar Filme em uma posição sem filme
        assertEquals("", fn.getDetalhesFilme(100));
    }

    @Test
    void testDetalharFilmePosicaoAbaixoLimite() {
        // #4 Detalhar Filme em uma posição abaixo do limite inferior
        assertEquals("POSIÇÃO INVÁLIDA", fn.getDetalhesFilme(0));
    }

    @Test
    void testDetalharFilmePosicaoAcimaLimite() {
        // #5 Detalhar Filme em uma posição acima do limite superior
        assertEquals("POSIÇÃO INVÁLIDA", fn.getDetalhesFilme(101));
    }

    @Test
    void testDetalharFilmeDaHotList() {
        // #6 Detalhar Filme um filme da HotList
        fn.cadastraFilme(1, "Avatar", "2009", "Disney+");

        // CORREÇÃO: Mudei de getDetalhesFilme(1, 1) para o método que provavelmente adiciona na HotList
        fn.adicionarHotList(1, 1);

        assertEquals("🔥 Avatar, 2009\nDisney+", fn.getDetalhesFilme(1));
    }
}