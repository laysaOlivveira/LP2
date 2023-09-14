/**
 * SubClasse de ElementoAbstract do tipo Lista.
 * @author Laysa Santos Oliveira - 122210585
 * */

package DocuMin.entidades;

public class Lista extends ElementoAbstract{

	// Atributo do separador de uma lista
	protected String separador;
	// Atributo do caracter da lista
	protected String charLista;
	//Indica se a lista tem um título de referência ou não.
	protected boolean tituloRef = false;

	/**
	 * Construtor de Lista
	 * @param valorLista valor do elemento abstrato.
	 * @param prioridade prioridade do elemento abstrato
	 * @param separador separador da lista
	 * @param charLista caracter da lista
	 */
	public Lista(String valorLista, int prioridade, String separador, String charLista) {
		super(valorLista, prioridade);
		this.separador = separador;
		this.charLista = charLista;
	}

	/**
	* Gera a representação completa da lista.
	* @return A representação completa da lista.
	**/
	@Override
	public String gerarRepresentacaoCompleta() {
		String representacao = null;
		String[] termos = valor.split(separador);
		for(int i = 0; i < valor.length(); i++) {
			representacao = charLista + termos[i] + "\n";
		}
		return representacao;
	}

	/**
	 * Gera a representacao resumida da lista
	 * @return valor valor da lista
	 */
	@Override
	public String gerarRepresentacaoResumida() {
		return valor;
	}

	/**
	* Obtém a indicação de se a lista tem um título de referência.
	* @return true se a lista tem um título de referência, false caso contrário. */
	@Override
	public boolean getTituloRef() {
		// TODO Auto-generated method stub
		return tituloRef;
	}

}
