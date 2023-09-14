/**
 * SubClasse de ElementoAbstract do tipo Termo.
 * @author Laysa Santos Oliveira - 122210585
 * */
package DocuMin.entidades;

import java.util.Arrays;
import java.util.Comparator;

public class Termo extends ElementoAbstract {

	// Atributo do separador de termos
	protected String separador;
	// Atributo do ordenador dos termos
	protected String ordem;
	//Indica se a lista tem um título de referência ou não.
	protected boolean tituloRef = false;
	
	/**
	 * Construtor de Termo
	 * @param valor valor do elemento abstrato.
	 * @param prioridade prioridade do elemento abstrato
	 * @param separador separador dos termos
	 * @param ordem ordena os termos
	 */
	public Termo(String valor, int prioridade, String separador, String ordem) {
		super(valor, prioridade);
		this.separador = separador;
		this.ordem = ordem;
	}

	/**
	 * Conta quantos elementos tem o termo
	 * @return contador quantidade de termos
	 */
	public int quantidadeDeTermos() {
		int contador = 0;
		for (int i = 0; i < valor.length(); i++) {
			if (valor.valueOf(i) == separador) {
				contador++;
			}
		}
		return contador;
	}
	
	/**
	* Gera a representação completa dos termos.
	* @return A representação completa dos termos.
	**/
	@Override
	public String gerarRepresentacaoCompleta() {
		String representacao = "Total de termos: " + quantidadeDeTermos() + "\n" + "- ";
		String termosFormatados = null;
		String[] termos = valor.split(separador);
		switch (ordem){
			case "ALFABÉTICA":
				Arrays.sort(termos);
				for(int i = 0; i < valor.length(); i++) {
					termosFormatados = termos[i] + ", ";
				}
				return representacao + termosFormatados;
				
			case "NENHUM":
				for(int i = 0; i < valor.length(); i++) {
					termosFormatados = termos[i] + ", ";
				}
				return  representacao + termosFormatados;
				
			case "TAMANHO":
				/**
				 * o array palavras é ordenado pelo comprimento das palavras 
				 * usando o método Arrays.sort() e um comparador personalizado que implementa o método compare(). 
				 * O método compare() usa o método Integer.compare() para comparar o comprimento das duas strings e retornar um valor negativo, zero ou positivo, 
				 * dependendo se a primeira string é menor, igual ou maior do que a segunda string. 
				 * O resultado é um array ordenado pelo tamanho das palavras
				 */
				Arrays.sort(termos, new Comparator<String>() {
		            @Override
		            public int compare(String termo1, String termo2) {
		                return Integer.compare(termo1.length(), termo2.length());
		            }
		        });
				for(int i = 0; i < valor.length(); i++) {
					termosFormatados = termos[i] + ", ";
				}
				return representacao + termosFormatados;
				
			default:
		}
		return null;
	}

	/**
	 * Gera a representacao resumida dos termos
	 * @return A representação resumida dos termos.
	 */
	@Override
	public String gerarRepresentacaoResumida() {
		String termosFormatados = null;
		String[] termos = valor.split(separador);
		switch (ordem){
			case "ALFABÉTICA":
				Arrays.sort(termos);
				for(int i = 0; i < valor.length(); i++) {
					termosFormatados = termos[i] + " " + separador + " ";
				}
				return termosFormatados;
				
			case "NENHUM":
				for(int i = 0; i < valor.length(); i++) {
					termosFormatados = termos[i] +  " " + separador + " ";
				}
				return termosFormatados;
				
			case "TAMANHO":
				Arrays.sort(termos, new Comparator<String>() {
		            @Override
		            public int compare(String termo1, String termo2) {
		                return Integer.compare(termo1.length(), termo2.length());
		            }
		        });
				for(int i = 0; i < valor.length(); i++) {
					termosFormatados = termos[i] + ", ";
				}
				return "- " + termosFormatados;
			default:
		}
		return null;
	}

	/**
	* Obtém a indicação de se o termo tem um título de referência.
	* @return true se o termo tem um título de referência, false caso contrário. */
	@Override
	public boolean getTituloRef() {
		// TODO Auto-generated method stub
		return tituloRef;
	}

}