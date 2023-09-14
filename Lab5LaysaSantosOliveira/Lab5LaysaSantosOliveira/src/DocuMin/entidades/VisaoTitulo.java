/**
*Classe Visao pelo titulo implementa a interface Visao
*@author Laysa Santos Oliveira - 122210585
*/

package DocuMin.entidades;

public class VisaoTitulo implements Visao {

	//Atributo visao pelo titulo
	protected String[] visaoTitulo;
	
	/**
	 * Construtor de visao pelo titulo
	 * @param documento documento que sera visto
	 */

	public VisaoTitulo(Documento documento){
        this.visaoTitulo = documento.visaoTituloDocumento();
    }
	
	/**
	 * Exibe a visão de um documento
	 * @return visaoTitulo visao do documento
	 */
	@Override
	public String[] exibirVisao() {
		// TODO Auto-generated method stub
		return visaoTitulo;
	}

}
