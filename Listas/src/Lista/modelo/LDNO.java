package Lista.modelo;

import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Lista.ElementoDuplo;
import Lista.Ordenadas.LDO;

public class LDNO {

	private String StringDeVerificacao = null, resultado;
	private int EscolhaPrincipal;
	private boolean teste = false, ErroVerificaNumero = false;
	public ElementoDuplo novo = null, inicio = null, fim = null, aux = null, auxDir = null, auxEsq = null,
			auxAntrior = null;

	public void executar() {

		do {

			String[] opt = { "sair", "Inserir no inicio\n", "Inserir no final", "Buscar", "Excluir", "Esvaziar",
					"Ordenar (com outra lista)", "Ordenar (na mesma lista)", "Listar" };
			EscolhaPrincipal = JOptionPane.showOptionDialog(null, "Escolha umas das opçoes para continuar", "OPÇOES",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, opt[0]);

			switch (EscolhaPrincipal) {

			case 0:
				System.exit(0);
				break;

			// Inserir no inicio
			case 1:
				do {

					StringDeVerificacao = JOptionPane.showInputDialog(null, "Digite um numero:", "DADOS",
							JOptionPane.QUESTION_MESSAGE);

					VerificaRetornoIgualNull(StringDeVerificacao);
					VerificaSeeNumero(StringDeVerificacao);
				} while (ErroVerificaNumero == true);
				InserirInicio(Integer.parseInt(StringDeVerificacao));

				break;

			// Inserir no final
			case 2:
				do {

					StringDeVerificacao = JOptionPane.showInputDialog(null, "Digite um numero:", "DADOS",
							JOptionPane.QUESTION_MESSAGE);
					VerificaRetornoIgualNull(StringDeVerificacao);
					VerificaSeeNumero(StringDeVerificacao);

				} while (ErroVerificaNumero == true);
				inserirFinal(Integer.parseInt(StringDeVerificacao));
				
				break;

			// Buscar
			case 3:
				do {
					StringDeVerificacao = JOptionPane.showInputDialog(null, "Digite um numero para buscar:", "DADOS",
							JOptionPane.QUESTION_MESSAGE);
					VerificaRetornoIgualNull(StringDeVerificacao);
					VerificaSeeNumero(StringDeVerificacao);
					
				} while (ErroVerificaNumero == true);

				BuscaNumero(Integer.parseInt(StringDeVerificacao));
				
				break;

			// Excluir
			case 4:
				do {
					StringDeVerificacao = JOptionPane.showInputDialog(null, "Digite um numero para excluir:", "DADOS",
							JOptionPane.QUESTION_MESSAGE);
					VerificaRetornoIgualNull(StringDeVerificacao);
					VerificaSeeNumero(StringDeVerificacao);
				} while (ErroVerificaNumero == true);

				BuscaNumero(Integer.parseInt(StringDeVerificacao));
				ExculirElemento();
				
				break;

			// Esvaziar
			case 5:
				inicio = null;
				fim = null;
				JOptionPane.showMessageDialog(null, "Lista vazia", "AVISO", JOptionPane.INFORMATION_MESSAGE);
				break;

			// ordenar (com outra lista)
			case 6:
				if (inicio == null) {
					JOptionPane.showMessageDialog(null, "Lista vazia", "ERRO", JOptionPane.ERROR_MESSAGE);
					
					break;
				}
				if (aux == inicio && aux == fim) {
					break;
				}
				LDO listaOrdenada = new LDO();
				aux = inicio;
				while (aux != null) {
					listaOrdenada.inserir(aux.numero);
					aux = aux.prox;
				}
				inicio = null;
				ElementoDuplo auxLDO = new ElementoDuplo();
				auxLDO = listaOrdenada.inicio;
				while (auxLDO != null) {
					inserirFinal(auxLDO.numero);
					auxLDO = auxLDO.prox;
				}
				break;

			// Ordenar (na mesma lista)
			case 7:
				if (inicio == null) {
					JOptionPane.showMessageDialog(null, "Lista vazia", "ERRO", JOptionPane.ERROR_MESSAGE);
					break;
				}
				OrdenaNaMesmaLista();
				break;

			// Listar
			case 8:
				resultado = "";
				if (inicio == null) {
					JOptionPane.showMessageDialog(null, "Lista vazia", "ERRO", JOptionPane.ERROR_MESSAGE);
				} else {
					aux = inicio;
					while (aux != null) {
						resultado += " |  " + aux.numero + "  | ";
						aux = aux.prox;
					}
					JOptionPane.showMessageDialog(null, "sua lista e : " + resultado + " ", "AVISO",
							JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			}
		} while (EscolhaPrincipal != 0);
	}

	public void VerificaRetornoIgualNull(String x) {

		if (x == null) {
			System.exit(0);
		}
	}

	public void VerificaSeeNumero(String x) {

		try {
			Pattern padrao = Pattern.compile("[+-]?[\\d]+");
			Matcher pesquisa = padrao.matcher(x);
			if (!pesquisa.matches())
				throw new IllegalArgumentException("Por Favor digite algum numero para continuar");
			ErroVerificaNumero = false;
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			ErroVerificaNumero = true;
		}
	}

	public void InserirInicio(int x) {
		novo = new ElementoDuplo();
		novo.numero = x;
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			novo.prox = inicio;
			inicio.ant = novo;
			inicio = novo;
		}
	}
	public void inserirFinal(int x) {

		novo = new ElementoDuplo();
		novo.numero = x;

		if (inicio == null) {
			// lista vazia
			inicio = novo;
			fim = novo;
		} else {
			fim.prox = novo;
			novo.ant = fim;
			fim = novo;
		}
	}
	public void BuscaNumero(int x) {
		aux = inicio;
		while (aux != null && x != aux.numero) {
			aux = aux.prox;
		}
		if (aux == null) {
			JOptionPane.showMessageDialog(null, "numero nao encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "numero achado : " + x + " ", "AVISO", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public void ExculirElemento() {
		if (aux != null) {
			if (aux == inicio || aux == fim) {
				if (aux == inicio) {
					inicio = aux.prox;
				} else if (aux == fim) {
					fim = aux.ant;
					fim.prox = null;
				}
			} else {
				aux.ant.prox = aux.prox;
				aux.prox.ant = aux.ant;
			}
		}
	}

	public void OrdenaNaMesmaLista() {
		do {
			aux = inicio;
			if (aux == inicio && aux == fim) {
				break;
			}
			auxEsq = aux;
			auxDir = inicio.prox;
			while (aux != null) {
				teste = false;
				if (aux == inicio) {
					if (inicio.numero > auxDir.numero) {
						inicio.prox = auxDir.prox;
						auxDir.prox.ant = inicio;
						auxDir.prox = inicio;
						inicio.ant = auxDir;
						inicio = auxDir;
						inicio.ant = null;
						teste = true;
						break;
					}
				} else {
					if (auxEsq.numero > aux.numero) {
						auxAntrior.prox = aux;
						auxEsq.prox = aux.prox;
						aux.ant = auxAntrior;
						aux.prox = auxEsq;
						auxEsq.ant = aux;
						if (aux != fim) {
							auxEsq.prox.ant = auxEsq;
						}
						if (aux == fim) {
							fim = auxEsq;
							fim.prox = null;
						}
						teste = true;
						break;
					}
				}

				auxAntrior = auxEsq;
				auxEsq = aux;
				aux = aux.prox;

			}
		} while (teste == true);

	}

}
