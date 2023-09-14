/**
*Classe Visao Resumida implementa a interface Visao
*@author Laysa Santos Oliveira - 122210585
*/

package DocuMin.entidades;

public class VisaoResumida implements Visao {
	
	//Atributo visao resumida
	protected String[] visaoResumida;
	
	/**
	 * Construtor de visao resumida
	 * @param documento documento que sera visto
	 */
	public VisaoResumida(Documento documento){
        this.visaoResumida = documento.visaoResumidaDocumento();
    }
	
	/**
	 * Exibe a visão de um documento
	 * @return visaoResumida visao do documento
	 */
	public String[] exibirVisao() {
		return visaoResumida;
	}

}
