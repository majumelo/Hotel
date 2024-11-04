package Gerenciamento_de_Funcionario;
import Humano.Pessoa;
public class Funcionario extends Pessoa {
    private String cargo;
    private double salarioPorHora;
    private String turno;
    private double horasTrabalhadas;

    public Funcionario(String nome, String cpf, String cargo, double salarioPorHora, String turno) {
        super(nome,cpf);
        this.cargo = cargo;
        this.salarioPorHora = salarioPorHora;
        this.turno = turno;
        this.horasTrabalhadas = 0.0; 
    }
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalarioPorHora() {
		return salarioPorHora;
	}

	public void setSalarioPorHora(double salarioPorHora) {
		this.salarioPorHora = salarioPorHora;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public void registrarHoras(double horas) {
		this.horasTrabalhadas += horas;
	}

	public double calcularSalario() {
		return salarioPorHora * horasTrabalhadas;
	}

}
