package DocuMin.entidades;

import java.util.Objects;
import java.util.ArrayList;

public class Documento {
	
	// Atributo do titulo de um documento.
	private String titulo;
	// Atributo do tamanho maximo de um documento
	private int tamanhoMaximo;
	// Atributo de elementos; Cria um hashMap do tipo ElementoAbstract
	ArrayList<ElementoAbstract> elementos = new ArrayList<ElementoAbstract>();
	
	/**
	* Construtor da classe Documento, com título e tamanho máximo.
	* @param titulo Título do documento.
	* @param tamanhoMaximo Tamanho máximo do documento.
	**/
	public Documento(String titulo, int tamanhoMaximo) {
		this.setTitulo(titulo);
		this.tamanhoMaximo = tamanhoMaximo;
	}

	/**
	* Construtor da classe Documento, com apenas o título.
	* @param titulo Título do documento.
	**/
	public Documento(String titulo) {
		this.titulo = titulo;
	}

	/**
	* Retorna o título do documento.
	* @return Título do documento.
	**/
	public String getTitulo() {
		return titulo;
	}

	/**
	* Altera o título do documento.
	* @param titulo Novo título do documento.
	**/
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	* Gera um código hash para o título do documento.
	* @return Código hash gerado
	**/
	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	/**
	* Verifica se dois objetos do tipo Documento são iguais, comparando seus títulos.
	* @param obj Objeto a ser comparado.
	* @return True se forem iguais, False caso contrário.
	**/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Documento other = (Documento) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
	/**
	* Retorna a quantidade de elementos do documento.
	* @return Quantidade de elementos do documento.
	**/
	public int contarElementos(){
		return elementos.size();
	}
	
	/**
	* Retorna um array contendo a representação completa de cada elemento do documento.
	* @return Array com a representação completa de cada elemento.
	**/
	public String[] imprimirDocumentos() {
		String[] documento = new String[elementos.size()];
		for (int i = 0 ; i < elementos.size() ; i++ ) {
			documento[i] = elementos.get(i).gerarRepresentacaoCompleta();
		}
		return documento;
	}
	
	/**
	* Adiciona um novo elemento ao documento.
	* @param elemento Elemento a ser adicionado.
	* @return Retorna o índice do elemento adicionado, ou -1 caso o tamanho máximo tenha sido atingido.
	*/
	public int adicionaElemento(ElementoAbstract elemento) {
		if (tamanhoMaximo < elementos.size()) {
			elementos.add(elemento);
			return elementos.indexOf(elemento);
		}
		return -1;
	}
	
	/**
	* Remove um elemento do documento, dada a sua posição.
	* @param elementoPosicao Posição do elemento a ser removido.
	* @return True se a remoção foi bem sucedida, False caso contrário.
	*/
	public boolean apagarElemento(int elementoPosicao) {
		if (!(elementos.equals(null) || elementos.get(elementoPosicao).equals(null) || elementoPosicao <= elementos.size())) {
			elementos.remove(elementoPosicao);
			return true;
		}
		return false;
	}

	/**
	Retorna a representação completa de um elemento do documento, dada a sua posição.
	@param posicaoElemento Posição do elemento.
	@return Representação completa do elemento. */
	public String representacaoCompleta(int posicaoElemento) {
		if (!(elementos.equals(null) || elementos.get(posicaoElemento).equals(null) || posicaoElemento <= elementos.size())) {
			return elementos.get(posicaoElemento).gerarRepresentacaoCompleta();
		}
		return "";
	}

	/**
	Retorna a representação resumida de um elemento do documento, dada a sua posição.
	@param elementoPosicao Posição do elemento.
	@return Representação resumida do elemento. */
	public String representacaoResumida(int elementoPosicao) {
		if (!(elementos.equals(null) || elementos.get(elementoPosicao).equals(null) || elementoPosicao <= elementos.size())) {
			return elementos.get(elementoPosicao).gerarRepresentacaoResumida();
		}
		return "";
	}

