package LAB2_LAYSAOLIVEIRA;
/**
* Essa classe é a representação da rotina de descanso de um aluno, verificando a partir de suas horas de estudo por semana, o seu estado de descanso.
* 
* @author Laysa Oliveira - 122210585
*/

public class Descanso {
	/**
	 * Atributo de horas descansadas durante a semana
	 * */
	private int horasDescanso;
	/**
	 * Atributo de numero de semanas de estudo.
	 * */
	private int numeroSemana;

	/**
	 * O construtor sem argumento inicializa cada variável de instância.
	 */
	public Descanso() {
		this.horasDescanso = 0;
		this.numeroSemana = 1;
	}

	/**
	* Verifica o estado de descanso e retorna a String que representa o estado do aluno. 
	* @return a representação em String do estado do aluno.
	*/
	public String getStatusGeral() {
		if (horasDescanso / numeroSemana >= 26) { /** verifica as horas de descanso por semana e retorna o estado*/
			return "descansado";
		}
		return "cansado";

	}

	/**
	* Atribui o parâmetro ao atributo de horas de descanso 
	* @param horas as horas informadas pelo aluno
	*/
	public void defineHorasDescanso(int horas) {
		this.horasDescanso = horas; /**atribui o parametro*/

	}

	/**
	* Atribui o parâmetro ao atributo numero de semanas
	* @param semanas o numero de semanas de estudo do aluno
	*/
	public void defineNumeroSemanas(int semanas) {
		if (semanas != 0) {/** verifica se a semana é diferente de zero*/
			this.numeroSemana = semanas;
		}

	}
}
