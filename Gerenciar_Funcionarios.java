package Gerenciamento_de_Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciar_Funcionarios {
	private List<Funcionario> funcionarios;

    public Gerenciar_Funcionarios() {
        this.funcionarios = new ArrayList<>();
    }
    public void cadastrarFuncionario(String nome, String cpf, String cargo, double salarioPorHora, String turno) {
        Funcionario funcionario = new Funcionario(nome, cpf, cargo, salarioPorHora, turno);
        funcionarios.add(funcionario);
        System.out.println("Funcionário " + nome + " cadastrado com sucesso!");
    }
    public void editarFuncionario(String cpf) {
        Funcionario funcionario = buscarFuncionarioPorCpf(cpf);
        if (funcionario != null) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Novo nome (atual: " + funcionario.getNome() + "): ");
            funcionario.setNome(sc.nextLine());

            System.out.print("Novo cargo (atual: " + funcionario.getCargo() + "): ");
            funcionario.setCargo(sc.nextLine());

            System.out.print("Novo salário por hora (atual: " + funcionario.getSalarioPorHora() + "): ");
            funcionario.setSalarioPorHora(sc.nextDouble());
            sc.nextLine();
            System.out.print("Novo turno (atual: " + funcionario.getTurno() + "): ");
            funcionario.setTurno(sc.nextLine());

            System.out.println("Informações do funcionário atualizadas com sucesso!");
        } else {
            System.out.println("Funcionário com CPF " + cpf + " não encontrado.");
        }
    }
    public void registrarHoras(String cpf, double horas) {
        Funcionario funcionario = buscarFuncionarioPorCpf(cpf);
        if (funcionario != null) {
            funcionario.registrarHoras(horas);
            System.out.println("Horas registradas com sucesso para o funcionário " + funcionario.getNome());
        } else {
            System.out.println("Funcionário com CPF " + cpf + " não encontrado.");
        }
    }
    public void calcularSalarioFuncionario(String cpf) {
        Funcionario funcionario = buscarFuncionarioPorCpf(cpf);
        if (funcionario != null) {
            double salarioCalculado = funcionario.calcularSalario();
            System.out.println("Salário calculado para o funcionário " + funcionario.getNome() + ": R$ " + salarioCalculado);
        } else {
            System.out.println("Funcionário com CPF " + cpf + " não encontrado.");
        }
    }
    private Funcionario buscarFuncionarioPorCpf(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }
}
