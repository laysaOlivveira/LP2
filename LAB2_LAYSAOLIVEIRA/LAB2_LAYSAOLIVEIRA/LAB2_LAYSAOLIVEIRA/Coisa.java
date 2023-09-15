package LAB2_LAYSAOLIVEIRA;

/*/**
* Representação do COISA, que auxilia na organização da vida academica dos estudantes
* e os computadores do LCC, organizando a vida do estudante em quatro atividades: 
* verificando seu estado de descanço, monitorando seu tempo de estudo online,
* controle de disciplinas e notas, e o cadastro de resumos.
* 
* @author Laysa Olivera
*/

/** Classe principal, realizando toda a estrutura do coisa
 * */
public class Coisa {
	/** inicializa e chama as classes */
	public static void main(String[] args) {
		registrarDescanso();
		System.out.println("-----");
		registrarTempoOnline();
		System.out.println("-----");
		controlarDisciplina();
		System.out.println("-----");
		registrarResumos();
	}

	/** A classe registrarDescanso monitora o estado de cansaço do aluno
	 * baseado nas horas de descanso por semana que o usuario fornece */
	public static void registrarDescanso() {
		Descanso descanso = new Descanso();
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(30);
		descanso.defineNumeroSemanas(1);
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(2);
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(1);
		System.out.println(descanso.getStatusGeral());

	}

	/** A classe registrarTempoOnline registra o tempo de estudo na internet dedicado a disciplina,
	 * verificando se o aluno atingiu a meta esperada de tempo de estudo online de cada disciplina. */
	private static void registrarTempoOnline() {
		RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);
		tempoLP2.adicionaTempoOnline(10);
		System.out.println(tempoLP2.atingiuMetaTempoOnline());
		tempoLP2.adicionaTempoOnline(10);
		tempoLP2.adicionaTempoOnline(10);
		System.out.println(tempoLP2.atingiuMetaTempoOnline());
		tempoLP2.adicionaTempoOnline(2);
		System.out.println(tempoLP2.atingiuMetaTempoOnline());
		System.out.println(tempoLP2.toString());
		RegistroTempoOnline tempoP2 = new RegistroTempoOnline("P2", 120);
		System.out.println(tempoP2.toString());
	}

	/** A classe controlarDisciplina recebe e armazana 4 notas do aluno na respecyiva disciplina, as notas podem ser recadastradas, será calculado a média e verificado se o aluno foi aprovado ou não,*/
	private static void controlarDisciplina() {
		Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
		prog2.cadastraHoras(4);
		prog2.cadastraNota(1, 5.0);
		prog2.cadastraNota(2, 6.0);
		prog2.cadastraNota(3, 7.0);
		System.out.println(prog2.aprovado());
		prog2.cadastraNota(4, 10.0);
		System.out.println(prog2.aprovado());
		System.out.println(prog2.toString());
	}

	/** A classe registrarResumos armazena pequenos resumos e os seus temas em um registro de tamanho fixo, que pode ser alterado pelo usuario, 
	 * verificando a quantidade de armazenados e realocando os novos caso tenha chegado ao limite, ainda é possível verificar se há um resumo cadastrado
	 * a partir do seu tema. */
	private static void registrarResumos() {
		RegistroResumos meusResumos = new RegistroResumos(100); // 100 resumos

		meusResumos.adiciona("Classes", "Classes definem um tipo e a base de código para criação de objetos.");
		meusResumos.adiciona("Tipo", "Identifica a semântica (operações e significados) de um conjunto de dados.");

		String[] resumos = meusResumos.pegaResumos();

		for (int i = 0; i < meusResumos.conta(); i++) {
			System.out.println(resumos[i]);
		}

		System.out.println();
		System.out.println("Resumos: ");
		System.out.println(meusResumos.imprimeResumos());
		System.out.println(meusResumos.temResumo("Classes"));
		System.out.println(meusResumos.temResumo("Objetos"));
	}

}
