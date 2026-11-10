package PacoteFilmNow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema FilmNow.
 *
 * @author eliane
 */
public class MainFilmNow {

    public static void main(String[] args) {
        FilmNow fn = new FilmNow();

        System.out.println("Carregando filmes ...");
        try {
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

    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(A)Adicionar filme\n" +
                        "(M)Mostrar todos\n" +
                        "(D)Detalhar filme\n" +
                        "(E)Exibir HotList\n" +
                        "(H)Atribuir Hot\n" +
                        "(R)Remover Hot\n" +
                        "(W)Adicionar Plataforma\n" +
                        "(Q)Remover Plataforma\n" +
                        "(S)Sair\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

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
            case "W":
                addPlataforma(fn, scanner);
                break;
            case "Q":
                removePlataforma(fn, scanner);
                break;
            case "S":
                sai();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void mostrarFilmes(FilmNow fn) {
        String[] filmes = fn.getFilmes();
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i] != null) {
                System.out.println(formataFilme(i + 1, filmes[i]));
            }
        }
    }

    private static void exibirHotList(FilmNow fn) {
        String[] filmesHot = fn.getFilmesHot();
        for (int i = 0; i < filmesHot.length; i++) {
            if (filmesHot[i] != null) {
                System.out.println(formataFilme(i + 1, filmesHot[i]));
            }
        }
    }

    private static void atribuirHotList(FilmNow fn, Scanner scanner) {
        System.out.print("\nQual filme (posição no sistema)> ");
        int posicaoFilme = scanner.nextInt();
        System.out.print("Qual posição na HotList (1 a 10)> ");
        int posicaoHotList = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        try {
            fn.adicionarHotList(posicaoFilme, posicaoHotList);
            System.out.println("FILME ATRIBUÍDO À HOTLIST!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private static void removerHotList(FilmNow fn, Scanner scanner) {
        System.out.print("\nQual posição na HotList remover (1 a 10)> ");
        int posicaoHotList = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        try {
            fn.removerHotList(posicaoHotList);
            System.out.println("FILME REMOVIDO DA HOTLIST!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private static void detalharFilme(FilmNow fn, Scanner scanner) {
        System.out.print("\nQual filme> ");
        int posicao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        try {
            String filme = fn.getDetalhesFilme(posicao);
            if (filme != null) {
                System.out.println("Dados do filme:\n" + filme);
            } else {
                System.out.println("Nenhum filme cadastrado nesta posição.");
            }
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private static String formataFilme(int posicao, String filme) {
        return posicao + " - " + filme;
    }

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

        try {
            fn.cadastraFilme(posicao, nome, ano, local);
            System.out.println("FILME ADICIONADO");
        } catch (Exception e) {
            System.out.println("ERRO AO ADICIONAR FILME: " + e.getMessage());
        }
    }

    public static void addPlataforma(FilmNow fn, Scanner scanner ){
        System.out.println("Qual Filme (posição no sistema)?");
        int filme = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        System.out.println("Qual Plataforma?");
        String plataforma = scanner.nextLine();

        System.out.println("Qual Posição (0 a 4)?");
        int posicao = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        try {
            fn.adicionaPlataforma(filme, plataforma, posicao);
            System.out.println("PLATAFORMA ADICIONADA!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public static void removePlataforma(FilmNow fn, Scanner scanner) {
        System.out.println("Qual Filme (posição no sistema)?");
        int filme = scanner.nextInt();

        System.out.println("Qual Plataforma (índice 0 a 4)?");
        int plataforma = scanner.nextInt();
        scanner.nextLine(); // Limpa buffer

        try {
            fn.removePlataforma(filme, plataforma);
            System.out.println("PLATAFORMA REMOVIDA!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private static void sai() {
        System.out.println("\nVlw flw o/");
        System.exit(0);
    }

    private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
        LeitorFilmNow leitor = new LeitorFilmNow();
        int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
        System.out.println("Carregamos " + carregados + " registros.");
    }
}