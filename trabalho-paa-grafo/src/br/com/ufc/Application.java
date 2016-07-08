package br.com.ufc;

import br.com.ufc.grafo.BuscaProfundidade;
import br.com.ufc.grafo.Grafo;

public class Application {

	public static void main(String[] args) {
		Grafo grafo = new Grafo();

		grafo.criarGrafo(4);

		grafo.insereArestaDirecionada(1, 2, 1);
		grafo.insereArestaDirecionada(1, 3, 2);
		grafo.insereArestaDirecionada(2, 4, 1);
		grafo.insereArestaDirecionada(3, 4, 1);
		grafo.insereArestaDirecionada(4, 1, 2);

		int[][] matriz = grafo.getMatriz();
		
		grafo.imprimeGrafo(matriz);
		System.out.println();
		
		BuscaProfundidade dfs = new BuscaProfundidade();
		
		dfs.DFS(matriz);
		
			
		System.out.println();
		System.out.println("Vertice de maior finalização: Vertice - " + dfs.verticeMaiorFinalizacao(dfs.getFinalizacao()));
		
		int[][] grafoTransposto = grafo.transposta(matriz);

		grafo.imprimeGrafo(grafoTransposto);
		
//		dfs.DFS(grafoTransposto);
		
		BuscaProfundidade dfs2 = new BuscaProfundidade();
		
		
//		System.out.println();
//		System.out.println("Vertice de maior finalização: Vertice - " + dfs.verticeMaiorFinalizacao(dfs.getFinalizacao()));
		int maiorVerticeFinal = dfs.verticeMaiorFinalizacao(dfs.getFinalizacao());
		int saida = dfs2.CheckComponenteFortementeConexo(grafoTransposto, maiorVerticeFinal);
		
		System.out.println();
		System.out.println("Saída = " +saida);
	}
}
