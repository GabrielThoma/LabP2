import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema FilmNow.
 *
 * @author eliane
 *
 */
public class MainFilmNow {

    public static void main(String[] args) {
        FilmNow fn = new FilmNow();

        System.out.println("Carregando filmes ...");
        try {
            /*
             * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
             */
            carregaFilmes("filmes_inicial.csv", fn);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro lendo arquivo: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, fn, scanner);
        }

    }

    /**
     * Exibe o menu e captura a escolha do/a usuário/a.
     *
     * @param scanner Para captura da opção do usuário/a.
     * @return O comando escolhido.
     */
    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(A)Adicionar filme\n" +
                        "(M)Mostrar todos\n" +
                        "(D)Detalhar filme\n" +
                        "(E)Exibir HotList\n" +
                        "(H)Atribuir Hot\n" +
                        "(R)Remover Hot\n" +
                        "(S)Sair\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

    /**
     * Interpreta a opção escolhida por quem está usando o sistema.
     *
     * @param opcao   Opção digitada.
     * @param fn  O sistema FilmNow que estamos manipulando.
     * @param scanner Objeto scanner para o caso do comando precisar de mais input.
     */
    private static void comando(String opcao, FilmNow fn, Scanner scanner) {
        switch (opcao) {
            case "A":
                adicionaFilme(fn, scanner);
                break;
            case "M":
                mostrarFilmes(fn);
                break;
            case "D":
                detalharFilme(fn, scanner);
                break;
            case "E":
                exibirHotList(fn);
                break;
            case "H":
                atribuirHotList(fn, scanner);
                break;
            case "R":
                removerHotList(fn, scanner);
                break;
            case "S":
                sai();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    /**
     * Imprime lista de filmes.
     *
     * @param fn O sistema FilmNow a ser manipulado.
     */
    private static void mostrarFilmes(FilmNow fn) {
        String[] filmes = fn.getFilmes();
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null) {
                // Soma 1 pois os arrays em Java começam no índice 0, mas para o usuário começa no 1
                System.out.println(formataFilme(i + 1, filmes[i]));
            }
        }
    }

    /**
     * Imprime a lista de filmes marcados como Hot (HotList).
     *
     * @param fn O sistema FilmNow a ser manipulado.
     */
    private static void exibirHotList(FilmNow fn) {
        String[] filmesHot = fn.getFilmesHot();
        for (int i = 0; i < filmesHot.length; i++) {
            if (filmesHot[i] != null) {
                System.out.println(formataFilme(i + 1, filmesHot[i]));
            }
        }
    }

    /**
     * Atribui um filme previamente cadastrado à HotList.
     *
     * @param fn O sistema FilmNow a ser manipulado.
     * @param scanner Scanner para capturar entradas.
     */
    private static void atribuirHotList(FilmNow fn, Scanner scanner) {
        System.out.print("\nQual filme (posição no sistema)> ");
        int posicaoFilme = scanner.nextInt();
        System.out.print("Qual posição na HotList (1 a 10)> ");
        int posicaoHotList = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        fn.adicionarHotList(posicaoFilme, posicaoHotList);
    }

    /**
     * Remove um filme da HotList.
     *
     * @param fn O sistema FilmNow a ser manipulado.
     * @param scanner Scanner para capturar entradas.
     */
    private static void removerHotList(FilmNow fn, Scanner scanner) {
        System.out.print("\nQual posição na HotList remover (1 a 10)> ");
        int posicaoHotList = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        fn.removerHotList(posicaoHotList);
    }

    /**
     * Imprime os detalhes de um dos filmes.
     *
     * @param fn O sistema FilmNow a ser manipulado.
     * @param scanner Scanner para capturar qual filme.
     */
    private static void detalharFilme(FilmNow fn, Scanner scanner) {
        System.out.print("\nQual filme> ");
        int posicao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        String filme = fn.getDetalhesFilme(posicao);
        if (filme != null) {
            System.out.println("Dados do filme:\n" + filme);
        } else {
            System.out.println("POSIÇÃO INVÁLIDA");
        }
    }

    /**
     * Formata um filme para impressão.
     *
     * @param posicao A posição do filme (que é exibida)/
     * @param filme O filme a ser impresso.
     * @return A String formatada.
     */
    private static String formataFilme(int posicao, String filme) {
        return posicao + " - " + filme;
    }

    /**
     * Cadastra um filme no sistema.
     *
     * @param fn O sistema FilmNow a ser manipulado.
     * @param scanner Scanner para pedir informações do filme.
     */
    private static void adicionaFilme(FilmNow fn, Scanner scanner) {
        System.out.print("\nPosição no sistema> ");
        int posicao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer após ler o int

        System.out.print("Nome> ");
        String nome = scanner.nextLine();

        System.out.print("Ano> ");
        String ano = scanner.nextLine();

        System.out.print("Local> ");
        String local = scanner.nextLine();

        System.out.println("FILME ADICIONADO");

        fn.cadastraFilme(posicao, nome, ano, local);
    }

    /**
     * Sai da aplicação.
     */
    private static void sai() {
        System.out.println("\nVlw flw o/");
        System.exit(0);
    }

    /**
     * Lê carga de filmes de um arquivo csv.
     *
     * @param arquivoFilmes O caminho para o arquivo.
     * @param fn O sistema FilmNow a ser populado com os dados.
     * @throws IOException Caso o arquivo não exista ou não possa ser lido.
     */
    private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
        LeitorFilmNow leitor = new LeitorFilmNow();
        int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
        System.out.println("Carregamos " + carregados + " registros.");
    }
}