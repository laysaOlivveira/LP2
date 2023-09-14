package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author Laysa Oliveira - 122210585
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(R)emover Favorito\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
            listaDeFavoritos(agenda);
            break;
        case "A":
            adicionarContatoFavorito(agenda,scanner);
            break;
        case "R":
            removerContatoFavorito(agenda,scanner);
            break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Remove um contato na lista de favoritos. Recebe a posição está armazenado em favoritos e o remove a partir de removerFavorito.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 * */
	private static void removerContatoFavorito(Agenda agenda, Scanner scanner) {
		System.out.println("POSICAO> ");
        int posicaofavorito = scanner.nextInt();
        agenda.removerFavorito(posicaofavorito);
		
	}

	/**
	 * Cadastra um contato na lista de favoritos. Recebe a posição do contato que vai adicionar e a posição que ele será armazenado na outra lista, 
	 * verifica se a posição é válida e adiciona na lista.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 * */
	private static void adicionarContatoFavorito(Agenda agenda, Scanner scanner) {
		System.out.println("\nContato> ");
		int contatoEscolhido = scanner.nextInt();
		System.out.println("\nPosição> ");
        int posicaofavorito = scanner.nextInt();
        if(posicaofavorito < 1 || posicaofavorito > 10)
        {
            System.out.println("POSIÇÃO INVÁLIDA");
            return;
        }
        
        agenda.favoritarContato(contatoEscolhido, posicaofavorito);
        System.out.println("CONTATO FAVORITADO NA POSIÇÃO " + posicaofavorito + "!");
        return;
		
	}

	/**
	 * Imprime lista de contatos favoritados da agenda.
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaDeFavoritos(Agenda agenda) {
		System.out.println("\nLista de favoritos: ");
        System.out.println(agenda.getFavoritos());
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		String[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda.Verifica se a posição escolhida não há contato,
	 * imprimindo que a posição é inválida e verifica também a condição do contato ter sido favoritado, se sim,
	 * um "❤" é adicionado na frente do nome. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		Contato contato = agenda.getContato(posicao);
		if( agenda.getContato(posicao) == null) {
			System.out.print("POSIÇÃO INVÁLIDA");
		}
		else {
			if (contato.isFavorito() == true) {
				System.out.println(" ❤️ " + contato);
			}
			else {
				System.out.println(contato);
			}
				
		}
		
	}

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contatos O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();
		
		agenda.cadastraContato(posicao, nome, sobrenome, telefone);
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
