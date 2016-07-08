package br.com.ufc.exception;

import br.com.ufc.grafo.Grafo;

public class ParseException {

	/**
	 * Realiza a conversão da entrada string para um inteiro.
	 * 
	 * @param data
	 * @return valor.
	 */
	public Integer parseInt(String data) {
		Integer val = 0;
		try {
			val = Integer.parseInt(data);
		} catch (NumberFormatException nfe) {
			System.out.println("Problema na conversão da string: " + data);
			System.out.println("Por favor informe um numero!!!");
			System.exit(0);
		}
		return val;
	}

	/**
	 * Este método tem como objetivo inserir valores inteiros nas arestas do grafo.
	 * Respeito o formato de três numeros separados por espaço.
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
			System.out.println("Por favor informe 3 valores separador por espaço!");
			System.out.println("Aresta V, W e Direção");
			System.out.println("Exemplo: 1 2 3");
			System.exit(0);
		}
	}

	/**
	 * Este método tem como objetivo setar o número de vértices e arestas do grafo 
	 * de acordo com os números fornecidos pelo usuário.
	 * Respeitando a entrada de dois numeros separados por espaço.
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
