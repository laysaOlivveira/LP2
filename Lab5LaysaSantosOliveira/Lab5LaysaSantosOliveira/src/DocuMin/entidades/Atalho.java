package DocuMin.entidades;
/**
* Classe Atalho representa um elemento abstrato com uma representação completa e resumida, além de uma indicação
* Esta classe herda da classe ElementoAbstract.
* 
* @author Laysa Santos Oliveira - 122210585
*/
public class Atalho extends ElementoAbstract {
	//Representa a representação completa do atalho.
	protected String representacaoCompleta;
	//Representa a representação resumida do atalho.
	protected String representacaoResumida;
	//Indica se o atalho tem um título de referência ou não.
	protected boolean tituloRef = false;

	/**
	* Construtor da classe Atalho.
	* @param valor O valor do elemento abstrato.
	* @param prioridade A prioridade do elemento abstrato.
	* @param representacaoCompleta A representação completa do atalho.
	* @param representacaoResumida A representação resumida do atalho.
	**/
	public Atalho(String valor, int prioridade,String representacaoCompleta, String representacaoResumida) {
		super(valor, prioridade);
		this.representacaoCompleta = representacaoCompleta;
        this.representacaoResumida = representacaoResumida;
		// TODO Auto-generated constructor stub
	}

	/**
	* Gera a representação completa do atalho.
	* @return A representação completa do atalho.
	**/
	@Override
	public String gerarRepresentacaoCompleta() {
		// TODO Auto-generated method stub
		return representacaoCompleta;
	}

	/**
	* Gera a representação resumida do atalho.
	* @return A representação resumida do atalho.
	**/
	@Override
	public String gerarRepresentacaoResumida() {
		// TODO Auto-generated method stub
		return representacaoResumida;
	}
	
	/**
	* Obtém a indicação de se o atalho tem um título de referência.
	* @return true se o atalho tem um título de referência, false caso contrário. */
	public boolean getTituloRef(){
        return tituloRef;
    }
}
