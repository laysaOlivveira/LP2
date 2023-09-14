/**
 * SubClasse de ElementoAbstract do tipo Texto.
 * @author Laysa Santos Oliveira - 122210585
 * */
package DocuMin.entidades;

public class Texto extends ElementoAbstract{

	// Atributo do titulo do documento
	protected String tituloDoc;
	// Indica se a lista tem um título de referência ou não.
	protected boolean tituloRef = false;
	
	/**
	 * Construtor do Texto
	 * @param valor valor do elemento abstrato.
	 * @param prioridade prioridade do elemento abstrato
	 */
	public Texto(String valor, int prioridade) {
		super(valor, prioridade);
	}

	/**
	 * Gera a representacao completa do texto
	 * @return valor valor do texto
	 */
	@Override
	public String gerarRepresentacaoCompleta() {
		return valor;
	}

	/**
	 * Gera a representacao resumida do texto
	 * @return valor valor do texto
	 */
	@Override
	public String gerarRepresentacaoResumida() {
		return valor;
	}

	/**
	* Obtém a indicação de se o texto tem um título de referência.
	* @return true se o texto tem um título de referência, false caso contrário. */
	@Override
	public boolean getTituloRef() {
		// TODO Auto-generated method stub
		return tituloRef;
	}
}