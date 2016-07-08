package br.com.ufc.exception;

import br.com.ufc.grafo.Grafo;

public class ParseException {

	/**
	 * Realiza a convers�o da entrada string para um inteiro.
	 * 
	 * @param data
	 * @return valor.
	 */
	public Integer parseInt(String data) {
		Integer val = 0;
		try {
			val = Integer.parseInt(data);
		} catch (NumberFormatException nfe) {
			System.out.println("Problema na convers�o da string: " + data);
			System.out.println("Por favor informe um numero!!!");
			System.exit(0);
		}
		return val;
	}

	/**
	 * Este m�todo tem como objetivo inserir valores inteiros nas arestas do grafo.
	 * Respeito o formato de tr�s numeros separados por espa�o.
	 * 
	 * @param grafo
	 * @param pe
	 * @param listaArestaDirecao
	 */
	public void insereArestaDaEntrada(Grafo grafo, ParseException pe, String[] listaArestaDirecao) {
		try {
			int v = pe.parseInt(listaArestaDirecao[0]);
			int w = pe.parseInt(listaArestaDirecao[1]);
			int direcao = pe.parseInt(listaArestaDirecao[2]);

			grafo.insereArestaDirecionada(v, w, direcao);
		} catch (Exception e) {
			System.out.println("Por favor informe 3 valores separador por espa�o!");
			System.out.println("Aresta V, W e Dire��o");
			System.out.println("Exemplo: 1 2 3");
			System.exit(0);
		}
	}

	/**
	 * Este m�todo tem como objetivo setar o n�mero de v�rtices e arestas do grafo 
	 * de acordo com os n�meros fornecidos pelo usu�rio.
	 * Respeitando a entrada de dois numeros separados por espa�o.
	 * 
	 * @param grafo
	 * @param pe
	 * @param entradaVerticesArestas
	 */
	public void setVerticeArestaEntrada(Grafo grafo, ParseException pe, String[] entradaVerticesArestas) {
		try {
			grafo.setNumeroVertices(pe.parseInt(entradaVerticesArestas[0]));
			grafo.setNumeroArestas(pe.parseInt(entradaVerticesArestas[1]));
		} catch (IndexOutOfBoundsException e) {
			System.exit(0);
		}
	}
}
