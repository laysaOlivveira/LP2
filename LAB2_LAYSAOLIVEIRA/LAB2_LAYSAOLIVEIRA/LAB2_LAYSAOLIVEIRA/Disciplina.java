package LAB2_LAYSAOLIVEIRA;
/**
* Essa classe é a representação das disciplinas estudadas verificando as
* horas estudadas, cadastrando notas, calculando a média e retornando o 
* estado de aprovação ou reprovação do aluno.
* 
* @author Laysa Oliveira - 122210585
*/
public class Disciplina {

	/**
	 * Atributo da media aritmética das provas
	 * */
    private double media;
    /**
	 * Atributo do array de notas cadastradas
	 * */
    private double[] valorNota;
    /**
	 * Atributo do nome da disciplina
	 * */
    private String nomeDisciplina;
    /**
	 * Atributo de horas estudadas
	 * */
    private int horasEstudo;

    /**
	* O contrutor inicializa as varíaveis de instancia e o atributo de array de notas.
	*
	* @param string nome da disciplina que serão cadastradas as notas
	*/
    public Disciplina(String string) {
        this.nomeDisciplina = string;
        this.horasEstudo = 0;
        this.valorNota = new double[4];
    }

    /** 
	 * Soma as horas de estudo da disciplina ao atributo de horas de estudo.
	 * @param horas horas de estudo da disciplina
	 * */
    public void cadastraHoras(int horas) {
        this.horasEstudo += horas; /** atribuição e soma das horas */
    }

    /** 
	 * Recebe as notas dos alunos e as armazenas em um array de acordo com sua ordem, de 1 a 4.
	 * @param nota qual das quatro notas está sendo cadastrada
	 * @param valorNota valor da nota que será armazenada no array
	 * */
    public void cadastraNota(int nota, double valorNota) {
        this.valorNota[nota - 1] = valorNota; /** adiciona a nota no seu valor-1 para que possa ocupar a posição certa,
                                                 de 1 a 4, de acordo com seu peso e possa ser cadastrada novamente caso necessario */
    }

    /** Verifica se o aluno está aprovado na disciplina a partir da sua média.
	 * @return true media maior ou igual a 7
	 * @return false media menor que 7
	 * */
    public boolean aprovado() {
        double soma = 0;
        for (double nota : this.valorNota) {
            soma += nota; /**percorre o array de notas e soma as notas cadastradas*/
        }
        this.media = soma / 4; /** calcula a media aritmetica das notas do aluno */
        if (this.media >= 7.0) {/** verifica se está aprovado */
            return true;
        }
        return false;
    }

    /** Verifica o inicio da String, adiciona as notas conforme o array de notas e o finaliza quando o espaço está vazio,
     * gerando uma representação da disciplina. 
     * @return atributo do nome da disciplina, o tempo online e o tempo esperado*/
    public String toString() {
        String listaNotas = "";
        for (double nota : this.valorNota) {
            if (listaNotas.equals("")) {/** se o espaço estiver vazio, adiciona colchetes e adiciona a primeira nota*/
                listaNotas += "[" + nota;
            } else { /** caso não, adiciona uma virgula e a proxima nota cadastrada */
                listaNotas += ", " + nota;
            }

        }
        listaNotas += "]"; /**finaliza a String de notas*/

        return this.nomeDisciplina + " " + this.horasEstudo + " " + this.media + " " + listaNotas;
    }

}
