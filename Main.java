package Hotel;

import java.util.Scanner;
import Gerenciamento_de_Funcionario.Gerenciar_Funcionarios;
import Gerenciamento_de_Hospede.Checkin_Checkout;
import Gerenciamento_de_Hospede.Gerenciar_Hospedes;
import Gerenciamento_de_Hospede.Hospede;
import Gerenciamento_de_Quartos.Gerenciar_Quartos;
import Gerenciamento_de_Reserva.Gerenciar_Reservas;
import exception.ClienteNaoEncontradoException;
import exception.QuartoIndisponivelException;
import exception.ReservaInvalidaException;

public class Main {
	public static void main(String[] args)
			throws ClienteNaoEncontradoException, QuartoIndisponivelException, ReservaInvalidaException {
		Scanner sc = new Scanner(System.in);

		
		Gerenciar_Quartos gq = new Gerenciar_Quartos();
		Checkin_Checkout sistema = new Checkin_Checkout(gq); 
		Gerenciar_Hospedes gh = new Gerenciar_Hospedes(gq); 
		Gerenciar_Funcionarios gf = new Gerenciar_Funcionarios();
		Gerenciar_Reservas gr = new Gerenciar_Reservas();

		System.out.println("\n==== Digite ENTER para entrar no sistema de Motel SI =====");
		System.out.print("Digite: ");
		String enter = sc.nextLine();

		while (true) {
			System.out.println(
				    "\n=== Sistema de Gerenciamento de Hotel ===\n" +
				    "1. Cadastrar hóspede\n" +
				    "2. Check-in\n" +
				    "3. Check-out\n" +
				    "4. Cadastrar funcionário\n" +
				    "5. Visualizar reservas\n" +
				    "6. Exibir hóspedes\n" +
				    "7. Editar cadastro de funcionário\n" +
				    "8. Verificar quartos disponíveis\n" +
				    "9. Verificar quartos disponíveis por tipo\n" +
				    "10. Sair\n" +
				    "Escolha uma opção: "
				);

			int opcao = sc.nextInt();
			sc.nextLine(); 

			switch (opcao) {
			case 1:
				System.out.print("Nome do Hospede: ");
				String nomeHospede = sc.nextLine();
				System.out.print("CPF do Hospede: ");
				String cpfHospede = sc.nextLine();
				System.out.print("Data de Nascimento do Hospede: ");
				String dataNascimento = sc.nextLine();
				System.out.print("Endereco do Hospede: ");
				String enderecoHospede = sc.nextLine();
				System.out.print("Numero de Contato Hospede: ");
				String numeroHospede = sc.nextLine();

				Hospede novoHospede = new Hospede(nomeHospede, cpfHospede, dataNascimento, enderecoHospede,
						numeroHospede);
				gh.cadastrar(novoHospede); 
				break;

			case 2:
				System.out.print("Número do quarto: ");
				String numeroQuartoCheckIn = sc.nextLine();
				System.out.print("CPF do hóspede: ");
				String cpfHospedeCheckIn = sc.nextLine();
				sistema.checkIn(numeroQuartoCheckIn, cpfHospedeCheckIn);
				break;

			case 3:
				System.out.print("CPF do hóspede: ");
				String cpfHospedeCheckOut = sc.nextLine();
				System.out.print("Data de check-in (dd/MM/yyyy): ");
				String dataCheckIn = sc.nextLine();
				System.out.print("Data de check-out (dd/MM/yyyy): ");
				String dataCheckOut = sc.nextLine();
				sistema.checkOut(cpfHospedeCheckOut, dataCheckIn, dataCheckOut);
				break;

			case 4:
				System.out.print("Nome do funcionário: ");
				String nomeFuncionario = sc.nextLine();
				System.out.print("CPF do funcionário: ");
				String cpfFuncionario = sc.nextLine();
				System.out.print("Cargo do funcionário: ");
				String cargoFuncionario = sc.nextLine();
				System.out.print("Salário do funcionário: ");
				double salarioFuncionario = sc.nextDouble();
				sc.nextLine(); 
				System.out.print("Turno do funcionário: ");
				String turnoFuncionario = sc.nextLine();

				gf.cadastrarFuncionario(nomeFuncionario, cpfFuncionario, cargoFuncionario, salarioFuncionario,
						turnoFuncionario);
				break;

			case 5:
				gr.exibirTodos();
				break;

			case 6:
				gh.exibirTodos();
				break;

			case 7:
				System.out.print("CPF do funcionário para editar: ");
				String cpfFuncionarioEditar = sc.nextLine();
				gf.editarFuncionario(cpfFuncionarioEditar);
				break;

			case 8:
				gq.listarQuartosDisponiveis();
				break;

			case 9:
				System.out.print("Digite o tipo de quarto (casal, solteiro, suíte luxo): ");
				String tipoQuarto = sc.nextLine();
				sistema.listarQuartosDisponiveisPorTipo(tipoQuarto);
				break;

			case 10:
				System.out.println("Saindo do sistema...");
				sc.close();
				return;

			default:
				System.out.println("Opção inválida! Tente novamente.");
			}

		}
	}
}
