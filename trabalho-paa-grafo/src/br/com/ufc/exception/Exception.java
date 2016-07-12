package br.com.ufc.exception;

import br.com.ufc.grafo.Grafo;

/**
 * Classe respons�vel pelos tratamentos de exce��es de convers�es de valores e acessos
 * a �ndices incorretos.
 * 
 * @author Lucas Ara�jo - lucas.compufc@gmail.com
 */
public class Exception {

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
	public void insereArestaDaEntrada(Grafo grafo, Exception pe, String[] listaArestaDirecao) {
		try {
			int v = pe.parseInt(listaArestaDirecao[0]);
			int w = pe.parseInt(listaArestaDirecao[1]);
			int direcao = pe.parseInt(listaArestaDirecao[2]);

			grafo.insereArestaDirecionada(v, w, direcao);
		} catch (IndexOutOfBoundsException e) {
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
	public void setVerticeArestaEntrada(Grafo grafo, Exception pe, String[] entradaVerticesArestas) {
		try {
			grafo.setNumeroVertices(pe.parseInt(entradaVerticesArestas[0]));
			grafo.setNumeroArestas(pe.parseInt(entradaVerticesArestas[1]));
		} catch (IndexOutOfBoundsException e) {
			System.exit(0);
		}
	}
	
	public void verificaQuantidadeArestas(Exception pe, String[] entradaVerticesArestas){
		try {
			int n = pe.parseInt(entradaVerticesArestas[0]);
			int m = pe.parseInt(entradaVerticesArestas[1]);
			int arestaRegra = n*(n-1)/2;
			if(m >= 2 && m <= arestaRegra) {
				System.out.println("Informe tr�s valores, v�rtice V, v�rtice W e a dire��o (1 - unidirecional, 2 - bidirecional)");
				System.out.println("Exemplo: 1 2 1. Quer dizer que: v�rtice 1 tem uma aresta direcionada para o v�rtice 2.");
			}else {
				System.out.println("Informe uma quantidade maior de arestas!");
				System.exit(0);
			}
		} catch (IndexOutOfBoundsException e) {
			System.exit(0);
		}
	}
}
