package Lista.Ordenadas;

import Lista.ElementoSimples;
import Lista.modelo.LSNO;

public class LSO {

	public ElementoSimples inicio = null, fim = null, aux = null, novo = null, te = null, cop = null;

	public void inserir(int x) {
		novo = new ElementoSimples();
		novo.numero = x;
		aux = inicio;
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else if (novo.numero > fim.numero) {
			fim.prox = novo;
			fim = novo;
		} else if (novo.numero < inicio.numero) {
			novo.prox = inicio;
			inicio = novo;
		} else {
			te = null;
			while (aux != null) {
				if (novo.numero > aux.numero) {
					te = aux;
				}
				aux = aux.prox;
			}
			cop = te.prox;
			te.prox = novo;
			novo.prox = cop;
		}
	}

	public void retorna() {

		LSNO listaNaoOrdenada = new LSNO();
		aux = inicio;
		while (aux != null) {
			listaNaoOrdenada.inserirFinal(aux.numero);
			aux = aux.prox;
		}
	}

}
