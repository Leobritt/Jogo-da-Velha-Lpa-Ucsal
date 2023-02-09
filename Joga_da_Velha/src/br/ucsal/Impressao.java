package br.ucsal;

public class Impressao {
	public static void imprimir(String str) {
		System.out.println(str);
	}

	public static void imprimir(int str) {
		System.out.println(str);
	}

	/* metodo para imprimir todos os elemnto do vetor de vez */
	public static void imprimir(String[] vet) {
		for (int i = 0; i < vet.length; i++) {
			imprimir(vet[i]);
		}
	}

	public static void imprimir(String[] vet1, String[] vet2) {
		for (int i = 0; i < vet2.length; i++) {
			imprimir(vet1[i] + " " + vet2[i]);
		}
	}

	public static void imprimir(int[] vet) {
		for (int i = 0; i < vet.length; i++) {
			imprimir(vet[i]);
		}
	}

	public static void imprimir(double str) {
		System.out.println(str);
	}

	public static void imprimir(int[][] vetBid) {
		for (int i = 0; i < vetBid.length; i++) {
			for (int j = 0; j < vetBid[i].length; j++) {
				System.out.print(vetBid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void imprimir(String[][] vetBid) {
		for (int i = 0; i < vetBid.length; i++) {
			for (int j = 0; j < vetBid[i].length; j++) {
				System.out.print(vetBid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void imprimir(double[][] vetBid) {
		for (int i = 0; i < vetBid.length; i++) {
			for (int j = 0; j < vetBid[i].length; j++) {
				System.out.print(vetBid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void imprimir(char[][] vetBid) {
		for (int i = 0; i < vetBid.length; i++) {
			for (int j = 0; j < vetBid[i].length; j++) {
				System.out.print(vetBid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
