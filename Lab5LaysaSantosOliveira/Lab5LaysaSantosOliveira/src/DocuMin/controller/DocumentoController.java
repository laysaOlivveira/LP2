/**
* Representacao do DocuMin, que funciona como uma estrutura para a criação de documentos.
* 
* @author Laysa Santos Olivera - 122210585
*/
package DocuMin.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import DocuMin.entidades.*;
/**
 *  Classe principal, realizando toda a estrutura e controller do DocuMin.
 * */
public class DocumentoController {

	// Atributo de documentos; Cria um hashMap do tipo Documento
	private Map<String, Documento> documentos = new HashMap<>();
    // Atributo de visoes; Cria um hashMap do tipo Visao
    private Map<Integer, Visao> visoes = new HashMap<>();
    private int numeroDeVisoes = 0; // Armazena o número de visões criadas
    private Visao visao; // Objeto da interface Visao
	
    /**
     * Cria um novo documento com base no título passado como parâmetro.
     * @param titulo Título do novo documento.
     * @return Retorna true caso seja possível criar um novo documento e false caso contrário.
     * @throws IllegalArgumentException Caso o título passado como parâmetro seja nulo.
     */
	public boolean criarDocumento(String titulo) {
		
		boolean situacao = true;
		Documento novoDocumento = new Documento(titulo);
		
		if(titulo.equals(null)) {
			throw new IllegalArgumentException();
		}
		if (documentos.containsKey(titulo)) {
			situacao = false;
		}
		else {
			documentos.put(titulo, novoDocumento);
		}
		return situacao;
	}

	/**
	 * Cria um novo documento com base no título e no tamanho máximo passados como parâmetros.
	 * @param titulo Título do novo documento.
	 * @param tamanhoMaximo Tamanho máximo do novo documento.
	 * @return Retorna true caso seja possível criar um novo documento e false caso contrário.
	 * @throws IllegalArgumentException Caso o título passado como parâmetro seja nulo ou o tamanho máximo seja menor ou igual a  0.
	 */
	public boolean criarDocumento(String titulo, int tamanhoMaximo) {
		boolean situacao = true;
		Documento novoDocumento = new Documento(titulo);
		
		if (tamanhoMaximo <= 0 ) {
			throw new IllegalArgumentException();
		}
		if(titulo.equals(null)) {
			throw new IllegalArgumentException();
		}
		if (documentos.containsKey(titulo)) {
			situacao = false;
		}
		else {
			documentos.put(titulo, novoDocumento);
		}
		return situacao;
	}
	
	/**
	 * Remove um documento com base no título passado como parâmetro.
	 * @param titulo Título do documento a ser removido.
	 * @throws IllegalArgumentException Caso o título passado como parâmetro seja nulo.
	 * @throws NoSuchElementException Caso o título passado como parâmetro não exista na lista de documentos.
	 */
	public void removerDocumento(String titulo) {
		if(titulo.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(titulo)) {
			throw new NoSuchElementException();
		}
		
		if (documentos.containsKey(titulo)) {
			documentos.remove(titulo);
		}
	}

	/**
	 * Retorna o número de elementos de um documento com base no título passado como parâmetro.
	 * @param titulo Título do documento que deseja contar os elementos.
	 * @return Retorna o número de elementos do documento.
	 * @throws IllegalArgumentException Caso o título passado como parâmetro seja nulo.
	 * @throws NoSuchElementException Caso o título passado como parâmetro não exista na lista de documentos.
	 */
	public int contarElementos(String titulo) {
		if(titulo.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(titulo)) {
			throw new NoSuchElementException();
		}
		return documentos.get(titulo).contarElementos();
	}

	/**
	 * Retorna um array contendo a representação em string de todos os elementos de um documento com base no título passado como parâmetro.
	 * @param titulo Título do documento que deseja exibir os elementos.
	 * @return Retorna um array contendo as representações em string dos elementos do documento.
	 * @throws IllegalArgumentException Caso o título passado como parâmetro seja nulo.
	 * @throws NoSuchElementException Caso o título passado como parâmetro não exista na lista de documentos.
	 */
	public String[] exibirDocumento(String titulo) {		
		if(titulo.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(titulo)) {
			throw new NoSuchElementException();
		}
		Documento documento = documentos.get(titulo);
		
		return documento.imprimirDocumentos();
	}

