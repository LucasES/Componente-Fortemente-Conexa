package br.com.ufc.grafo;

import br.com.ufc.enums.Cor;

/**
 * Classe responsável por realizar a busca em profundidada (DFS) em uma matriz de adjacências.
 * 
 * @author Lucas Araújo - lucas.compufc@gmail.com
 * @author Jonas Sousa - jonasdesousaf@gmail.com
 */
public class BuscaProfundidade {

	private int tempo = 0;

	private int[][] matriz;
	private String[] cor;
	private int[] descoberta;
	private int[] finalizacao;

	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public int[] getDescoberta() {
		return descoberta;
	}

	public void setDescoberta(int[] descoberta) {
		this.descoberta = descoberta;
	}

	public int[] getFinalizacao() {
		return finalizacao;
	}

	public void setFinalizacao(int[] finalizacao) {
		this.finalizacao = finalizacao;
	}

	public String[] getCor() {
		return cor;
	}

	public void setCor(String[] cor) {
		this.cor = cor;
	}

	/**
	 * Este método tem como objetivo realizar mais uma DFS Visit na matriz transposta
	 * com o objetivo  de encontrar algum vertice em branco ao final da verificação. 
	 * Caso encontre, quer dizer que essa grafo não é uma única componente fortemente conexa.
	 * 
	 * @param matrizTransposta
	 * @param maiorVertice
	 * @return
	 */
	public int CheckComponenteFortementeConexo(int[][] matrizTransposta, int maiorVertice) {
		
		criarMatriz(matrizTransposta);
		
		for (int vertice = 1; vertice < getMatriz().length; vertice++) {
			this.cor[vertice] = Cor.Branco.name();
		}
		
		DfsVisit(maiorVertice);
		
		for (int vertice = 1; vertice < getMatriz().length; vertice++) {
			if (cor[vertice].equals(Cor.Branco.name())) {
				return 0;
			}
		}
		
		return 1;
	}

	/**
	 * Realiza a busca em profundidade em uma matriz de adjacências.
	 * 
	 * @param matriz
	 */
	public void DFS(int[][] matriz) {
		criarMatriz(matriz);

		for (int vertice = 1; vertice < getMatriz().length; vertice++) {
			this.cor[vertice] = Cor.Branco.name();
		}

		for (int vertice = 1; vertice < getMatriz().length; vertice++) {
			if (cor[vertice].equals(Cor.Branco.name())) {
				DfsVisit(vertice);
			}
		}
	}

	/**
	 * Cria um grafo com uma matriz de adjacência.
	 * 
	 * @param matriz
	 */
	private void criarMatriz(int[][] matriz) {
		setMatriz(matriz);

		int tamanhoMatriz = getMatriz().length;

		setCor(new String[tamanhoMatriz]);
		setDescoberta(new int[tamanhoMatriz]);
		setFinalizacao(new int[tamanhoMatriz]);
	}

	private void DfsVisit(int vertice) {
		this.cor[vertice] = Cor.Cinza.name();
		tempo++;
		this.descoberta[vertice] = tempo;

		for (int i = 1; i < getMatriz().length; i++) {
			if (getMatriz()[vertice][i] == 1) {
				if (getCor()[i].equals(Cor.Branco.name())) {
					DfsVisit(i);
				}
			}
		}
		this.cor[vertice] = Cor.Preto.name();
		tempo++;
		this.finalizacao[vertice] = tempo;
	}

	/**
	 * Encontra o vertice com o maior valor no array de finalizações.
	 * 
	 * @param finalizacoes
	 * @return inteiro com a maior finalização.
	 */
	public int verticeMaiorFinalizacao(int[] finalizacoes) {
		finalizacoes = getFinalizacao();
		int verticeMaior = 0;
		int maior = 0;

		for (int i = 1; i < finalizacao.length; i++) {
			if (finalizacao[i] > maior) {
				maior = finalizacao[i];
				verticeMaior = i;
			}
		}

		return verticeMaior;
	}

}
