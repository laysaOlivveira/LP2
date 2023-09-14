package agenda;

/**
 * Uma classe que cuida em armazenar, acessar e modificar os dados dos contatos da agenda. 
 * 
 * @author Laysa Oliveira - 122210585
 *
 */

import java.util.Objects;

public class Contato {
	private String nome; 
	private String sobrenome; 
	private String numeroTelefone; 
	private boolean favorito = false;
	
	/**
	 * Construtor da classe Contato, inicializando os atributos de contato.
	 * */
	public Contato(String nome, String sobrenome, String numeroTelefone) {
		this.nome = nome; // atributo de nome
		this.sobrenome = sobrenome; // atributo de sobrenome
		this.numeroTelefone = numeroTelefone; // atributo de telefone
	}
	
	/**
	 * Obtém o numero de telefone.
	 * @return numero de telefone recebido e armazenado
	 */
	public String getNumeroTelefone() {
		return numeroTelefone;
	}
	
	/**
	 * Acessa e configura o numero do telefone.
	 * @param numero do telefone Numero do contato.
	 */
	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	/**
	 * Obtém o nome do contato
	 * @return nome do contato recebido e armazenado
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Acessa e configura o nome do contato.
	 * @param nome Nome do contato.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Obtém sobrenome do contato.
	 * @return sobrenome recebido e armazenado
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Acessa e configura sobrenome.
	 * @param sobrenome Sobrenome do contato.
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	/**
	 * Obtém o nome completo do contato, nome + sobrenome
	 * @return nome do contato + sobrenome do contato
	 */
	public String getNomeCompleto() {
		return nome +  " " + sobrenome;
	}
	
	/**
	 * Representação do contato em String.
	 * */
	@Override
	public String toString() {
		return nome + " " + sobrenome + "\n" + numeroTelefone ;
	}	
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}
	
	/**
	 * Acessa e configura o contato favoritado.
	 * @param favorito O favoritado.
	 */
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	
	/**
	 * Insere o contato na lista de favoritos
	 * */
	public void InsereFavorito() {
		 this.nome = nome;
	     this.favorito = true;
	}
	
	/**
	 * Remove o contato da lista de favoritos
	 * */
	public void RemoverFavorito() {
        this.favorito = false;
	}

	/**
	 * Verifica se o contato está na lista de favoritos
	 * @return favorito Condição se o contato está na lista ou não
	 * */
	public boolean isFavorito() {
		return favorito;
	} 
}
