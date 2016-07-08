package br.com.ufc.grafo;

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

	public int CheckComponenteFortementeConexo(int[][] matrizTransposta, int maiorVertice) {
		
		criarMatriz(matrizTransposta);
		
		for (int vertice = 1; vertice < getMatriz().length; vertice++) {
			this.cor[vertice] = "branco";
		}
		
		DfsVisit(maiorVertice);
		
		for (int vertice = 1; vertice < getMatriz().length; vertice++) {
			if (cor[vertice].equals("branco")) {
				return 0;
			}
		}
		
		return 1;
	}

	public void DFS(int[][] matriz) {
		criarMatriz(matriz);

		for (int vertice = 1; vertice < getMatriz().length; vertice++) {
			this.cor[vertice] = "branco";
		}

		for (int vertice = 1; vertice < getMatriz().length; vertice++) {
			if (cor[vertice].equals("branco")) {
				DfsVisit(vertice);
			}
		}
	}

	private void criarMatriz(int[][] matriz) {
		setMatriz(matriz);

		int tamanhoMatriz = getMatriz().length;

		setCor(new String[tamanhoMatriz]);
		setDescoberta(new int[tamanhoMatriz]);
		setFinalizacao(new int[tamanhoMatriz]);
	}

	private void DfsVisit(int vertice) {
		this.cor[vertice] = "cinza";
		tempo++;
		this.descoberta[vertice] = tempo;

		for (int i = 1; i < getMatriz().length; i++) {
			if (getMatriz()[vertice][i] == 1) {
				if (getCor()[i].equals("branco")) {
					DfsVisit(i);
				}
			}
		}
		this.cor[vertice] = "preto";
		tempo++;
		this.finalizacao[vertice] = tempo;
	}

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
