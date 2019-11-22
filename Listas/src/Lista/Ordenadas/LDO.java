package Lista.Ordenadas;

import Lista.ElementoDuplo;
import Lista.modelo.LDNO;

public class LDO {

	public ElementoDuplo inicio = null, fim = null, aux = null, novo = null;

	public void inserir(int x) {
		novo = new ElementoDuplo();
		novo.numero = x;
		aux = inicio;
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else if (novo.numero > fim.numero) {
			novo.ant = fim;
			fim.prox = novo;
			fim = novo;
		} else if (novo.numero < inicio.numero) {
			novo.prox = inicio;
			inicio.ant = novo;
			inicio = novo;
		} else {
			while (novo.numero > aux.numero) {
				aux = aux.prox;
			}
			novo.prox = aux;
			novo.ant = aux.ant;
			aux.ant.prox = novo;
			aux.ant = novo;
		}
	}

	public void retorna() {

		LDNO listaNaoOrdenada = new LDNO();
		aux = inicio;
		while (aux != null) {
			listaNaoOrdenada.inserirFinal(aux.numero);
			aux = aux.prox;
		}
	}

}
