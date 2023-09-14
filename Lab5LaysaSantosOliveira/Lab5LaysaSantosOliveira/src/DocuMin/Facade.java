package DocuMin;

import DocuMin.controller.DocumentoController;

public class Facade {
	
	private DocumentoController DocumentoController;
	
	public Facade(DocuMin.controller.DocumentoController documentoController) {
		documentoController = new DocumentoController();
	}

	public boolean criarDocumento (String titulo) {
		return DocumentoController.criarDocumento(titulo);
	}
	
	public boolean criarDocumento(String titulo, int tamanhoMaximo) {
		return DocumentoController.criarDocumento(titulo, tamanhoMaximo);
	}
	
	public void removerDocumento(String titulo) {
		DocumentoController.removerDocumento(titulo);
	}
	
	public int contarElementos(String titulo) {
		return DocumentoController.contarElementos(titulo);
		}
	
	public String[] exibirDocumento(String titulo) {
		return DocumentoController.exibirDocumento(titulo);
		}
	
	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		return DocumentoController.criarTexto(tituloDoc, valor, prioridade);
		}
	
	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		return DocumentoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
		}
	
	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
		return DocumentoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);}	
	
	public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		return DocumentoController.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);}

	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		return DocumentoController.gerarRepresentacaoCompleta(tituloDoc, elementoPosicao);
		}
	
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		return tituloDoc;}
	
	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		return DocumentoController.apagarElemento(tituloDoc, elementoPosicao);}
	
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		DocumentoController.moverParaCima(tituloDoc, elementoPosicao);
	}
	
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		DocumentoController.moverParaBaixo(tituloDoc, elementoPosicao);
	}
	
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		return DocumentoController.criarAtalho(tituloDoc, tituloDocReferenciado);
	}
	
	public int criarVisaoCompleta(String titulodoc) {
		return DocumentoController.criarVisãoCompleta(titulodoc);
	}
	
	public int criarVisaoResumida(String titulodoc) {
		return DocumentoController.criarVisãoResumida(titulodoc);
	}
	
	public int criarVisaoPrioritaria(String titulodoc, int prioridade) {
		return DocumentoController.criarVisãoPrioritaria(titulodoc, prioridade);
	}
	
	public int criarVisaoTitulo(String titulodoc) {
		return DocumentoController.criarVisãoTitulo(titulodoc);
	}
	public String[] exibirVisao(int visaold) {
		return DocumentoController.exibirVisao(visaold);
	}
}
