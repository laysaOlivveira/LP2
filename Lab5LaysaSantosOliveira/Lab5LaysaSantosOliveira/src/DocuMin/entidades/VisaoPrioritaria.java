/**
*Classe Visao prioritaria implementa a interface Visao
*@author Laysa Santos Oliveira - 122210585
*/

package DocuMin.entidades;

public class VisaoPrioritaria implements Visao {

	//Atributo visao prioritaria
	protected String[] visaoPrioritaria;
	
	/**
	 * Construtor de visao prioritaria
	 * @param documento documento que sera visto
	 */
	public VisaoPrioritaria(Documento documento,int limite){
        this.visaoPrioritaria = documento.visaoPrioritariaDocumento(limite);
    }
	
	/**
	 * Exibe a visão de um documento
	 * @return visaoPrioritaria visao do documento
	 */
	@Override
	public String[] exibirVisao() {
		// TODO Auto-generated method stub
		return visaoPrioritaria;
	}

}
