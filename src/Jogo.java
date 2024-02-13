import java.util.Scanner;

public class Jogo {
    private static Scanner scanner = new Scanner(System.in);

    public void jogar(Jogador jogador) {
        while (true) {
            System.out.println("Escolha o tipo de jogo:");
            System.out.println("1. Pedra, papel, tesoura");
            System.out.println("2. Acerte o número");
            System.out.println("3. Sair");

            int escolha = 0;
            try {
                escolha = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, insira um número.");
                continue;
            }

            switch (escolha) {
                case 1:
                    jogarPedraPapelTesoura(jogador);
                    break;
                case 2:
                    jogarAcerteONumero(jogador);
                    break;
                case 3:
                    System.out.println("Saindo do jogo.");
                    return;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        }
    }

    private void jogarPedraPapelTesoura(Jogador jogador) {
        while (true) {
            System.out.println("Escolha sua jogada (pedra, papel, tesoura) ou 'sair' para sair do jogo:");
            String jogada = scanner.nextLine().toLowerCase();

            if (jogada.equals("sair")) {
                break;
            }

            if (!jogada.equals("pedra") && !jogada.equals("papel") && !jogada.equals("tesoura")) {
                System.out.println("Jogada inválida. Por favor, escolha entre 'pedra', 'papel' ou 'tesoura'.");
                continue;
            }

            jogador.adicionaTentativa();

            String[] opcoes = {"pedra", "papel", "tesoura"};
            String jogadaSistema = opcoes[(int) (Math.random() * 3)];

            System.out.println("O sistema escolheu: " + jogadaSistema);

            if (jogada.equals(jogadaSistema)) {
                System.out.println("Empate!");
            } else if ((jogada.equals("pedra") && jogadaSistema.equals("tesoura")) ||
                    (jogada.equals("papel") && jogadaSistema.equals("pedra")) ||
                    (jogada.equals("tesoura") && jogadaSistema.equals("papel"))) {
                System.out.println("Você ganhou!");
                jogador.adicionarPontos(1); // Adiciona um ponto ao jogador
            } else {
                System.out.println("Você perdeu!");
            }
        }

        System.out.println("O jogo foi encerrado.");
    }

    private void jogarAcerteONumero(Jogador jogador) {
        System.out.println("Digite o número máximo para o jogo:");
        int numMaximo = 0;
        try {
            numMaximo = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Número máximo inválido. Por favor, insira um número.");
            return;
        }

        while (true) {
            System.out.println("Escolha um número entre 0 e " + numMaximo + " ou 'sair' para sair do jogo:");
            String input = scanner.nextLine();

            if (input.equals("sair")) {
                break;
            }

            try {
                int escolha = Integer.parseInt(input);
                int numeroSistema = (int) (Math.random() * (numMaximo + 1));

                System.out.println("O sistema escolheu o número: " + numeroSistema);

                if (escolha == numeroSistema) {
                    System.out.println("Parabéns, você acertou!");
                    jogador.adicionarPontos(1);
                } else {
                    System.out.println("Que pena, você errou.");
                    jogador.perderPontos(1);
                }

                jogador.adicionaTentativa();
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }

        System.out.println("O jogo de acertar o número foi encerrado.");
    }
}
