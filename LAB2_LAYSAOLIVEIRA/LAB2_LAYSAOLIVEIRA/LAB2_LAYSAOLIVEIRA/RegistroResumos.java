package LAB2_LAYSAOLIVEIRA;

public class RegistroResumos {

	/**
	 * Atributo da quantidade de resumos que pode ser armazenados
	 * */
	private int quantidadeDeResumos = 0;
	/**
	 * Atributo da array de armazenamento dos temas
	 * */
	private String[] tema;
	/**
	 * Atributo da array de armazenamento dos resumos
	 * */
	private String[] resumo;
	/**
	 * Atributo do apontador que adicionará os resumos no array
	 * */
	private int apontador;


    /**
	* O contrutor inicializa as varíaveis de instancia, o atributo de array de temas e resumos.
	*
	* @param numeroDeResumos quantidade fixa de resumos que poderá ser cadastrado
	*/
	public RegistroResumos(int numeroDeResumos) {
		this.quantidadeDeResumos = numeroDeResumos;
		this.resumo = new String[numeroDeResumos];
		this.tema = new String[numeroDeResumos];
		this.apontador = 0;
	}

	/** 
	 * Recebe e armazena os resumos e temas em se srespectivos arrays, organizando para que seja
	 * armazenado no proximo elemento do array e cuida para que caso chegue a ultima posição do array
	 * o primeiro resumo e tema sejam substituidos e assim sucessivamente. 
	 * @param tema tema do resumo que será cadastrado
	 * @param resumo resumo que será armazenado */
	public void adiciona(String tema, String resumo) {
		this.tema[this.apontador] = tema;
		this.resumo[this.apontador] = resumo;
		if (this.apontador == this.quantidadeDeResumos - 1) {
			this.apontador = 0;
		} else {
			this.apontador += 1;
		}
	}

	/**
	 * Imprime cada um dos resumos cadastrados sinalizados com seus temas.
	 * @return resumos o tema e o seu respectivo resumo cadastrado
	 * */
	public String[] pegaResumos() {
		String[] resumos = new String[conta()];
		for (int i = 0; i < this.resumo.length; i++) {
			if (this.resumo[i] != null) {
				resumos[i] = tema[i] + ": " + resumo[i];
			}
		}
		return resumos;
	}

	/** Quantifica quantos resumos há no array a partir do tamanho do array de resumos armazenados. 
	 * @return conta quantidade de resumos armazenados */
	public int conta() {
		int conta = 0;
		for (int i = 0; i < this.resumo.length; i++) { /** percorre o atributo que armazena os resumos contando seus elementos */
			if (this.resumo[i] != null) {
				conta++;
			}
		}
		return conta;
	}

	/** Informa quantos resumos há cadastrados, mostrando os temas dos respectivos resumos armazenados
	 * @return resultados ultimo tema cadastrado */
	public String imprimeResumos() {
		String cadastrados = "- " + conta() + " resumo(s) cadastrado(s)";
		System.out.println(cadastrados);
		System.out.print("- ");
		for (int i = 0; i < conta() - 1; i++) {
			if (this.tema[i] != null) {
				System.out.print(this.tema[i] + " | ");
			}
		}
		String resultados = this.tema[conta() - 1];
		return resultados;
	}

	/** Verifica se há um resumo cadastrado a partir do seu tema
	 * @param tema tema do resumo a ser procurado no array de temas
	 * @return true se for encontrado no array de temas
	 * @return false se não houver nenhum*/
	public boolean temResumo(String tema) {
		for (int i = 0; i < conta(); i++) {/** percorre a o atributo de temas, a partir da quantidade de temas e resumos cadastrados */
			if (this.tema[i].equals(tema)) {/** Compara os temas para verificação */
				return true;
			}
		}
		return false;
	}

}
