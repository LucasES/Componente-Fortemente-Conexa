package br.com.ufc.grafo;

/**
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @author Jonas Sousa - jonasdesousaf@gmail.com
 */
public class Grafo {

	private int numeroVertices;
	private int[][] matriz;
	
	public Grafo() {
		super();
	}

	/**
	 * Este método cria uma matriz com a quantidade de vértices informada.
	 * 
	 * @param numeroVertices
	 */
	public void criarGrafo(int numeroVertices) {
		if (numeroVertices >= 2 && numeroVertices <= 2000) {
			this.numeroVertices = numeroVertices;
			this.matriz = new int[numeroVertices + 1][numeroVertices + 1];
		} else {
			System.out.println("Numero de vertices deve ser maior que 2 e menor ou igual a 2 mil");
		}
	}

	public int[][] getMatriz() {
		return matriz;
	}


	/**
	 * Insere uma aresta unidirecional de v para w se a direção for 1. Se a
	 * direção for 2 insere uma aresta bidirecional de v para w.
	 * 
	 * @param v
	 * @param w
	 * @param direcao
	 */
	public void insereArestaDirecionada(int v, int w, int direcao) {
		if (v != 0 && w != 0) {
			if (direcao == 1) {
				this.matriz[v][w] = 1;
			} else if (direcao == 2) {
				this.matriz[v][w] = 1;
				this.matriz[w][v] = 1;
			}
		} else {
			System.out.println("Digite uma aresta (v,w) válida(maior que 0)!");
		}

	}

	/**
	 * Gera o grafo transposto da matriz informada.
	 * 
	 * @param matriz
	 */
	public int[][] transposta(int[][] matriz) {
		int[][] tempMatriz = new int[matriz[0].length][matriz.length];
		for (int linha = 1; linha < matriz.length; linha++) {
			for (int coluna = 1; coluna < matriz[1].length; coluna++) {
				if (matriz[linha][coluna] == 1 && matriz[coluna][linha] == 0) {
					tempMatriz[coluna][linha] = 1;
					tempMatriz[linha][coluna] = 0;
				} 
				else if (matriz[linha][coluna] == 1 && matriz[coluna][linha] == 1) {
					tempMatriz[coluna][linha] = 1;
					tempMatriz[linha][coluna] = 1;
				}
			}
		}
		return tempMatriz;
	}

	/**
	 * Imprime o grafo informado como parâmetro.
	 * 
	 * @param grafo
	 */
	public void imprimeGrafo(int[][] matriz) {
		int count = 0;
		for (int i = 1; i < matriz.length; i++) {
			for (int j = 1; j < matriz.length; j++) {
				if (count % this.numeroVertices == 0) {
					System.out.println();
				}
				System.out.print(matriz[i][j] + " ");
				count++;
			}
		}
	}

}