	/**
	* Cria um novo Texto e o adiciona ao Documento com o título especificado.
	* @param tituloDoc  O título do Documento a receber o Texto.
	* @param valor  O valor do Texto a ser criado.
	* @param prioridade  A prioridade do Texto a ser criado.
	* @return O índice do Texto adicionado ao Documento.
	* @throws IllegalArgumentException Se o título do Documento passado como parâmetro for nulo.
	* @throws NoSuchElementException Se o título do Documento não for encontrado nos Documentos existentes.
	*/
	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		Texto texto = new Texto(valor, prioridade);
		
		if(tituloDoc.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException();
		}
		
		return documentos.get(tituloDoc).adicionaElemento(texto);
	}

	/**
	* Cria um novo Título e o adiciona ao Documento com o título especificado.
	* @param tituloDoc  O título do Documento a receber o Título.
	* @param valor  O valor do Título a ser criado.
	* @param prioridade  A prioridade do Título a ser criado.
	* @param nivel  O nível do Título a ser criado.
	* @param linkavel  Um booleano indicando se o Título é linkável.
	* @return O índice do Título adicionado ao Documento, ou 0 caso o Título não seja válido.
	* @throws IllegalArgumentException Se o título do Documento passado como parâmetro for nulo.
	* @throws NoSuchElementException Se o título do Documento não for encontrado nos Documentos existentes.
	*/
	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		String nivelS = String.valueOf(nivel);
		String linkavelS = String.valueOf(linkavel);
		Titulo titulo = null;
		
		titulo = new Titulo(valor, prioridade, nivel, linkavel);
		titulo.setValorPropriedade(nivelS, linkavelS);
		
		if(tituloDoc.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException();
		}
		if (titulo.nivelTitle(nivel) ==  true && titulo.validaPrioridade(prioridade) == true) {
			return documentos.get(tituloDoc).adicionaElemento(titulo);			
		}
		return 0;
	}

	/**
	* Cria uma nova Lista e a adiciona ao Documento com o título especificado.
	* @param tituloDoc  O título do Documento a receber a Lista.
	* @param valorLista  O valor da Lista a ser criada.
	* @param prioridade  A prioridade da Lista a ser criada.
	* @param separador  O separador da Lista a ser criada.
	* @param charLista  O caractere da Lista a ser criada.
	* @return O índice da Lista adicionada ao Documento, ou 0 caso a Lista não seja válida.
	* @throws IllegalArgumentException Se o título do Documento passado como parâmetro for nulo.
	* @throws NoSuchElementException Se o título do Documento não for encontrado nos Documentos existentes.
	*/
	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador,
			String charLista) {
		
		Lista lista = new Lista(valorLista, prioridade, separador, charLista);
		lista.setValorPropriedade(separador, charLista);
		
		if(tituloDoc.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException();
		}
		if (lista.validaPrioridade(prioridade) == true) {
			return documentos.get(tituloDoc).adicionaElemento(lista);			
		}
		return 0;
	}

	/**
	* Cria um novo termo e adiciona à lista de elementos de um documento.
	* @param tituloDoc o título do documento que terá o termo adicionado.
	* @param valorTermos o valor do termo.
	* @param prioridade a prioridade do termo.
	* @param separador o separador que será utilizado.
	* @param ordem a ordem que será utilizada.
	* @return um inteiro representando o índice do elemento adicionado.
	* @throws IllegalArgumentException Se o título do documento for nulo ou vazio.
	* @throws NoSuchElementException Se o título do documento não estiver presente na coleção de documentos. 
	*/
	public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador,
			String ordem) {
		
		Termo termo = new Termo(valorTermos, prioridade, separador, ordem);
		termo.setValorPropriedade(separador, ordem);
		
		if(tituloDoc.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException();
		}
		if (termo.validaPrioridade(prioridade) == true) {			
			return documentos.get(tituloDoc).adicionaElemento(termo);
		}
		return 0;
	}

	/**
	* Gera a representação completa do elemento escolhido de um documento.
	* @param tituloDoc o título do documento que contém o elemento a ser representado.
	* @param elementoPosicao a posição do elemento a ser representado.
	* @return uma String com a representação completa do elemento escolhido.
	* @throws IllegalArgumentException Se o título do documento for nulo ou vazio.
	* @throws NoSuchElementException Se o título do documento não estiver presente na coleção de documentos. 
	*/
	public String gerarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		if(tituloDoc.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException();
		}
		return documentos.get(tituloDoc).representacaoCompleta(elementoPosicao);
	} 
	
	/**
	* Gera a representação resumida do elemento escolhido de um documento.
	* @param tituloDoc o título do documento que contém o elemento a ser representado.
	* @param elementoPosicao a posição do elemento a ser representado.
	* @return uma String com a representação resumida do elemento escolhido.
	* @throws IllegalArgumentException Se o título do documento for nulo ou vazio.
	* @throws NoSuchElementException Se o título do documento não estiver presente na coleção de documentos. 
	*/
	public String gerarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		if(tituloDoc.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException();
		}
		
		return documentos.get(tituloDoc).representacaoResumida(elementoPosicao);
	}
	
	/**
	* Remove o elemento escolhido de um documento.
	* @param tituloDoc o título do documento que contém o elemento a ser removido.
	* @param elementoPosicao a posição do elemento a ser removido.
	* @return true se o elemento foi removido com sucesso, false caso contrário.
	* @throws IllegalArgumentException Se o título do documento for nulo ou vazio.
	* @throws NoSuchElementException Se o título do documento não estiver presente na coleção de documentos. 
	*/
	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		if(tituloDoc.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException();
		}
		return documentos.get(tituloDoc).apagarElemento(elementoPosicao);

	}

	/**
	* Move o elemento escolhido uma posição para cima na lista de elementos de um documento.
	* @param tituloDoc o título do documento que contém o elemento a ser movido.
	* @param elementoPosicao a posição do elemento a ser movido.
	* @throws IllegalArgumentException Se o título do documento for nulo ou vazio.
	* @throws NoSuchElementException Se o título do documento não estiver presente na coleção de documentos. 
	* */
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		if(tituloDoc.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException();
		}
		else {
			documentos.get(tituloDoc).moverElementoCima(elementoPosicao);
		}
	}

	/**
	* Move o elemento escolhido uma posição para baixo na lista de elementos de um documento.
	* @param tituloDoc o título do documento que contém o elemento a ser movido.
	* @param elementoPosicao a posição do elemento a ser movido.
	* @throws IllegalArgumentException Se o título do documento for nulo ou vazio.
	* @throws NoSuchElementException Se o título do documento não estiver presente na coleção de documentos. 
	*/
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		if(tituloDoc.equals(null)) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException();
		}
		else {
			documentos.get(tituloDoc).moverElementoBaixo(elementoPosicao);
		}
		
	}
	
	/**
	* Cria um atalho para um determinado documento
	* @param tituloDoc o título do documento que terá o atalho criado
	* @param tituloDocReferenciado o título do documento que será referenciado pelo atalho
	* @return a posicao do atalho adicionado em documento
	* @throws IllegalArgumentException Se o título do documento for nulo ou vazio.
	* @throws NoSuchElementException Se o título do documento não estiver presente na coleção de documentos. 
	*/
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		int prioridadeDoAtalho;
		String representacaoCompleta;
		String representacaoResumida;
		if(tituloDoc.equals(null) || tituloDoc.equals(" ")) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(tituloDoc)) {
			throw new NoSuchElementException();
		}
		prioridadeDoAtalho = documentos.get(tituloDocReferenciado).mediaDePrioridades();
		representacaoCompleta = documentos.get(tituloDocReferenciado).representacaoCompletaDeAtalho();
        representacaoResumida = documentos.get(tituloDocReferenciado).representacaoResumidaDeAtalho();
        String valor = documentos.get(tituloDocReferenciado).getTitulo();
		Atalho atalho = new Atalho(valor, prioridadeDoAtalho, representacaoCompleta, representacaoResumida);
		return documentos.get(tituloDoc).adicionaElemento(atalho);
	}

	/**
	* Cria uma visão completa de um documento existente
	* @param titulodoc o título do documento que terá a visão criada
	* @return o número da visão criada
	* @throws IllegalArgumentException Se o título do documento for nulo ou vazio.
	* @throws NoSuchElementException Se o título do documento não estiver presente na coleção de documentos. 
	*/
	public int criarVisãoCompleta(String titulodoc) {
		if(titulodoc.equals(null) || titulodoc.equals(" ")) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(titulodoc)) {
			throw new NoSuchElementException();
		}
		if(documentos.containsKey(titulodoc)) {
			visao = new VisaoCompleta(documentos.get(titulodoc));
			visoes.put(numeroDeVisoes, visao);
			numeroDeVisoes++;
			return numeroDeVisoes;
		}
		return -1;
	}

	/**
	* Cria uma visão resumida de um documento existente
	* @param titulodoc o título do documento que terá a visão criada
	* @return o número da visão criada
	* @throws IllegalArgumentException Se o título do documento for nulo ou vazio.
	* @throws NoSuchElementException Se o título do documento não estiver presente na coleção de documentos. 
	*/
	public int criarVisãoResumida(String titulodoc) {
		if(titulodoc.equals(null) || titulodoc.equals(" ")) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(titulodoc)) {
			throw new NoSuchElementException();
		}
		if(documentos.containsKey(titulodoc)) {
			visao = new VisaoResumida(documentos.get(titulodoc));
			visoes.put(numeroDeVisoes, visao);
			numeroDeVisoes++;
			return numeroDeVisoes;
		}
		return -1;
	}

	/**
	* Método responsável por criar uma visão prioritária de um documento.
	* @param titulodoc O título do documento que será criado a visão prioritária.
	* @param prioridade A prioridade da visão prioritária.
	* @return O número da visão criada.
	* @throws IllegalArgumentException Se o título do documento for nulo ou vazio.
	* @throws NoSuchElementException Se o título do documento não estiver presente na coleção de documentos.
	*/
	public int criarVisãoPrioritaria(String titulodoc, int prioridade) {
		// TODO Auto-generated method stub
		if(titulodoc.equals(null) || titulodoc.equals(" ")) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(titulodoc)) {
			throw new NoSuchElementException();
		}
		if(documentos.containsKey(titulodoc)) {
			visao = new VisaoPrioritaria(documentos.get(titulodoc), prioridade);
			visoes.put(numeroDeVisoes, visao);
			numeroDeVisoes++;
			return numeroDeVisoes;
		}
		return -1;
	}

	/**
	* Método responsável por criar uma visão com base no título de um documento.
	* @param titulodoc O título do documento que será criado a visão.
	* @return O número da visão criada.
	* @throws IllegalArgumentException Se o título do documento for nulo ou vazio.
	* @throws NoSuchElementException Se o título do documento não estiver presente na coleção de documentos.
	**/
	public int criarVisãoTitulo(String titulodoc) {
		// TODO Auto-generated method stub
		if(titulodoc.equals(null) || titulodoc.equals(" ")) {
			throw new IllegalArgumentException();
		}
		if(!documentos.containsKey(titulodoc)) {
			throw new NoSuchElementException();
		}
		if(documentos.containsKey(titulodoc)) {
			visao = new VisaoTitulo(documentos.get(titulodoc));
			visoes.put(numeroDeVisoes, visao);
			numeroDeVisoes++;
			return numeroDeVisoes;
		}
		return -1;
	}

	/**
	* Método responsável por exibir uma visão com base na sua posicao.
	* @param visaold O número da visão que será exibida.
	* @return Um array de String com os dados da visão.
	* @throws NoSuchElementException Se o número da visão não estiver presente na coleção de visões.
	**/
	public String[] exibirVisao(int visaold) {
		if(!visoes.containsKey(visaold)) {
			throw new NoSuchElementException();
		}
		return visoes.get(visaold).exibirVisao();
	}
}