package Gerenciamento_de_Hospede;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import Humano.Pessoa;

public class Hospede extends Pessoa {
	private String data_nasc;
	private String endereco;
	private String numero_cont;
	private List<String> historicoEstadias;

	public Hospede(String nome, String cpf, String data_nasc, String endereco, String numero_cont) {
		super(nome,cpf);
		this.data_nasc = data_nasc;
		this.endereco = endereco;
		this.numero_cont = numero_cont;
		this.historicoEstadias = new ArrayList<>();
	}
	public String getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero_cont() {
		return numero_cont;
	}

	public void setNumero_cont(String numero_cont) {
		this.numero_cont = numero_cont;
	}

	public void adicionarEstadia(String estadia) {
		historicoEstadias.add(estadia);
	}

	public void exibirHistoricoEstadias() {
		System.out.println("Histórico de estadias de " + getNome() + ":");
		for (String estadia : historicoEstadias) {
			System.out.println(estadia);
		}
	}

	public static boolean validarCpf(String cpf) {
		return Pattern.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", cpf);
	}
   
	@Override
	public String toString() {
		return "Hospede nome =" + getNome() + ", cpf =" + getCpf() + ", data_nasc =" + data_nasc + ", endereco =" + endereco
				+ ", numero_cont =" + numero_cont ;
	}

}