	/**
	Move o elemento na posição indicada para cima.
	@param elementoPosicao a posição do elemento a ser movido para cima.
	*/
	public void moverElementoCima(int elementoPosicao) {
		if (!(elementos.equals(null) || elementos.get(elementoPosicao).equals(null) || elementoPosicao <= elementos.size())) {
			ElementoAbstract elemento1 = elementos.get(elementoPosicao);
			elementos.remove(elementoPosicao);
			elementos.add(elementoPosicao - 1, elemento1);
		}
	}
	
	/**
	Move o elemento na posição indicada para baixo.
	@param elementoPosicao a posição do elemento a ser movido para baixo.
	*/
	public void moverElementoBaixo(int elementoPosicao) {
		if (!(elementos.equals(null) || elementos.get(elementoPosicao).equals(null) || elementoPosicao <= elementos.size())) {
			ElementoAbstract elemento1 = elementos.get(elementoPosicao);
			elementos.remove(elementoPosicao);
			elementos.add(elementoPosicao + 1, elemento1);
		}
	}
	
	/**
	Calcula a média das prioridades dos elementos do documento.
	@return a média das prioridades.
	*/
	public int mediaDePrioridades() {
		int somaPrioridades = 0;
		for(ElementoAbstract elemento: elementos) {
		    somaPrioridades += elemento.getPrioridade();
		}
		int mediaDePrioridades = somaPrioridades/elementos.size();
		return mediaDePrioridades;
	}
	
	/**
	Retorna a representação completa dos elementos do documento que possuem prioridade entre 4 e 5.
	@return a representação completa dos elementos selecionados.
	*/
	public String representacaoCompletaDeAtalho() {
		String out = "";
		for( ElementoAbstract elemento : elementos) {
			if(elemento.getPrioridade() > 3 || elemento.getPrioridade() < 6) {
				out += elemento.gerarRepresentacaoCompleta() + "\n";
			}
		}
		return out;
	}
	
	/**
	Retorna a representação resumida dos elementos do documento que possuem prioridade entre 4 e 5.
	@return a representação resumida dos elementos selecionados.
	*/
	public String representacaoResumidaDeAtalho() {
		String out = "";
		for( ElementoAbstract elemento : elementos) {
			if(elemento.getPrioridade() > 3 || elemento.getPrioridade() < 6) {
				out += elemento.gerarRepresentacaoResumida() + "\n";
			}
		}
		return out;
	}

	/**
	Retorna um array de string contendo a visão completa do documento.
	@return a representação completa dos elementos do documento em um array de string.
	*/
	public String[] visaoCompletaDocumento() {
		String[] out = new String[elementos.size()];
		for(ElementoAbstract elemento : elementos) {
			int i = 0;
			out[i] = elemento.gerarRepresentacaoCompleta();
		    i++;
		}
		return out;
	}
	
	/**
	Retorna um array de string contendo a visão resumida do documento.
	@return a representação resumida dos elementos do documento em um array de string.
	*/
	public String[] visaoResumidaDocumento() {
		String[] out = new String[elementos.size()];
		for(ElementoAbstract elemento : elementos) {
			int i = 0;
			out[i] = elemento.gerarRepresentacaoResumida();
		    i++;
		}
		return out;
	}

	/**
	Retorna um array de string contendo a visão prioritária do documento, considerando o limite de prioridade informado.
	@param limite o limite de prioridade a ser considerado.
	@return a representação resumida dos elementos do documento com prioridade acima do limite informado em um array de string. 
	*/
	public String[] visaoPrioritariaDocumento(int limite) {
		String[] out = new String[elementos.size()];
		for(ElementoAbstract elemento : elementos) {
			int i = 0;
			if(elemento.getPrioridade() >= limite) {
				out[i] = elemento.gerarRepresentacaoResumida();
				i++;
			}
		}
		return out;
	}

	/**
	Retorna um array de string contendo a visão do título de todos os elementos que possuem referência ao título.
	@return a representação resumida dos elementos do documento com titulo
	*/
	public String[] visaoTituloDocumento() {
		String[] out = new String[elementos.size()];
		for(ElementoAbstract elemento : elementos) {
			int i = 0;
			if(elemento.getTituloRef()) {
				out[i] = elemento.gerarRepresentacaoResumida();
				i++;
			}
		}
		return out;
	}
}