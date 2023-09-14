package agenda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import agenda.Agenda;
import agenda.Contato;

class ContatoTest {
	private Contato contatobase;
	private Agenda agenda;
	
	@BeforeAll
	void before() {
		this.contatobase = new Contato("Matheus", "Gaudencio", "(83) 555-5551");
		//Agenda agenda = new Agenda();		
	}
	
	@Test
	void testeNomeCompleto() {
		String saida = "esperando obter o nome completo";
		assertEquals("Matheus Gaudencio", contatobase.getNomeCompleto(), saida);
		
	}
	
	
	

	
}



