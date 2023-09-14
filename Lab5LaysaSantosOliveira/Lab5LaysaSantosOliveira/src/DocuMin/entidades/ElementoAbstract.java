/**
*Classe abstrata ElementoAbstract implementa a interface Elemento
*@author Laysa Santos Oliveira - 122210585
*/
package DocuMin.entidades;

import java.util.HashMap;

public abstract class ElementoAbstract implements Elemento {

	// Atributo de valor do elemento
	protected String valor;
	// Atributo de prioridade do elemento
	protected int prioridade;
	// Atributo de propriedades do elemento
	protected HashMap<String,String> propriedades;
	
	/**
	 * @param valor Valor do elemento
	 * @param prioridade Prioridade do elemento
	 */
	public ElementoAbstract(String valor, int prioridade) {
		this.valor = valor;
		this.prioridade = prioridade;
		this.propriedades =  new HashMap<String, String>();
	}
	
	/**
	 * Verifica se a prioridade do elemento é válida
	 * @param prioridade Prioridade a ser verificada
	 * @return true se a prioridade é válida, false caso contrário
	 */
	public boolean validaPrioridade(int prioridade) {
		boolean valido = true;
		if (prioridade > 5 || prioridade < 1) {
			valido = false;
			return valido;
		}
		return valido;
	}
	
	/**
	 * Retorna a prioridade do elemento
	 * @return Prioridade do elemento
	 */
	public int getPrioridade() {
		return prioridade;
	}

	/**
	 * Retorna o valor do elemento
	 * @return Valor do elemento
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Define uma propriedade do elemento
	 * @param chave Chave da propriedade
	 * @param valor Valor da propriedade
	 */
	public void setValorPropriedade(String chave, String valor) {
		this.propriedades.put(chave, valor);
	}
	
}