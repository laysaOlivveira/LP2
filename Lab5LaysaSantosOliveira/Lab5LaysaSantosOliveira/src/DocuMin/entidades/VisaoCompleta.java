/**
*Classe Visao Completa implementa a interface Visao
*@author Laysa Santos Oliveira - 122210585
*/

package DocuMin.entidades;

public class VisaoCompleta implements Visao{
	
	//Atributo visao completa
	protected String visaoCompleta[];
	
	/**
	 * Construtor de visao completa
	 * @param documento documento que sera visto
	 */
	public VisaoCompleta(Documento documento){
        this.visaoCompleta = documento.visaoCompletaDocumento();
    }
	
	/**
	 * Exibe a visão de um documento
	 * @return visaoCompleta visao do documento
	 */
	@Override
	public String[] exibirVisao() {
		// TODO Auto-generated method stub
		return visaoCompleta;
	}

}
