package br.com.ufc;

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

		grafo.imprimeGrafo(grafo);

		grafo.transposta(grafo.getMatriz());
		System.out.println();

		grafo.imprimeGrafo(grafo);
	}
}
