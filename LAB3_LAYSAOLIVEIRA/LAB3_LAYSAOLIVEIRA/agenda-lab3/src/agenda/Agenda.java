package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Laysa Oliveira - 122210585
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100; //definição da constante do tamanho da agenda
	private Contato[] contatos; //apenas uma simplificacao de contato

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return usuarios O array de contatos em string.
	 */
	public String[] getContatos() {
		String[] usuarios = new String[TAMANHO_AGENDA]; 
		for(int i = 0; i< TAMANHO_AGENDA; i++) {
			if(this.contatos[i]!= null) {
				usuarios[i] = this.contatos[i].toString();
			}
		}
		return usuarios;
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return contatos Dados do contato, Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}
	
	/**
	 * Verifica se há um contato com nome e sobrenome já cadastrado
	 * @param nome Nome do contato
	 * @param sobrenome Sobrenome do contato
	 * @return existe Condição de existencia do nome e sobrenome nos cadastros
	 * */
	
	public boolean verificaContato(String nome, String sobrenome, String telefone) {
		boolean entrou = false;
		
		if(!(nome.equals("")) && !(telefone.equals(""))) {
			for(int i = 0; i < contatos.length; i++) {
				if(contatos[i] != null && contatos[i].getNome().equals(nome) && contatos[i].getSobrenome().equals(sobrenome)) {
					entrou = true;
				}
			}
		}
			return entrou;
}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior, mas antes de cadastrar
	 * verifica se a posição escolhida está no intervalo [1,100], se o nome, sobrenome e/ou telefone não estão vazios ou se já
	 * há algum contato com nome e sobrenome iguais já cadastrados atraves do método verificaContato.
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		Contato pessoa = new Contato(nome, sobrenome,telefone);
		if (posicao > 100 || posicao < 1) {
			System.out.print("POSIÇÃO INVÁLIDA");
		}
		else {
			if (verificaContato(nome, sobrenome,telefone) == true) {
				System.out.print("CONTATO JÁ CADASTRADO");
			}
			else {
				if (nome.equals("")) {
					System.out.print("CONTATO INVALIDO");
				}
				if (telefone.equals("")) {
					System.out.print("CONTATO INVALIDO");
				}
				else {
					this.contatos[posicao-1] = pessoa;
					System.out.println("CONTATO CADASTRADO COM SUCESSO");
				}
			}
		}
	}

	/**
	 * Acessa os dados de um contato específico na lista de favoritos.
	 * @return contatoFavorito contato que foi favoritado e seus dados em string
	 * */
	public String getFavoritos() {
		String contatoFavorito = "";
		for(int i = 0; i < 100; i++){
			if(contatos[i] != null){
				if(contatos[i].isFavorito() == true){
					contatoFavorito += i + " - " + contatos[i].getNomeCompleto()+"\n";
				}
			}
		}
		return contatoFavorito;
	}

	/**
	 * A partir da posição do contato escolhido na lista de contatos e a posição escolhida na lista de favoritos 
	 * o contato é inserido na lista pelo metodo InsereFavorito.
	 * @param contatoEscolhido posicao do contato na lista de contatos
	 * @param posicaofavorito posição escolhida para o contato na lista de favoritos
	 * */
	public void favoritarContato(int contatoEscolhido, int posicaofavorito) {
		contatos[contatoEscolhido].InsereFavorito();
		
	}

	/**
	 * A partir da posição do contato na lista de favoritos 
	 * o contato é removido da lista de favoritos pelo metodo RemoverFavorito.
	 * @param posicaofavoritos posição escolhida para o contato na lista de favoritos
	 * */
	public void removerFavorito(int posicaofavorito) {
		contatos[posicaofavorito].RemoverFavorito();
	}

}
