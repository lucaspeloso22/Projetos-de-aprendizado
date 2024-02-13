import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jogo jogo = new Jogo();
        Jogador jogador = null;

        System.out.println("Bem-vindo ao Jogo!");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Identificar-se ou criar novo jogador");
            System.out.println("2 - Jogar");
            System.out.println("3 - Ver ranking completo");
            System.out.println("4 - Ver os 10 maiores");
            System.out.println("5 - Encerrar o Jogo");

            System.out.print("Opção escolhida: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    jogador = cadastrarOuIdentificarJogador(scanner);
                    break;
                case 2:
                    if (jogador != null) {
                        jogo.jogar(jogador);
                    } else {
                        System.out.println("Por favor, identifique-se ou crie um novo jogador primeiro.");
                    }
                    break;
                case 3:
                    Jogador.exibirRanking();
                    break;
                case 4:
                    Jogador.exibirRanking();
                    break;
                case 5:
                    System.out.println("Encerrando o Jogo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static Jogador cadastrarOuIdentificarJogador(Scanner scanner) {
        System.out.println("Digite o nome do jogador:");
        String nome = scanner.nextLine();

        for (Jogador jogador : Jogador.getMelhoresJogadores()) {
            if (jogador.getNome().equals(nome)) {
                System.out.println("Bem-vindo de volta, " + nome + "!");
                return jogador;
            }
        }

        System.out.println("Jogador não encontrado. Criando novo jogador...");

        System.out.println("Digite a idade do jogador:");
        int idade = Integer.parseInt(scanner.nextLine());

        Jogador novoJogador = new Jogador(nome, idade);
        System.out.println("Novo jogador cadastrado com sucesso!");
        return novoJogador;
    }
}
