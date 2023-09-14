/**
 * SubClasse de ElementoAbstract do tipo Titulo.
 * @author Laysa Santos Oliveira - 122210585
 * */
package DocuMin.entidades;

public class Titulo extends ElementoAbstract{
	// Atributo do nivel de um titulo
	protected int nivel; // propriedades
	// Atributo que diz se o titulo é linkavel
	protected boolean linkavel; // propriedades
	// Indica se a lista tem um título de referência ou não.
	protected boolean tituloRef = false;

	/**
	 * Construtor do Titulo
	 * @param valor valor do elemento abstrato
	 * @param prioridade prioridade do elemento abstrato
	 * @param nivel nivel do titulo
	 * @param linkavel condicao se o titulo pode ser linkavel ou não
	 */
	public Titulo(String valor, int prioridade, int nivel, boolean linkavel) {
		super(valor, prioridade);
		this.nivel = nivel;
		this.linkavel = linkavel;
	}
	
	/**
	 * Verifica o nivel.
	 * @param nivel nivel do titulo
	 * @return true se for valido e fale caso contrario
	 */
	public boolean nivelTitle(int nivel) {
		boolean valido = true;
		if(nivel > 5 || nivel < 1) {
			valido = false;
			return valido;
		}
		return valido;
	}
	
	/**
	 * Gera a representacao completa do texto
	 * @return representacao completa de um titulo
	 */
	@Override
	public String gerarRepresentacaoCompleta() {
		if (linkavel) {
			String link =  nivel + "-" + valor.toUpperCase();
			String representacaoCompleta = nivel + ". " + valor + "-- " + link; 
			return representacaoCompleta;
		}
		String representacaoCompleta = nivel + ". " + valor; 
		return representacaoCompleta;
	}

	/**
	 * Gera a representacao resumida do texto
	 * @return representacao resumida de um titulo
	 */
	@Override
	public String gerarRepresentacaoResumida() {
		String representacaoResumida = nivel + ". " + valor; 
		return representacaoResumida;
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