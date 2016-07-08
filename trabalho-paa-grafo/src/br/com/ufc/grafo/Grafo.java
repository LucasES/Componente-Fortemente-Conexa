package br.com.ufc.grafo;

/**
 * @author Lucas Ara�jo - lucas.compufc@gmail.com
 * @author Jonas Sousa - jonasdesousaf@gmail.com
 */
public class Grafo {

	private int numeroVertices;
	private int[][] matriz;
	
	public Grafo() {
		super();
	}

	/**
	 * Este m�todo cria uma matriz com a quantidade de v�rtices informada.
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

	public int getNumeroVertices() {
		return numeroVertices;
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public void setNumeroVertices(int numeroVertices) {
		this.numeroVertices = numeroVertices;
	}

	/**
	 * Insere uma aresta unidirecional de v para w se a dire��o for 1. Se a
	 * dire��o for 2 insere uma aresta bidirecional de v para w.
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
			System.out.println("Digite uma aresta (v,w) v�lida(maior que 0)!");
		}

	}

	/**
	 * Gera o grafo transposto da matriz informada.
	 * 
	 * @param matriz
	 */
	public void transposta(int[][] matriz) {
		for (int linha = 1; linha < matriz.length; linha++) {
			for (int coluna = linha + 1; coluna < matriz.length; coluna++) {
				if (matriz[linha][coluna] == 1 && matriz[coluna][linha] == 0) {
					matriz[coluna][linha] = 1;
					matriz[linha][coluna] = 0;
				}
			}
		}
	}

	/**
	 * Imprime o grafo informado como par�metro.
	 * 
	 * @param grafo
	 */
	public void imprimeGrafo(Grafo grafo) {
		int count = 0;
		for (int i = 1; i < grafo.getMatriz().length; i++) {
			for (int j = 1; j < grafo.getMatriz().length; j++) {
				if (count % this.numeroVertices == 0) {
					System.out.println();
				}
				System.out.print(grafo.getMatriz()[i][j] + " ");
				count++;
			}
		}
	}

}
