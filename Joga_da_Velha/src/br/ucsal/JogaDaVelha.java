package br.ucsal;

import java.util.*;

public class JogaDaVelha {
	static String nomeUsuario1, nomeUsuario2, jogadorAtual;
	static char pecaAJogar;
	static int escolhaDoUsuario, pontuacaoUsuario1 = 0, pontuacaoUsuario2 = 0, turnoJogador;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = 0;

		Impressao.imprimir("1º Jogador, informe seu nome: ");
		nomeUsuario1 = sc.nextLine();

		Impressao.imprimir("2º Jogador, informe seu nome: ");
		nomeUsuario2 = sc.nextLine();

		while (x != 1) {
			Impressao.imprimir("\n" + nomeUsuario1
					+ ", Digite 1 para jogar: \\n(1)Joga da Velha");
			escolhaDoUsuario = sc.nextInt();
			Impressao.imprimir("");

			if (escolhaDoUsuario == 1) {
				System.out.print("");
				daVelha();
			} else {
				Impressao.imprimir("Opção inválida");
			}

			Impressao.imprimir("");
			escolhaDoUsuario = sc.nextInt();
		}
	}

	public static void daVelha() {
		char[][] tabuleiro = new char[3][3];
		boolean empate = true;

		// Enche todos os espaços com -
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiro[i][j] = '-';
			}
		}

		// Enquanto a verificação de que os vencedores não foram definidos ficará um
		// ciclo;

		for (int i = 1; i < 10; i++) {
			// Condicional até chegar na 5 rodada, pois é a quantidade minima de rodadas
			// para se ter um vencedor:
			if (i < 5) {
				Impressao.imprimir(tabuleiro);
				turnoJogador = i;
				turno(tabuleiro);
			} else {
				// A partir da 5 ele imprime, recebe o valor e verifica se o vencedor foi
				// determinado;
				Impressao.imprimir(tabuleiro);
				turnoJogador = i;
				turno(tabuleiro);
				if (Vencedor(tabuleiro)) {
					// Logica de verificação de jogadores no método de turno;
					if (turnoJogador % 2 != 0) {
						pontuacaoUsuario1++;
					} else {
						pontuacaoUsuario2++;
					}
					empate = false;
					break;
				}
			}
		}
		Impressao.imprimir(tabuleiro);
		// Se não for definido que alguem ganhou no deuVelha=true então ele declara como
		// empate;
		if (empate) {
			Impressao.imprimir("Empate!");
		}
	}

	public static void turno(char[][] jogo) {
		Scanner tec1 = new Scanner(System.in);
		// Verifica quem é o jogador de acordo com o turno seguindo a ideia de que o
		// jogador 1 joga em rodadas ímpares e
		// o jogador 2 joga em rodadas pares;
		if (turnoJogador % 2 != 0) {
			jogadorAtual = nomeUsuario1;
			pecaAJogar = 'X';
		} else {
			jogadorAtual = nomeUsuario2;
			pecaAJogar = 'O';
		}
		int pos1 = 0, pos2 = 0, x = 0, y = 0;

		while (x != 1) {
			// validação total de duas formas se existe e está ocupada
			while (y != 1) {
				// verificar a posição q o usuario digitar está dentro do valor jogo da velha
				Impressao.imprimir(jogadorAtual + " (" + pecaAJogar + "),"
						+ " digite a linha e a the coluna de sua escolha: (Max. 3 linha e 3 colunas)");

				Impressao.imprimir("\nLinha:");
				pos1 = tec1.nextInt();
				Impressao.imprimir("");

				if (pos1 >= 1 && pos1 <= 3) {
					y = 1;
					// usuario digitou certo valor y=1 e sai do loop menor
				}

				Impressao.imprimir("\nColuna:");
				pos2 = tec1.nextInt();
				Impressao.imprimir("");

				if (pos2 < 1 || pos2 > 3 || y != 1) {
					Impressao.imprimir(jogo);
					Impressao.imprimir("Posição inválida.\n");
					y = 0;
				}

			}
			y = 0;

			// Validação de caso a posição esteja preenchida por X (88) ou O (79) não
			// permite a entrada duas vezes no mesmo lugar
			if (jogo[pos1 - 1][pos2 - 1] != 88 && jogo[pos1 - 1][pos2 - 1] != 79) {
				jogo[pos1 - 1][pos2 - 1] = pecaAJogar;
				x = 1;
			} else {
				Impressao.imprimir(jogo);
				Impressao.imprimir("Posição ocupada.\n");
			}
		}
	}

	public static boolean Vencedor(char[][] seq) {
		// Verificação de possiveis jogadas para o jogador atual ganhar
		boolean eVencedor = false;
		if ((seq[0][0] == pecaAJogar && seq[1][0] == pecaAJogar && seq[2][0] == pecaAJogar)
				|| (seq[0][1] == pecaAJogar && seq[1][1] == pecaAJogar && seq[2][1] == pecaAJogar)
				|| (seq[0][2] == pecaAJogar && seq[1][2] == pecaAJogar && seq[2][2] == pecaAJogar)
				|| (seq[0][0] == pecaAJogar && seq[0][1] == pecaAJogar && seq[0][2] == pecaAJogar) || // linha
				(seq[1][0] == pecaAJogar && seq[1][1] == pecaAJogar && seq[1][2] == pecaAJogar) || // linha
				(seq[2][0] == pecaAJogar && seq[2][1] == pecaAJogar && seq[2][2] == pecaAJogar) || // linha
				(seq[0][0] == pecaAJogar && seq[1][1] == pecaAJogar && seq[2][2] == pecaAJogar) || // diagonal
				(seq[2][0] == pecaAJogar && seq[1][1] == pecaAJogar && seq[0][2] == pecaAJogar))// diagonal
		{
			System.out.print(jogadorAtual + " Vencedor!\n");
			eVencedor = true;
		}
		return eVencedor;

	}
}
