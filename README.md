# Componente-Fortemente-Conexos
Este projeto tem como objetivo desenvolver um algoritmo capaz de informar se em um grafo é fortemente conexo ou não.
Representação utilizada: Matriz de Adjacência.

## DESCRIÇÃO: ##

 Em uma determinada cidade existem interseções N ligadas por ruas de sentido ´unico e em dois sentidos. E uma cidade moderna, e várias das 
ruas possuem túneis ou viadutos. Evidentemente, deve ser possível viajar entre quaisquer duas interseções. Mais precisamente, dadas duas 
interseções V e W, tem que ser possível viajar de V para W e de W para V na cidade. Sua tarefa é escrever um programa que lê a 
descrição do sistema de rua da cidade e determina se a exigência de conexidade mencionada no final do parágrafo anterior está 
satisfeita ou não para essa cidade. 

**Importante:** Implemente um algoritmo com complexidade O(n² + (n · m)).

## ENTRADA: ##
Recebe-se primeiramente uma linha contendo dois inteiros N e M, separados por um espaço, que indica o número de 
interseções (2 ≤ N ≤ 2000) e o número de ruas (2 ≤ M ≤ N · (N − 1)/2). As próximas M linhas descrevem o sistema de rua
da cidade, com cada linha representando uma rua. Uma descriçao de rua consiste de três números inteiros V , W e P, separados
por um espaço em branco, em que V e W são identificadores distintos de interseções (1 ≤ V , W ≤ N, V != W) e P pode ser 1 ou 2;
Se P = 1 a rua é de mão única e o tráfego vai de V para W; se P = 2, a rua ´e de m˜ao dupla e liga V a W. Um par de
interseções está ligado por no máximo uma rua.

## SAÍDA: ##
Imprimir uma única linha contendo um inteiro C, onde C É igual a um se a condiao de conexão é satisfeita, e G é zero
caso contrário.

![paa](https://cloud.githubusercontent.com/assets/2569126/16679798/be6bd374-44c0-11e6-98ae-7eabce45626b.png)

**Developed By:** [Lucas Araújo](https://github.com/lucases) and [Jonas de Sousa](https://github.com/jonasdesousaf)
