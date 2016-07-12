package br.com.ufc;

import java.util.Scanner;

import br.com.ufc.exception.Exception;
import br.com.ufc.grafo.BuscaProfundidade;
import br.com.ufc.grafo.Grafo;

public class Application {

	public static void main(String[] args) {

		Grafo grafo = new Grafo();
		Exception pe = new Exception();

		Scanner in = new Scanner(System.in);

		System.out.println("Informe a quantidade de vértices e de arestas (N M) separados por espaço.");
		System.out.println("Exemplo de entrada com 4 vértices e 5 arestas: 4 5");

		String[] entradaVerticesArestas = in.nextLine().split("\\s+");
		
		pe.verificaQuantidadeVerticesArestas(pe, entradaVerticesArestas);
		
		pe.setVerticeArestaEntrada(grafo, pe, entradaVerticesArestas);

		grafo.criarGrafo(grafo.getNumeroVertices());

		for (int i = 1; i <= grafo.getNumeroArestas(); i++) {
			String[] listaArestaDirecao = in.nextLine().split("\\s+");

			pe.insereArestaDaEntrada(grafo, pe, listaArestaDirecao);
		}

		BuscaProfundidade dfs = new BuscaProfundidade();

		dfs.DFS(grafo.getMatriz());

		int[][] grafoTransposto = grafo.transposta(grafo.getMatriz());

		BuscaProfundidade dfs2 = new BuscaProfundidade();

		int maiorVerticeFinal = dfs.verticeMaiorFinalizacao(dfs.getFinalizacao());
		int saida = dfs2.CheckComponenteFortementeConexo(grafoTransposto, maiorVerticeFinal);

		System.out.println("Saída = " + saida);
	}

}
