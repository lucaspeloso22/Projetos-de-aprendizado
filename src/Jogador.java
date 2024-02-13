import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogador {

    private String nome;
    private int idade;
    private int pontuacao;
    private int numeroTentativas;

    private static List<Jogador> melhoresJogadores = new ArrayList<>();

    public Jogador(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = 0;
        this.numeroTentativas = 0;
        melhoresJogadores.add(this);
        atualizarRanking();
    }

    private static void atualizarRanking() {
        Collections.sort(melhoresJogadores, (jogador1, jogador2) ->
                Integer.compare(jogador2.getPontuacao(), jogador1.getPontuacao()));
    }

    public void adicionarPontos(int pontosAdicionar) {
        this.pontuacao += pontosAdicionar;
    }

    public static List<Jogador> getMelhoresJogadores() {
        return melhoresJogadores;
    }


    public void perderPontos(int pontosPerder) {
        this.pontuacao -= pontosPerder;
    }

    public void adicionaTentativa() {
        this.numeroTentativas++;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getNumeroTentativas() {
        return numeroTentativas;
    }

    public static boolean verificarNomeExistente(String nome) {
        for (Jogador jogador : melhoresJogadores) {
            if (jogador.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public static void exibirRanking() {
        System.out.println("Ranking dos jogadores:");
        for (int i = 0; i < melhoresJogadores.size(); i++) {
            Jogador jogador = melhoresJogadores.get(i);
            System.out.println((i + 1) + ". " + jogador.getNome() + " - Pontuação: " + jogador.getPontuacao());
        }
    }
}
