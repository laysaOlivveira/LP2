package LAB2_LAYSAOLIVEIRA;
/**
* Essa classe é a representação da organização do tempo de 
* uso da internet para o estudo das disciplinas, verificando 
* se o aluno atingiu a meta da disciplina ou não.
* 
* @author Laysa Oliveira - 122210585
*/

public class RegistroTempoOnline {
	/** atributo de tempo esperado por disciplina*/
	private int tempoOnlineEsperado = 0;
	/** atributo de tempo online dedicado a disciplina*/
	private int tempoOnline = 0;
	/** atributo do nome da disciplina*/
	private String nomeDisciplina;

	/**
	* Constrói o registro, inicializando as varíaveis de instancia como zero e
	* atribuindo os parametros aos atributos.
	*
	* @param nomeDisciplina nome da disciplina estudada no formato "XXXXXXXX"
	* @param tempoOnlineEsperado tempo esperado de estudo da respectiva disciplina
	*/
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;

	}

	/** 
	 * Soma o tempo dedicado a disciplina ao atributo de tempo online para futura verificação
	 * @param tempoOnline horas na internet dedicadas a disciplina
	 * */
	public void adicionaTempoOnline(int tempoOnline) {
		this.tempoOnline += tempoOnline;
	}

	/** Verifica se o tempo dedicado a estudo da disciplina atinge a meta esperada.
	 * @return true se atingir a meta
	 * @return false se a meta não for atingida
	 * */
	public boolean atingiuMetaTempoOnline() {
		if (this.tempoOnline >= this.tempoOnlineEsperado) { /** condição de verificação*/
			return true;
		}
		return false;

	}

	/**Retorna a disciplina, o tempo estudado e o tempo esperado de estudo.
	 *  @return atributo do nome da disciplina, o tempo online e o tempo esperado*/
	public String toString() {
		return this.nomeDisciplina + " " + this.tempoOnline + "/" + this.tempoOnlineEsperado;
	}

}
